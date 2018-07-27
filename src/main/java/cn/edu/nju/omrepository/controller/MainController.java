package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.service.TempService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class MainController implements Initializable {

    @Resource
    private TempService tempService;

    @FXML
    void onClick(ActionEvent event) {
        tempService.addProduct();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
