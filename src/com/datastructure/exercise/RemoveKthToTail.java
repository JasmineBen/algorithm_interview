package com.datastructure.exercise;

/**
 * 
 *����һ����������������е�����k����㡣
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
	 * 1����������ÿ��next��k--���������k'=k-m,mΪ������
	 * 2��k'=0˵��������Ϊk��ɾ��head����
	 * 3��k'<0˵�������ȴ���k,��ô��ͷ��ʼ����-k'-1��Ԫ�أ�
	 * ��ʱָ���ָ���-k'-1��Ԫ�أ�Ҳ���ǵ�����k+1��Ԫ�أ���������ڵ�Ϊcur��Ҫɾ���Ľڵ���ں��棬
	 * ��ʱ����cur.next = cur.next.next����
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
		if(k == 0){//�б���=k��ɾ����һ��Ԫ��
			head =  head.next;
		}
		
		//�����ȴ���K������������Ϊm,�򾭹�����ѭ����k'=k-m
		//��ô��head������-k'-1��Ԫ�أ�ʣ���Ԫ�ؾ���m-(-k'-1)=m-(m-k-1)=k+1
		//��ʱ����ɾ��headָ������k+1��Ԫ�أ�
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
