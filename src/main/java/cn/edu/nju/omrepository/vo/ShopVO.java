package cn.edu.nju.omrepository.vo;

public class ShopVO {

    private String shopName;
    private String shopAddress;
    private int shopPrice;

    public ShopVO() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public int getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(int shopPrice) {
        this.shopPrice = shopPrice;
    }
}
