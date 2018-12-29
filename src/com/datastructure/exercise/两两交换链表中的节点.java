package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * ���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 */
public class �������������еĽڵ� {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = new �������������еĽڵ�().swapPairs(head);
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
