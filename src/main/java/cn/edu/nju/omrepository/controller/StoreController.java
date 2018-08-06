package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.SaleStageView;
import cn.edu.nju.omrepository.vo.ProductVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class StoreController implements Initializable {

    @FXML
    private Pane allProductPane;

    @FXML
    private Pane addToStorePane;

    @FXML
    private Pane confirmPane;

    @FXML
    private TextField barCode;

    @FXML
    private Pane nameCheckPane;

    @FXML
    private Pane barCheckPane;

    @FXML
    private TextField nameInput;


    @FXML
    private TableView<ProductVO> productTable;

    @FXML
    private TableColumn<ProductVO, String> barCodeCol;

    @FXML
    private TableColumn<ProductVO, String> nameCol;

    @FXML
    private TableColumn<ProductVO, Integer> primeCol;

    @FXML
    private TableColumn<ProductVO, String> saleCol;

    @FXML
    private TableColumn<ProductVO, String> supplyCol;

    @FXML
    private TableColumn<ProductVO, Integer> balanceCol;

    @FXML
    private TableColumn<ProductVO, String> createTimeCol;

    @FXML
    private Label checkWarning;

    @FXML
    private TableView<ProductVO> productTable1;

    @FXML
    private TableColumn<ProductVO, String> barCodeCol1;

    @FXML
    private TableColumn<ProductVO, String> nameCol1;

    @FXML
    private TableColumn<ProductVO, Integer> primeCol1;

    @FXML
    private TableColumn<ProductVO, String> saleCol1;

    @FXML
    private TableColumn<ProductVO, String> supplyCol1;

    @FXML
    private TableColumn<ProductVO, Integer> balanceCol1;

    @FXML
    private TableColumn<ProductVO, String> createTimeCol1;

    private ObservableList<ProductVO> productList = FXCollections.observableArrayList();
    private ObservableList<ProductVO> allProductList = FXCollections.observableArrayList();

    @Resource
    private TempService tempService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkAll(new ActionEvent());
    }

    @FXML
    void productAboutAction(ActionEvent event) {
        OmRepositoryApplication.showView(MainStageView.class);
    }

    @FXML
    void saleAboutAction (ActionEvent event) {
        OmRepositoryApplication.showView(SaleStageView.class);
    }

    @FXML
    void countAboutAction (ActionEvent event) {
        OmRepositoryApplication.showView(CountStageView.class);
    }

    @FXML
    void addToStoreActionByBar (ActionEvent event) {
        addToStorePane.setVisible(true);
        allProductPane.setVisible(false);
        barCheckPane.setVisible(true);
        nameCheckPane.setVisible(false);

        barCode.clear();
        productTable.getItems().clear();
    }

    @FXML
    void addToStoreActionByName (ActionEvent event) {
        addToStorePane.setVisible(true);
        allProductPane.setVisible(false);
        barCheckPane.setVisible(false);
        nameCheckPane.setVisible(true);

        nameInput.clear();
        productTable.getItems().clear();

    }

    @FXML
    void confirm (ActionEvent event) {
        OmRepositoryApplication.showView(MainStageView.class);
    }

    @FXML
    void checkAll(ActionEvent event) {
        allProductPane.setVisible(true);
        addToStorePane.setVisible(false);
        barCheckPane.setVisible(false);
        nameCheckPane.setVisible(false);

        List<ProductVO> productVOList = tempService.checkAllProduct();

        productTable1.getItems().clear();
        productList.clear();

        productList.addAll(productVOList);

        productTable1.setItems(productList);

        barCodeCol1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBarCode()));
        nameCol1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductName()));
        primeCol1.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPrimeCost()).asObject());
        saleCol1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductPrice().toString()));
        supplyCol1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSupply()));
        balanceCol1.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getBalance()).asObject());
        createTimeCol1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCreateTime().toString().substring(0, 10)));

    }

    @FXML
    void checkProductByBar(ActionEvent event) {
        addToStorePane.setVisible(true);
        productTable.getItems().clear();
        productList.clear();

        String barCodeInput = barCode.getText();

        if (! barCodeInput.isEmpty() && barCodeInput.length() <= 15) {
            List<ProductVO> productVOList = tempService.checkProductByBarcode(barCodeInput);
            productList.addAll(productVOList);

            productTable.setItems(productList);

            barCodeCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBarCode()));
            nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductName()));
            primeCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPrimeCost()).asObject());
            saleCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductPrice().toString()));
            supplyCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSupply()));
            balanceCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getBalance()).asObject());
            createTimeCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCreateTime().toString().substring(0, 10)));
        } else {
            checkWarning.setVisible(true);
            checkWarning.setText("请正确输入条码！");
        }

    }


    @FXML
    void checkProductByName(ActionEvent event) {
        productList.clear();
        productTable.getItems().clear();

        String productName = nameInput.getText();

        if (! productName.isEmpty() && productName.length() <= 20) {
            List<ProductVO> productVOList = tempService.checkProductByName(productName);
            productList.addAll(productVOList);

            productTable.setItems(productList);

            barCodeCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBarCode()));
            nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductName()));
            primeCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPrimeCost()).asObject());
            saleCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductPrice().toString()));
            supplyCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSupply()));
            balanceCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getBalance()).asObject());
            createTimeCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCreateTime().toString().substring(0, 10)));

        } else {
            checkWarning.setVisible(true);
            checkWarning.setText("请正确输入商品名称！");
        }
    }






}
