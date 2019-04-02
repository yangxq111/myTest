package com.huishu.productcomplains.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 友情链接的实体类
 */
@Entity
@Table(name="t_username")
public class TSysManager implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="username")
    private String adminAccount;
    @Column(name="password")
    private String password;
    @Column(name="realname")
    private String adminRealname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminRealname() {
        return adminRealname;
    }

    public void setAdminRealname(String adminRealname) {
        this.adminRealname = adminRealname;
    }
}
