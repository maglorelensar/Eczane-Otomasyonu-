package eczaneotomasyonu.Tablo;

public class Sprey extends ilacABS {

    int spreykapasitesi;

    public Sprey(int spreykapasitesi, String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        super(ilac_no, ilac_adet, ilac_ad, fiyat);
        this.spreykapasitesi = spreykapasitesi;
    }

   

    public int getSpreykapasitesi() {
        return spreykapasitesi;
    }

    public void setSpreykapasitesi(int spreykapasitesi) {
        this.spreykapasitesi = spreykapasitesi;
    }
     public void ilacKullanimTalimati(){
        System.out.println("Sprey kullanım talimatları .. ");
    }

    @Override
    public String IlacTipi() {
        return "Sprey";
    }
}
