package com.datastructure.search;

import java.util.Comparator;

public class Key implements Comparable<Key>{
	
	int key;
	
	public Key(int key){
		this.key = key;
	}

	@Override
	public int compareTo(Key o) {
		if(key > o.key){
			return 1;
		}else if(key < o.key){
			return -1;
		}else{
			return 0;
		}
	}
	

}
