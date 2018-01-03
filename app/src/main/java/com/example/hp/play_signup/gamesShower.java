package com.example.hp.play_signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gamesShower extends AppCompatActivity {
    // private ListView mListview;
    String uid;
    TextView tv;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    ListView list1;
    ArrayAdapter<String> adapter;
    List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_cricket);
        itemList = new ArrayList<>();

/*here apply FOR loop to get the values of id//
        DatabaseReference pushedPlayerRef =FirebaseDatabase.getInstance().getReference().child("outdoor").child("cricket").push();
        String userIdOnebyOne=IdReference.orderByKey()
        String PlayerId = pushedPlayerRef.getKey();*/


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
                            String Rname = info.Name;
                            String Rbranch = info.Branch;
                            String Rphone = info.MobileNo;
                            String Rfbid = info.FbId;
                            String Rprogramme = info.Programme;
                            Log.e("CHECKUSER NAME", "Name " + Rname);
                            Log.d("contact:: ", "Name"+Rname);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(gamesShower.this, "Failed to show data", Toast.LENGTH_SHORT).show();
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