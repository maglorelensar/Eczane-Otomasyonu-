package eczaneotomasyonu.Tablo;

public class Tablet extends ilacABS {
    
    int tabletkapasitesi;

    public Tablet(int tabletkapasitesi, String ilac_no, int ilac_adet, String ilac_ad, double fiyat) {
        super(ilac_no, ilac_adet, ilac_ad, fiyat);
        this.tabletkapasitesi = tabletkapasitesi;
    }
    
   

    public int getTabletkapasitesi() {
        return tabletkapasitesi;
    }

    public void setTabletkapasitesi(int tabletkapasitesi) {
        this.tabletkapasitesi = tabletkapasitesi;
    }
    
     public void ilacKullanimTalimati(){
        System.out.println("Tablet kullanım talimatları .. ");
    }

    @Override
    public String IlacTipi() {
        return "Tablet";
    }
    
}
