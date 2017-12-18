package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
   private static EditText username;
    private static EditText password;
    private static Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //LoginButton();

    }
    public  void LoginButton() {
        username=(EditText)findViewById(R.id.Enrolllment);
        password=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.loginButton);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("123") &&
                                password.getText().toString().equals("pass")  ) {
                            Toast.makeText(login.this,"User and Password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.hp.play_signup.actualActivity");
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this,"User and Password is not correct",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );
    }


    public void signupbuttoncick(View k){
        if(k.getId()==R.id.signupButton)
        {
            Intent z=new Intent(login.this,signup.class);
            startActivity(z);
        }

    }
}
