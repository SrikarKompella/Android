package com.srikar.ppfinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by prasadkompella on 25/01/17.
 */

public class DataObccesubjects extends RecyclerView.Adapter<DataObccesubjects.ViewHolder> {
    int realflag, a = 1,realpos;
    Context context;

    public DataObccesubjects(Context context, int flag,int realpos) {
        this.context = context;
        realflag = flag;
        this.realpos=realpos;
    }


//    private String[] titles = {
//            "Sem Three",
//            "Sem Four",
//            "Sem Five",
//            "Sem Six",
//            "Sem Seven"
//    };

    private String[] sem4 = {
            "APT",
            "ES",
            "OS",
            "MATHS",
            "TCP/IP",
            "OE"
    };
    private String[] sem5 = {
            "SDT",
            "HSCN",
            "PE1",
            "PP",
            "DBS",
            "FAAD"
    };
    private String[] sem3 = {
            "OOP",
            "DS",
            "DSD",
            "DC",
            "MATHS"
    };
    private String[] sem6 = {
            "PE2",
            "PE3",
            "OE",
            "WCC",
            "EEFM",
            "DMPA"
    };
    private String[] sem7 = {
            "Subject 1",
            "Subject 2",
            "Subject 3",
            "Subject 4",
            "Subject 5",
            "Subject 6"
    };


    public String returnstring(String s) {
        return s;
    }


//    private String[] details = {"Item one details",
//            "Item two details", "Item three details",
//            "Item four details", "Item file details",
//            "Item six details", "Item seven details",
//            "Item eight details"};

//    private int[] images = {R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//                };


    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            //itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title_subject);
            //itemDetail =
            //7(TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();


                    int actualpos = position + a;
                    if(realpos==3&&realflag==5&&actualpos==1){
                        Intent i=new Intent(context,Swipe.class);
                        i.putExtra("key1",realpos);
                        i.putExtra("key2",realflag);
                        i.putExtra("key3",actualpos);
                        context.startActivity(i);

                    }
                    else if(realpos==3&&realflag==5&&actualpos==2){
                        Intent i=new Intent(context,Swipe.class);
                        i.putExtra("key1",realpos);
                        i.putExtra("key2",realflag);
                        i.putExtra("key3",actualpos);
                        context.startActivity(i);
                    }
//                    else if(realpos==3){
//                        Intent i=new Intent(context,Subjectsix.class);
//                        i.putExtra("key","CCE sem5 subjects");
//                        context.startActivity(i);
//                    }

//                    Snackbar.make(v, "You have clicked on subject" + " " + realpos,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();



                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.subjectcards, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (realflag == 5) {
            viewHolder.itemTitle.setText(sem3[i]);
        } else if(realflag==6){
            viewHolder.itemTitle.setText(sem4[i]);
        }
        else if(realflag==7){
            viewHolder.itemTitle.setText(sem5[i]);
        }
        else if(realflag==8){
            viewHolder.itemTitle.setText(sem6[i]);
        }
        else if(realflag==9){
            viewHolder.itemTitle.setText(sem7[i]);
        }
        //viewHolder.itemDetail.setText(details[i]);
        //viewHolder.itemImage.setImageResource(images[i]);
    }


    @Override
    public int getItemCount() {
        if (realflag == 5) {
            return sem3.length;
        } else {
            return sem4.length;
        }


    }
}

