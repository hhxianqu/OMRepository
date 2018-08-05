package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.service.ShopService;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.StoreStageView;
import cn.edu.nju.omrepository.vo.ProductVO;
import cn.edu.nju.omrepository.vo.ShopVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SaleController implements Initializable {

    @FXML
    private TextField shopName;

    @FXML
    private TextField shopAddress;

    @FXML
    private TextField shopPrice;

    @FXML
    private Pane addMarketMenu;

    @FXML
    private Pane orderMenu;

    @FXML
    private Label shopNameWarning;

    @FXML
    private Label shopAddressWarning;

    @FXML
    private Label shopPriceWarning;

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

    private ShopVO shopVO = new ShopVO();
    private ShopService shopService;

    @FXML
    void addShopAction(ActionEvent event) {
        addMarketMenu.setVisible(true);
        orderMenu.setVisible(false);
    }

    @FXML
    void orderPaneAction(ActionEvent event) {
        orderMenu.setVisible(true);
        addMarketMenu.setVisible(false);
    }

    @FXML
    void addShop(ActionEvent event) {
        if (doWarning()) {
            shopVO.setShopName(shopName.getText());
            shopVO.setShopAddress(shopAddress.getText());
            shopVO.setShopPrice(Integer.valueOf(shopPrice.getText()));

            shopService.addShop(shopVO);

        }


    }

    @FXML
    void onClick(MouseEvent event) {
        shopNameWarning.setVisible(false);
        shopAddressWarning.setVisible(false);
        shopPriceWarning.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private boolean doWarning() {
        boolean test = true;

        //名称检测
        if (shopName.getText().isEmpty()) {
            shopNameWarning.setVisible(true);
            shopNameWarning.setText("请输入商店名称！");
            test = false;
        } else if (shopName.getText().length() >= 20) {
            shopNameWarning.setVisible(true);
            shopNameWarning.setText("商店名称应小于20字！");
            test = false;
        }

        if (shopAddress.getText().isEmpty()) {
            shopAddressWarning.setVisible(true);
            shopAddressWarning.setText("请输入商店地址描述！");
            test = false;
        } else if (shopAddress.getText().length() >= 40) {
            shopAddressWarning.setVisible(true);
            shopAddressWarning.setText("商店地址描述请少于40字！");
            test = false;
        }


        if (shopPrice.getText().isEmpty()) {
            shopPriceWarning.setVisible(true);
            shopPriceWarning.setText("请输入价格！");
            test = false;
        }

        try {
            int num = Integer.valueOf(shopPrice.getText());
        } catch (NumberFormatException e) {
            shopPriceWarning.setVisible(true);
            shopPriceWarning.setText("请正确输入价格，不要含有特殊字符");
            test = false;
        }


        return test;
    }
}
