package com.datastructure.search;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

	//层次遍历
	public static void levelTraversal(Node node){
		if(node != null){
			Queue<Node> queue = new LinkedList<>();
			queue.offer(node);
			while(!queue.isEmpty()){
				Node n = queue.poll();
				System.out.println("levelTraversal:"+n.val.val);
				if(n.left != null){
					queue.offer(n.left);
				}
				if(n.right != null){
					queue.offer(n.right);
				}
			}
		}
	}
	
	//树的高度
	public static int height(Node node){
		if(node == null){
			return 0;
		}
		int height =  Math.max(height(node.left), height(node.right)) + 1;
//		System.out.println("height:"+height);
		return height;
	}
}
