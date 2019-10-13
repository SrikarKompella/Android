package com.srikar.history20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button con,show;
    //long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con=(Button)findViewById(R.id.conti);
        show=(Button)findViewById(R.id.vi);
        con.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.conti:
                Intent intent=new Intent(getApplicationContext(),Form.class);
                startActivity(intent);
                break;
            case R.id.vi:
                    Intent intent1 = new Intent(getApplicationContext(), List.class);
                    startActivity(intent1);

        }
    }

    /*public boolean Check(){
        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("Users");
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                count=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(count==0){
            return false;
        }else {
            return true;
        }
    }*/
}
