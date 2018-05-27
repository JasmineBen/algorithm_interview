package com.datastructure.exercise;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
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
		//相遇点一定在环上，相遇之后接着走，第二次相遇就正好右走了一环
		int cycleLength = 1;
		ListNode tmp = meeting;
		while(tmp.next != meeting){
			tmp = tmp.next;
			cycleLength ++;
		}
		//假设起点距离环的入口距离为X，环的长度为Y，总长度为X+Y
		//让一个节点先走Y的距离，距离入口剩下X的距离，这时候第二个节点从起点出发，走X的距离后两个节点会正好相遇
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
