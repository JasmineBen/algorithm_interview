package com.datastructure.search;

/**
 * ƽ������� ���������߶Ȳ����1�Ķ��������
 *
 */
public class ƽ������� extends ����������{


	public static void main(String[] args) {
		ƽ������� test = new ƽ�������();
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
		}else{//���ҵ���Ҫɾ���Ľڵ�
			if(node.left == null){//��ǰ�ڵ��������Ϊnull����ǰ�ڵ��滻Ϊ������
				return node.right;
			}
			if(node.right == null){//��ǰ�ڵ��������Ϊnull����ǰ�ڵ��滻Ϊ������
				return node.right;
			}
			if(height(node.left)>height(node.right)){//�������ߣ��������������Ԫ���滻
				System.out.println("xxx");
				Node temp = node;
				node = max(node.left);
				node.left = deleteMax(temp.left);
				node.right = temp.right;
			}else{//�������ߣ�������������СԪ���滻
				//������������Ϊ�գ�����ǰ�ڵ��滻Ϊ����������Сֵ
				System.out.println("xxxxxx");
				Node temp = node;
				node = min(node.right);
				node.right = deleteMin(temp.right);//�����ȵ���
				node.left = temp.left;		
			}
			
			
		}
		node.N = size(node.left) +size(node.right)+1;
		node.height = TreeUtils.height(node);
		return node;
	}
	
	

	private Node makeLeftTreeAvl(Node node, Key key) {
		if (height(node.left) - height(node.right) == 2) {// ��node������������Ԫ�غ�ƽ����
			int subCmp = key.compareTo(node.left.key);
			if (subCmp > 0) {// ������������������
				node = RotateLR(node);
			} else {// ������������������
				node = RotateLL(node);
			}
		}
		return node;
	}

	private Node makeRightTreeAvl(Node node, Key key) {
		if (height(node.right) - height(node.left) == 2) {// ��node������������Ԫ�غ�ƽ����
			int subCmp = key.compareTo(node.left.key);
			if (subCmp > 0) {// ������������������
				node = RotateRR(node);
			} else {// ������������������
				node = RotateRL(node);
			}
		}
		return node;
	}
	

	/**
	 * ���������������ڵ㵼�¸��ڵ�ʧȥƽ��--����
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
		return temp;// �µĸ��ڵ�
	}

	/**
	 * ������������Һ��ӵ���ʧȥƽ��--����
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
		return temp;// �µĸ��ڵ�
	}

	/**
	 * ����������Һ���ʧȥƽ��--����node.leftΪ������������nodeΪ������
	 * 
	 * @param node
	 */
	public Node RotateLR(Node node) {
		System.out.println("RotateLR");
		node.left = RotateRR(node.left);// node.left.right �϶�������null
		return RotateLL(node);
	}

	/**
	 * �������������ʧȥƽ��--����node.rightΪ������������nodeΪ������
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
