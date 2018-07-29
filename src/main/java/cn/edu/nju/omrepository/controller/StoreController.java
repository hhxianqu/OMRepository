package cn.edu.nju.omrepository.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    private Button storeAboutButton;

    @FXML
    private Pane addToStorePane;

    @FXML
    private Pane confirmPane;

    @FXML
    private Pane outStorePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storeAboutButton.setStyle("-fx-background-color: #ed6973; -fx-text-fill: white;");
        addToStorePane.setVisible(true);
    }

    @FXML
    void productAboutAction(ActionEvent event) {

    }

    @FXML
    void saleAboutAction (ActionEvent event) {
    }

    @FXML
    void countAboutAction (ActionEvent event) {
    }

    @FXML
    void addToStoreAction (ActionEvent event) {
        addToStorePane.setVisible(true);
        outStorePane.setVisible(false);
    }

    @FXML
    void outStoreAction (ActionEvent event) {
        addToStorePane.setVisible(false);
        outStorePane.setVisible(true);
    }

    @FXML
    void confirm (ActionEvent event) {
    }


}
