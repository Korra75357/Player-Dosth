package com.example.hp.play_signup;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gamesShower extends AppCompatActivity {
    private ArrayList<String> userInfo=new ArrayList<>();
    TextView tv1;
    ListView lv1;
    ArrayAdapter<String> adapter;
    ArrayList<UserInformation> userdata=new ArrayList<>();
    String Rname;String Rbranch;String Rphone;String Rfbid; String Rprogramme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_cricket);

        tv1=(TextView)findViewById(R.id.textview1);
        lv1=(ListView)findViewById(R.id.listView1);
        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,userInfo);
       lv1.setAdapter(arrayAdapter);
        DatabaseReference IdReference = FirebaseDatabase.getInstance().getReference().child("outdoor").child("cricket");//ref for all id's
        IdReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> cricketChildren = dataSnapshot.getChildren();
                for (DataSnapshot contact : cricketChildren) {
                    String userIdOnebyOne = contact.getValue(String.class);
                    DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("users");//ref for data under users
                    //let we are getting id of cricket one by one and that let it be String userIdOnebyOne
                   userReference.child(userIdOnebyOne).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot1) {
                            UserInformation info = dataSnapshot1.getValue(UserInformation.class);
                          Rname = info.AName;
                             Rbranch = info.Branch;
                            Rphone = info.dMobileNo;
                            Rfbid = info.eFbId;
                           Rprogramme = info.cProgramme;
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(gamesShower.this, "Failed to show data", Toast.LENGTH_SHORT).show();
                        }

                    });

                   userReference.child(userIdOnebyOne).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            String values =dataSnapshot.getValue(String.class);
                            userInfo.add(values);
                            arrayAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }
}
//can show better data by using costum layout for scrpll views