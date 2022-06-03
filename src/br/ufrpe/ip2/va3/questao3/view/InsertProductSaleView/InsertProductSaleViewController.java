package br.ufrpe.ip2.va3.questao3.view.InsertProductSaleView;

/**
 * Sample Skeleton for 'InsertProductSaleView' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import br.ufrpe.ip2.va3.questao3.controller.Controller;
import br.ufrpe.ip2.va3.questao3.model.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InsertProductSaleViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="createButton"
    private Button createButton; // Value injected by FXMLLoader

    @FXML // fx:id="dateLabel"
    private Label dateLabel; // Value injected by FXMLLoader

    @FXML // fx:id="datePicker"
    private DatePicker datePicker; // Value injected by FXMLLoader

    @FXML // fx:id="priceLabel"
    private Label priceLabel; // Value injected by FXMLLoader

    @FXML // fx:id="priceTextField"
    private TextField priceTextField; // Value injected by FXMLLoader

    @FXML // fx:id="productPicker"
    private ComboBox<String> productPicker; // Value injected by FXMLLoader

    @FXML // fx:id="productSelectionLabel"
    private Label productSelectionLabel; // Value injected by FXMLLoader

    @FXML // fx:id="storeLabel"
    private Label storeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="storePicker"
    private ComboBox<String> storePicker; // Value injected by FXMLLoader

    @FXML // fx:id="storeSelectionLabel"
    private Label storeSelectionLabel; // Value injected by FXMLLoader

    @FXML // fx:id="titleLabel"
    private Label titleLabel; // Value injected by FXMLLoader

    private Controller controller;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
    }

    public void initWithData(Controller controller) {
        this.controller = controller;
        ObservableList<Store> stores = FXCollections.observableArrayList(controller.getStores());
            this.storePicker.setItems(FXCollections.observableArrayList(stores.stream().map(m -> m.getName()).collect(Collectors.toList())));
    }
}
