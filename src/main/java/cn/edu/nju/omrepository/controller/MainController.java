package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.vo.ProductVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.annotation.Resource;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@FXMLController
public class MainController implements Initializable {

    private ProductVO productVO = new ProductVO();

    @Resource
    private TempService tempService;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private Pane addProductPane;

    @FXML
    private Pane checkProductPane;

    @FXML
    private TextField barCode;

    @FXML
    private TextField productName;

    @FXML
    private TextField primeCost;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField supply;

    @FXML
    void addProduct(ActionEvent event) {
        productVO.setBarCode(barCode.getText());
        productVO.setProductName(productName.getText());
        productVO.setPrimeCost(Integer.valueOf(primeCost.getText()));
        productVO.setProductPrice(Integer.valueOf(productPrice.getText()));
        productVO.setSupply(supply.getText());
        System.out.println((checkInDatePicker.getEditor()));

        tempService.addProduct(productVO);

    }

    @FXML
    void addProductMenu(ActionEvent event) {
        addProductPane.setVisible(true);
        checkProductPane.setVisible(false);
    }

    @FXML
    void checkProductMenu(ActionEvent event) {
        checkProductPane.setVisible(true);
        addProductPane.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //初始化日期控件
        checkInDatePicker.setValue(LocalDate.now());
        checkInDatePicker.setShowWeekNumbers(true);



    }
}
