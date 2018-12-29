package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ����һ��������ת����������ÿ���ڵ������ƶ� k ��λ�ã����� k �ǷǸ�����
 * ʾ�� 1:
 * ����: 1->2->3->4->5->NULL, k = 2
 * ���: 4->5->1->2->3->NULL
 * ����:
 * ������ת 1 ��: 5->1->2->3->4->NULL
 * ������ת 2 ��: 4->5->1->2->3->NULL
 * 
 * ����: 0->1->2->NULL, k = 4
 * ���: 2->0->1->NULL
 * ����:
 * ������ת 1 ��: 2->0->1->NULL
 * ������ת 2 ��: 1->2->0->NULL
 * ������ת 3 ��: 0->1->2->NULL
 * ������ת 4 ��: 2->0->1->NULL
 *
 */
public class ��ת���� {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ListNode result = new ��ת����().rotateRight(head, 0);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		ListNode tail = head;//β�ڵ�
		int count = 1;
		while (tail != null && tail.next != null) {
			tail = tail.next;
			count++;
		}
		if(count == 1 ||  k % count == 0) {
			return head;
		}
		int moveCount = count -  k % count;//��ת֮��ͷ�ڵ��λ��
		ListNode cutNode = head;//���յķ���ֵ
		ListNode preNode = null;
		while (moveCount > 0) {
			preNode = cutNode;
			cutNode = cutNode.next;
			moveCount--;
		}
		if (preNode != null) {
			preNode.next = null;
		}
		tail.next = head;
		return cutNode;
	}
}
