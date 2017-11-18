package com.wind.entity;

import java.util.List;
/**
 * citys.xml配置文件中对应的实体类
 * @author wind
 *
 */
public class Provience {
	
	private String name;
	private List<String> items;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	
	
}
