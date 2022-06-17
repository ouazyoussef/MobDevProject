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

    private EditText Pwd, Email, DateOfBirth, Description, User;
    private CheckBox checkBox;
    private Button btnAnnuler, btnAccept;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        final String[] pwd = new String[1];
        final String[] email = new String[1];
        final String[] dateOfBirth = new String[1];
        final String[] user = new String[1];
        final String[] description = {""};


        this.User = findViewById(R.id.password);
        this.Pwd = findViewById(R.id.username);
        this.Email = findViewById(R.id.Email);
        this.DateOfBirth = findViewById(R.id.BDay);
        this.Description = findViewById(R.id.Description);
        this.checkBox = findViewById(R.id.conditions);

        this.btnAccept = findViewById(R.id.bouton_ok);
        this.btnAnnuler = findViewById(R.id.bouton_annuler);

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
                }
                else {
                    if (!checkBox.isChecked()){
                        Toast.makeText(AddUser.this,"Accepter les conditions",Toast.LENGTH_SHORT);
                        System.out.println("Accepter les conditions");
                    } else {
                        System.out.println("Creation nouvel user");
                        new DBManagement().CreateUser(user[0], pwd[0], email[0], dateOfBirth[0], description[0]);
                        Toast.makeText(AddUser.this,"User created",Toast.LENGTH_SHORT);
                        finish();
                    }
                }



            }
        });


    }



}
