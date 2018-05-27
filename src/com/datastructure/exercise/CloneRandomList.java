package com.datastructure.exercise;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */
public class CloneRandomList {

	public static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode node1 = new RandomListNode(2);
		RandomListNode node2 = new RandomListNode(3);
		RandomListNode node3 = new RandomListNode(4);
		RandomListNode node4 = new RandomListNode(5);
		RandomListNode node5 = new RandomListNode(6);
		RandomListNode node6 = new RandomListNode(7);
		RandomListNode node7 = new RandomListNode(8);
		RandomListNode node8 = new RandomListNode(9);
		head.next = node1;
		head.random = node4;
		node1.next = node2;
		node1.random = node3;
		node2.next = node3;
		node2.random = node1;
		node3.next = node4;
		node3.random = node5;
		node4.next = node5;
		node4.random = node6;
		node5.next = node6;
		node5.random = node5;
		node6.next = node7;
		node6.random = node7;
		node7.next = node8;
		node7.random = node1;
//		while(head.next != null){
//			System.out.println(head.label + "-"+head.next.label+"-"+head.random.label);
//			head = head.next;
//		}
		System.out.println("----------------");
		RandomListNode clone = new CloneRandomList().Clone(head);
		while(clone.next != null){
			System.out.println(clone.label + "-"+clone.next.label+"-");
			clone = clone.next;
		}
	}
	

	/*
	* 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
	* 2、遍历链表，A1->random = A->random->next;
	* 3、将链表拆分成原链表和复制后的链表
	* A  B  C  D  E
	* | /| /| /| /|
	* A1 B1 C1 D1 E1
	*/
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null){
			return null;
		}
		RandomListNode currentNode = pHead;
		while(currentNode != null){
			RandomListNode node = new RandomListNode(currentNode.label);
			node.next = currentNode.next;
			currentNode.next = node;
			currentNode = node.next;
		}
		currentNode = pHead;
		while(currentNode != null){
			RandomListNode node = currentNode.next;
			if(currentNode.random != null){
				//currentNode.random在上面，他的next就是下面复制的值
				node.random = currentNode.random.next;
			}
			currentNode = node.next;
		}
		
		//拆分
		RandomListNode result = pHead.next;
		RandomListNode temp;
		currentNode = pHead;
		while(currentNode.next != null){
			temp = currentNode.next;
			currentNode.next = temp.next;
			currentNode = temp;
		}
		return result;
	}
}
