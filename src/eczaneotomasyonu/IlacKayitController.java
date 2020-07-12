package eczaneotomasyonu;


import dao.IlacKayitDao;
import eczaneotomasyonu.Tablo.ilacKYT;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;

public class IlacKayitController implements Initializable {

    IlacKayitDao ilacKayitdao;
    //private Button closeButton
    @FXML
    private TableView tblview;

    @FXML
    private Button closeButton;

    @FXML
    private TextField txtNo;
    @FXML
    private TextField txtAd;
    @FXML
    private TextField txtFiyat;
    @FXML
    private TextField txtAdet;

    private DBConnection db;
    private IlacKayitDao ik;
    private ilacKYT ilac;

    public ilacKYT getIlac() {
        if(this.ilac==null)
            this.ilac=new ilacKYT();
        return ilac;
    }       

    public IlacKayitDao getIk() {
        if(this.ik==null)
            this.ik=new IlacKayitDao();
        return ik;
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
    
    @FXML
    private void btnKaydet(ActionEvent event) {
        //Cast Conver işlemi String ifadeyi integere dönüştürdüm
       int x = Integer.parseInt(txtAdet.getText());
   
       double y = Double.valueOf(txtFiyat.getText());
       
        ilacKYT ilc=new ilacKYT(txtNo.getText(), x, txtAd.getText(), y);
        getIk().add(ilc);
        dataTransfer(tblview);
        txtNo.setText("");
        txtAdet.setText("");
        txtAd.setText("");
        txtFiyat.setText("");
        
    }
      @FXML
    private void btnSil(ActionEvent event) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("                                          ONAYLA");
        alert.setHeaderText(tblview.getSelectionModel().getSelectedItems().get(0).toString());
        alert.setContentText("Bu kaydı silmek istediğinize emin misiniz?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            TableColumn col = pos.getTableColumn();
            //
            String data = (String) col.getCellObservableValue(row).getValue();
            System.out.println(data);
            getIlac().setIlac_no(data);
            getIk().delete(getIlac());        
            dataTransfer(tblview);
        } else {
         
        }
   
    }
     ObservableList<String> hlist;
      @FXML
    private void btnDuzenle(ActionEvent event) {
       
        //hlist=FXCollections.observableArrayList();
        //Tablomdaki seçmiş olduğum modelin verilerini bir listeye aktardım  
        /*get(0) Object tipinde olması sayesin farklı türde(int String double .. gibi)
        verileri bir listede topladık */
        hlist = (ObservableList<String>) tblview.getSelectionModel().getSelectedItems().get(0);
        System.out.println(hlist.get(0));
        // String a=hlist.get(0);
        /*Listeme aktarmış olduğum verileri txtField alanlarıma set ederek sergiledim ve Amacım
        ( veriler üzerinde yapılıcak eğişiklikleri güncelle metoduyla kaydetmek*/
        txtNo.setText(hlist.get(0));
        txtAdet.setText(hlist.get(1));
        txtAd.setText(hlist.get(2));
        txtFiyat.setText(hlist.get(3));      
      
        // txtTc.setText(hlist.get(0).toString());
        System.out.println(hlist);
    }
  @FXML
    private void btnGuncelle(ActionEvent event) {
        
     int x = Integer.parseInt(txtAdet.getText());
   
       double y = Double.valueOf(txtFiyat.getText());
       
        ilacKYT ilc=new ilacKYT(txtNo.getText(), x, txtAd.getText(), y);
        getIk().update(ilc);
        dataTransfer(tblview);
        txtNo.setText("");
        txtAdet.setText("");
        txtAd.setText("");
        txtFiyat.setText("");
        

    }

    @FXML
    private void btnFormTemizle(ActionEvent event) {
        txtNo.setText("");
        txtAdet.setText("");
        txtAd.setText("");
        txtFiyat.setText("");
    }
  


    @FXML
    private void btnGörüntüle(ActionEvent event) {
        dataTransfer(tblview);
    }

    @FXML
    private void btnKapat(ActionEvent event) {
        tblview.getItems().removeAll(aa);
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
    void CLoseBtn(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

        // window.initStyle(StageStyle.TRANSPARENT);
        //window.centerOnScreen();
        double width = 600;
        double height = 400;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

    @FXML
    private void btnIlacTxtKayit(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("IlacTxtKayit.fxml"));

        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

       //Yeni Açılan Pencerenin ekranın ortasında görüntülenebilmesi için ....
        double width = 711;
        double height = 450;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

  

  

   

}
