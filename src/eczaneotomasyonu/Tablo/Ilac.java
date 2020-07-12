
package eczaneotomasyonu.Tablo;

public class Ilac  {
    private String ilac_no;
    private String ilac_ad;
    private String fiyat;
    private String ilac_adet;
    private String ilac_kayit_tarihi;
    
    public Ilac() {
    }

    public Ilac(String ilac_no, String ilac_ad, String fiyat, String ilac_adet, String ilac_kayit_tarihi) {
        this.ilac_no = ilac_no;
        this.ilac_ad = ilac_ad;
        this.fiyat = fiyat;
        this.ilac_adet = ilac_adet;
        this.ilac_kayit_tarihi = ilac_kayit_tarihi;
    }

    public String getIlac_no() {
        return ilac_no;
    }

    public void setIlac_no(String ilac_no) {
        this.ilac_no = ilac_no;
    }

    public String getIlac_ad() {
        return ilac_ad;
    }

    public void setIlac_ad(String ilac_ad) {
        this.ilac_ad = ilac_ad;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getIlac_adet() {
        return ilac_adet;
    }

    public void setIlac_adet(String ilac_adet) {
        this.ilac_adet = ilac_adet;
    }

    public String getIlac_kayit_tarihi() {
        return ilac_kayit_tarihi;
    }

    public void setIlac_kayit_tarihi(String ilac_kayit_tarihi) {
        this.ilac_kayit_tarihi = ilac_kayit_tarihi;
    }
// Nesnenin String olarak servis edilmesini sağlar
    @Override
    public String toString() {
        return "Ilac{" + "ilac_no=" + ilac_no + ", ilac_ad=" + ilac_ad + ", fiyat=" + fiyat + ", ilac_adet=" + ilac_adet + ", ilac_kayit_tarihi=" + ilac_kayit_tarihi + '}';
    }

    
}
