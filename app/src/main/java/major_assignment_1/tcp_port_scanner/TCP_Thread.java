package major_assignment_1.tcp_port_scanner;

import android.util.Log;

/**
 * Created by Jeff on 2/19/2018.
 */

public class TCP_Thread extends Thread{
    // TODO CHANGE PORT AND CREATE PROPER CONSTRUCTOR
    private String IP = null;
    private int PORT_INCREMENT = 0;
    private int THREAD_NUMBER = 0;

    TCP_Thread (String ip, int portsMax, int thread){
        IP = ip;
        PORT_INCREMENT = portsMax/MainActivity.NUMBER_OF_THREADS;
        THREAD_NUMBER = thread;

    }
    public void run() {
        int startingPort = PORT_INCREMENT*THREAD_NUMBER;
        Object[] objects = {0};
        for (int i = startingPort; i < startingPort + PORT_INCREMENT; i++) {
            objects[0] = i;
            try {
                Log.d("THREAD", "scanning " +i);
                Scan scan = new Scan(IP);
                if (scan.doInBackground(objects)) {
                    MainActivity.OPEN_PORTS.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
