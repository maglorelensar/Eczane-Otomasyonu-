package eczaneotomasyonu.Tablo;

public class Merhem extends ilacABS implements Marka{

    int merhemkapasitesi;

    public Merhem(int merhemkapasitesi, String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        super(ilac_no, ilac_adet, ilac_ad, fiyat);
        this.merhemkapasitesi = merhemkapasitesi;
    }

   

    public int getMerhemkapasitesi() {
        return merhemkapasitesi;
    }

    public void setMerhemkapasitesi(int merhemkapasitesi) {
        this.merhemkapasitesi = merhemkapasitesi;
    }

     public void ilacKullanimTalimati(){
        System.out.println("Merhem kullanım talimatları ..");
    }
    @Override
    public String IlacTipi() {
        return "Merhem";
    }   

    @Override
    public String IlacMarkasi() {
       return "Ben-GAY";
    }

}
