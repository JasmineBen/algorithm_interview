package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ����һ������ÿ k ���ڵ�һ����з�ת�������ط�ת�������
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�����ʣ��ڵ㱣��ԭ��˳��
 * ʾ�� :
 * �����������1->2->3->4->5
 * �� k = 2 ʱ��Ӧ������: 2->1->4->3->5
 * �� k = 3 ʱ��Ӧ������: 3->2->1->4->5
 * ˵�� :
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 */
public class k��һ�鷭ת���� {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode result = new k��һ�鷭ת����().reverseKGroup(head, 2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	/**
	 * �ݹ����
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		int canProceed = 0;
		ListNode check = head;
		// ����������Ƿ����㷭ת
		while (canProceed < k && check != null) {
			check = check.next;
			canProceed++;
		}
		//���Խ��з�ת
		if(canProceed == k) {
			ListNode pre = null;
			ListNode current = head;
			ListNode next = null;
			while(canProceed > 0) {
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
				canProceed --;
			}
			if(next != null) {
				head.next = reverseKGroup(next, k);
			}
			return pre;
		}else {
			//���ܽ��з�ת
			return head;
		}
	}
}
