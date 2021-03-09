package freqUsedAlg;

import java.util.ArrayList;
import java.util.Arrays;

public class kruskalMST {
	//O(ElogV) => O(ElogE) through sorting
	public static void main(String[] args) {
		int numV = 0;
		int numE = 0;
		
		Edge[] edges = new Edge[numE];
		Node[] vertices = new Node[numV];
		
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = new Node(i, 0);
		}
		Arrays.sort(edges);
		
		ArrayList<Edge> mstEdges = new ArrayList<>();
		
		for(int i = 0; i < edges.length; i++) {
			if(!connected(edges[i].start, edges[i].end, vertices)) {
				union(edges[i].start, edges[i].end, vertices);
				mstEdges.add(edges[i]);
				if(mstEdges.size() == numV - 1) break;
			}
 		}
		
		for(Edge e : mstEdges) {
			System.out.println(e);
		}
	}

	static void union(int a, int b, Node[] vertices) {
		int aroot = find(a, vertices);
		int broot = find(b, vertices);
		if(vertices[aroot].rank > vertices[broot].rank) {
			vertices[broot].parent = a;
		} else if(vertices[aroot].rank < vertices[broot].rank) {
			vertices[aroot].parent = b;
		} else {
			vertices[broot].parent = a;
			vertices[aroot].rank++;
		}
	}
	
	static boolean connected(int a, int b, Node[] vertices) {
		return find(a, vertices) == find(b, vertices);
	}
	
	static int find(int a, Node[] vertices) {
		if(vertices[a].parent == a) return a;
		return vertices[a].parent = find(vertices[a].parent, vertices);
	}
	
	static class Node {
		int parent, rank;
		
		public Node(int p, int r) {
			parent = p;
			rank = r;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int s, int e, int w) {
			start = s;
			end = e;
			weight = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return weight - e.weight;
		}
		
		public String toString() {
			return "Start: " + start + " End: " + end + " Weight: " + weight;
		}
	}
}
