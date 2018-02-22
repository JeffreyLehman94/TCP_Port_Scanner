package major_assignment_1.tcp_port_scanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public final static int NUMBER_OF_THREADS = 100;
    private String IP = null;
    protected static ArrayList<Integer> OPEN_PORTS = new ArrayList();
    private int MAX_PORTS_TO_SCAN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startScan("2601:8a:8100:b885:f142:c96:cfea:64fc");

    }

    private void startScan(String IP) {
        OPEN_PORTS = new ArrayList<Integer>();
        ArrayList<TCP_Thread> threads = new ArrayList();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new TCP_Thread(IP, MAX_PORTS_TO_SCAN, i));
            Log.d("THREAD", i + " CREATED");
        }
        for(TCP_Thread thread : threads){
            thread.start();
        }
        for(TCP_Thread thread : threads){
            try{thread.join();}
            catch(Exception e){

            }
        }
        for(int port: OPEN_PORTS) {
            Log.d("FINISH OPEN PORT AT", Integer.toString(port));
        }
    }
}
