package cn.org.linkage.entity;

import java.util.Date;

public class SysTemplate {
    private Integer id;

    private String ttitle;

    private String tproperty;

    private Integer status;

    private Integer pcid;

    private Integer fid;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle == null ? null : ttitle.trim();
    }

    public String getTproperty() {
        return tproperty;
    }

    public void setTproperty(String tproperty) {
        this.tproperty = tproperty == null ? null : tproperty.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}