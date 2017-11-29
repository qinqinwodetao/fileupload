package com.vkill.boot.service;

import com.vkill.boot.model.Whois;

public interface WhoisService extends BaseService<Whois,String> {


	void getWhoisData();

}
