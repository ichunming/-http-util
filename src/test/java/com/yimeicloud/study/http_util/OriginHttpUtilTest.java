package com.yimeicloud.study.http_util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class OriginHttpUtilTest {
	// 所有方法执行一次
	@AfterClass
	public static void afterClass() {
	};

	// 每个测试方法执行之前都要执行一次。
	@Before
	public void before() {
	}

	// 每个测试方法执行之后要执行一次。
	@After
	public void after() {
	}

	@Test
	public void getTest() {
		String url = "http://v.juhe.cn/weather/index";
		String param = "format=2&cityname=上海&key=e71104e73458a0280667cd6cd63b6b97";
		String result = OriginHttpUtil.get(url, param);
		
		System.out.println(result);	
	}
	
	@Test
	public void postTest() {
		String url = "http://v.juhe.cn/weather/index";
		String param = "format=2&cityname=上海&key=e71104e73458a0280667cd6cd63b6b97";
		
		String result = OriginHttpUtil.post(url, param);
		
		System.out.println(result);
	}
}
