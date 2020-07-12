package dao;



import eczaneotomasyonu.Tablo.ilacKYT;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import util.DBConnection;


public class IlacKayitDao {
      private Connection c;


    public Connection getC() {
        this.c = new DBConnection().getConnection();
        return c;
    }

       /*
       public boolean Kaydet(ilacKYT arac) {
        dosyaYazma.SatirlaraEkle(arac.getIlac_no() + "@"
                + arac.getIlac_adet() + "@"
                + arac.getIlac_ad() + "@"
                + arac.getFiyat() + "@"
        );
        return true;
       }
*/
    //Veri tabanındaki verileri Okuma işlemi/Read
    public List<ilacKYT> getList() {
        List<ilacKYT> hlist = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from hastagiris");

            //isteğe bağlı for ile optimize edilebilir !
            while (rs.next()) {
          hlist.add(new ilacKYT(rs.getString("ilac_no"), rs.getInt("ilac_adet"),
          rs.getString("ilac_ad"), rs.getDouble("ilac_fiyat")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hlist;
    }
    
    //Veri tabanına kayıt /Create  
    public void add(ilacKYT i) {
         List<ilacKYT> ilist = new ArrayList<>();
         
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into ilackayit values('" +i.getIlac_no()+ "'," + 
            "'" + i.getIlac_adet() + "','" + i.getIlac_ad()+ "','" + i.getFiyat()+  "',default);");
        } catch (Exception e) {
            System.out.println(e.getMessage());
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                   UYARI");
            alert.setContentText("                          Bu ilaç zaten mevcut !!");

            alert.showAndWait();
            
        }
        ilist.add(i);
    }
    
       public void delete(ilacKYT i) {

        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from ilackayit where ilac_no=" +"'"+i.getIlac_no()+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
         public void update(ilacKYT i) {
        try {
            Statement st = this.getC().createStatement();

            st.executeUpdate("Update ilackayit set ilac_no='" + i.getIlac_no() + "',ilac_adet='" + 
                   i.getIlac_adet() + "',ilac_ad='" + 
                   i.getIlac_ad()+"',ilac_fiyat='" + 
                   i.getFiyat()+ "' where ilac_no='" + i.getIlac_no() + "'");
            System.out.println("Güncelleme başarılı");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Güncelleme başarısız");
        }
    }
       
}


   