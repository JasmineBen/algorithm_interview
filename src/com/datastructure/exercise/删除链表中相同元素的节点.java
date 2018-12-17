package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.basic.ListNode;

/**
 * 刪除单链表中值相同的结点，例如：
 * 1->2->3->3->4->4->2->1->1删除后为1->2->3->4
 *
 */
public class 删除链表中相同元素的节点 {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		ListNode node6 = new ListNode(4);
		node5.next = node6;
		ListNode node7 = new ListNode(2);
		node6.next = node7;
		ListNode node8 = new ListNode(1);
		node7.next = node8;
		ListNode node9 = new ListNode(1);
		node8.next = node9;
		ListNode res = removeSame(node1);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		
	}

	
	public static ListNode removeSame(ListNode head){
		if(head == null){
			return head;
		}
		List<Integer> list = new ArrayList<Integer>();
		ListNode pre = head;
		ListNode cur = head.next;
		list.add(pre.val);
		while(cur != null){
			if(list.contains(cur.val)){
				pre.next = cur.next;
				cur.next = null;
				cur = pre.next;
			}else{
				list.add(cur.val);
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
