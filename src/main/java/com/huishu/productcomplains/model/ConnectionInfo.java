package com.huishu.productcomplains.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="t_footer_connection")
public class ConnectionInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
