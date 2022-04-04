package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap =  new HashMap<Integer, String>();
		hashMap.put(11, "str11"); // 11key값에 매핑되는 데이터 "str11"추가
		hashMap.put(20, "str20");
		hashMap.put(33, "str33");
		System.out.println(hashMap);
		System.out.println(hashMap.get(20)); // key값으로 데이터 get함
		System.out.println("remove 전 : " + hashMap);
		hashMap.remove(20); // 20key와 값이 remove
		System.out.println("remove 후 : " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty()? "데이터 모두 삭제": "데이터 있음");
		hashMap.put(0, "Hong gilldong");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"의 데이터는 "+hashMap.get(key));
		}
	}

}
