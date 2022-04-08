package com.lec.ex1_list;

import java.util.LinkedList;

public class Ex02_linkedList {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0");
		linkedList.add("str1");
		linkedList.add("str2");
		linkedList.add(1,"str3");
		System.out.println(linkedList);
		for (String list : linkedList) {
			System.out.println(list);
		}
		linkedList.clear();
		System.out.println(linkedList.isEmpty()?"데이터가 없습니다":"데이터가 있습니다");
	}

}
