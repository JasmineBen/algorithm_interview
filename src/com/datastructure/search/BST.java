package com.datastructure.search;

/**
 * ���������
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
	 * ��ȡ��СԪ��
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
	 * ��ȡ���Ԫ��
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
	 * ɾ����СԪ��
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
	 * ɾ�����Ԫ��
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
	 * ɾ��ָ��Ԫ��
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
		}else{//���ҵ���Ҫɾ���Ľڵ�
			if(node.left == null){//��ǰ�ڵ��������Ϊnull����ǰ�ڵ��滻Ϊ������
				return node.right;
			}
			if(node.right == null){//��ǰ�ڵ��������Ϊnull����ǰ�ڵ��滻Ϊ������
				return node.right;
			}
			//������������Ϊ�գ�����ǰ�ڵ��滻Ϊ����������Сֵ
			Node temp = node;
			node = min(node.right);
			node.right = deleteMin(temp.right);//�����ȵ���
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
