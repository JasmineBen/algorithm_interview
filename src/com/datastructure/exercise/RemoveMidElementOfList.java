package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 删除链表的中间元素
 * 1：不删除
 * 1 2：删除1
 * 1 2 3：删除2
 * 1 2 3 4：删除2
 *
 */
public class RemoveMidElementOfList {

	
	/**
	 * 利用两个指针pre next
	 * 初始化时pre=head,next=pre.next
	 */
	public static ListNode removeMid(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = head;
		ListNode next = head.next.next;
		while(next != null && next.next != null){
			pre = pre.next;
			next = next.next.next;
		}
		//循环结束后pre就是要删除的节点的前一个节点
		pre.next = pre.next.next;
		return head;
	}
}
