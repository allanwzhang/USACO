package freqUsedAlg;

import java.util.*;

public class primMST {

	public static void main(String[] args) {
		int numVertices = 0;
		
		int[][] edges = new int[numVertices][numVertices];
		Node[] nodes = new Node[numVertices];
		Arrays.fill(nodes, Integer.MAX_VALUE);
		nodes[0].key = 0;
		
		int edgeSum = 0;
		HashSet<Node> inMST = new HashSet<>();
		while(inMST.size() < numVertices) {
			int minKey = Integer.MAX_VALUE;
			int minI = -1;
			for(int i = 0; i < nodes.length; i++) {
				if(!inMST.contains(nodes[i])) {
					if(nodes[i].key < minKey) {
						minKey = nodes[i].key;
						minI = i;
					}
				}
			}
			inMST.add(nodes[minI]);
			edgeSum += minKey;
			for(int i = 0; i < nodes.length; i++) {
				if(!inMST.contains(nodes[i])) nodes[i].key = Math.min(edges[i][minI], nodes[i].key);
			}
		}
		
		System.out.println(edgeSum);
	}

	static class Node implements Comparable<Node> {
		int key;
		public Node(int k) {
			key = k;
		}
		@Override
		public int compareTo(Node n) {
			return key - n.key;
		}
		
	}
}
