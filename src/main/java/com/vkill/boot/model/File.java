package com.vkill.boot.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author boot
 */
@Table
@Entity
public class File extends BaseModel {

	private String MD5;
	private String fileName;
	private Date uploadDate;

	public File(String fileName, String MD5, Date uploadDate) {
		this.fileName = fileName;
		this.MD5 = MD5;
		this.uploadDate = uploadDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String MD5) {
		this.MD5 = MD5;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}



	@Override
	public String toString() {
		return "File{" +
				"fileName='" + fileName + '\'' +
				", MD5='" + MD5 + '\'' +
				", uploadDate=" + uploadDate +
				'}';
	}
}
