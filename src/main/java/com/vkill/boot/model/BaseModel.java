package com.vkill.boot.model;

import com.vkill.boot.utils.UUIDUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wucy
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

	@Id
	public String id;

	public Date createTime;

	public Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@PrePersist
	public void onPrePersist() {
		this.id = UUIDUtil.getUUID();
		this.createTime = new Date();
	}

	@PreUpdate
	public void onPreUpdate() {
		this.updateTime = new Date();
	}

}
