package cn.edu.nju.omrepository.entity;

import cn.edu.nju.omrepository.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_info")
public class OrderInfo {
    private Integer id;
    private int shopID;
    private Date createTime;

    public OrderInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "shop_id")
    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
