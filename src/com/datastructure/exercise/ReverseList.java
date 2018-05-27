package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * ��������
 */
public class ReverseList {

	static class ListNode{
		ListNode next = null;
		int val = 0;
		
		ListNode(){
			
		}
		
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode first = new ListNode(1);
		head.next = first;
		ListNode two = new ListNode(2);
		first.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ReverseList reverseList = new ReverseList();
		//ListNode result = reverseList.reverseWithoutHead(first);
		//ListNode result = reverseList.reverseWithHead(head);
		ListNode result = reverseList.reverseWithHead2(head);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
		
		
	}
	
	/**
	 *1������һ��pre��һ��nextԪ�أ�
	 *2�����Ƚ�next���óɵ�ǰ���ʽڵ��next
	 *3������ǰԪ�ص�next���ó�pre
	 *4������preΪ��ǰԪ�أ����õ�ǰԪ��Ϊnext
	 */
	public ListNode reverseWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = null;
		while(listNode != null){
			next = listNode.next;
			listNode.next = pre;
			pre = listNode;
			listNode = next;
			
		}
		return pre;
	}
	
	/**
	 * ÿ�ν���lastNode�����Ԫ�ز��뵽head����
	 * @param head
	 * @return
	 */
	public ListNode reverseWithHead(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//��ʼ״̬head.next,Ҳ�����������һ��Ԫ��
		ListNode lastNode = head.next;
		ListNode currentInsertNode = head.next.next;
		while(currentInsertNode != null){
			ListNode nextInsertNode = currentInsertNode.next;
			currentInsertNode.next = head.next;
			head.next = currentInsertNode;
			lastNode.next = nextInsertNode;
			currentInsertNode = lastNode.next;
		}
		return head;
	}
	
	/**
	 * ����pre��next��next��pre����
	 * �ȱ���next.next��Ȼ��next.next����Ϊpre
	 * ��pre����Ϊnext����next����Ϊ�ոձ����next.next
	 * �����һ��Ԫ���޸���ɺ�next=next.next=null���������޸�head��next
	 * @param head
	 * @return
	 */
	public ListNode reverseWithHead2(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//��ʼ״̬head.next,Ҳ�����������һ��Ԫ��
		ListNode pre = head.next;
		ListNode next = head.next.next;
		pre.next = null;
		while(next != null){
			ListNode nextInsertNode = next.next;
			next.next = pre;
			pre = next;
			next = nextInsertNode;
		}
		head.next = pre;
		return head;
	}
}
