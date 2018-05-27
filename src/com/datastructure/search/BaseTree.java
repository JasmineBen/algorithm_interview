package com.datastructure.search;

public abstract class BaseTree {

	public Node root;
	
	public int size(){
		return size(root);
	}
	
	public int size(Node node){
		if(node == null){
			return 0;
		}
		return node.N;
	}
	
	/**
	 * 查找指定的元素
	 * @param key
	 * @return
	 */
	public Value get(Key key){
		return get(root, key);
	}
	
	public abstract Value get(Node node,Key key);
	
	/**
	 * 插入元素
	 * @param key
	 * @param val
	 */
	public void put(Key key,Value val){
		root = put(root,key,val);
	}
	
	public abstract Node put(Node node,Key key,Value val);
	
	public int height(Node node) {
		if (node != null) {
			return node.height;
		}
		return 0;
	}

	public int height() {
		return height(root);
	}
}
