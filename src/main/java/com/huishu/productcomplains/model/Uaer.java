package com.huishu.productcomplains.model;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;

public class Uaer {
    private String username;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uaer uaer = (Uaer) o;

        if (username != null ? !username.equals(uaer.username) : uaer.username != null) return false;
        return id != null ? id.equals(uaer.id) : uaer.id == null;
    }

    @Override
    public int hashCode() {

        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
