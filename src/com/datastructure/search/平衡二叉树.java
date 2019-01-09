package com.datastructure.search;

/**
 * 平衡二叉树 左右子树高度差不超过1的二叉查找树
 *
 */
public class 平衡二叉树 extends 二叉搜索树{


	public static void main(String[] args) {
		平衡二叉树 test = new 平衡二叉树();
		int[] array = new int[] { 10, 9 ,8,7,6,5,4,3,2,1};
		for (int i : array) {
			test.put(new Key(i), new Value(i));
		}
		test.delete(new Key(7));
		System.out.println(TreeUtils.height(test.root));
		System.out.println(test.root);
		TreeUtils.levelTraversal(test.root);
	}


	public Node put(Node node, Key key, Value val) {
		if (node == null) {
			node = new Node(key, val);
		} else {
			int cmp = key.compareTo(node.key);
			if (cmp > 0) {
				node.right = put(node.right, key, val);
				node = makeRightTreeAvl(node, key);
			} else if (cmp < 0) {
				node.left = put(node.left, key, val);
				node = makeLeftTreeAvl(node, key);
			} else {
				node.val = val;
			}
		}
		node.N = size(node.left) + size(node.right) + 1;
		node.height = TreeUtils.height(node);
		return node;
	}
	
	public Node delete(Node node,Key key){
		if(node == null){
			return null;
		}
		System.out.println("delete");
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			node.right = delete(node.right,key);
			node = makeRightTreeAvl(node, key);
		}else if(cmp < 0){
			node.left = delete(node.left,key);
			node = makeLeftTreeAvl(node, key);
		}else{//查找到需要删除的节点
			if(node.left == null){//当前节点的左子树为null，则当前节点替换为右子树
				return node.right;
			}
			if(node.right == null){//当前节点的右子树为null，则当前节点替换为左子树
				return node.right;
			}
			if(height(node.left)>height(node.right)){//左子树高，用左子树的最大元素替换
				System.out.println("xxx");
				Node temp = node;
				node = max(node.left);
				node.left = deleteMax(temp.left);
				node.right = temp.right;
			}else{//右子树高，用右子树的最小元素替换
				//左右子树都不为空，将当前节点替换为右子树的最小值
				System.out.println("xxxxxx");
				Node temp = node;
				node = min(node.right);
				node.right = deleteMin(temp.right);//必须先调用
				node.left = temp.left;		
			}
			
			
		}
		node.N = size(node.left) +size(node.right)+1;
		node.height = TreeUtils.height(node);
		return node;
	}
	
	

	private Node makeLeftTreeAvl(Node node, Key key) {
		if (height(node.left) - height(node.right) == 2) {// 在node的左子树插入元素后不平衡了
			int subCmp = key.compareTo(node.left.key);
			if (subCmp > 0) {// 左子树的右子树插入
				node = RotateLR(node);
			} else {// 左子树的左子树插入
				node = RotateLL(node);
			}
		}
		return node;
	}

	private Node makeRightTreeAvl(Node node, Key key) {
		if (height(node.right) - height(node.left) == 2) {// 在node的右子树插入元素后不平衡了
			int subCmp = key.compareTo(node.left.key);
			if (subCmp > 0) {// 右子树的右子树插入
				node = RotateRR(node);
			} else {// 右子树的左子树插入
				node = RotateRL(node);
			}
		}
		return node;
	}
	

	/**
	 * 在左子树上添加左节点导致根节点失去平衡--右旋
	 * 
	 * @param node
	 */
	public Node RotateLL(Node node) {
		Node temp = node.left;
		node.left = temp.right;
		temp.right = node;
		node.height = TreeUtils.height(node);
		temp.height = TreeUtils.height(temp);
//		System.out.println("RotateLL temp:"+temp);
//		System.out.println("RotateLL temp.left:"+temp.left);
//		System.out.println("RotateLL temp.right:"+temp.right);
//		System.out.println("RotateLL temp.height:"+temp.height);
		return temp;// 新的根节点
	}

	/**
	 * 右子树的添加右孩子导致失去平衡--左旋
	 * 
	 * @param node
	 */
	public Node RotateRR(Node node) {
		System.out.println("RotateRR");
		Node temp = node.right;
		node.right = temp.left;
		temp.left = node;
		node.height = TreeUtils.height(node);
		temp.height = TreeUtils.height(temp);
		return temp;// 新的根节点
	}

	/**
	 * 左子树添加右孩子失去平衡--先以node.left为根左旋，再以node为根右旋
	 * 
	 * @param node
	 */
	public Node RotateLR(Node node) {
		System.out.println("RotateLR");
		node.left = RotateRR(node.left);// node.left.right 肯定不等于null
		return RotateLL(node);
	}

	/**
	 * 右子树添加左孩子失去平衡--线以node.right为根右旋，再以node为根左旋
	 * 
	 * @param node
	 * @return
	 */
	public Node RotateRL(Node node) {
		System.out.println("RotateRL");
		node.right = RotateLL(node.right);
		return RotateRR(node);
	}


}
