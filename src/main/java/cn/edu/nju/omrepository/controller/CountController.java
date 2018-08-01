package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.SaleStageView;
import cn.edu.nju.omrepository.view.StoreStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class CountController implements Initializable {

    @FXML
    void productAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(MainStageView.class);
    }

    @FXML
    void storeAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(StoreStageView.class);
    }

    @FXML
    void saleAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(SaleStageView.class);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
