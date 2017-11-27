package com.wucy.fileupload.job;

import com.wucy.fileupload.model.MailInfo;
import com.wucy.fileupload.model.Whois;
import com.wucy.fileupload.service.WhoisService;
import com.wucy.fileupload.utils.HttpClientUtil;
import com.wucy.fileupload.utils.MailUtil;
import com.wucy.fileupload.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WhoisFetch {
	Logger logger = LoggerFactory.getLogger(WhoisFetch.class);

	@Autowired
	private WhoisService whoisService;


	@Scheduled(fixedRate = 30000)
	public void timerRate() {
		String domainName = "vkill.com";

		String data = HttpClientUtil.get("http://whois.chinaz.com/"+domainName);

		Whois whois = new Whois();
		whois.setId(UUIDUtil.getUUID());
		whois.setDomainName(domainName);
		if(data.contains("pendingDelete")){
			whois.setDomainStatus("pendingDelete");
			//sendEmail("pendingDelete");
		}else {
			whois.setDomainStatus("deleting");
			sendEmail("deleting");
		}
		int index = data.indexOf("以下信息更新时间");
		whois.setDomainUpdateTime(data.substring(index+9,index+28));
		whois.setCreateTime(new Date());
		whois.setUpdateTime(new Date());

		whoisService.save(whois);
		logger.info(whois.toString());
	}


	public void sendEmail(String content){
		MailInfo mailInfo = new MailInfo();
		mailInfo.setSubject("赶紧去注册");
		mailInfo.setContent("状态变化了该去注册了!!!!" + content);
		mailInfo.addToAddress("wucy1991@163.com");
		mailInfo.addToAddress("wuchengyang1991@qq.com");
		MailUtil.sendEmail(mailInfo);
	}


}
