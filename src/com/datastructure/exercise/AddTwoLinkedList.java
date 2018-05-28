package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.ListNode;

/**
 * ������������ӣ�����9->3->7��6->3��Ӻ�Ϊ�� 1->0->0->0
 *
 */
public class AddTwoLinkedList {
	
	public static void main(String[] args) {
		ListNode first = new ListNode(9);
		first.next = new ListNode(3);
		first.next.next = new ListNode(7);
		
		ListNode second = new ListNode(6);
		second.next = new ListNode(3);
		add(first, second);
	}

	/**
	 * ����ջ�ṹ���������б��Ԫ�طֱ�ѹ������ջ
	 * 
	 * @param first
	 * @param second
	 */
	public static void add(ListNode first, ListNode second) {
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		while (first != null) {
			stack1.push(first);
			first = first.next;
		}
		while (second != null) {
			stack2.push(second);
			second = second.next;
		}

		int ca = 0;// ��λ
		ListNode last = null;
		ListNode head = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int a = stack1.isEmpty() ? 0 : stack1.pop().val;
			int b = stack2.isEmpty() ? 0 : stack2.pop().val;
			int res = (a + b + ca) % 10;
			ca = (a + b + ca) / 10;
			if (last == null) {
				last = new ListNode(res);
			} else {
				head = new ListNode(res);
				head.next = last;
				last = head;
			}
		}
		if(ca > 0){
			head = new ListNode(ca);
			head.next = last;
		}
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}
}
