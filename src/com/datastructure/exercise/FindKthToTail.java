package com.datastructure.exercise;

/**
 * 
 *����һ����������������е�����k����㡣
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
	 * 1��ʹ��head1 head2ͬʱָ��head
	 * 2������һ����m���ڵ㣬��head1�����k-1������head1ʣ��(m-k)��Ԫ��
	 * 3����ʱ��head1 head2ͬʱ����ʣ��Ĳ�������head2����(m-k)��Ԫ�أ�ʣ��m-(m-k)=k��Ԫ��
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
