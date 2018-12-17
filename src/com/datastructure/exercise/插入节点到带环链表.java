package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * �����½ڵ㵽����Ļ��������У�����֤�����������Ȼ���� ���������ǵ�����
 *
 */
public class ����ڵ㵽�������� {

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(6);
		head.next.next = new ListNode(7);
		head.next.next.next = head;
		ListNode res = insert(head, 1);
		System.out.println(res.val);
		System.out.println(res.next.val);
		System.out.println(res.next.next.val);
		System.out.println(res.next.next.next.val);
	}

	public static ListNode insert(ListNode head, int num) {
		ListNode node = new ListNode(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != head) {
			if (pre.val <= num && cur.val >= num) {
				break;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		pre.next = node;
		node.next = cur;
		return num < head.val ? node : head;
	}

}
