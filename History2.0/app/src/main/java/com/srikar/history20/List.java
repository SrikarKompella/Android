package com.srikar.history20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView listView;
    DatabaseReference dref;
    ArrayList<String> list;
    ArrayAdapter<String> aa;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=(ListView)findViewById(R.id.listname);
        list=new ArrayList<>();
        aa=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        dref= FirebaseDatabase.getInstance().getReference().child("Users");
        listView.setAdapter(aa);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot player : dataSnapshot.getChildren()) {
                    //Log.i("player", player.getKey());
                    list.add(player.getValue().toString());
                }
                //list.add(dataSnapshot.getValue().toString());
                listView.setAdapter(aa);
                aa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(List.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                name=aa.getItem(i).toString();
                //Toast.makeText(Main2Activity.this, name, Toast.LENGTH_SHORT).show();
                Intent in=new Intent(getApplicationContext(),Show.class);
                in.putExtra("Name",name);
                startActivity(in);
            }
        });
    }
}
