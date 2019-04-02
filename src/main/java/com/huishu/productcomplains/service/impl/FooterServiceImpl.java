package com.huishu.productcomplains.service.impl;

import com.huishu.productcomplains.model.ConnectionInfo;
import com.huishu.productcomplains.model.FriendlyLink;
import com.huishu.productcomplains.repository.ConnectionInfoRepository;
import com.huishu.productcomplains.repository.FooterRepository;
import com.huishu.productcomplains.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FooterServiceImpl implements FooterService {
    @Autowired
    private FooterRepository footerRepository;
    @Autowired
    private ConnectionInfoRepository connectonInfoRepository;
    @Override
    public List<FriendlyLink> getLinks() {
            return footerRepository.getLinks();
        }

    @Override
        public List<ConnectionInfo> getConnctionInfo() {
            return connectonInfoRepository.getConnectionInfo();
    }
}
