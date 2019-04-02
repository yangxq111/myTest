package com.huishu.productcomplains.repository;

import com.huishu.productcomplains.model.TSysManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/2.
 */
@Repository
public interface SysManagerRepository extends JpaRepository<TSysManager, Integer> {
    @Query(value="select id,username,password,realname from t_username where username=?1",nativeQuery =true)
    TSysManager selectByAccount(String userName);
}
