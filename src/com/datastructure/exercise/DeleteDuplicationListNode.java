package com.datastructure.exercise;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 */
public class DeleteDuplicationListNode {
	
	private static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null){
			return null;
		}
		ListNode head = new ListNode(Integer.MAX_VALUE);
		head.next = pHead;
		ListNode preNode = head;
		ListNode postNode = pHead;
		int sameNum = 0;
		while(postNode != null){
			if(postNode.next == null){
				if(sameNum > 0){
					preNode.next = null;
				}
				postNode = postNode.next;
				sameNum = 0;
			}else if(postNode.val == postNode.next.val){
				postNode = postNode.next;
				sameNum++;
			}else{
				if(sameNum > 0){
					preNode.next = postNode.next;
					postNode = postNode.next;
				}else{
					preNode = postNode;
					postNode = postNode.next;
				}
				sameNum = 0;
			}
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		ListNode pHead = new ListNode(1);
		pHead.next =  new ListNode(2);
		pHead.next.next =  new ListNode(3);
		pHead.next.next.next =  new ListNode(3);
		pHead.next.next.next.next =  new ListNode(4);
		pHead.next.next.next.next.next =  new ListNode(4);
		pHead.next.next.next.next.next.next =  new ListNode(5);
		DeleteDuplicationListNode test = new DeleteDuplicationListNode();
		ListNode result = test.deleteDuplication(pHead);
		while(result != null){
			System.out.print(result.val+";");
			result = result.next;
		}
	}
}
