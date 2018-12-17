package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 给定一个key，将链表分为三部分，其中左边小于key,中间等于key,右边大于key,
 * 并保证原来的顺序不变，例如5，3，4，7，6的结果为3，4，5，7，6
 * @author zhoupeiyuan
 *
 */
public class 分割链表左边小于k右边大于k {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		ListNode node1 = new ListNode(3);
		head.next = node1;
		ListNode node2 = new ListNode(4);
		node1.next = node2;
		ListNode node3 = new ListNode(7);
		node2.next = node3;
		ListNode node4 = new ListNode(6);
		node3.next = node4;
		ListNode result = partion(head, 5);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

	
	/**
	 * 采用三个链表：
	 * small链表保存小于key的节点
	 * equal链表保存大于key的节点
	 * larger链表保存大于key的节点
	 * 最后再将这三个链表连接起来形成新的链表。
	 * 在连接的过程中需要small链表的头节点，用于返回；
	 * small链表的尾结点连接equal链表的头节点；equal链表的尾节点连接larger链表的头结点
	 */
	public static ListNode partion(ListNode head,int key){
		ListNode sH = null;//small链表头节点
		ListNode sE = null;//small链表尾节点
		ListNode eH = null;//equal链表头节点
		ListNode eE = null;//equal链表尾节点
		ListNode lH = null;//larger链表头节点
		ListNode lE = null;//larger链表尾节点
		ListNode next = null;
		while(head != null){
			next = head.next;
			head.next = null;
			if(head.val < key){
				if(sH == null){
					sH = head;
					sE = head;
				}else{
					sE.next = head;
					sE = sE.next;
				}
			}else if(head.val == key){
				if(eH == null){
					eH = head;
					eE = head;
				}else{
					eE.next = head;
					eE = eE.next;
				}
			}else{
				if(lH == null){
					lH = head;
					lE = head;
				}else{
					lE.next = head;
					lE = lE.next;
				}
			}
			head = next;
		}
		
		if(sH == null){
			if(eH == null){
				return lH;
			}else{
				eE.next = lH;
				return eE;
			}
		}else{
			if(eH == null){
				sH.next = lH;
				return sH;
			}else{
				sE.next = eH;
				eE.next = lH;
				return sH;
			}
		}
	}

}
