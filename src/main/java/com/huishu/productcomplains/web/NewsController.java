package com.huishu.productcomplains.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huishu.productcomplains.model.ProductComplains;
import com.huishu.productcomplains.service.LoginTestService;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/details.do")
	public String index(){
		return "/page/news/details";  
	}
	
}
