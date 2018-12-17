package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ��������
 * ��Ϊ�������˫��������������
 */
public class �������� {

	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode first = new ListNode(1);
		head.next = first;
		head.pre = null;
		ListNode two = new ListNode(2);
		first.next = two;
		first.pre = head;
		ListNode three = new ListNode(3);
		two.next = three;
		two.pre = first;
		ListNode four = new ListNode(4);
		three.next = four;
		three.pre = two;
		four.pre = three;
		�������� reverseList = new ��������();
		//ListNode result = reverseList.reverseWithHead(head);
//		ListNode result = reverseList.reverseDoublyWithoutHead(first);
		ListNode result = reverseList.reverseDoublyWithHead(head);
		ListNode next = result;
		while(next != null){
			System.out.print(next.val+";");
			next = next.next;
		}
		System.out.println();
		while(result != null && result.next != null){
			result = result.next;
		}
		while(result != null){
			System.out.print(result.val+";");
			result = result.pre;
		}
	}
	
	/**
	 * �����б�û��ͷ�ڵ�
	 *1������һ��pre��һ��nextԪ�أ���ʼ��ʱpre=null,next=�׽ڵ�
	 *2��ѭ����next.nextָ��pre����pre����Ϊnext������next����
	 *3����󷵻�next
	 */
	public ListNode reverseWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = listNode;
		while(next != null && next.next!=null){
			ListNode nextNext = next.next;
			next.next = pre;
			pre = next;
			next = nextNext;
		}
		next.next = pre;
		return next;
	}
	
	
	/**
	 * �����б���head
	 * ����pre��next��next��pre����
	 * �ȱ���next.next��Ȼ��next.next����Ϊpre
	 * ��pre����Ϊnext����next����Ϊ�ոձ����next.next
	 * �����һ��Ԫ���޸���ɺ�next=next.next=null���������޸�head��next
	 */
	public ListNode reverseWithHead(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		//��ʼ״̬head.next,Ҳ�����������һ��Ԫ��
		ListNode pre = head.next;
		ListNode next = head.next.next;
		pre.next = null;
		while(next != null){
			ListNode nextNext = next.next;
			next.next = pre;
			pre = next;
			next = nextNext;
		}
		head.next = pre;
		return head;
	}
	
	/**
	 * ˫������û��ͷ�ڵ�
	 */
	public ListNode reverseDoublyWithoutHead(ListNode listNode) {
		ListNode pre = null;
		ListNode next = listNode;
		while(next != null && next.next!=null){
			ListNode nextNext = next.next;
			next.next = pre;
			next.pre = nextNext;
			pre = next;
			next = nextNext;
		}
		next.next = pre;
		next.pre = null;
		return next;
	}
	
	/**
	 * ˫��������ͷ�ڵ�
	 */
	public ListNode reverseDoublyWithHead(ListNode listNode) {
		ListNode pre = listNode;
		ListNode next = listNode.next;
		ListNode firstNode = listNode.next;
		pre.next = null;
		while(next != null){
			ListNode nextNext = next.next;
			if(firstNode != next){
				next.next = pre;
			}else{
				next.next = null;
			}
			next.pre = nextNext;
			pre = next;
			next = nextNext;
		}
		listNode.next = pre;
		pre.pre = listNode;
		return listNode;
	}
	
}
