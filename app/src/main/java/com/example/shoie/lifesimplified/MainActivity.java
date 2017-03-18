package com.example.shoie.lifesimplified;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.key;


public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    String pass_value;



public static final String firebase_url="https://life-simplified.firebaseio.com/all";
    AutoCompleteTextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        a=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);



        Firebase.setAndroidContext(this);
        final Firebase ref = new Firebase(firebase_url);
     final   ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item);
     ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot name: dataSnapshot.getChildren()){
            String names = name.getKey();

            adapter.add(names);

        }

        a.setAdapter(adapter);
        a.setThreshold(2);


    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Toast.makeText(getApplicationContext(),"Please check the internet connection",Toast.LENGTH_LONG).show();

    }
});


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass_value = a.getText().toString();
               if(pass_value.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter to proceed",Toast.LENGTH_SHORT).show();
              }
               else{

                    Intent i= new Intent(MainActivity.this,second.class);
                    i.putExtra("a",pass_value);
                   startActivity(i);
                }
            }
        });




    }


}
