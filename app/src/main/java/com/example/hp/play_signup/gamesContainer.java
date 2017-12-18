package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class gamesContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_container);
    }

    public void CompleteProfile(View k) {
        if (k.getId() == R.id.button7) {
            Intent z = new Intent(gamesContainer.this, signup2.class);
            startActivity(z);
            datashower();
            //here signup2 is replaced by a scrolling activity which contains all related show data from fire base related to
        }
    }

    private void datashower() {
        //this method consists of a code to RETRIEVE DATA from fire base

    }

}
