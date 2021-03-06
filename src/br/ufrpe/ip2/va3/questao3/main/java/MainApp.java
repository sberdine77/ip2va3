package br.ufrpe.ip2.va3.questao3.main.java;

import br.ufrpe.ip2.va3.questao3.controller.Controller;
import br.ufrpe.ip2.va3.questao3.view.ListProductSalesView.ListProductSalesViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    Controller mainController = new Controller();
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/ListProductSalesView/ListProductSalesView.fxml"));
        Parent root = fxmlLoader.load();
        Scene insertProductSaleSreen = new Scene(root,600,400);
        primaryStage.setTitle("Lista de ofertas");
        primaryStage.setScene(insertProductSaleSreen);
        ListProductSalesViewController controller = fxmlLoader.getController();
        controller.initWithData(this.mainController);
        primaryStage.show(); 
    }  
    public static void main(String[] args) {
        launch(args);
    }
}