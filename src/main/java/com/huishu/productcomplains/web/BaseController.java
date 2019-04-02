package com.huishu.productcomplains.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.huishu.productcomplains.common.AjaxResult;
import com.huishu.productcomplains.shiro.MyShiroRealm.ShiroUser;

public abstract class BaseController {
	
	
	public AjaxResult success(Object data) {
		return new AjaxResult().setData(data).setSuccess(true).setStatus(0);
	}
	
	public AjaxResult error(String message) {
		return new AjaxResult().setMessage(message).setSuccess(false).setStatus(1);
	}

	public ShiroUser getCurrentShiroUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
	
}

