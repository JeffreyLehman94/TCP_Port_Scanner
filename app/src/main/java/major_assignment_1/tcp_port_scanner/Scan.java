package major_assignment_1.tcp_port_scanner;

import android.os.AsyncTask;
import android.util.Log;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Jeff on 2/17/2018.
 * Last edit on 2/17/2018 by Jeff.
 * <p>
 * ABSTRACT: This class is called whenever a port is to be scanned.
 * It takes a String  which is the IP address the user wishes to scan.
 * Scan extends AsyncTask so that it can run in the background of the Main Thread in
 * an Android application.
 */

public class Scan extends AsyncTask {
    private String IP_TO_SCAN;

    Scan(String ip) {
        IP_TO_SCAN = ip;
    }

    protected Boolean doInBackground(Object[] objects) {

        int i = (Integer) objects[0];
        String s = "";
        Boolean succ = false;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(IP_TO_SCAN, i), 1000);
            socket.close();
            Log.d("SCANNER", "SUCCESS");
            succ = true;
        } catch (Exception ex) {
            return succ;
        } finally {
            return succ;
        }
    }
}
