package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.ListNode;

/**
 * �ж������Ƿ��ǻ��Ľṹ
 * ʹ��ջ��ǰһ���Ԫ�ش洢��ջ���棬�Ƚ�ջ�����Ԫ�غ�ʣ�������Ԫ��
 *
 */
public class �ж������Ƿ���Ľṹ {
	
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(2);
		first.next = second;
		second.next = third;
		ListNode four  = new ListNode(1);
		third.next = four;
		System.out.println(isPalindrome(first));
	}

	
	public static boolean isPalindrome(ListNode head){
		if(head != null){
			ListNode cur = head;
			ListNode next = head;
			Stack<ListNode> stack = new Stack<>();
			while(next != null && next.next!= null){
				stack.push(cur);
				cur = cur.next;
				next = next.next.next;
			}
			if(next != null){
				cur = cur.next;
			}
			while(!stack.isEmpty()){
				if(stack.pop().val != cur.val){
					return false;
				}
				cur = cur.next;
			}
		}
		return true;
	}
}
