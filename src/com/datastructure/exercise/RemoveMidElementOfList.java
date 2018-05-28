package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ɾ��������м�Ԫ��
 * 1����ɾ��
 * 1 2��ɾ��1
 * 1 2 3��ɾ��2
 * 1 2 3 4��ɾ��2
 *
 */
public class RemoveMidElementOfList {

	
	/**
	 * ��������ָ��pre next
	 * ��ʼ��ʱpre=head,next=pre.next
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
		//ѭ��������pre����Ҫɾ���Ľڵ��ǰһ���ڵ�
		pre.next = pre.next.next;
		return head;
	}
}
