package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.service.ShopService;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.StoreStageView;
import cn.edu.nju.omrepository.vo.ShopVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.annotation.Resource;
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
    private TextField beginTime;

    @FXML
    private TextField endTime;

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
    private Label beginTimeWarning;

    @FXML
    private Label endTimeWarning;

    @FXML
    private Pane confirmPane;

    @FXML
    private TextField saleNumber;

    @FXML
    private Label detailBarcode;

    @FXML
    private Label detailName;

    @FXML
    private Label detailBalance;

    @FXML
    private Label detailSalePrice;

    @FXML
    private Label saleNumWarning;

    @FXML
    private Label checkWarning;

    @FXML
    private Pane saleProjectDetailPane;

    private ShopVO shopVO = new ShopVO();

    @Resource
    private ShopService shopService;

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
            shopVO.setBeginTime(beginTime.getText());
            shopVO.setEndTime(endTime.getText());

            shopService.addShop(shopVO);

            confirmPane.setVisible(true);

        }
    }

    @FXML
    void confirm(ActionEvent event) {
        confirmPane.setVisible(false);
        OmRepositoryApplication.showView(StoreStageView.class);
    }

    @FXML
    void onClick(MouseEvent event) {
        shopNameWarning.setVisible(false);
        shopAddressWarning.setVisible(false);
        shopPriceWarning.setVisible(false);
        endTimeWarning.setVisible(false);
        beginTimeWarning.setVisible(false);
    }

    @FXML
    void detailConfirm (ActionEvent event) {
        if (!saleNumber.getText().isEmpty()) {
            saleProjectDetailPane.setVisible(false);
        } else {
            saleNumWarning.setVisible(true);
            saleNumWarning.setText("请输入出库数量！");
        }
    }

    @FXML
    void closeDetail (ActionEvent event) {
        saleNumWarning.setVisible(false);
    }

    @FXML
    void preview(ActionEvent event) {

    }

    @FXML
    void previewConfirm(ActionEvent event) {

    }

    @FXML
    void checkProductByBar(ActionEvent event) {

    }

    @FXML
    void checkProductByName(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shopName.clear();
        shopAddress.clear();
        shopPrice.clear();
        beginTime.clear();
        endTime.clear();
    }

    //输入检测
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

        if (beginTime.getText().isEmpty()) {
            beginTimeWarning.setVisible(true);
            beginTimeWarning.setText("请输入开始结账日期");
            test = false;
        } else if (beginTime.getText().length() > 2) {
            beginTimeWarning.setVisible(true);
            beginTimeWarning.setText("仅需要输入日期");
            test = false;
        } else if (Integer.valueOf(beginTime.getText()) > 31 && Integer.valueOf(beginTime.getText()) < 1) {
            beginTimeWarning.setVisible(true);
            beginTimeWarning.setText("请正确输入日期（ < 31号）");
            test = false;
        }

        if (endTime.getText().isEmpty()) {
            endTimeWarning.setVisible(true);
            endTimeWarning.setText("请输入结账截止日期");
            test = false;
        } else if (endTime.getText().length() > 2) {
            endTimeWarning.setVisible(true);
            endTimeWarning.setText("仅需要输入日期");
            test = false;
        } else if (Integer.valueOf(endTime.getText()) < Integer.valueOf(beginTime.getText())) {
            endTimeWarning.setVisible(true);
            endTimeWarning.setText("截止日期需在开始日期之后");
            test = false;
        } else if (Integer.valueOf(endTime.getText()) > 31 && Integer.valueOf(endTime.getText()) < 1) {
            endTimeWarning.setVisible(true);
            endTimeWarning.setText("请正确输入日期（ < 31号）");
            test = false;
        }

        return test;
    }
}
