
package dao;

import eczaneotomasyonu.DosyaIslemleri.Dosya;

import eczaneotomasyonu.Tablo.Ilac;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class IlacTxtDao {
    
    Dosya dosyaOkumaYazma;
   

    public IlacTxtDao() {
        dosyaOkumaYazma = new Dosya("ilacdata.txt");
        
    }

    public boolean ilacKaydet(Ilac ilac) {
        dosyaOkumaYazma.SatirlaraEkle(ilac.getIlac_no()+ "@"
                + ilac.getIlac_ad()+ "@"
                + ilac.getFiyat()+ "@"
                + ilac.getIlac_adet()+ "@"
                + ilac.getIlac_kayit_tarihi()+ "#" 
        );

        return true;
    }

    public ArrayList<Ilac> ilacListesiGetir() {
        ArrayList<Ilac> ilacListesi = new ArrayList<>();

        String ilacDosyaStr = dosyaOkumaYazma.TumSatirlariGetir();
        if (ilacDosyaStr.length() == 1 || ilacDosyaStr.length() == 0) {
            return ilacListesi;
        }
        String[] ilaclarlarStr = ilacDosyaStr.split("#");

        for (String ilacDStr : ilaclarlarStr) {
            String[] ilacStr = ilacDStr.split("@");
            Ilac ilac = new Ilac(ilacStr[0], ilacStr[1], ilacStr[2], ilacStr[3], ilacStr[4]);
            ilacListesi.add(ilac);
        }

        return ilacListesi;

    }

    public void Sil(Ilac ilac) {

        ArrayList<Ilac> ilacListesi = this.ilacListesiGetir();

        ilacListesi.removeIf(x -> (x.getIlac_no()== null ? ilac.getIlac_no() != null : x.getIlac_no().equals(ilac.getIlac_no())));

        dosyaOkumaYazma.SatirlariSil();

        for (Ilac ilc : ilacListesi) {
            this.ilacKaydet(ilc);
        }

    }
}
