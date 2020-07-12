package eczaneotomasyonu.Tablo;

public class Sampuan extends ilacKYT implements Marka{

    int sampuankapasitesi;

    public Sampuan(int sampuankapasitesi, String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        super(ilac_no, ilac_adet, ilac_ad, fiyat);
        this.sampuankapasitesi = sampuankapasitesi;
    }

   

    public int getSampuankapasitesi() {
        return sampuankapasitesi;
    }

    public void setSampuankapasitesi(int sampuankapasitesi) {
        this.sampuankapasitesi = sampuankapasitesi;
    }

     public void ilacKullanimTalimati(){
        System.out.println("Sampuan kullanım talimatları .. ");
    }
    @Override
    public String IlacTipi() {
        return "Sampuan";
    }

    @Override
    public String IlacMarkasi() {
       return "ClearMan";
    }

}
