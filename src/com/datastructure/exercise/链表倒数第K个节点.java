package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 
 *����һ����������������е�����k����㡣
 */
public class ��������K���ڵ� {

	public static void main(String[] args) {
		��������K���ڵ� test = new ��������K���ڵ�();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(test.findKthToTail(head, 4).val);
	}
	
	/**
	 * 1��ʹ��head1 head2ͬʱָ��head
	 * 2������һ����m���ڵ㣬��head1�����k-1������head1ʣ��(m-k)��Ԫ��
	 * 3����ʱ��head1 head2ͬʱ����ʣ��Ĳ�������head2����(m-k)��Ԫ�أ�ʣ��m-(m-k)=k��Ԫ��
	 */
	public ListNode findKthToTail(ListNode head,int k) {
		if(k < 1 || head == null){
			return null;
		}
		ListNode head1 = head;
		ListNode head2 = head;
		//��������ĳ�����n
		//head1����k-1������������������K���ڵ�,ʣ��n-k���ڵ�
		for(int i=0;i<k-1;i++){
			if(head1 != null){
				head1 = head1.next;
			}else{
				return null;
			}
		}
		if(head1 == null){
			return null;
		}else if(head1.next == null){
			return head2;
		} else {
			// head1 head2ͬʱ��ʣ���n-k���ڵ�
			while (head1.next != null) {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return head2;
    }
	

}
