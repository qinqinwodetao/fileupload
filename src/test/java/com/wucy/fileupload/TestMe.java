package com.wucy.fileupload;

import com.wucy.fileupload.Model.MailInfo;
import com.wucy.fileupload.Utils.HttpClientUtil;
import com.wucy.fileupload.Utils.MailUtil;
import com.wucy.fileupload.Utils.UnicodeUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

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
		logger.info(UnicodeUtil.encode("可自理（0~3分）"));
	}


}
