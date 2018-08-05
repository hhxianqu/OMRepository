package cn.edu.nju.omrepository.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class ShopInfo {

    private Integer id;
    private String shopName;
    private String shopAddress;
    private int shopPrice;

    public ShopInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column(name = "shop_address")
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Column(name = "shop_price")
    public int getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(int shopPrice) {
        this.shopPrice = shopPrice;
    }
}
