
package com.ganpai.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {
	/**
	 * @param list 对象集合
	 * @param property 分组属性
	 * @return Map<Bean.property, List<Bean>>
	 */
	public static Map groupByProperty(List list, String property){
		Map map = new HashMap();
		if(list!=null&&!list.isEmpty()){
			for(Object bean:list){
				try {
					Object pv = getProperty(bean, property);
					List pList = (List) map.get(pv);
					if(pList==null){
						pList = new ArrayList();
						map.put(pv, pList);
					}
					pList.add(bean);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return map;
	}

	/**
	 * 根据唯一属性分组对象集合,一个key对应一个对象
	 * @param list
	 * @param property
	 * @return Map<Bean.property, Bean>
	 */
	public static Map groupByUniqueProperty(List list, String property){
		HashMap map = new HashMap();
		for(Object bean:list){
			try {
				Object pv = getProperty(bean, property);
				if(!map.containsKey(pv)){
					map.put(pv, bean);
				}else{
					throw new RuntimeException("duplicate property : "+property+"=" + pv);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	/**
	 * 根据属性名称获取list对象中的该属性封装-去重、不含空
	 * @author:dengbo
	 */
	public static <T> List<T> getPropertyList(List list, String property){
		List<T> plist = new ArrayList<T>();
		for(int i=0;i<list.size();i++){
			Object bean = list.get(i);
			try {
				T pv = (T) getProperty(bean, property);
				if(pv!=null&&!plist.contains(pv)){
					plist.add(pv);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return plist;
	}
	
	public static Object getProperty(Object bean, String property){
		try {
			return PropertyUtils.getProperty(bean, property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据属性名与值在链表中匹配返回对象
	 *@author dengbo
	 *@data 2017/6/15 9:54
	 */
	public static <T> T getBeanByEqValue(List<T> list,String property,Object value){
		if(list == null || list.isEmpty() || StringUtils.isBlank(property) || value==null){
			return null;
		}
		try {
			for(T bean : list){
				if(value.equals(getProperty(bean,property))){
					return bean;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}


	/**
	 * 下划线字符串转为驼峰，首字母小写
	 *@author dengbo
	 *@data 2017/6/13 10:19
	 */
	public static String convertCamelCase(String str) {
		String result = "";

		String[] strArr = str.trim().split("_");
		for (String s : strArr) {
			if (s.length() > 1) {
				result += s.substring(0, 1).toLowerCase() + s.substring(1).toLowerCase();
			} else {
				result += s.toUpperCase();
			}
		}
		return result;
	}
}


