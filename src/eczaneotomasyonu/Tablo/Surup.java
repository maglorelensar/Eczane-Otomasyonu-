package eczaneotomasyonu.Tablo;

public class Surup extends ilacABS {

    int surupkapasitesi;

    public Surup(int surupkapasitesi, String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        super(ilac_no, ilac_adet, ilac_ad, fiyat);
        this.surupkapasitesi = surupkapasitesi;
    }

    

    public int getSurupkapasitesi() {
        return surupkapasitesi;
    }

    public void setSurupkapasitesi(int surupkapasitesi) {
        this.surupkapasitesi = surupkapasitesi;
    }

     public void ilacKullanimTalimati(){
        System.out.println("Surub kullanım talimatları .. ");
    }
    @Override
    public String IlacTipi() {
        return "Surup";
    }

}
