package com.nurettingorsoy.recyclerviewadapter.Model;

public class Manzara {
   private String imageurl;
   private String baslik;
   private String tanim;

    public Manzara() {
    }

    public Manzara(String imageurl, String baslik, String tanim) {
        this.imageurl = imageurl;
        this.baslik = baslik;
        this.tanim = tanim;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getTanim() {
        return tanim;
    }
}
