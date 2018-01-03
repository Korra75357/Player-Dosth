package com.example.hp.play_signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup2 extends AppCompatActivity implements View.OnClickListener {
     private CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
     private Button outdoorSaveButton;
    // private FirebaseDatabase firebaseDatabase;
     private FirebaseAuth firebaseAuth;
     private DatabaseReference databaseReference;
     private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        cb1=(CheckBox)findViewById(R.id.checkbox1);
        cb2=(CheckBox)findViewById(R.id.checkbox2);
        cb3=(CheckBox)findViewById(R.id.checkbox3);
        cb4=(CheckBox)findViewById(R.id.checkbox4);
        cb5=(CheckBox)findViewById(R.id.checkbox5);
        cb6=(CheckBox)findViewById(R.id.checkbox6);
        outdoorSaveButton=(Button)findViewById(R.id.button);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("outdoor");
        outdoorSaveButton.setOnClickListener(this);

    }

    public void selectCheckBox(){
        FirebaseUser user =firebaseAuth.getCurrentUser();
        userid=user.getUid();
        if(cb1.isChecked()){
            databaseReference.child("cricket").push().setValue(userid);
        }
        if(cb2.isChecked()){
            databaseReference.child("football").push().setValue(userid);
        }
        if(cb3.isChecked()){
            databaseReference.child("hockey").push().setValue(userid);
        }
        if(cb4.isChecked()){
            databaseReference.child("tennis").push().setValue(userid);
        }
        if(cb5.isChecked()){
            databaseReference.child("kabaddi").push().setValue(userid);
        }
        if(cb6.isChecked()){
            databaseReference.child("basketball").push().setValue(userid);
        }
    }

    @Override
    public void onClick(View view) {
        if(view==outdoorSaveButton){
            selectCheckBox();
            finish();
            startActivity(new Intent(this,signup3.class));
        }
    }
}
