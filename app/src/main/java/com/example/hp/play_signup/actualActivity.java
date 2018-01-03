package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class actualActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView toShowCurrentUser;
    private Button editProfButton;
    private Button FindPlayerButton;
    private Button gamesAdderButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, login.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        toShowCurrentUser = (TextView) findViewById(R.id.texttoDisplay);
        toShowCurrentUser.setText("Welcome " + user.getEmail());
        logoutButton = (Button) findViewById(R.id.button5);
        editProfButton = (Button) findViewById(R.id.button6);
        FindPlayerButton = (Button) findViewById(R.id.button1);
        gamesAdderButton = (Button) findViewById(R.id.button7);
        logoutButton.setOnClickListener(this);
        editProfButton.setOnClickListener(this);
        FindPlayerButton.setOnClickListener(this);
        gamesAdderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == logoutButton) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login.class));
        }
        else if (view == editProfButton) {
            finish();
            startActivity(new Intent(this, completeProfile.class));
        }
        else if (view == FindPlayerButton) {
            finish();
            startActivity(new Intent(this, gamesContainer.class));
        }
       else  if (view == gamesAdderButton) {
            finish();
            startActivity(new Intent(this, signup2.class));
        }

    }
}