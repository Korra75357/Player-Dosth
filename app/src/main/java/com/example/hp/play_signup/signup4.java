package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class signup4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
    }
    public void signupbuttonAct(View k){
        if(k.getId()==R.id.button_ok)
        {
            Intent z=new Intent(signup4.this,actualActivity.class);
            startActivity(z);
        }
    }
}

