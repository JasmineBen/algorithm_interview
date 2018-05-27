package com.datastructure.exercise;

/**
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * 
 * @author admin
 *
 */
public class EntryNodeOfLoop {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		
		ListNode meeting = getMeetingNode(pHead);	
		if(meeting == null){
			return null;
		}
		//������һ���ڻ��ϣ�����֮������ߣ��ڶ�������������������һ��
		int cycleLength = 1;
		ListNode tmp = meeting;
		while(tmp.next != meeting){
			tmp = tmp.next;
			cycleLength ++;
		}
		//���������뻷����ھ���ΪX�����ĳ���ΪY���ܳ���ΪX+Y
		//��һ���ڵ�����Y�ľ��룬�������ʣ��X�ľ��룬��ʱ��ڶ����ڵ������������X�ľ���������ڵ����������
		ListNode first = pHead;
		while(cycleLength > 0){
			first = first.next;
			cycleLength--;
		}
		ListNode second = pHead;
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	//find the meeting node
	private ListNode getMeetingNode(ListNode pHead) {
		ListNode first = pHead.next;
		ListNode second = pHead.next.next;
		ListNode meeting = null;
		while (first != null && second != null) {
			if (first == second) {
				meeting = first;
				break;
			} else {
				first = first.next;
				second = second.next;
				if (first == second) {
					meeting = first;
					break;
				} else if (second != null) {
					second = second.next;
				}
			}
		}
		return meeting;
	}
}
