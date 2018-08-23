package cn.edu.nju.omrepository.entity;


import javax.persistence.*;

@Entity
@Table(name = "product_in order")
public class ProductInOrderInfo {
    private Integer id;
    private int orderID;
    private int productID;
    private int productNum;

    public ProductInOrderInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "order_id")
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Column(name = "product_id")
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Column(name = "product_num")
    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
