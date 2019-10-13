package com.srikar.history20;

/**
 * Created by prasadkompella on 05/04/17.
 */

public class User {

    public String name;
    public String age;
    public String grp;
    public String wgt;
    public String hgt;
    public String gender;
    public String surg;
    public String medc;
    public String medcon;

    public User(){

    }

    public User(String age1,String grp1,String wgt1,String hgt1,String gender1,String surg1,String medc1,String medcon1){
        this.age=age1;
        this.grp=grp1;
        this.wgt=wgt1;
        this.hgt=hgt1;
        this.gender=gender1;
        this.surg=surg1;
        this.medc=medc1;
        this.medcon=medcon1;
    }

    public String getName(){
        return name;
    }

    public void setName(String name1){
        this.name=name1;
    }
}
