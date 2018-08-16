package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.OmRepositoryApplication;
import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.view.CountStageView;
import cn.edu.nju.omrepository.view.MainStageView;
import cn.edu.nju.omrepository.view.SaleStageView;
import cn.edu.nju.omrepository.view.StoreStageView;
import cn.edu.nju.omrepository.vo.ProductVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private Pane previewPane;

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

    @FXML
    private TableView<ProductVO> productTablePreview;

    @FXML
    private TableColumn<ProductVO, String> barCodeColPreview;

    @FXML
    private TableColumn<ProductVO, String> nameColPreview;

    @FXML
    private TableColumn<ProductVO, Integer> primeColPreview;

    @FXML
    private TableColumn<ProductVO, String> saleColPreview;

    @FXML
    private TableColumn<ProductVO, String> supplyColPreview;

    @FXML
    private TableColumn<ProductVO, Integer> addColPreview;

    @FXML
    private TableColumn<ProductVO, Integer> presentBalPreview;

    @FXML
    private TextField addNumber;

    @FXML
    private Label detailBarcode;

    @FXML
    private Label detailName;

    @FXML
    private Label detailBalance;

    @FXML
    private Label detailPrimePrice;

    @FXML
    private Label addNumWarning;

    @FXML
    private Pane addProjectDetailPane;

    private ObservableList<ProductVO> productList = FXCollections.observableArrayList();
    private ObservableList<ProductVO> productListPreview = FXCollections.observableArrayList();
    private List<ProductVO> addToStore = FXCollections.observableArrayList();
    private ProductVO addToStoreVO = new ProductVO();
    private int changeCount = 0;
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
        cutPane(addToStorePane);
        barCheckPane.setVisible(true);
        nameCheckPane.setVisible(false);

        barCode.clear();
        productTable.getItems().clear();
    }

    @FXML
    void addToStoreActionByName (ActionEvent event) {
        cutPane(addToStorePane);
        barCheckPane.setVisible(false);
        nameCheckPane.setVisible(true);

        nameInput.clear();
        productTable.getItems().clear();
    }

    @FXML
    void confirm (ActionEvent event) {
        confirmPane.setVisible(false);
        checkAll(new ActionEvent());
    }

    @FXML
    void checkAll(ActionEvent event) {
        cutPane(allProductPane);

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

            addProject();
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

            addProject();
        } else {
            checkWarning.setVisible(true);
            checkWarning.setText("请正确输入商品名称！");
        }

    }

    @FXML
    void detailConfirm(ActionEvent event) {
        if (!addNumber.getText().isEmpty()) {
            addToStoreVO.setAddNumber(Integer.valueOf(addNumber.getText()));
            addToStore.add(addToStoreVO);

            addProjectDetailPane.setVisible(false);
            addNumber.clear();
            nameInput.clear();
            barCode.clear();
        } else {
            addNumWarning.setVisible(true);
            addNumWarning.setText("请输入数量");
        }
    }

    @FXML
    void closeDetail(ActionEvent event) {
        addProjectDetailPane.setVisible(false);
    }

    @FXML
    void preview(ActionEvent event) {
        cutPane(previewPane);

        productListPreview.clear();
        productListPreview.addAll(addToStore);
        productTablePreview.setItems(productListPreview);

        barCodeColPreview.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBarCode()));
        nameColPreview.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductName()));
        primeColPreview.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPrimeCost()).asObject());
        saleColPreview.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductPrice().toString()));
        supplyColPreview.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSupply()));
        addColPreview.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getAddNumber()).asObject());
        presentBalPreview.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getBalance()).asObject());
    }

    @FXML
    void previewConfirm(ActionEvent event) {
        tempService.addToStore(addToStore);
        productListPreview.clear();
        confirmPane.setVisible(true);
    }

    @FXML
    void continuesAdd(ActionEvent event) {
        cutPane(addToStorePane);
    }

    private void addProject() {
        productTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductVO>() {
            @Override
            public void changed(ObservableValue<? extends ProductVO> observable, ProductVO oldValue, ProductVO newValue) {
                if (changeCount % 2 == 0) {
                    addNumber.clear();
                    addNumWarning.setVisible(false);
                    addProjectDetailPane.setVisible(true);
                    detailBalance.setText(String.valueOf(observable.getValue().getBalance()));
                    detailName.setText(observable.getValue().getProductName());
                    detailBarcode.setText(observable.getValue().getBarCode());
                    detailPrimePrice.setText(String.valueOf(observable.getValue().getPrimeCost()));

                    addToStoreVO = tempService.checkProductByID(observable.getValue().getId());
                }
                changeCount ++;
            }
        });
    }

    private void cutPane(Pane showPane) {
        allProductPane.setVisible(false);
        addToStorePane.setVisible(false);
        previewPane.setVisible(false);

        showPane.setVisible(true);
    }

}
