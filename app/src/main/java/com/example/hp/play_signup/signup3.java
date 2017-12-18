package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class signup3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);
    }
    public void signupbutton7(View k){
        if(k.getId()==R.id.next_ind)
        {
            Intent z=new Intent(signup3.this,signup4.class);
            startActivity(z);
        }
    }
}

