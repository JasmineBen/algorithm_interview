package com.datastructure.exercise;

/**
 * 
 *输入一个链表，输出该链表中倒数第k个结点。
 */
public class RemoveKthToTail {

	public static void main(String[] args) {
		RemoveKthToTail test = new RemoveKthToTail();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = test.removeKthToTail(head, 1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
	/**
	 * 1、遍历链表，每次next做k--操作，最后k'=k-m,m为链表长度
	 * 2、k'=0说明链表长度为k，删除head即可
	 * 3、k'<0说明链表长度大于k,那么从头开始遍历-k'-1个元素，
	 * 此时指针就指向第-k'-1个元素，也就是倒数第k+1个元素，假设这个节点为cur，要删除的节点就在后面，
	 * 此时设置cur.next = cur.next.next即可
	 * 
	 */
	public ListNode removeKthToTail(ListNode head,int k) {
		if(k < 1 || head == null){
			return null;
		}
		ListNode cur = head;
		while(cur != null){
			k--;
			cur = cur.next;
		}
		if(k == 0){//列表长度=k，删除第一个元素
			head =  head.next;
		}
		
		//链表长度大于K，假设链表长度为m,则经过上面循环后k'=k-m
		//那么从head向后遍历-k'-1个元素，剩余的元素就是m-(-k'-1)=m-(m-k-1)=k+1
		//这时候在删除head指向倒数第k+1个元素，
		if(k < 0){
			cur = head;
			while(++k < 0){
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
    }
	
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
