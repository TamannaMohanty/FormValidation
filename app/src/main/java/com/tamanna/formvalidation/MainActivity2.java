package com.tamanna.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView username,userdesg,useremail,usermob,userpwd;
    String txtname,txtdesg,txtemail,txtmob,txtpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username=findViewById(R.id.txt1);
        txtname=getIntent().getStringExtra("Username");
        username.setText(""+txtname);

        userdesg=findViewById(R.id.txt2);
        txtdesg=getIntent().getStringExtra("Designation");
        userdesg.setText(""+txtdesg);

        useremail=findViewById(R.id.txt3);
        txtemail=getIntent().getStringExtra("Email");
        useremail.setText(""+txtemail);


        usermob=findViewById(R.id.txt4);
        txtmob=getIntent().getStringExtra("Phone");
        usermob.setText(""+txtmob);

        userpwd=findViewById(R.id.txt5);
        txtpwd=getIntent().getStringExtra("Password");
        userpwd.setText(""+txtpwd);
    }

public void Button(View view){

        startActivity(new Intent(MainActivity2.this,MainActivity.class));

        finish();
}
}