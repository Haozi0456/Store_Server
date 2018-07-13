package com.zwh.store.entity;

import java.util.Date;

public class Manager {
    private Integer id;

    private String account;

    private String password;

    private Date createtime;

    private Integer dataflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDataflag() {
        return dataflag;
    }

    public void setDataflag(Integer dataflag) {
        this.dataflag = dataflag;
    }
}