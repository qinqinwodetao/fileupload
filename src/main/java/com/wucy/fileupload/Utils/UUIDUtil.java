package com.wucy.fileupload.Utils;

import java.util.UUID;

/**
 * Created by wucy on 2017/8/8.
 */
public class UUIDUtil {


	/**
	 * 获取32位UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


}
