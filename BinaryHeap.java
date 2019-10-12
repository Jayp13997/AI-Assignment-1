package structures;

import java.util.ArrayList;
//import java.util.Scanner;

public class BinaryHeap {

	
	ArrayList<Cell> heap = new ArrayList<Cell>();
	Cell root;
	Cell end;
		
	
	public static void main(String[] args) {
		

		BinaryHeap h = new BinaryHeap();
		Cell c = new Cell();
		c.setF(10);
		h.add(c);
		
		Cell d = new Cell();
		d.setF(5);
		h.add(d);
		
		Cell e = new Cell();
		e.setF(13);
		h.add(e);
		
		Cell g = new Cell();
		g.setF(4);
		h.add(g);
		
		Cell u = new Cell();
		u.setF(100);
		h.add(u);
		
		Cell o = new Cell();
		o.setF(100);
		h.add(o);
		
		Cell j = new Cell();
		j.setF(120);
		h.add(j);
		
		Cell a = new Cell();
		a.setF(100);
		h.add(a);
		
		Cell b = new Cell();
		b.setF(1);
		h.add(b);
		
		Cell m = new Cell();
		m.setF(2);
		h.add(m);
		
		
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
	
	/*public void initializeHeap(double f) {
		root = new Node(f);
	}*/
	
	public int get(int index) {
		//System.out.println(heap.get(index).getF());
		return heap.get(index).getF();
	}
	
	public  int size() {
		return heap.size();
	}

	public void add(Cell n){
		heap.add(n);
		 int k = heap.size() - 1;

		while(k > 0) {
			
			int parent = heap.get((k-1)/2).getF();
			int child =	heap.get(k).getF();
			
			//System.out.println(parent + " " + child);
			
			if(child < parent){
				Cell temp = heap.get((k-1)/2);
				//System.out.println(temp.getF());
				//System.out.println(temp.getF());
				 //System.out.println(heap.get(k).getF());
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
			if(heap.get(parent).getF() <= heap.get(left).getF() && heap.get(parent).getF() <= heap.get(right).getF()) {
				return;
			}
		
			int smallest;
			
			if(heap.get(left).getF() <= heap.get(right).getF()) {
				smallest = left;
			}
			else {
				smallest = right;
			}
		
			Cell temp = heap.get(smallest);
			heap.set(smallest, heap.get(parent));
			heap.set(parent, temp);
		
			heapify(n, smallest);
		}
		else if(left <= n-1 && right > n-1) {
			if(heap.get(parent).getF() <= heap.get(left).getF()) {
				return;
			}
			else {
				Cell temp = heap.get(left);
				heap.set(left, heap.get(parent));
				heap.set(parent, temp);
				return;
			}
		}
		else if(right <= n-1 && left > n-1) {
			if(heap.get(parent).getF() <= heap.get(right).getF()) {
				return;
			}
			else {
				Cell temp = heap.get(right);
				heap.set(right, heap.get(parent));
				heap.set(parent, temp);
				return;
			}
		}
	}
		
	public Cell delete() {
		if(heap.size() == 0) {
			return null;
		}
		Cell ret = heap.get(0);
		
		int k = heap.size() - 1;
		
		heap.set(0, heap.get(k));
		heap.remove(k);
		
		heapify(heap.size(), 0);
		
		return ret;
	}	

}