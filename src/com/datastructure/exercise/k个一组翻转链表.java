package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class k个一组翻转链表 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode result = new k个一组翻转链表().reverseKGroup(head, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	/**
	 * 递归求解
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		int canProceed = 0;
		ListNode check = head;
		// 检查链表长度是否满足翻转
		while (canProceed < k && check != null) {
			check = check.next;
			canProceed++;
		}
		//可以进行翻转
		if(canProceed == k) {
			ListNode pre = null;
			ListNode current = head;
			ListNode next = null;
			while(canProceed > 0) {
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
				canProceed --;
			}
			if(next != null) {
				head.next = reverseKGroup(next, k);
			}
			return pre;
		}else {
			//不能进行翻转
			return head;
		}
	}
}
