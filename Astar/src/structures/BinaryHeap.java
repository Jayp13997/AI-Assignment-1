package structures;

import java.util.ArrayList;
//import java.util.Scanner;

public class BinaryHeap {

	
	ArrayList<Node> heap = new ArrayList<Node>();
	Node root;
	Node end;
		
	
	public static void main(String[] args) {
		

		BinaryHeap h = new BinaryHeap();
		h.add(new Node(10));
		h.add(new Node(5));
		h.add(new Node(13));
		h.add(new Node(4));
		h.add(new Node(100));
		h.add(new Node(100));
		h.add(new Node(120));
		h.add(new Node(100));
		h.add(new Node(1));
		h.add(new Node(2));
		h.delete();
		h.delete();
		
	
		for(int i = 0; i < h.size(); i++) {
			System.out.print(i + " ");
		}
			
		System.out.println();
			
		for(int i = 0; i < h.size(); i++) {
			System.out.print(h.get(i) + " ");
		}	
		
	}
	
	public void initializeHeap(double f) {
		root = new Node(f);
	}
	
	public double get(int index) {
		return heap.get(index).f;
	}
	
	public  int size() {
		return heap.size();
	}

	public void add(Node n){
		heap.add(n);
		 int k = heap.size() - 1;

		while(k > 0) {
			
			double parent = heap.get((k-1)/2).f;
			double child =	heap.get(k).f;
			
			if(child < parent){
				Node temp = heap.get((k-1)/2);
				heap.set((k-1)/2, heap.get(k));
				heap.set(k, temp);	
			}
			k = (k-1)/2;
		}
	}
	
	
	public void heapify(int n, int i) {
		int parent = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left <= n-1 && right <= n-1) {
			if(heap.get(parent).f <= heap.get(left).f && heap.get(parent).f <= heap.get(right).f) {
				return;
			}
		
			int smallest;
			
			if(heap.get(left).f <= heap.get(right).f) {
				smallest = left;
			}
			else {
				smallest = right;
			}
		
			Node temp = heap.get(smallest);
			heap.set(smallest, heap.get(parent));
			heap.set(parent, temp);
		
			heapify(n, smallest);
		}
		else if(left <= n-1 && right > n-1) {
			if(heap.get(parent).f <= heap.get(left).f) {
				return;
			}
			else {
				Node temp = heap.get(left);
				heap.set(left, heap.get(parent));
				heap.set(parent, temp);
				return;
			}
		}
		else if(right <= n-1 && left > n-1) {
			if(heap.get(parent).f <= heap.get(right).f) {
				return;
			}
			else {
				Node temp = heap.get(right);
				heap.set(right, heap.get(parent));
				heap.set(parent, temp);
				return;
			}
		}
	}
		
	public Node delete() {
		if(heap.size() == 0) {
			return null;
		}
		Node ret = heap.get(0);
		
		int k = heap.size() - 1;
		
		heap.set(0, heap.get(k));
		heap.remove(k);
		
		heapify(heap.size(), 0);
		
		return ret;
	}	

}