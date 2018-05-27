package com.datastructure.exercise;

/**
 * 
 *输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

	public static void main(String[] args) {
		FindKthToTail test = new FindKthToTail();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(test.findKthToTail(head, 5).val);
	}
	
	/**
	 * 1、使用head1 head2同时指向head
	 * 2、假设一共有m个节点，将head1向后走k-1步，则head1剩下(m-k)个元素
	 * 3、这时候head1 head2同时走完剩余的步数，则，head2会走(m-k)个元素，剩余m-(m-k)=k个元素
	 */
	public ListNode findKthToTail(ListNode head,int k) {
		if(k == 0 || head == null){
			return null;
		}
		ListNode head1 = head;
		ListNode head2 = head;
		int skip = 1;
		while(skip < k && head1.next != null){
			head1 = head1.next;
			skip ++;
		}
		if(skip < k -1){
			return null;
		}
		while(head1.next != null){
			head1 = head1.next;
			head2 = head2.next;
		}
		return head2;
    }
	
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
