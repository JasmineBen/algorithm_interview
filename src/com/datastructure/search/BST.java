package com.datastructure.search;

/**
 * 二叉查找树
 *
 */
public class BST extends BaseTree{
	

	
	public Value get(Node node,Key key){
		if(node == null){
			return null;
		}
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			return get(node.right,key);
		}else if(cmp < 0){
			return get(node.left,key);
		}else{
			return node.val;
		}
	}
	
		
	public Node put(Node node,Key key,Value val){
		if(node == null){
			Node newNode = new Node(key, val);
			newNode.N = 1;
			return newNode;
		}
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			node.right = put(node.right, key, val);
		}else if(cmp < 0){
			node.left = put(node.left, key, val);
		}else{
			node.val = val;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	/**
	 * 获取最小元素
	 * @return
	 */
	public Node min(){
		return min(root);
	}
	
	public Node min(Node node){
		if(node == null){
			return null;
		}
		if(node.left == null){
			return node;
		}
		return min(node.left);
	}
	
	/**
	 * 获取最大元素
	 * @return
	 */
	public Node max(){
		return max(root);
	}
	
	public Node max(Node node){
		if(node == null){
			return null;
		}
		if(node.right == null){
			return node;
		}
		return max(node.right);
	}
	
	/**
	 * 删除最小元素
	 */
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node node){
		if(node.left == null){
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.N = size(node.left) + size(node.right) + 1;
		return node;
		
	}
	
	/**
	 * 删除最大元素
	 */
	public void deleteMax(){
		root = deleteMax(root);
	}
	
	public Node deleteMax(Node node){
		if(node.right == null){
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.N = size(node.left) + size(node.right) + 1;
		return node;
		
	}
	
	/**
	 * 删除指定元素
	 * @param key
	 */
	public void delete(Key key){
		root = delete(root, key);
	}
	
	public Node delete(Node node,Key key){
		if(node == null){
			return null;
		}
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			node.right = delete(node.right,key);
		}else if(cmp < 0){
			node.left = delete(node.left,key);
		}else{//查找到需要删除的节点
			if(node.left == null){//当前节点的左子树为null，则当前节点替换为右子树
				return node.right;
			}
			if(node.right == null){//当前节点的右子树为null，则当前节点替换为左子树
				return node.right;
			}
			//左右子树都不为空，将当前节点替换为右子树的最小值
			Node temp = node;
			node = min(node.right);
			node.right = deleteMin(temp.right);//必须先调用
			node.left = temp.left;		
			
		}
		node.N = size(node.left) +size(node.right)+1;
		return node;
	}
	
	
	
	public static void main(String[] args) {
		BST test = new BST();
		int[] a = new int[]{5,4,7,6,1,8,9,3,2,10};
		for(int i : a){
			test.put(new Key(i),new Value(i));
		}
		test.delete(new Key(5));
		TreeUtils.levelTraversal(test.root);
		System.out.println("root height:"+TreeUtils.height(test.root));
	}
	
}
