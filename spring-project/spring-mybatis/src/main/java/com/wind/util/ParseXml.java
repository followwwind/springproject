package com.wind.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析xml文件 并生成树结构
 * @author followwwind
 *
 */
public class ParseXml {
	//private static int index = 0;
	/**
	 * 初始化xml文件
	 * @param xml
	 * @return
	 */
	public static List<Map<String,String>> init(String xml){
		SAXReader reader = new SAXReader();
		List<Map<String,String>> xmlList = new ArrayList<Map<String,String>>();
		try {
			Document doc = reader.read(ParseXml.class.getClassLoader().getResourceAsStream(xml));
			Element root = doc.getRootElement();
			System.out.println(root.getName());
			getElements(root);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return xmlList;
	}
	static int i = 0;
	/**
	 * 遍历该元素的所有子元素
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public static void getElements(Element element){
		//System.out.print("|-");
		//index++;
		List<Element> eles = element.elements();
		
		//getAttrs(element);
		if(eles.size() == 0){
			//System.out.println(element.getTextTrim());
			//System.out.println("#"+element.getName()+"#");
			i = 1;
		}else if(eles.size() > 0){
			//System.out.println("*"+element.getName()+"*");
			i++;
			for(Element ele : eles){
				for(int j = i;j > 0;j--){
					System.out.print("->");
				}
				System.out.println( ele.getName()+" ");
				getElements(ele);
			}
			/*System.out.println();
			for(Element ele : eles){
				//System.out.print("|-");
				getElements(ele);
			}*/
		}
	}
	
	/**
	 * 遍历该元素的所有属性
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public static void getAttrs(Element element){
		Iterator<Attribute> attrs = element.attributeIterator();
		while(attrs.hasNext()){
			Attribute attr = attrs.next();
			System.out.print(attr.getName()+" ");
		}
		System.out.println();
	}
	
}
