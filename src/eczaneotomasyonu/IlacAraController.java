package eczaneotomasyonu;

import dao.IlacAraDao;
import eczaneotomasyonu.Tablo.ilacKYT;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;

public class IlacAraController implements Initializable {

    //TableView<IlacRapor> tableView;
    @FXML
    Button closeButton;

    @FXML
    private TextField txtIlacno;
    private TableView tblvv;

    IlacAraDao iad;
    DBConnection db;
    @FXML
    private TextArea txtArea;

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public IlacAraDao getIad() {
        if (this.iad == null) {
            this.iad = new IlacAraDao();
        }
        return iad;
    }

    @FXML
    private void btnIlacAra(ActionEvent event) {
        //Overload

        ilacKYT ilac = new ilacKYT(txtIlacno.getText());
        System.out.println("---------------------------------------------");
        System.out.println(getIad().ilacAra(ilac).toString());
        System.out.println("---------------------------------------------");
        System.out.println("İLAÇ BULUNDU ! " + getIad().ilacAra(ilac).toString());
        System.out.println("---------------------------------------------");
        txtArea.setText(getIad().ilacAra(ilac).toString());
        System.out.println("---------------------------------------------");

        txtIlacno.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void CloseBtn(ActionEvent event) {
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
    private void btnDepo(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("Depo.fxml"));

        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

        // window.initStyle(StageStyle.TRANSPARENT);
        //window.centerOnScreen();
        double width = 600;
        double height = 500;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

    @FXML
    private void btnTxtAreaTemizle(ActionEvent event) {
        txtArea.setText("");
    }

}
