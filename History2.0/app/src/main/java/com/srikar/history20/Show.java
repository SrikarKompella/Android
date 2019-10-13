package com.srikar.history20;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Show extends AppCompatActivity {
    TextView pname,page,weight,height,bgroup,gender,surgery,medi,medcond;
    Dialog dialog;
    DatabaseReference mdref;
    DatabaseReference cref;
    Button up,can,heartbeat;
    EditText changes;
    String refnamedialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        heartbeat=(Button)findViewById(R.id.heart_btn);
        pname=(TextView)findViewById(R.id.name);
        page=(TextView)findViewById(R.id.age);
        weight=(TextView)findViewById(R.id.wt);
        height=(TextView)findViewById(R.id.ht);
        bgroup=(TextView)findViewById(R.id.bgrp);
        gender=(TextView)findViewById(R.id.gen);
        surgery=(TextView)findViewById(R.id.surg);
        medi=(TextView)findViewById(R.id.med);
        medcond=(TextView)findViewById(R.id.dis);
        final String refname=getIntent().getStringExtra("Name");
        refnamedialog=getIntent().getStringExtra("Name");
        mdref= FirebaseDatabase.getInstance().getReference().child("Users Info");
        cref=mdref.child(refname);
        pname.setText(refname);
        cref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                page.setText(dataSnapshot.child("age").getValue().toString());
                weight.setText(dataSnapshot.child("wgt").getValue().toString());
                height.setText(dataSnapshot.child("hgt").getValue().toString());
                bgroup.setText(dataSnapshot.child("grp").getValue().toString());
                gender.setText(dataSnapshot.child("gender").getValue().toString());
                surgery.setText(dataSnapshot.child("surg").getValue().toString());
                medi.setText(dataSnapshot.child("medc").getValue().toString());
                medcond.setText(dataSnapshot.child("medcon").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        heartbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),HeartBeat.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.phone:
                Intent launch=getPackageManager().getLaunchIntentForPackage("com.android.dialer");
                if(launch!=null){
                    startActivity(launch);
                }
                break;
            case R.id.share:
                String s1=pname.getText().toString();
                String s2=page.getText().toString();
                String s3=weight.getText().toString();
                String s4=height.getText().toString();
                String s5=bgroup.getText().toString();
                String s6=gender.getText().toString();
                String s7=surgery.getText().toString();
                String s8=medi.getText().toString();
                String s9=medcond.getText().toString();
                Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String sharingtext=("Patient Details:\n\n"+"Name:"+s1+"    "+"\n\n"+"Age:"+s2+"     "+"Weight:"+s3+"      "+"Height:"+s4+"   "+"\n\n"+"Blood Group:"+s5+"        "+"Gender:"+s6+" "+"\n\n"+"Prior Surgeries:"+s7+"\n\n"+"Prior Medication:"+s8+"  "+"\n\n"+"Prior Medical Conditions:"+s9+" "+"\n\n");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,sharingtext);
                startActivity(Intent.createChooser(sharingIntent,"Share Via:"));
                break;
            case R.id.item1:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Age");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(page.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String upage=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("age").setValue(upage);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        dialog.cancel();
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.item2:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Weight");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(weight.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String upwgt=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("wgt").setValue(upwgt);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        dialog.cancel();
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.item3:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Height");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(height.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String uphgt=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("hgt").setValue(uphgt);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        dialog.cancel();
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.item4:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Surgeries");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(surgery.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String upsurg=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("surg").setValue(upsurg);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        dialog.cancel();
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.item5:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Medication");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(medi.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String upmedc=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("medc").setValue(upmedc);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.item6:
                dialog=new Dialog(Show.this);
                dialog.setTitle("Update Medical Conditions");
                dialog.setContentView(R.layout.update_layout);
                dialog.show();
                up=(Button)dialog.findViewById(R.id.update);
                can=(Button)dialog.findViewById(R.id.cancel);
                //head=(TextView)dialog.findViewById(R.id.textView);
                changes=(EditText)dialog.findViewById(R.id.makechange);
                changes.setText(medcond.getText().toString());
                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String upmedcon=changes.getText().toString();
                        DatabaseReference mg=FirebaseDatabase.getInstance().getReference().child("Users Info");
                        mg.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot.getRef().child(refnamedialog).child("medcon").setValue(upmedcon);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        dialog.cancel();
                    }
                });
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

