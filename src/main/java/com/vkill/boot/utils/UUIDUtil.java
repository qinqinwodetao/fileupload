package com.vkill.boot.utils;

import java.util.UUID;

/**
 * Created by boot on 2017/8/8.
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
