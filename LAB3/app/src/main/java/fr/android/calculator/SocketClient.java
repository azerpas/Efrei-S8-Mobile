package fr.android.calculator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SocketClient extends Activity {
    private Socket client;

    private static final int PORT = 9876;
    private static final String IP = "127.0.0.1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Thread(new CalculusRunner()).start();
    }

    class CalculusRunner implements Runnable {

        @Override
        public void run() {

            try {
                InetAddress serverAddress = InetAddress.getByName(IP);

                client = new Socket(serverAddress, PORT);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
