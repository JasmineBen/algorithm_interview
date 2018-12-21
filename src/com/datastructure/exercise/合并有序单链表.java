package com.datastructure.exercise;

/**
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并有序单链表 {

	static class ListNode {
		ListNode next = null;
		int val = 0;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(9);

		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(6);
		head1.next.next = new ListNode(8);

		ListNode result = Merge(head, head1);
		while (result.next != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

	public static ListNode Merge(ListNode list1, ListNode list2) {
		ListNode head = null;
		ListNode current = null;
		if(list1 == null){
			return list2;
		}
		if(list2 == null){
			return list1;
		}
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				if (head == null) {
					head = list1;
					current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (head == null) {
					head = list2;
					current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 != null) {
			current.next = list1;
		}
		if (list2 != null) {
			current.next = list2;
		}
		return head;
	}
	
}
