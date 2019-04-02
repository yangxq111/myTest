package com.huishu.productcomplains.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huishu.productcomplains.common.AjaxResult;
import com.huishu.productcomplains.service.ProductComplainsService;
import com.huishu.productcomplains.shiro.MyShiroRealm.ShiroUser;

/*
 * @Description: 产品投诉
 * @author yxq
 * @date: 2018年1月10日 上午11:32:29
 */
@Controller
@RequestMapping(value = "/productcomplains")
public class ProductComplainsController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductComplainsService productComplainsService;
	
	/*
	 * @Description: 投诉全景统计图数据
	 * @author yxq
	 * @date: 2018年1月10日 上午11:35:40
	 */
	@RequestMapping(value = "/statisticsView", method=RequestMethod.POST)
	public AjaxResult getStatisticsView(){
		ShiroUser currentShiroUser = getCurrentShiroUser();
		Object data = null;
		return success(data);
	}
	
}
