package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 
 *输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表倒数第K个节点 {

	public static void main(String[] args) {
		链表倒数第K个节点 test = new 链表倒数第K个节点();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(test.findKthToTail(head, 4).val);
	}
	
	/**
	 * 1、使用head1 head2同时指向head
	 * 2、假设一共有m个节点，将head1向后走k-1步，则head1剩下(m-k)个元素
	 * 3、这时候head1 head2同时走完剩余的步数，则，head2会走(m-k)个元素，剩余m-(m-k)=k个元素
	 */
	public ListNode findKthToTail(ListNode head,int k) {
		if(k < 1 || head == null){
			return null;
		}
		ListNode head1 = head;
		ListNode head2 = head;
		//假设链表的长度是n
		//head1先走k-1步，这样到达正数第K个节点,剩余n-k个节点
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
			// head1 head2同时走剩余的n-k个节点
			while (head1.next != null) {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return head2;
    }
	

}
