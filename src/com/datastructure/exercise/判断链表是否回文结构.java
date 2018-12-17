package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.ListNode;

/**
 * 判断链表是否是回文结构
 * 使用栈将前一半的元素存储到栈里面，比较栈里面的元素和剩余链表的元素
 *
 */
public class 判断链表是否回文结构 {
	
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
