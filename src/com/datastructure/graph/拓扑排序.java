package com.datastructure.graph;

import java.util.List;

/**
 * ��������
 * @author admin
 *
 */
public class �������� {
	����ͼ G;

	public ��������(����ͼ G){
		this.G = G;
	}
	
	/**
	 * G�������޻�ͼ��
	 * @return
	 */
	public boolean isGAG(){
		return new Ѱ������(G).hasCycle();
	}
	
	/**
	 * �������������ж���
	 * @return
	 */
	public List<Integer> order(){
		return null;
	}
}
