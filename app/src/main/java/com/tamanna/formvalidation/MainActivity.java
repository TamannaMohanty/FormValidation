package com.tamanna.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //1 button
    Button Submit;

    //5 edit txt name designation email number,password

    EditText name , desg,email,phone,pwd;
    String nameStr,desgStr,emailStr,phoneStr,pwdStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.edttxt1);
        desg=findViewById(R.id.edttxt2);
        email=findViewById(R.id.edttxt3);
        phone= findViewById(R.id.edttxt4);
        pwd=findViewById(R.id.edttxt5);
        Submit=findViewById(R.id.btn);


        //handle button

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            nameStr=name.getText().toString().trim();
            desgStr=desg.getText().toString().trim();
            phoneStr=phone.getText().toString().trim();
            emailStr=email.getText().toString().trim();
            pwdStr=pwd.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                intent.putExtra("Username: ",nameStr);
                intent.putExtra("Designation: ",desgStr);
                intent.putExtra("Email: " ,emailStr);
                intent.putExtra("Phone: " ,phoneStr);
                intent.putExtra("Password: " ,pwdStr);
                startActivity(intent);

                if (null==nameStr||nameStr.length()==0) {

                    name.setError("Enter name");

                } else if (null==emailStr||emailStr.length()==0){

                    email.setError("Enter email");
                }
                else if (!isValidEmail(emailStr)) {
                    email.setError("Enter valid Email");
                }
                else if (null==desgStr||desgStr.length()==0){

                    desg.setError("Enter Designation");
                }
                else if (null==phoneStr||phoneStr.length()==0){

                    phone.setError("Enter mobile number");
                }
                else if (!(phone.length()==10)){

                    phone.setError("Enter 10 digit mobile number");
                }

                else if (!isValidateMobileNumber(phoneStr))
                {
                    phone.setError("Enter Valid Mobile Number");
                }
                else if (null==pwdStr||pwdStr.length()==0){

                    pwd.setError("Enter Password");
                }
                else if (pwdStr.length()<6){

                    pwd.setError("Enter minimum 6 charecters ");
                }
                else if (!isValidPassword(pwdStr)){

                    pwd.setError("Enter Valid Password ");
                }
            }


        });}


    public boolean isValidPassword(String pwd)
    {
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$").matcher(pwd).matches();

    }

    public boolean isValidEmail(String email) {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1,}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();

    }

    public boolean isValidateMobileNumber(String phone)
    {
        return Pattern.compile("(0/91)?[7-9][0-9]{9}").matcher(phone).matches();
    }


}