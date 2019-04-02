package com.huishu.productcomplains.service;

import com.huishu.productcomplains.model.TSysManager;

/**
 * Created by Administrator on 2018/7/2.
 */
public interface SysManagerService {
    TSysManager selectByAccount(String userName);
}
