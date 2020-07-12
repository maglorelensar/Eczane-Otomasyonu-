package eczaneotomasyonu.Tablo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;

public class ilacKYT {

    private String ilac_no;
    private int ilac_adet;
    private String ilac_ad;
    private double fiyat;

    //Overload
    public ilacKYT() {

    }

    public ilacKYT(String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        this.ilac_no = ilac_no;
        this.ilac_adet = ilac_adet;
        this.ilac_ad = ilac_ad;
        this.fiyat = fiyat;
    }

    public ilacKYT(String ilac_no) {
        this.ilac_no = ilac_no;
    }

    public void ilacKullanimTalimati() {
        System.out.println("İlaçları Nasıl kullanmalıyım ?? ");
    }

    public String IlacTipi() {
        return "İlac";
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
