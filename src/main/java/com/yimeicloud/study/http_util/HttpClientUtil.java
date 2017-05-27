package com.yimeicloud.study.http_util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	/**
	 * GET请求
	 */
	public static String get(String url) {
		
		String result = null;
		
		// 构造client
		HttpClient client = HttpClientBuilder.create().build();
		
		// 构造get请求
		HttpGet request = new HttpGet(url);
		try {
			// 发送get请求
			HttpResponse response = client.execute(request);
			
			// 请求成功，并得到响应
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 解析响应字符
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			} else {
				System.out.println("GET请求失败");
			}
			
			
		} catch (IOException e) {
			System.out.println("GET请求失败");
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * POST请求
	 */
	public static String post(String url, String param) {
		
		String result = null;
		
		BasicCookieStore cookieStore = new BasicCookieStore();
        // 新建一个Cookie
        BasicClientCookie cookie1 = new BasicClientCookie("UM_distinctid", "15b0dacdb431af-0cc4ceb35dc668-396b4c0b-100200-15b0dacdb44385");
        BasicClientCookie cookie2 = new BasicClientCookie("ASP.NET_SessionId", "u5htj3gdgkkljmlntvdp2gzf");
        cookieStore.addCookie(cookie1);
        cookieStore.addCookie(cookie2);
        
		// 构造client
        CloseableHttpClient client = HttpClients.custom()
		        .setDefaultCookieStore(cookieStore).build();
		
		// 构造post请求
		HttpPost request = new HttpPost(url);
		try {
			// 封装请求参数
			StringEntity entity = new StringEntity(param, "utf-8");
			entity.setContentEncoding("UTF-8");
			//entity.setContentType("application/json");
			request.setEntity(entity);
			
			// 发送post请求
			HttpResponse response = client.execute(request);
			
			// 请求成功，并得到响应
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 解析响应字符
				result = EntityUtils.toString(response.getEntity());
			} else {
				System.out.println("GET请求失败");
			}
			
			
		} catch (IOException e) {
			System.out.println("GET请求失败");
			e.printStackTrace();
		}
		
		return result;
	}
}
