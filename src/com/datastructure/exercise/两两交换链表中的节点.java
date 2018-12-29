package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 两两交换链表中的节点 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = new 两两交换链表中的节点().swapPairs(head);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode result = head;
		ListNode pre = null;
		boolean flag = false;
		while(head != null && head.next != null) {
			ListNode next = head.next;
			ListNode nextNext = next.next;
			head.next = nextNext;
			next.next = head;
			head = nextNext;
			if(pre != null) {
				pre.next = next;
			}
			pre = next.next;
			if(!flag) {
				result = next;
				flag = true;
			}
		}
		return result;
	}
}
