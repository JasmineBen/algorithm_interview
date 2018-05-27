package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * 链表逆序
 */
public class ReverseList {

	static class ListNode{
		ListNode next = null;
		int val = 0;
		
		ListNode(){
			
		}
		
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode first = new ListNode(1);
		head.next = first;
		ListNode two = new ListNode(2);
		first.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ReverseList reverseList = new ReverseList();
		//ListNode result = reverseList.reverseWithoutHead(first);
		//ListNode result = reverseList.reverseWithHead(head);
		ListNode result = reverseList.reverseWithHead2(head);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
		
		
	}
	
	/**
	 *1、定义一个pre和一个next元素，
	 *2、首先将next设置成当前访问节点的next
	 *3、将当前元素的next设置成pre
	 *4、设置pre为当前元素，设置当前元素为next
	 */
	public ListNode reverseWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = null;
		while(listNode != null){
			next = listNode.next;
			listNode.next = pre;
			pre = listNode;
			listNode = next;
			
		}
		return pre;
	}
	
	/**
	 * 每次将后lastNode后面的元素插入到head后面
	 * @param head
	 * @return
	 */
	public ListNode reverseWithHead(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//初始状态head.next,也是逆序后的最后一个元素
		ListNode lastNode = head.next;
		ListNode currentInsertNode = head.next.next;
		while(currentInsertNode != null){
			ListNode nextInsertNode = currentInsertNode.next;
			currentInsertNode.next = head.next;
			head.next = currentInsertNode;
			lastNode.next = nextInsertNode;
			currentInsertNode = lastNode.next;
		}
		return head;
	}
	
	/**
	 * 设置pre和next，next在pre后面
	 * 先保存next.next，然后将next.next设置为pre
	 * 将pre设置为next，将next设置为刚刚保存的next.next
	 * 在最后一个元素修改完成后next=next.next=null，结束：修改head的next
	 * @param head
	 * @return
	 */
	public ListNode reverseWithHead2(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//初始状态head.next,也是逆序后的最后一个元素
		ListNode pre = head.next;
		ListNode next = head.next.next;
		pre.next = null;
		while(next != null){
			ListNode nextInsertNode = next.next;
			next.next = pre;
			pre = next;
			next = nextInsertNode;
		}
		head.next = pre;
		return head;
	}
}
