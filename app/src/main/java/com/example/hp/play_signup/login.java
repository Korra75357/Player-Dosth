package com.example.hp.play_signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity  implements View.OnClickListener {
    private  EditText useremail;
    private  EditText userpassword;
    private  Button buttonsignin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private Button buttonsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        useremail = (EditText) findViewById(R.id.UserEmail);
        userpassword = (EditText) findViewById(R.id.Password);
        buttonsignin = (Button) findViewById(R.id.loginButton);
        buttonsignup = (Button) findViewById(R.id.signupButton);
        buttonsignin.setOnClickListener(this);
        buttonsignup.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, actualActivity.class));
        }

    }

    public void onLoginButton() {
        String email = useremail.getText().toString().trim();
        String password = userpassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email id", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter passsword", Toast.LENGTH_SHORT).show();
        }
        progressDialog.setMessage("Logging in .....Please wait");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "login succussful", Toast.LENGTH_SHORT).show();
                            finish();
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), actualActivity.class));

                        } else {
                            Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }
                    }
                });
    }
    @Override
    public void onClick(View view) {
        if (view == buttonsignin) {
            onLoginButton();
        }
       else  if (view == buttonsignup) {
            finish();
            startActivity(new Intent(this, signup.class));
        }
    }
}

