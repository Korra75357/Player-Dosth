package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gamesContainer extends AppCompatActivity implements View.OnClickListener {
    private Button crickBUtton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_container);
        crickBUtton=(Button)findViewById(R.id.cricket);
        crickBUtton.setOnClickListener(this);
    }
  /*  private void datashower() {

    }
    public void Cricket (){

    }*/

    @Override
    public void onClick(View view) {
        if(view ==crickBUtton){

            startActivity(new Intent(this,gamesShower.class));
        }
    }
}
