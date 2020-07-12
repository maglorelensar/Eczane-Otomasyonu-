/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eczaneotomasyonu.Tablo;

/**
 *
 * @author zimba
 */
public abstract class ilacABS {
    
    private String ilac_no;
    private int ilac_adet;
    private String ilac_ad;
    private double fiyat;

    //Overload
    public ilacABS() {

    }

    public ilacABS(String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        this.ilac_no = ilac_no;
        this.ilac_adet = ilac_adet;
        this.ilac_ad = ilac_ad;
        this.fiyat = fiyat;
    }

    public ilacABS(String ilac_no) {
        this.ilac_no = ilac_no;
    }

    public void ilacKullanimTalimati() {
        System.out.println("İlaçları Nasıl kullanmalıyım ?? ");
    }
 
    public abstract String IlacTipi();
    
    public String IlacKullanimKlavuz() {
        return "Sabah aksam 1 er kez";
    }

    public String getIlac_no() {
        return ilac_no;
    }

    public void setIlac_no(String ilac_no) {
        this.ilac_no = ilac_no;
    }

    public int getIlac_adet() {
        return ilac_adet;
    }

    public void setIlac_adet(int ilac_adet) {
        this.ilac_adet = ilac_adet;
    }

    public String getIlac_ad() {
        return ilac_ad;
    }

    public void setIlac_ad(String ilac_ad) {
        this.ilac_ad = ilac_ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "İLAÇ BİLGİLERİ : \n" + "ilac_no=" + ilac_no + "\nilac_adet=" + ilac_adet + "\nilac_ad=" + ilac_ad + "\nfiyat=" + fiyat;
    }

}


