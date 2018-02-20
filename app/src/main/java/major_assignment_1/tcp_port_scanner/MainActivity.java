package major_assignment_1.tcp_port_scanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String IP = null;
    protected static ArrayList<Integer> Open_Ports = new ArrayList();
    private int MAX_PORTS_TO_SCAN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void startScan(String IP){
        Open_Ports = new ArrayList<Integer>();
        ArrayList<TCP_Thread> threads = new ArrayList();
        for(int i=0;i<16;i++){
            threads.add(new TCP_Thread(IP));
        }
        for(TCP_Thread thread:threads){
            thread.start();
        }
    }
}
