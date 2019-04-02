package com.huishu.productcomplains.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 友情链接的实体类
 */
@Entity
@Table(name="t_footer_friendlylink")
public class FriendlyLink implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="linktitle")
    private String linkTitle;
    @Column(name="linkurl")
    private String linkurl;
    @Column(name="is_used")
    private Integer used;
    @Column(name="sort")
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
