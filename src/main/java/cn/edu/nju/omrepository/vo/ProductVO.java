package cn.edu.nju.omrepository.vo;

import java.util.Date;

public class ProductVO {

    private Integer Id;
    private String barCode;
    private String productName;
    private Integer primeCost;
    private Integer productPrice;
    private Date createTime;
    private String supply;
    private int balance;
    private int addNumber;

    public ProductVO() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(Integer primeCost) {
        this.primeCost = primeCost;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(int addNumber) {
        this.addNumber = addNumber;
    }
}
