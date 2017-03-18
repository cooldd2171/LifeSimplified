package com.example.shoie.lifesimplified;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class hack extends AppCompatActivity {
    ImageButton i;
    TextView t;
    String firebase_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack);
        t=(TextView)findViewById(R.id.textView2);
        Intent i=getIntent();
        String s=i.getExtras().getString("a");
        Firebase.setAndroidContext(this);
        firebase_url="https://life-simplified.firebaseio.com/"+s ;
      //  t.setText(firebase_url);
        final Firebase ref=new Firebase(firebase_url);


       ref.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               t.setText((CharSequence)dataSnapshot.getValue());

           }

           @Override
           public void onCancelled(FirebaseError firebaseError) {

           }
       });



    }
}
