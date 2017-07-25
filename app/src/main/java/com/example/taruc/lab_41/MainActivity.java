package com.example.taruc.lab_41;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String USERID = "userid";
    private static String PASSWORD = "password";
    EditText editTextUserID, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserID = (EditText)findViewById(R.id.editTextUserID);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        // Create an instance of shared preference object
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        String userID, password;
        userID = sharedPreferences.getString(USERID, "");
        password = sharedPreferences.getString(PASSWORD, "");

        editTextUserID.setText(userID);
        editTextPassword.setText(password);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Create an instance of shared preference object
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        String userID, password;
        userID = editTextUserID.getText().toString();
        password = editTextPassword.getText().toString();
        // Write values to shared preference file
        editor.putString(USERID, userID);
        editor.putString(PASSWORD, password);
    }

}
