package com.example.shoie.lifesimplified;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class second extends AppCompatActivity {
    TextView t;
    String firebase_url;
    ListView lv;
    private ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t=(TextView)findViewById(R.id.textView5);
        lv=(ListView)findViewById(R.id.list_view);
        Intent myintent=getIntent();
        final String s=myintent.getExtras().getString("a");
        t.setText(s);
        firebase_url="https://life-simplified.firebaseio.com/"+s ;
        Firebase.setAndroidContext(this);
        Firebase ref=new Firebase(firebase_url);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(second.this,R.layout.support_simple_spinner_dropdown_item,data);
        lv.setAdapter(adapter);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                data.add(value);
                adapter.notifyDataSetChanged();
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
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i =new Intent(second.this,hack.class);
                        i.putExtra("a",s+"/hack 1");
                        startActivity(i);
                        break;
                    case 1:
                        Intent j =new Intent(second.this,hack.class);
                        j.putExtra("a",s+"/hack 2");
                        startActivity(j);
                        break;
                    case 2:
                        Intent k =new Intent(second.this,hack.class);
                        k.putExtra("a",s+"/hack 3");
                        startActivity(k);
                        break;
                    case 3:
                        Intent l =new Intent(second.this,hack.class);
                        l.putExtra("a",s+"/hack 4");
                        startActivity(l);
                        break;
                    case 4:
                        Intent m =new Intent(second.this,hack.class);
                        m.putExtra("a",s+"/hack 5");
                        startActivity(m);
                        break;
                    case 5:
                        Intent n =new Intent(second.this,hack.class);
                        n.putExtra("a",s+"hack 6");
                        startActivity(n);
                        break;
                    case 6:
                        Intent o =new Intent(second.this,hack.class);
                        o.putExtra("a",s+"hack 7");
                        startActivity(o);
                        break;


               }

            }
        });



    }
}
