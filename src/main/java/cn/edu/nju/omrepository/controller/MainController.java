package cn.edu.nju.omrepository.controller;

import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.util.DateUtil;
import cn.edu.nju.omrepository.util.WindowUtil;
import cn.edu.nju.omrepository.vo.ProductVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import javax.annotation.Resource;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class MainController implements Initializable {

    private ProductVO productVO = new ProductVO();

    @Resource
    private TempService tempService;

    @FXML
    private DatePicker createTime;

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
    private TextField barInput;

    @FXML
    private Button productAboutButton;

    @FXML
    private Label barCodeWarning;

    @FXML
    private Label primeCostWarning;

    @FXML
    private Label productNameWarning;

    @FXML
    private Label productPriceWarning;

    @FXML
    private Label supplyWarning;

    @FXML
    private Pane confirmPane;

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

    private DateUtil dateUtil = new DateUtil();

    private ObservableList<ProductVO> productList = FXCollections.observableArrayList();

    private WindowUtil window = new WindowUtil();

    @FXML
    void addProduct(ActionEvent event) throws ParseException {

        if (doWarning()) {
            productVO.setBarCode(barCode.getText());
            productVO.setProductName(productName.getText());
            productVO.setPrimeCost(Integer.valueOf(primeCost.getText()));
            productVO.setProductPrice(Integer.valueOf(productPrice.getText()));
            productVO.setSupply(supply.getText());
            productVO.setCreateTime(dateUtil.localdateToDate(createTime.getValue()));
            productVO.setBalance(0);

            tempService.addProduct(productVO);

            confirmPane.setVisible(true);
        }
    }

    @FXML
    void addProductMenu(ActionEvent event) {
        addProductPane.setVisible(true);
        checkProductPane.setVisible(false);
    }

    @FXML
    void checkProductMenu (ActionEvent event) {
        checkProductPane.setVisible(true);
        addProductPane.setVisible(false);
    }

    @FXML
    void storeAboutAction (ActionEvent event) {
        window.changeScene("/fxml/store.fxml", event);
    }

    @FXML
    void saleAboutAction (ActionEvent event) {
    }

    @FXML
    void countAboutAction (ActionEvent event) {
    }

    @FXML
    void confirm (ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void checkProduct(ActionEvent event) {
        String barCode = barInput.getText();
        List<ProductVO> productVOList = tempService.checkProduct(barCode);
        productList.addAll(productVOList);

        productTable.setItems(productList);

        barCodeCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBarCode()));
        nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductName()));
        primeCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getPrimeCost()).asObject());
        saleCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProductPrice().toString()));
        supplyCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSupply()));
        balanceCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getBalance()).asObject());
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        //初始化日期控件
        createTime.setValue(LocalDate.now());
        createTime.setShowWeekNumbers(true);

        productAboutButton.setStyle("-fx-background-color: #ed6973; -fx-text-fill: white;");

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isAfter(createTime.getValue())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #EEEEEE;");
                        }
                    }
                };
            }
        };
        createTime.setDayCellFactory(dayCellFactory);
    }


    private boolean doWarning() {
        boolean test = true;

        //条码检测
        if (barCode.getText().isEmpty()) {
            barCodeWarning.setVisible(true);
            barCodeWarning.setText("请输入条码！");
            test = false;
        } else if (barCode.getText().length() >= 15) {
            barCodeWarning.setVisible(true);
            barCodeWarning.setText("条码长度应小于15！");
            test = false;
        }

        //商品名称检测
        if (productName.getText().isEmpty()) {
            productNameWarning.setVisible(true);
            productNameWarning.setText("请输入商品名称！");
            test = false;
        } else if (productName.getText().length() >= 20){
            productNameWarning.setVisible(true);
            productNameWarning.setText("商品名称应小于20字！");
            test = false;
        }

        //进价检测
        if (primeCost.getText().isEmpty()) {
            primeCostWarning.setVisible(true);
            primeCostWarning.setText("请输入进价！");
            test = false;
        }

//        int num = Integer.valueOf(primeCost.getText());



        if (productPrice.getText().isEmpty()) {
            productPriceWarning.setVisible(true);
            productPriceWarning.setText("请输入售价！");
            test = false;
        }

        if (supply.getText().isEmpty()) {
            supplyWarning.setVisible(true);
            supplyWarning.setText("请输入从何处进货！");
            test = false;
        } else if (supply.getText().length() >= 20){
            supplyWarning.setVisible(true);
            supplyWarning.setText("供货商名字应小于20字！");
            test = false;
        }


        return test;

    }

}
