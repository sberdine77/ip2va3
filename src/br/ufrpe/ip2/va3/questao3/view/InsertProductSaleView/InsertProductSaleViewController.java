package br.ufrpe.ip2.va3.questao3.view.InsertProductSaleView;

/**
 * Sample Skeleton for 'InsertProductSaleView' Controller Class
 */

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;

import br.ufrpe.ip2.va3.questao3.controller.Controller;
import br.ufrpe.ip2.va3.questao3.model.Product;
import br.ufrpe.ip2.va3.questao3.model.ProductSale;
import br.ufrpe.ip2.va3.questao3.model.Store;
import br.ufrpe.ip2.va3.questao3.view.HelperViews.NumberTextField;
import br.ufrpe.ip2.va3.questao3.view.ListProductSalesView.ListProductSalesViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.Node;

public class InsertProductSaleViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="createButton"
    private Button createButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton;

    @FXML // fx:id="dateLabel"
    private Label dateLabel; // Value injected by FXMLLoader

    @FXML // fx:id="datePicker"
    private DatePicker datePicker; // Value injected by FXMLLoader

    @FXML // fx:id="priceLabel"
    private Label priceLabel; // Value injected by FXMLLoader

    @FXML // fx:id="priceTextField"
    private NumberTextField priceTextField; // Value injected by FXMLLoader

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

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Controller controller;

    private ObservableList<Store> stores;
    private ObservableList<Product> products;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
    }

    public void initWithData(Controller controller) {
        this.controller = controller;

        this.stores = FXCollections.observableArrayList(controller.getStores());
        this.storePicker.setItems(FXCollections.observableArrayList(stores.stream().map(m -> m.getName()).collect(Collectors.toList())));

        this.products = FXCollections.observableArrayList(controller.getProducts());
        this.productPicker.setItems(FXCollections.observableArrayList(products.stream().map(m -> m.getName()).collect(Collectors.toList())));

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
        this.datePicker.setValue(LocalDate.now());
    }

    @FXML
    void createAction(ActionEvent event) {
        if(!storePicker.getSelectionModel().isEmpty() && !productPicker.getSelectionModel().isEmpty() && datePicker.getValue() != null && priceTextField.getText() != null || !priceTextField.getText().trim().isEmpty()) {
            int productIndex = productPicker.getSelectionModel().getSelectedIndex();
            int storeIndex = storePicker.getSelectionModel().getSelectedIndex();
            ProductSale newSale = new ProductSale(this.products.get(productIndex), this.stores.get(storeIndex), datePicker.getValue(), Double.parseDouble(priceTextField.getText().trim()), UUID.randomUUID().toString());
            try {
                this.controller.addProductSale(newSale);
                System.out.println("Oferta cadastrada com sucesso");
                createAnAlert(AlertType.INFORMATION, "Sucesso", null, "Oferta criada com sucesso!");
            } catch (Exception e) {
                System.out.println("Não foi possível cadastrar oferta");
                e.printStackTrace();
                this.createAnAlert(AlertType.ERROR, "Erro", "Não foi possível criar a sua oferta", e.getMessage());
            }
        } else {
            System.out.println("Preencha todos os campos para cadastrar uma oferta");
            this.createAnAlert(AlertType.ERROR, "Erro", null, "Preencha todos os campos para cadastrar uma oferta");
        }
    }

    void createAnAlert(AlertType type, String alertTitle, String alertHeader, String alertMessage) {
        Alert alert = new Alert(type);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeader);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    @FXML
    void backAction(ActionEvent event) throws Exception {
        backToListView(event);
    }

    void backToListView(Event event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/ListProductSalesView/ListProductSalesView.fxml"));
        this.root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setTitle("Lista de ofertas");
        this.stage.setScene(this.scene);
        ListProductSalesViewController controller = fxmlLoader.getController();
        controller.initWithData(this.controller);
        this.stage.show();
    }
}
