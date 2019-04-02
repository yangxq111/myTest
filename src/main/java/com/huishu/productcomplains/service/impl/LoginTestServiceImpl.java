package com.huishu.productcomplains.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.productcomplains.mapper.ProductComplainsMapper;
import com.huishu.productcomplains.model.ProductComplains;
import com.huishu.productcomplains.service.LoginTestService;

@Service
public class LoginTestServiceImpl implements LoginTestService {

	@Autowired
	private ProductComplainsMapper productComplainsMapper;
	@Override
	public List<ProductComplains> getProductComplainsList() {
		List<ProductComplains> list = productComplainsMapper.getProductComplainsList();
		return list;
	}

}
