package com.huishu.productcomplains.service.impl;

import com.huishu.productcomplains.model.TSysManager;
import com.huishu.productcomplains.repository.SysManagerRepository;
import com.huishu.productcomplains.service.SysManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/2.
 */
@Service
public class SysManagerServiceImpl implements SysManagerService {
    @Autowired
    private SysManagerRepository sysManagerRepository;
    @Override
    public TSysManager selectByAccount(String userName) {
        return sysManagerRepository.selectByAccount(userName);
    }
}
