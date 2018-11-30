package cn.org.linkage.entity;

import java.util.Date;

public class SysProduct {
    private Integer id;

    private String prucutName;

    private String productMsg;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrucutName() {
        return prucutName;
    }

    public void setPrucutName(String prucutName) {
        this.prucutName = prucutName == null ? null : prucutName.trim();
    }

    public String getProductMsg() {
        return productMsg;
    }

    public void setProductMsg(String productMsg) {
        this.productMsg = productMsg == null ? null : productMsg.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}