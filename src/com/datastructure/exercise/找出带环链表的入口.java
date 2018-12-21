package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * Note:必须以不同的速度移动，一前一后
 *
 */
public class 找出带环链表的入口 {


	/**
	 * 1、让两个指针以不同的速度从起点开始移动，找到两个指针的相遇节点，这个节点一定在环上
	 * 2、
	 */
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		//获取还上相遇节点
		ListNode meeting = getMeetingNode(pHead);	
		if(meeting == null){
			return null;
		}
		//相遇点一定在环上，相遇之后接着走，第二次相遇就正好右走了一环
		int cycleLen = 1;
		ListNode tmp = meeting.next;
		while(tmp != meeting){
			cycleLen++;
			tmp = tmp.next;
		}
		//假设起点距离环的入口距离为X，环的长度为Y，总长度为X+Y
		//让一个节点先走Y的距离，距离入口剩下X的距离，这时候第二个节点从起点出发，走X的距离后两个节点会正好相遇
		ListNode first = pHead;
		while(cycleLen > 0){
			first = first.next;
			cycleLen--;
		}
		ListNode second = pHead;
		//first已经走了y步，剩余x步就到环的入口了，现在让second开始走，走了x步后，两者在环的起点相遇了
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	/**
	 * find the meeting node
	 * first从后面的节点出发，second从前面的节点出发，second的速度是first的两倍。
	 */
	private static ListNode getMeetingNode(ListNode node) {
		ListNode first = node;
		ListNode second = node.next;
		while(first != null && second != null){
			if(first == second){//相遇了
				return first;
			}else{
				first = first.next;
				second = second.next;
				if(first == second){//一步就相遇了，直接返回
					return first;
				}else if(second.next != null){//一步没有相遇，那再多走一步
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
