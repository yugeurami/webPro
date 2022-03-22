package com.lec.ex12_store;

public class TestMain {

	public static void main(String[] args) {
		HeadQuarterStore[] 	store = {	new HeadQuarterStore("= = = 본사 = = ="),
										new Store1("= = = 1호점 = = ="),
										new Store2("= = = 2호점 = = ="),
										new Store3("= = = 3호점 = = =")};
		for(int idx = 0 ; idx<store.length ; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibim();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		for (HeadQuarterStore st : store) {
			System.out.println(st.getStr());
			st.kimchi();
			st.bude();
			st.bibim();
			st.sunde();
			st.gonggibab();
		}
		

	}

}
