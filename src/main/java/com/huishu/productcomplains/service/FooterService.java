package com.huishu.productcomplains.service;

import com.huishu.productcomplains.model.ConnectionInfo;
import com.huishu.productcomplains.model.FriendlyLink;

import java.util.List;

public interface FooterService {
    List<FriendlyLink> getLinks();

    List<ConnectionInfo> getConnctionInfo();
}
