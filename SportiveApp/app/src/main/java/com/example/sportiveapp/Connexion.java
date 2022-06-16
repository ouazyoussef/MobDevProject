package com.example.sportiveapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Connexion extends Activity {
    private Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        final EditText usr, passWord;
        final String[] UserName = new String[1];
        final String[] PassWord = { null };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        btnLogin = findViewById(R.id.btnLogin);
        usr = findViewById(R.id.userName);
        passWord = findViewById(R.id.pswd);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserName[0] = usr.getText().toString();
                PassWord[0] = passWord.getText().toString();
                System.out.println("Result : " + new DBManagement().UserIsReal(UserName[0],PassWord[0]));
                //
                // startActivity(new Intent(Connexion.this, profilePage.class));

                /*if(DBCheck) {
                startActivity

                }*/


            }
        });
    }
    public void Login(View view) {
    }
}
