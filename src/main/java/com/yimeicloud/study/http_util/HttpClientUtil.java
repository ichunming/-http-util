package com.yimeicloud.study.http_util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
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
	
	/**
	 * POST请求
	 */
	public static String post(String url, String param) {
		
		String result = null;
		
		// 构造client
		HttpClient client = HttpClientBuilder.create().build();
		
		// 构造post请求
		HttpPost request = new HttpPost(url);
		try {
			// 封装请求参数
			StringEntity entity = new StringEntity(param, "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
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
