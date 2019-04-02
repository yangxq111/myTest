package com.huishu.productcomplains.shtechown.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huishu.productcomplains.shtechown.utils.HttpRequest;

public class MessageTest {

	 public static void main(String[] args) {
	       /* //发送 GET 请求
	        String s=HttpRequest.sendGet("http://172.16.18.234/plain/SmsMt.php", "acctno=cust001&passwd=111111&mobile=15657376123&msg= 【签名】内容");
	        System.out.println(s);*/
	        String objectStr="{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
	        
	        JSONObject  parse = JSON.parseObject(objectStr);
	        String str = (String) parse.get("name");
	        System.out.println(str);
	        String jsonString = JSON.toJSONString(parse);
	        System.out.println(jsonString);
	       /* //发送 POST 请求
	        String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
	        System.out.println(sr);*/
	    }
}
