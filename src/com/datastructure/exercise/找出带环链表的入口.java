package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * 
 * Note:�����Բ�ͬ���ٶ��ƶ���һǰһ��
 *
 */
public class �ҳ������������� {


	/**
	 * 1��������ָ���Բ�ͬ���ٶȴ���㿪ʼ�ƶ����ҵ�����ָ��������ڵ㣬����ڵ�һ���ڻ���
	 * 2��
	 */
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		//��ȡ���������ڵ�
		ListNode meeting = getMeetingNode(pHead);	
		if(meeting == null){
			return null;
		}
		//������һ���ڻ��ϣ�����֮������ߣ��ڶ�������������������һ��
		int cycleLen = 1;
		ListNode tmp = meeting.next;
		while(tmp != meeting){
			cycleLen++;
			tmp = tmp.next;
		}
		//���������뻷����ھ���ΪX�����ĳ���ΪY���ܳ���ΪX+Y
		//��һ���ڵ�����Y�ľ��룬�������ʣ��X�ľ��룬��ʱ��ڶ����ڵ������������X�ľ���������ڵ����������
		ListNode first = pHead;
		while(cycleLen > 0){
			first = first.next;
			cycleLen--;
		}
		ListNode second = pHead;
		//first�Ѿ�����y����ʣ��x���͵���������ˣ�������second��ʼ�ߣ�����x���������ڻ������������
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	/**
	 * find the meeting node
	 * first�Ӻ���Ľڵ������second��ǰ��Ľڵ������second���ٶ���first��������
	 */
	private static ListNode getMeetingNode(ListNode node) {
		ListNode first = node;
		ListNode second = node.next;
		while(first != null && second != null){
			if(first == second){//������
				return first;
			}else{
				first = first.next;
				second = second.next;
				if(first == second){//һ���������ˣ�ֱ�ӷ���
					return first;
				}else if(second.next != null){//һ��û�����������ٶ���һ��
					second = second.next;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node4;
		System.out.println(EntryNodeOfLoop(node1).val);
		
	}
}
