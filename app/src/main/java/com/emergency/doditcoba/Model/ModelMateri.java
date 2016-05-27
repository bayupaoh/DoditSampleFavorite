package com.emergency.doditcoba.Model;

/**
 * Created by CodeLabs on 28/05/2016.
 */
public class ModelMateri {
    private int background;
    private String judul;
    private  String desc;

    public ModelMateri() {
    }

    public ModelMateri(int background, String judul, String desc) {
        this.background = background;
        this.judul = judul;
        this.desc = desc;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
