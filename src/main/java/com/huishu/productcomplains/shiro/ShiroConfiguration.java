package com.huishu.productcomplains.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by yuwei on 2016/12/22
 */
@Configuration
public class ShiroConfiguration {

   private final static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
    private final static Map<String, Filter> filters = new LinkedHashMap<String, Filter>();

    @Bean(name = "shiroDbRealm")
    public MyShiroRealm getShiroDbRealm() {
    	MyShiroRealm shiroRealm = new MyShiroRealm();
        //shiroRealm.setCredentialsMatcher(getCustomCredentialsMatcher());
        return shiroRealm;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

//    @Bean
//    public EhCacheManager ehCacheManager() {
//        EhCacheManager cacheManager = new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
//        return cacheManager;
//
//    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(new DefaultWebSessionManager());
        securityManager.setRealm(getShiroDbRealm());
       // securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    @Bean(name = "authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor auth = new AuthorizationAttributeSourceAdvisor();
        auth.setSecurityManager(getDefaultWebSecurityManager());
        return auth;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        filterChainDefinitionMap.put("/logout.do", "logout");

        filterChainDefinitionMap.put("/admin/generateKey.do", "anon");

        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/lib/**", "anon");
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        filters.put("authc", getMyFormAuthenticationFilter());
        filters.put("user", new UserFilter());
        shiroFilterFactoryBean.setFilters(filters);

        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setUnauthorizedUrl("/login.do");
        shiroFilterFactoryBean.setLoginUrl("/login.do");
        shiroFilterFactoryBean.setSuccessUrl("/");
        return shiroFilterFactoryBean;
    }

    @Bean(name = "loginFormAuthenticationFilter")
    public FormAuthenticationFilter getMyFormAuthenticationFilter() {
        return new FormAuthenticationFilter();
    }

    @Bean(name = "customCredentialsMatcher")
    public CustomCredentialsMatcher getCustomCredentialsMatcher() {
        return new CustomCredentialsMatcher();
    }
}
