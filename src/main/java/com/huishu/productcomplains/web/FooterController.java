package com.huishu.productcomplains.web;

import com.huishu.productcomplains.common.AjaxResult;
import com.huishu.productcomplains.model.ConnectionInfo;
import com.huishu.productcomplains.model.FriendlyLink;
import com.huishu.productcomplains.model.Menu;
import com.huishu.productcomplains.service.FooterService;
import com.huishu.productcomplains.service.HearderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/footer")
public class FooterController extends BaseController{

    private   Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HearderService hearderService;
    @Autowired
    private FooterService footerService;
    /*
    * h获取菜单
    * */
    @ResponseBody
    @RequestMapping(value = "getFooterMenu")
    public AjaxResult getMenu(){
        List<Menu> list = hearderService.getMenu();
        return success(list);
    }
    /*
    * 获取友情链接
    *
    * */
    @ResponseBody
    @RequestMapping(value = "getLinks")
    public AjaxResult getLink(){
        List<FriendlyLink> list  =  footerService.getLinks();
        return success(list);
    }
    @ResponseBody
    @RequestMapping(value="getConnectionInfo")
    public AjaxResult getConnectionInfo(){
        List<ConnectionInfo>  list = footerService.getConnctionInfo();
        return success(list);
    }


}
