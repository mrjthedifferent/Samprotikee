package com.odepe.samprotikee;

public class Model {

    public static final int IMAGE_TYPE =1;
    public String tab, title, subtitle, Image, time;
    public int type;


    public Model (int mtype, String mtab, String mtitle, String msubtitle, String image, String time  ){

        this.tab = mtab;
        this.title = mtitle;
        this.subtitle = msubtitle;
        this.type = mtype;
        this.Image = image;
        this.time = time;
    }
}

