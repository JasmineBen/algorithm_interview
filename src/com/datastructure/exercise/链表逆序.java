package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 链表逆序
 * 分为单链表和双向链表逆序两种
 */
public class 链表逆序 {

	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode first = new ListNode(1);
		head.next = first;
		head.pre = null;
		ListNode two = new ListNode(2);
		first.next = two;
		first.pre = head;
		ListNode three = new ListNode(3);
		two.next = three;
		two.pre = first;
		ListNode four = new ListNode(4);
		three.next = four;
		three.pre = two;
		four.pre = three;
		链表逆序 reverseList = new 链表逆序();
		//ListNode result = reverseList.reverseWithHead(head);
//		ListNode result = reverseList.reverseDoublyWithoutHead(first);
		ListNode result = reverseList.reverseDoublyWithHead(head);
		ListNode next = result;
		while(next != null){
			System.out.print(next.val+";");
			next = next.next;
		}
		System.out.println();
		while(result != null && result.next != null){
			result = result.next;
		}
		while(result != null){
			System.out.print(result.val+";");
			result = result.pre;
		}
	}
	
	/**
	 * 单向列表没有头节点
	 *1、定义一个pre和一个next元素，初始化时pre=null,next=首节点
	 *2、循环将next.next指向pre，将pre设置为next，并将next后移
	 *3、最后返回next
	 */
	public ListNode reverseWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = listNode;
		while(next != null && next.next!=null){
			ListNode nextNext = next.next;
			next.next = pre;
			pre = next;
			next = nextNext;
		}
		next.next = pre;
		return next;
	}
	
	
	/**
	 * 单向列表有head
	 * 设置pre和next，next在pre后面
	 * 先保存next.next，然后将next.next设置为pre
	 * 将pre设置为next，将next设置为刚刚保存的next.next
	 * 在最后一个元素修改完成后next=next.next=null，结束：修改head的next
	 */
	public ListNode reverseWithHead(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//初始状态head.next,也是逆序后的最后一个元素
		ListNode pre = head.next;
		ListNode next = head.next.next;
		pre.next = null;
		while(next != null){
			ListNode nextNext = next.next;
			next.next = pre;
			pre = next;
			next = nextNext;
		}
		head.next = pre;
		return head;
	}
	
	/**
	 * 双向链表没有头节点
	 */
	public ListNode reverseDoublyWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = listNode;
		while(next != null && next.next!=null){
			ListNode nextNext = next.next;
			next.next = pre;
			next.pre = nextNext;
			pre = next;
			next = nextNext;
		}
		next.next = pre;
		next.pre = null;
		return next;
	}
	
	/**
	 * 双向链表有头节点
	 */
	public ListNode reverseDoublyWithHead(ListNode listNode) {
		ListNode pre = listNode;
		ListNode next = listNode.next;
		ListNode firstNode = listNode.next;
		pre.next = null;
		while(next != null){
			ListNode nextNext = next.next;
			if(firstNode != next){
				next.next = pre;
			}else{
				next.next = null;
			}
			next.pre = nextNext;
			pre = next;
			next = nextNext;
		}
		listNode.next = pre;
		pre.pre = listNode;
		return listNode;
	}
	
}
