package br.ufrpe.ip2.va3.questao3.view.ListProductSalesView;

import java.io.IOException;

/**
 * Sample Skeleton for 'ListProductSalesView.fxml' Controller Class
 */

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import br.ufrpe.ip2.va3.questao3.controller.Controller;
import br.ufrpe.ip2.va3.questao3.view.InsertProductSaleView.InsertProductSaleViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.Node;

public class ListProductSalesViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="datePicker"
    private DatePicker datePicker; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="searchLabel"
    private Label searchLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabbleView"
    private TableView<?> tabbleView; // Value injected by FXMLLoader

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Controller controller;

    @FXML
    void addSaleAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/InsertProductSaleView/InsertProductSaleView.fxml"));
            root = fxmlLoader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Insira uma nova oferta");
            stage.setScene(scene);
            InsertProductSaleViewController controller = fxmlLoader.getController();;
            controller.initWithData(this.controller);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }

    public void initWithData(Controller controller) {
        this.controller = controller;
        this.tabbleView.setPlaceholder(new Label("Sem ofertas nessa data"));
        this.datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            @Override 
            public String toString(LocalDate date) {
                if (date != null) {
                    return formatter.format(date);
                } else {
                    return "";
                }
            }

            @Override 
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, formatter);
                } else {
                    return null;
                }
            }
        });
    }
}
