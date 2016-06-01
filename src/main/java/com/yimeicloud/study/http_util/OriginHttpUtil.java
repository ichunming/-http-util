package com.yimeicloud.study.http_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class OriginHttpUtil {

	/**
	 * GET请求
	 */
	public static String get(String url, String param) {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader in = null;
		
		try {
			// 创建URL
			URL realUrl = new URL(url + "?" + param);
			
			// 打开连接
			URLConnection connection = realUrl.openConnection();
			
			// 设置属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			// 建立实际连接
			connection.connect();
			
			// 获取某一响应头字段
			String f1 = connection.getHeaderField("field1");
			// 获取所有响应头字段
			Map<String, List<String>> fields = connection.getHeaderFields();
			
			// 读取URL响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			System.out.println("GET请求出错");
			e.printStackTrace();
			
		} finally {
			if(null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * POST请求
	 */
	public static String post(String url, String param) {
		
		BufferedReader in = null;
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			// 创建URL
			URL realUrl = new URL(url);
			
			// 打开连接
			URLConnection connection = realUrl.openConnection();
			
			// 设置属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			// 设置POST请求参数
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			// 发送请求参数
			out = new PrintWriter(connection.getOutputStream());
			out.write(param);
			out.flush();
			
			// 读取URL响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			System.out.println("POST请求出错");
			e.printStackTrace();
			
		} finally {
			try {
				if(null != in) {
					in.close();
				}
				if(null != out) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
}
