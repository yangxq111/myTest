package com.huishu.productcomplains.service.impl;

import java.util.List;

import com.huishu.productcomplains.model.Uaer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.productcomplains.model.Menu;
import com.huishu.productcomplains.repository.HearderRepository;
import com.huishu.productcomplains.service.HearderService;

@Service
public class HearderServiceImpl implements HearderService {

	@Autowired
	private HearderRepository hearderRepository;
	@Override
	public List<Menu> getMenu() {
		//return hearderRepository.getMenu();
		return  null;
	}

}
