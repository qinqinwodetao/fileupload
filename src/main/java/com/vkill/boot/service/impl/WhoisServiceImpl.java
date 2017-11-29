package com.vkill.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vkill.boot.hdao.WhoisRepository;
import com.vkill.boot.model.Whois;
import com.vkill.boot.service.WhoisService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;


@Service
@Transactional
public class WhoisServiceImpl extends BaseServiceImpl<Whois,String> implements WhoisService {
	private static Logger logger = LoggerFactory.getLogger(WhoisServiceImpl.class);



	@Autowired
	private WhoisRepository whoisRepository;


	@Override
	public void getWhoisData() {

	}


	/**
	 * 发送post请求
	 * @param postUrl
	 * @param jsonParam
	 * @return
	 * @throws IOException
	 */
	public static String postData(String postUrl, JSONObject jsonParam) throws IOException {
		HttpPost httpPost = new HttpPost(postUrl);// 创建HttpPost对象
		StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
		logger.info("StatusCode:" + httpResponse.getStatusLine().getStatusCode());
		HttpEntity httpEntity = httpResponse.getEntity();
		return EntityUtils.toString(httpEntity);
	}





}
