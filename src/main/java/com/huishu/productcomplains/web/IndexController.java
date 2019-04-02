package com.huishu.productcomplains.web;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huishu.productcomplains.model.ProductComplains;
import com.huishu.productcomplains.service.LoginTestService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginTestService loginTestService;
	@RequestMapping("/login.do")
	public String login(){
		return "/login";
	}
	@RequestMapping(value = "/admin/generateKey.do")
	public String login(String username, String password){
		JSONObject jsonObject = new JSONObject();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		subject.getSession().setTimeout(10000);
		try {
			subject.login(token);

			jsonObject.put("token",subject.getSession().getId());
			jsonObject.put("msg","登录成功");
			return "redirect:/index.do";
		}catch (IncorrectCredentialsException e) {
			jsonObject.put("msg", "密码错误");
		} catch (LockedAccountException e) {
			jsonObject.put("msg", "登录失败，该用户已被冻结");
		} catch (AuthenticationException e) {
			jsonObject.put("msg", "该用户不存在");
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "redirect:/login.do";
	}
	@RequestMapping("/")
	public String index(){
		return "/page/index/index";
	}
	@RequestMapping("index.do")
	public String index1(){
		return "/page/index/index";
	}
	@RequestMapping("solution.do")
	public String solution(){
		return "/page/solution/solution";  
	}
	@RequestMapping("programWebsite.do")
	public String programWebsite(){
		return "/page/programWebsite/programWebsite";  
	}
	@RequestMapping("about.do")
	public String about(){
		return "/page/about/about";  
	}
	@RequestMapping("clientCase.do")
	public String clientCase(){
		return "/page/clientCase/clientCase";  
	}
	@RequestMapping("news.do")
	public String news(){
		return "/page/news/news";  
	}
	@RequestMapping("technicalSupport.do")
	public String technicalSupport(){
		return "/page/technicalSupport/technicalSupport";  
	}
	@RequestMapping("contact.do")
	public String contact(){
		return "/page/contact/contact";  
	}
	@RequestMapping("logout.do")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login";
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
