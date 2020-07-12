
package eczaneotomasyonu;


import dao.IlacTxtDao;
import eczaneotomasyonu.Tablo.Ilac;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author g3250
 */
public class İlacTxtKayitController implements Initializable {
    
    @FXML
    private TextField txtIlacNo;
    @FXML
    private TextField txtIlacAd;
    @FXML
    private TextField txtIlacFiyat;
    @FXML
    private TextField txtIlacAdet;
    @FXML
    private DatePicker KayitTarihi;

    @FXML
    private TableView<Ilac> tableView;

    IlacTxtDao ilactxtdao;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ilactxtdao = new IlacTxtDao();

        düzenleButonuEkle();
        silButonuEkle();

        ilacListesi();

    }

    @FXML
    private void ilacKaydet(ActionEvent event) throws IOException {

        Ilac ilac = new Ilac(txtIlacNo.getText(), txtIlacAd.getText(), txtIlacFiyat.getText(), txtIlacAdet.getText(), KayitTarihi.getValue().toString());

        ilactxtdao.ilacKaydet(ilac);
        
        ilacListesi();

        txtIlacNo.setText(null);
        txtIlacAd.setText(null);
        txtIlacFiyat.setText(null);
        txtIlacAdet.setText(null);
        KayitTarihi.setValue(null);
    }

    private void ilacListesi() {
        ArrayList<Ilac> ilacListesi = ilactxtdao.ilacListesiGetir();

        ObservableList<Ilac> data = tableView.getItems();
        data.clear();
          
        for (Ilac ilac : ilacListesi) {
            data.add(ilac);
        }
          System.out.println("------------------------");
          System.out.println(data);
          System.out.println("------------------------");
    }

    void IlacSil(Ilac ilac) {
        ilactxtdao.Sil(ilac);
        ilacListesi();
    }

    private void düzenleButonuEkle() {
        TableColumn actionCol = new TableColumn("Düzenle");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Ilac, String>, TableCell<Ilac, String>> cellFactory
                = //
                new Callback<TableColumn<Ilac, String>, TableCell<Ilac, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Ilac, String> param) {
                        final TableCell<Ilac, String> cell = new TableCell<Ilac, String>() {

                            final Button btnedit = new Button("Düzenle");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    btnedit.setOnAction(event -> {
                                        Ilac ilac = getTableView().getItems().get(getIndex());
                                        IlacSil(ilac);

                                        txtIlacNo.setText(ilac.getIlac_no());
                                        txtIlacAd.setText(ilac.getIlac_ad());
                                        txtIlacFiyat.setText(ilac.getFiyat());
                                        txtIlacAdet.setText(ilac.getIlac_adet());
                                        String date = "";
                                        LocalDate localDate = null;
                                        DateTimeFormatter formatter = null;

                                        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                        localDate = LocalDate.parse(ilac.getIlac_kayit_tarihi(), formatter);

                                        KayitTarihi.setValue(localDate);
                                    });
                                    setGraphic(btnedit);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);
        tableView.getColumns().add(actionCol);
    }

    private void silButonuEkle() {
        TableColumn actionCol = new TableColumn("Sil");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Ilac, String>, TableCell<Ilac, String>> cellFactory
                = //
                new Callback<TableColumn<Ilac, String>, TableCell<Ilac, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Ilac, String> param) {
                        final TableCell<Ilac, String> cell = new TableCell<Ilac, String>() {

                            final Button btn = new Button("Sil");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Ilac ilac = getTableView().getItems().get(getIndex());
                                        Alert alert = new Alert(AlertType.INFORMATION, "Silmek İstediginize Emin misiniz? Ilac txtIlacNo : " + ilac.getIlac_no()+ " ?", 
                                                ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                                        alert.showAndWait();

                                        if (alert.getResult() == ButtonType.YES) {
                                            IlacSil(ilac);
                                        }

                                    });
                                    setGraphic(btn);

                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);
        tableView.getColumns().add(actionCol);
    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
          Parent x = FXMLLoader.load(getClass().getResource("IlacKayit.fxml"));

        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

       //Yeni Açılan Pencerenin ekranın ortasında görüntülenebilmesi için ....
        double width = 822;
        double height = 456;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

}
