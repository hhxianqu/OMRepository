package cn.edu.nju.omrepository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_info")
public class ProductInfo {
    private Integer id;
    private String barCode;
    private String productName;
    private Integer primeCost;
    private Integer productPrice;
    private Date createTime;
    private String supply;
    private int balance;


    public ProductInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "bar_code")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "prime_cost")
    public Integer getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(Integer primeCost) {
        this.primeCost = primeCost;
    }

    @Column(name = "product_price")
    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "supply")
    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
