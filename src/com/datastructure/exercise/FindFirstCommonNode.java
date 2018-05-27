package com.datastructure.exercise;

/**
 * 输入两个链表，找出它们的第一个公共结点
 *
 */
public class FindFirstCommonNode {
	
	private static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	    
	    
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		ListNode head2 = new ListNode(4);
		head2.next = new ListNode(5);
		ListNode common = new ListNode(6);
		common.next = new ListNode(7);
		head1.next.next.next = common;
		head2.next.next = common;
		FindFirstCommonNode test = new FindFirstCommonNode();
		ListNode result = test.FindFirstCommonNode(head1, head2);
		System.out.println(result);
	}
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int length1 = lenght(pHead1);
		int length2 = lenght(pHead2);
		if(length1 > length2){
			int diff = length1-length2;
			while(diff > 0){
				pHead1 = pHead1.next;
				diff -- ;
			}
		}else if(length2 > length1){
			int diff = length2-length1;
			while(diff > 0){
				pHead2 = pHead2.next;
				diff -- ;
			}
		}
		while(pHead1 != pHead2 && pHead1 != null && pHead2 != null){
			 pHead1 =  pHead1.next;
			 pHead2 = pHead2.next;
		 }
		 return pHead1;
    }
	
	private int lenght(ListNode head){
		ListNode temp = head;
		int length = 0;
		while(temp != null){
			temp = temp.next;
			length ++;
		}
		return length;
	}
}
