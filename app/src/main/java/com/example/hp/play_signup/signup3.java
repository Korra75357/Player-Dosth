package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup3 extends AppCompatActivity  implements View.OnClickListener{
        private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
        private Button indoorSaveButton;
        private FirebaseDatabase firebaseDatabase;
        private FirebaseAuth firebaseAuth;
        private DatabaseReference databaseReference;
       private String userid;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup3);
            cb1 = (CheckBox) findViewById(R.id.checkbox4);
            cb2 = (CheckBox) findViewById(R.id.checkbox1);
            cb3 = (CheckBox) findViewById(R.id.checkbox2);
            cb4 = (CheckBox) findViewById(R.id.checkbox3);
            cb5 = (CheckBox) findViewById(R.id.checkbox5);
            cb6 = (CheckBox) findViewById(R.id.checkbox6);
            cb7 = (CheckBox) findViewById(R.id.checkbox7);
            cb8 = (CheckBox) findViewById(R.id.checkbox8);
            indoorSaveButton = (Button) findViewById(R.id.next_ind);
            firebaseAuth = FirebaseAuth.getInstance();
            databaseReference = FirebaseDatabase.getInstance().getReference().child("indoor");
            indoorSaveButton.setOnClickListener(this);
        }

        public void selectCheckBox() {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            userid=user.getUid();
            if (cb1.isChecked()) {
                databaseReference.child("carrom").push().setValue(userid);
            }
            if (cb2.isChecked()) {
                databaseReference.child("snooker").push().setValue(userid);
            }
             if (cb3.isChecked()) {
                databaseReference.child("tt").push().setValue(userid);
            }
            if (cb4.isChecked()) {
                databaseReference.child("chess").push().setValue(userid);
            }
             if (cb5.isChecked()) {
                databaseReference.child("volleyball").push().setValue(userid);
            }
           if (cb6.isChecked()) {
                databaseReference.child("swimming").push().setValue(userid);
            }
             if (cb7.isChecked()) {
                databaseReference.child("badminton").push().setValue(userid);
            }
           if (cb8.isChecked()) {
                databaseReference.child("skating").push().setValue(userid);
            }
        }

        @Override
        public void onClick(View view) {
            if (view == indoorSaveButton) {
                selectCheckBox();
                finish();
                startActivity(new Intent(this, signup4.class));
            }
        }
    }

