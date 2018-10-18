package com.frame.admin.util;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;


public class RedisKey {
	 //分隔符
    public final static String split = ":";
    public  static String getRedisKey(String... name) {
		StringBuffer sb = new StringBuffer();
		for (String str : name) {
			if (!StringUtils.isEmpty(str)) {
				sb.append(str);
				sb.append(split);
			}
		}
		sb = sb.deleteCharAt(sb.lastIndexOf(split));
 
		return sb.toString();
	}
    
    public static String getRedisKeyJoin(String... name){
    	ArrayList<String> strlist = Lists.newArrayList();
    	for (String str : name) {
			if (!StringUtils.isEmpty(str)) {
				strlist.add(str);
			}
		}
    	return Joiner.on("_").join(strlist);
    }
}
