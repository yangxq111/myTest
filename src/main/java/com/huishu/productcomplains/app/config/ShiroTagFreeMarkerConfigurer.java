package com.huishu.productcomplains.app.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.huishu.productcomplains.shiro.HasAnyPermissionsTag;
import com.huishu.productcomplains.shiro.LacksAnyPermissionsTag;
import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.Configuration;

/**
 * 使FreeMarker支持Shiro标签
 */
@Component
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {

	@Autowired
	private Configuration configuration;

	@Autowired
	private FreeMarkerViewResolver resolver;

	@Override
	public void afterPropertiesSet() throws Exception {
		// 加上这句后，可以在页面上使用shiro标签
		ShiroTags tags=new ShiroTags();
    	tags.put("hasAnyPermissions", new HasAnyPermissionsTag());
    	tags.put("lacksAnyPermissions", new LacksAnyPermissionsTag());
    	configuration.setSharedVariable("shiro", tags);
		// 加上这句后，可以在页面上用${context.contextPath}获取contextPath
		resolver.setRequestContextAttribute("context");
	}
}