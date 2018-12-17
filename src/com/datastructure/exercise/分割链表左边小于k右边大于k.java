package com.datastructure.exercise;

import com.datastructure.basic.ListNode;

/**
 * ����һ��key���������Ϊ�����֣��������С��key,�м����key,�ұߴ���key,
 * ����֤ԭ����˳�򲻱䣬����5��3��4��7��6�Ľ��Ϊ3��4��5��7��6
 * @author zhoupeiyuan
 *
 */
public class �ָ��������С��k�ұߴ���k {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		ListNode node1 = new ListNode(3);
		head.next = node1;
		ListNode node2 = new ListNode(4);
		node1.next = node2;
		ListNode node3 = new ListNode(7);
		node2.next = node3;
		ListNode node4 = new ListNode(6);
		node3.next = node4;
		ListNode result = partion(head, 5);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

	
	/**
	 * ������������
	 * small������С��key�Ľڵ�
	 * equal���������key�Ľڵ�
	 * larger���������key�Ľڵ�
	 * ����ٽ��������������������γ��µ�����
	 * �����ӵĹ�������Ҫsmall�����ͷ�ڵ㣬���ڷ��أ�
	 * small�����β�������equal�����ͷ�ڵ㣻equal�����β�ڵ�����larger�����ͷ���
	 */
	public static ListNode partion(ListNode head,int key){
		ListNode sH = null;//small����ͷ�ڵ�
		ListNode sE = null;//small����β�ڵ�
		ListNode eH = null;//equal����ͷ�ڵ�
		ListNode eE = null;//equal����β�ڵ�
		ListNode lH = null;//larger����ͷ�ڵ�
		ListNode lE = null;//larger����β�ڵ�
		ListNode next = null;
		while(head != null){
			next = head.next;
			head.next = null;
			if(head.val < key){
				if(sH == null){
					sH = head;
					sE = head;
				}else{
					sE.next = head;
					sE = sE.next;
				}
			}else if(head.val == key){
				if(eH == null){
					eH = head;
					eE = head;
				}else{
					eE.next = head;
					eE = eE.next;
				}
			}else{
				if(lH == null){
					lH = head;
					lE = head;
				}else{
					lE.next = head;
					lE = lE.next;
				}
			}
			head = next;
		}
		
		if(sH == null){
			if(eH == null){
				return lH;
			}else{
				eE.next = lH;
				return eE;
			}
		}else{
			if(eH == null){
				sH.next = lH;
				return sH;
			}else{
				sE.next = eH;
				eE.next = lH;
				return sH;
			}
		}
	}

}
