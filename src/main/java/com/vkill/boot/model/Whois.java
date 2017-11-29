package com.vkill.boot.model;


import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "whois")
public class Whois extends BaseModel {

	/**
	 * 域名
	 */
	private String domainName;

	/**
	 * 域名数据更新时间
	 */
	private String domainUpdateTime;

	/**
	 * 域名状态
	 */
	private String domainStatus;


	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainUpdateTime() {
		return domainUpdateTime;
	}

	public void setDomainUpdateTime(String domainUpdateTime) {
		this.domainUpdateTime = domainUpdateTime;
	}

	public String getDomainStatus() {
		return domainStatus;
	}

	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
