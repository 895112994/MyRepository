package org.test.java;

import java.util.ArrayList;

public class MyString {
	
	public static void main(String[] args) {
		String str = myData();
		 long start2 = System.currentTimeMillis();
		 	mySplit(str);
		 	long end2 = System.currentTimeMillis();
		 	System.out.println("使用自定义方法分割用时："+(end2 - start2));
	}
	
	public static String myData(){
		final int COUNT = 10000;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < COUNT; i++) {
			if (i == COUNT-1) {
				sb.append(i+",");
			}else {
				sb.append(i);
			}
		}
		return sb.toString();
	}
	
	public static String[] mySplit(String str){
		ArrayList<String> arrayList = new ArrayList<String>();
		int len = -1;
		while((len = str.indexOf(",")) != -1){
			arrayList.add(str.substring(0,len));
			str=str.substring(len+1);
		}
		arrayList.add(str);
		return arrayList.toArray(new String[arrayList.size()]);
	}
}
