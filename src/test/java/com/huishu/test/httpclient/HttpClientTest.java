package com.huishu.test.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public class HttpClientTest {
    public static void main(String[] args)  throws Exception{
        testGet();
       // testPost();

    }

    public static void testPost()  throws Exception{
        List<BasicNameValuePair> valuePairList = new ArrayList<>();
        valuePairList.add(new BasicNameValuePair("account",""));
        valuePairList.add(new BasicNameValuePair("password",""));
        UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(valuePairList, "utf-8");
        RequestConfig build = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).setConnectionRequestTimeout(5000).build();

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://cnivi.com.cn/login");
        httpPost.setEntity(reqEntity);
        httpPost.setConfig(build);
        CloseableHttpResponse response = defaultHttpClient.execute(httpPost);
        Header[] allHeaders = response.getAllHeaders();
        System.out.print(response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode()==200){

        }
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity, "utf-8");
        System.out.print(s);
    }

    public static void testGet()  throws Exception{
        CloseableHttpClient clent = HttpClients.createDefault();
        try{
            HttpGet httpGet = new HttpGet("http://www.baidu.com/");
            System.out.println(httpGet.getURI());
            CloseableHttpResponse response = clent.execute(httpGet);
            Header[] allHeaders = response.getAllHeaders();
            for (Header h:allHeaders) {
                System.out.println(h);
            }
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");

            System.out.println(s);
            System.out.println(response.getStatusLine());
            System.out.println(entity.getContentLength());
            System.out.println(entity.getContentType());
            System.out.println(entity.getContentEncoding());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            clent.close();
        }

    }
}
