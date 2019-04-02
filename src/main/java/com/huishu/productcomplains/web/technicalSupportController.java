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
@RequestMapping(value = "/technicalSupport")
public class technicalSupportController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginTestService loginTestService;
	
	@RequestMapping("/details.do")
	public String index(){
		return "/page/technicalSupport/details";  
	}
	
	@RequestMapping("testmysql.do")
	public String test1(Map<String,Object> map){
		List<ProductComplains> list = loginTestService.getProductComplainsList();
		map.put("name", "[Angel -- 守护天使]");  
		map.put("age", "1000000");  
		map.put("list", list);  
		return "hello";  
	}
	public String testSechduler(){
		List<ProductComplains> list = loginTestService.getProductComplainsList();
		for (ProductComplains productComplains : list) {
			System.out.println(productComplains.getArea());
			System.out.println(productComplains.getComplainsTime());
		}
		return null;
		
	}
}
