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
    private EditText usr, passWord;

    protected void onCreate(Bundle savedInstanceState) {
        final String[] UserName = new String[1];
        final String[] PassWord = { null };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        this.btnLogin = findViewById(R.id.btnLogin);
        this.usr = findViewById(R.id.userName);
        this.passWord = findViewById(R.id.pswd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserName[0] = usr.getText().toString();
                PassWord[0] = passWord.getText().toString();
                String requete = "SELECT * FROM users where username = '" + UserName[0] + "' and pwd = '" + UserName[0] + "';";
                boolean isConnected = new DBManagement().UserIsReal(UserName[0], PassWord[0]);

                if(isConnected) {
                    Intent i = new Intent(Connexion.this, profilePage.class);
                    i.putExtra("UserConnected",UserName[0]);
                    startActivity(i);
                }
            }
        });
    }
    public void Login(View view) {
    }
}
