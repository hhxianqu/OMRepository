package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.StoreStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SaleController implements Initializable {

    @FXML
    private Pane addMarketMenu;

    @FXML
    private Pane orderMenu;

    @FXML
    void productAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(MainStageView.class);
    }

    @FXML
    void storeAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(StoreStageView.class);
    }

    @FXML
    void countAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(CountStageView.class);
    }

    @FXML
    void addMarket(ActionEvent event) {
        addMarketMenu.setVisible(true);
        orderMenu.setVisible(false);
    }


    @FXML
    void orderPaneAction(ActionEvent event) {
        orderMenu.setVisible(true);
        addMarketMenu.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
