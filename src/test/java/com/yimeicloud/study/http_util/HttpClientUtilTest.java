package com.yimeicloud.study.http_util;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class HttpClientUtilTest {
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
		String url = "http://v.juhe.cn/weather/index?format=2&cityname=上海&key=e71104e73458a0280667cd6cd63b6b97";
		String result = HttpClientUtil.get(url);

		System.out.println(result);
	}
	
	@Test
    public void get1Test() {
        String url = "https://www.baidu.com";
        String result = HttpClientUtil.get(url);
        System.out.println(result);
        
        Document doc = Jsoup.parse(result);
        
        List<Element> elements = doc.getElementsByClass("mnav");
        
        for (Element el : elements) {
            System.out.println(el.text());
        }
    }

	@Test
	public void postTest() {
		String url = "http://dzd.zt-express.com/CenterBill/GetCenterBillByPager";
		String param = "notDefaultSearch=notDefaultSearch&pager2.pageSize=100&pager2.pageNo=1&isPage=False&isExport=False&sort2=SCAN_DATE&direction2=DESC&entity.CodeType=BillCode&entity.Codes=435402062714&entity.BeginTime=2017-04-23 11:59:59&entity.EndTime=2017-04-25 11:59:59&entity.ScanSiteID=2743&pager.pageNo=1&pager.pageSize=100&sort=SCAN_DATE&direction=desc";

		String result = HttpClientUtil.post(url, param);

		System.out.println(result);
	}
}
