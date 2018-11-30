package cn.org.linkage.entity;

import java.util.Date;

public class SysFactory {
    private Integer id;

    private String facUsername;

    private String facPassword;

    private String facMsg;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacUsername() {
        return facUsername;
    }

    public void setFacUsername(String facUsername) {
        this.facUsername = facUsername == null ? null : facUsername.trim();
    }

    public String getFacPassword() {
        return facPassword;
    }

    public void setFacPassword(String facPassword) {
        this.facPassword = facPassword == null ? null : facPassword.trim();
    }

    public String getFacMsg() {
        return facMsg;
    }

    public void setFacMsg(String facMsg) {
        this.facMsg = facMsg == null ? null : facMsg.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}