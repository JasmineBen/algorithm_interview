package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class 链表排序 {

	/**
	 * 满足时间复杂度的排序算法只能是快排，归并，堆排序,选用归并排序
	 */
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		return merge(sortList(head),sortList(mid));
	}
	
	//归并两个有序链表
	private ListNode merge(ListNode l1,ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = new ListNode(Integer.MAX_VALUE);
		ListNode result = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				head.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				head.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			head = head.next;
		}

		while (l1 != null) {
			head.next = new ListNode(l1.val);
			l1 = l1.next;
			head = head.next;
		}
		while (l2 != null) {
			head.next = new ListNode(l2.val);
			l2 = l2.next;
			head = head.next;
		}
		return result.next;
	}
	
}
