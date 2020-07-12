package dao;

import eczaneotomasyonu.Tablo.ilacKYT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import util.DBConnection;

public class IlacAraDao {

    private Connection c;

    public Connection getC() {
        this.c = new DBConnection().getConnection();
        return c;
    }

    public List<ilacKYT> ilacAra(ilacKYT i) {
        List<ilacKYT> aramalistesi = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from ilackayit where ilac_no='" + i.getIlac_no() + "'");

            while (rs.next()) {
                ilacKYT tmp = new ilacKYT(rs.getString("ilac_no"), rs.getInt("ilac_adet"),
                        rs.getString("ilac_ad"), rs.getDouble("ilac_fiyat"));
                if (rs.getString("ilac_no") == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText("                                   UYARI");
                    alert.setContentText("                           İlaç stokta mevcut değil !!");

                    alert.showAndWait();
                }
                aramalistesi.add(tmp);
            }
            System.out.println("Arama Başarılı");
            return aramalistesi;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Arama Başarısız");

        }
        return aramalistesi;
    }
}





 
