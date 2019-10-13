package com.srikar.history20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Form extends AppCompatActivity {
    Button save;
    EditText fname, age, grp, wgt, hgt, gender, surg, medc, medcon;
    DatabaseReference mref;
    DatabaseReference dbref;
    DatabaseReference dbref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        save = (Button) findViewById(R.id.save);
        fname = (EditText) findViewById(R.id.fna);
        age = (EditText) findViewById(R.id.ag);
        grp = (EditText) findViewById(R.id.bgrp);
        wgt = (EditText) findViewById(R.id.wt);
        hgt = (EditText) findViewById(R.id.ht);
        gender = (EditText) findViewById(R.id.gen);
        surg = (EditText) findViewById(R.id.surgery);
        medc = (EditText) findViewById(R.id.med);
        medcon = (EditText) findViewById(R.id.medcon);
        mref= FirebaseDatabase.getInstance().getReference();
        dbref= mref.child("Users");
        dbref1=mref.child("Users Info");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname = fname.getText().toString();
                String sage = age.getText().toString();
                String swt = wgt.getText().toString();
                String sht = hgt.getText().toString();
                String sgrp = grp.getText().toString();
                String sgen = gender.getText().toString();
                String ssurg = surg.getText().toString();
                String smed = medc.getText().toString();
                String smedco = medcon.getText().toString();
                User user=new User(sage,sgrp,swt,sht,sgen,ssurg,smed,smedco);
                String key=dbref.push().getKey();
                if(sname.length()==0){
                    fname.setError("Enter name");
                }
                if(sage.length()==0){
                    age.setError("Enter age");
                }
                if(swt.length()==0){
                    wgt.setError("Enter weight");
                }
                if(sht.length()==0){
                    hgt.setError("Enter height");
                }
                if(sgrp.length()==0){
                    grp.setError("Enter blood group");
                }
                if(sgen.length()==0){
                    gender.setError("Fill Gender");
                }
                if(ssurg.length()==0){
                    surg.setError("Enter details or Enter none");
                }
                if(smed.length()==0){
                    medc.setError("Enter details or Enter none");
                }
                if(smedco.length()==0){
                    medcon.setError("Enter details or Enter none");
                }
                if (sname.length() != 0&&sage.length() != 0 && swt.length() != 0 &&sht.length()!=0&& sgrp.length() != 0 && sgen.length() != 0 && ssurg.length() != 0 && smed.length() != 0 && smed.length() != 0 && smedco.length() != 0) {
                    dbref.child(key).setValue(sname);
                    dbref1.child(sname).setValue(user);
                    Toast.makeText(Form.this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
                    fname.setText("");
                    age.setText("");
                    wgt.setText("");
                    hgt.setText("");
                    grp.setText("");
                    gender.setText("");
                    surg.setText("");
                    medc.setText("");
                    medcon.setText("");
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                    finish();
                }else{
                    Toast.makeText(Form.this, "Enter all details! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
