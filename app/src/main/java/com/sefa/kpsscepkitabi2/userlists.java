package com.sefa.kpsscepkitabi2;

public class userlists {

    private int eklendigi_kutu;
    private int unitesi;
    private String bilgi_kendi;


    public userlists() {
    }

    public userlists(int eklendigi_kutu, int unitesi, String bilgi_kendi) {
        this.eklendigi_kutu = eklendigi_kutu;
        this.unitesi = unitesi;
        this.bilgi_kendi = bilgi_kendi;
    }

    public int getEklendigi_kutu() {
        return eklendigi_kutu;
    }

    public void setEklendigi_kutu(int eklendigi_kutu) {
        this.eklendigi_kutu = eklendigi_kutu;
    }

    public int getUnitesi() {
        return unitesi;
    }

    public void setUnitesi(int unitesi) {
        this.unitesi = unitesi;
    }

    public String getBilgi_kendi() {
        return bilgi_kendi;
    }

    public void setBilgi_kendi(String bilgi_kendi) {
        this.bilgi_kendi = bilgi_kendi;
    }
}






