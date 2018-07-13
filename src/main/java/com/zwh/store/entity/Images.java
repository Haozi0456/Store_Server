package com.zwh.store.entity;

import java.util.Date;

public class Images {
    private Integer imgid;

    private Integer fromtype;

    private Integer dataid;

    private String imgpath;

    private Integer imgsize;

    private Integer isuse;

    private Date createtime;

    private String fromtable;

    private Integer ownid;

    private Integer dataflag;

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public Integer getFromtype() {
        return fromtype;
    }

    public void setFromtype(Integer fromtype) {
        this.fromtype = fromtype;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public Integer getImgsize() {
        return imgsize;
    }

    public void setImgsize(Integer imgsize) {
        this.imgsize = imgsize;
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable;
    }

    public Integer getOwnid() {
        return ownid;
    }

    public void setOwnid(Integer ownid) {
        this.ownid = ownid;
    }

    public Integer getDataflag() {
        return dataflag;
    }

    public void setDataflag(Integer dataflag) {
        this.dataflag = dataflag;
    }
}