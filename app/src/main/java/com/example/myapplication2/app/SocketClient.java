package com.example.myapplication2.app;

/**
 * Created by KvaNt on 04.01.2016.
 */
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.*;
import java.net.*;
import static com.example.myapplication2.app.MainActivity.main;

/**
 * Created by n.litvyak on 09.06.2015.
 */
public class SocketClient extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        try {
            socketProcessing();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    void socketProcessing() throws IOException {
        EditText editText = (EditText) main.findViewById(R.id.meditText);

        String [] args = new String[1];
        args[0] = editText.getText().toString();

        System.out.println("Welcome to Client side");

        Socket fromserver = null;

        if (args.length==0) {
            System.out.println("use: client hostname");
            System.exit(-1);
        }

        System.out.println("Connecting to... "+args[0]);

        fromserver = new Socket(args[0],4444);
        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        PrintWriter    out = new
                PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser = editText.getText().toString(),fserver;

        Spinner tempSpinner = (Spinner) main.findViewById(R.id.spinner);

        fuser = tempSpinner.getSelectedItem().toString();
        out.println(fuser);
        fserver = in.readLine();
        /*
        while ((editText.getText().toString())!="") {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }
*/
        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }

}