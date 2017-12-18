package com.example.hp.play_signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by HP on 14-12-2017.
 */

public class signup2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

    }
    public void signupbutton3(View k){
        if(k.getId()==R.id.button)
        {
            Intent z=new Intent(signup2.this,signup3.class);
            startActivity(z);
        }
    }
}
