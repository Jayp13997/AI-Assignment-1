package structures;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryHeap {
	
	ArrayList<Node> heap = new ArrayList<Node>();
	Node root;
	Node end;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner("Enter instruction");
		BinaryHeap h = new BinaryHeap();
		
		String s = sc.next();
		
		while(!s.equals("exit")) {
		Scanner u = new Scanner("Enter number");
			
		s = sc.next();
		
		if(s.equals("add")) {
	
			int t = u.nextInt();
			Node n = new Node(t);
			h.add(n);
			
		}else if(s.equals("del")) {
			Node ne = h.delete();
			System.out.println("TOP PRIORITY IS: " + ne.f);
			
		}else if(s.equals("display")) {
			
			for(int i = 0; i < h.size(); i++) {
				System.out.print(i + " ");
			}
			
			System.out.println();
			
			for(int i = 0; i < h.size(); i++) {
				System.out.print(h.get(i) + " ");
			}
		}
			
			
			
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
	
	
	
	public Node delete(){
		
		Node ret = heap.get(0);
		
		int k = heap.size() - 1;
		
		heap.set(0, heap.get(k));
		heap.remove(k);
		k = 0;
		while(k < heap.size()) {
		
			double parent = heap.get(k).f;
			
			
			if(heap.get((2*k + 1)).f < parent){
				Node temp = heap.get(k);
				heap.set(k, heap.get(2*k+1));
				heap.set(2*k+1, temp);
				k = 2*k+1;
				
			}else if(heap.get((2*k +2)).f < parent) {
				
			Node temp = heap.get(k);
			heap.set(k, heap.get(2*k+2));
			heap.set(2*k+2, temp);	
			k = 2*k+2;
		}else {
			break;
		}
			
			
		
		
			
		}
		
		
		
		
		return ret;
	}
	

}