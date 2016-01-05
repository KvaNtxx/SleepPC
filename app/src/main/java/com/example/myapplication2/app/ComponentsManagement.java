package com.example.myapplication2.app;

/**
 * Created by KvaNt on 04.01.2016.
 */
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.myapplication2.app.MainActivity.main;
/**
 * Created by n.litvyak on 10.06.2015.
 */
public class ComponentsManagement {

    public static final String PREFS_NAME = "MyPrefsFile";

    void init()
    {
        spinnerInit();
    }

    void spinnerInit()
    {
        Spinner dropdown = (Spinner) main.findViewById(R.id.spinner);
        String[] items = new String[]{"Sleep", "Restart", "Shutdown"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(main, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    void sharedPreferencesInit()
    {
        // Получаем и устанавливаем SharedPreferences
        SharedPreferences settings = main.getSharedPreferences(PREFS_NAME, 0);
        String lastIP = settings.getString("lastIP","");
        setLastIP(lastIP);
    }

    void setLastIP(String lastIP)
    {
        EditText editText = (EditText) main.findViewById(R.id.meditText);
        editText.setText(lastIP);
    }

    String getLastIP()
    {
        EditText editText = (EditText) main.findViewById(R.id.meditText);
        return editText.getText().toString();
    }

    void sharedPreferencesSave()
    {
        SharedPreferences settings = main.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("lastIP", getLastIP());
        editor.apply();
    }

}