package com.example.hp.play_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class completeProfile extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference databaseReference;
    private EditText fullName;
    private EditText mobileNumber;
    private EditText facebookId;
    private EditText branch;
    private EditText btechProgramme;
    private Button saveDatabutton;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("users");
        firebaseAuth=FirebaseAuth.getInstance();
        fullName=(EditText)findViewById(R.id.name);
        mobileNumber=(EditText)findViewById(R.id.mobile);
        branch=(EditText)findViewById(R.id.Branch);
        facebookId=(EditText)findViewById(R.id.fb_id);
        btechProgramme=(EditText)findViewById(R.id.btechPro);
        saveDatabutton=(Button)findViewById(R.id.button_Add);
        saveDatabutton.setOnClickListener(this);
    }
   public void completeUserProfile(){
        String name=fullName.getText().toString().trim();
       String mobile=mobileNumber.getText().toString().trim();
       String Branch=branch.getText().toString().trim();
       String fbid=facebookId.getText().toString().trim();
       String progra=btechProgramme.getText().toString().trim();
      UserInformation userInformation=new UserInformation(name,mobile,Branch,fbid,progra);
     FirebaseUser user =firebaseAuth.getCurrentUser();
     databaseReference.child(user.getUid()).setValue(userInformation);
       Toast.makeText(this," Information Saved Successfully",Toast.LENGTH_SHORT).show();
   }

    @Override
    public void onClick(View view) {
        if(view==saveDatabutton)
        {
            completeUserProfile();
            finish();
            startActivity(new Intent(this,actualActivity.class));
        }
    }
}

