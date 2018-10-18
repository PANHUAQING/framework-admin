package com.frame.utils;

import java.util.UUID;
/**
 * 
* @ClassName: UUIDUtils
* @Description: 
*    uuid 工具类
* @author panhuaqing
* @date 2018年7月26日 下午9:21:35
*
 */
public class UUIDUtils {
	public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
   }
}
