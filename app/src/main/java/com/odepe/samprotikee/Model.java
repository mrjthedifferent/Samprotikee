package com.odepe.samprotikee;

public class Model {

    public static final int IMAGE_TYPE =1;
    public String title, subtitle, Image, time;
    public int type;


    public Model (int mtype, String mtitle, String msubtitle, String image, String time  ){

        this.title = mtitle;
        this.subtitle = msubtitle;
        this.type = mtype;
        this.Image = image;
        this.time = time;
    }
}

