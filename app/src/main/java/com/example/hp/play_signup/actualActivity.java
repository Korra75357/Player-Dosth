package com.example.hp.play_signup;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class actualActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual);
    }
    public void CompleteProfile(View k){
        if(k.getId()==R.id.button7)
        {
            Intent z=new Intent(actualActivity.this,signup2.class);
            startActivity(z);
        }
        if (k.getId()==R.id.button5)
        {
            Intent z=new Intent(actualActivity.this,login.class);
            startActivity(z);

        }
        if (k.getId()==R.id.button6)
        {
            Intent z=new Intent(actualActivity.this,completeProfile.class);
            startActivity(z);

        }
        if (k.getId()==R.id.button1)
        {
            Intent z=new Intent(actualActivity.this,gamesContainer.class);
            startActivity(z);

        }
    }
}

