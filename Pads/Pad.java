package Pads;
import java.util.*;

public class Pad {

	public static void main(String[] args) {
		Node tn1 = new Node(1);
		Node tn2 = new Node(2);
		Node tn3 = new Node(3);
		Node tn4 = new Node(4);

		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		
		Deque<Node> queue = new ArrayDeque<Node>();
			queue.add(tn1);
		while(queue.size() > 0) {
			Node root = queue.pop();
			System.out.println(root.val);
			if(root.left != null) {
				queue.add(root.left);
			}
			if(root.right != null) {
				queue.add(root.right);
			}
		}
		
		//printTree(tn1);
	}
	
	static void printTree(Node root) {
		
		if(root.left != null) {
			printTree(root.left);
		}
		
		System.out.println(root.val);
		
		if(root.right != null) {
			printTree(root.right);
		}
	}
	
}
