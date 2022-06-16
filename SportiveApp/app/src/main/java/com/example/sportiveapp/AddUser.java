package com.example.sportiveapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class AddUser extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        final String[] pwd = new String[1];
        final String[] email = new String[1];
        final String[] dateOfBirth = new String[1];
        final String[] user = new String[1];
        final String[] description = {""};
        EditText Pwd, Email, DateOfBirth, Description, User;
        User = findViewById(R.id.password);
        Pwd = findViewById(R.id.username);
        Email = findViewById(R.id.Email);
        DateOfBirth = findViewById(R.id.BDay);
        Description = findViewById(R.id.Description);
        CheckBox checkBox = findViewById(R.id.conditions);
        Button btnAnnuler, btnAccept;
        btnAccept = findViewById(R.id.bouton_ok);
        btnAnnuler = findViewById(R.id.bouton_annuler);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user[0] = User.getText().toString();
                pwd[0] = Pwd.getText().toString();
                email[0] = Email.getText().toString();
                dateOfBirth[0] = DateOfBirth.getText().toString();
                description[0] = Description.getText().toString();
                if ((user[0].length() == 0 || pwd[0].length() == 0) || (email[0].length() == 0)
                || (dateOfBirth[0].length() == 0) || (description[0].length() == 0)){
                    System.out.println("set tout les champs");;
                } else {
                    if (!checkBox.isChecked()){
                        System.out.println("Accepter les conditions");
                    } else {
                        System.out.println("Creation nouvel user");
                        finish();
                    }
                }



            }
        });


    }



}
