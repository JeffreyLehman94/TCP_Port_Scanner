package major_assignment_1.tcp_port_scanner;

import android.util.Log;

/**
 * Created by Jeff on 2/19/2018.
 */

public class TCP_Thread extends Thread{
    // TODO CHANGE PORT AND CREATE PROPER CONSTRUCTOR
    private int CURR_PORT = 5;
    Object[] objects = {0};
    private String IP = null;
    private final int THREAD_NUMBER = 0;

    TCP_Thread (String ip, int thread){


    }
    public void run() {
        int port = CURR_PORT;
        CURR_PORT += 10;
        for (int i = port; i < port + 10; i++) {
            Log.d("RUN", port / 10 + " scanning " + i);
            objects[0] = i;
            try {
                Scan scan = new Scan(IP);
                if (scan.doInBackground(objects)) {
                    MainActivity.Open_Ports.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
