package com.vkill.boot;

import com.vkill.boot.utils.HttpClientUtil;
import com.vkill.boot.utils.MailUtil;
import com.vkill.boot.utils.UnicodeUtil;
import com.vkill.boot.model.MailInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestMe {
	Logger logger = LoggerFactory.getLogger(Test.class);


	@Test
	public void testGet() throws UnsupportedEncodingException {
		logger.info(HttpClientUtil.get("http://whois.chinaz.com/vkill.com"));
	}



	@Test
	public void testEmail() throws UnsupportedEncodingException {

		MailInfo mailInfo = new MailInfo();
		mailInfo.setSubject("赶紧去注册");
		mailInfo.setContent("状态变化了该去注册了!!!!");
		mailInfo.addToAddress("wucy1991@163.com");
		mailInfo.addToAddress("wuchengyang1991@qq.com");
		MailUtil.sendEmail(mailInfo);

	}


	@Test
	public void testUnicode() throws Exception {


		Map<String,Object> maps = new HashMap<>();


		maps.put("123", "sssss");
		maps.put("1231", "sssss");
		maps.put("123", "sssss");
		maps.put("123", "ssss");

		Map<String, Object> newMaps = new ConcurrentHashMap<>();

		for (Object obj : newMaps.keySet()) {
			logger.info(obj.toString());
		}

		Set<Boolean> sets = new HashSet<>();
		sets.add(true);


		List<String> strings = new ArrayList<>();



		logger.info(UnicodeUtil.encode("可自理（0~3分）"));
	}


}
