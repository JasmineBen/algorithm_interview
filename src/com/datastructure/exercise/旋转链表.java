package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class 旋转链表 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ListNode result = new 旋转链表().rotateRight(head, 0);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		ListNode tail = head;//尾节点
		int count = 1;
		while (tail != null && tail.next != null) {
			tail = tail.next;
			count++;
		}
		if(count == 1 ||  k % count == 0) {
			return head;
		}
		int moveCount = count -  k % count;//旋转之后头节点的位置
		ListNode cutNode = head;//最终的返回值
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
