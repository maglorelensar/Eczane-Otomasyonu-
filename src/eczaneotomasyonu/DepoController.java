package eczaneotomasyonu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class DepoController implements Initializable {

   
    DBConnection db;
    @FXML
    private TableView<?> tbldepo;
    
    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void btnGörüntüle(ActionEvent event) {
        dataTransfer(tbldepo);
    }

    @FXML
    private void btnKapat(ActionEvent event) {
        tbldepo.getItems().removeAll(aa);
    }
       private ObservableList<ObservableList> aa;

    //Veri tabanımdaki verileri tableview'ime dinamik olarak set ettiğim yapı 
    protected void dataTransfer(TableView t) {
        t.getColumns().clear();
        Connection c;
        aa = FXCollections.observableArrayList();
        try {
            c = getDb().getConnection();
            //sql string ifademiz. 
            String SQL = "SELECT * from  ilackayit";//tablomuzun adı bilgi. id ve adi alanları var. 
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            // TABLO SÜTUNLARINI DİNAMİK OLARAK EKLEYECEĞİMİZ YAPI 
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                t.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");

            }

            //ObservableList e verileri ekleyen döngü
            while (rs.next()) {
                //Satırları yinele
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //sütunları yinele
                    row.add(rs.getString(i));
                }
                System.out.println("Satır eklendi " + row);
                aa.add(row);
            }

            //Sonucu tabloya ekleme
            t.setItems(aa);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hata oluştu");
        }
    }
       @FXML
    private void btnGeri(ActionEvent e) throws IOException {
         Parent x = FXMLLoader.load(getClass().getResource("IlacAra.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 819;
            double height = 450;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }

   
}
