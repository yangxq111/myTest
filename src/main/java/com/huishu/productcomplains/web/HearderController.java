package com.huishu.productcomplains.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.productcomplains.common.AjaxResult;
import com.huishu.productcomplains.model.Menu;
import com.huishu.productcomplains.service.HearderService;

@Controller
@RequestMapping(value = "/hearder")
public class HearderController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HearderService hearderService;
	
	@ResponseBody
	@RequestMapping(value = "/getMenu", method=RequestMethod.POST)
	public AjaxResult getMenu(){
		try {
			List<Menu> list = hearderService.getMenu();
			return success(list);
		} catch (Exception e) {
			logger.error("获取菜单失败！", e.getMessage());
			return null;  
		}
	}
	
}
