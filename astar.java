package main;

import java.util.ArrayList;
import java.util.Random;

import structures.*;



public class astar {
	

	static int counter = 0;
	static int search = 0;
	static BinaryHeap open = new BinaryHeap();
	static ArrayList<Cell> closed = new ArrayList<Cell>();
	
	
	public static void main(String[] args) {
		
			Grid grid = new Grid();
			
			//grid.visitRandomCell();
			
			Grid newGrid = new Grid();
			
			
			Cell start = new Cell();
			Cell goal = new Cell();
			Cell curr = new Cell();
			
			Random rand = new Random();
/*			
			int sx = rand.nextInt(101) + 1;
			int sy = rand.nextInt(101) + 1;
			
			while(grid.getCell(sx, sy).getState() != 1) {
				 sx = rand.nextInt(101) + 1;
				 sy = rand.nextInt(101) + 1;
			}
			
			int gx = rand.nextInt(101) + 1;
			int gy = rand.nextInt(101) + 1;
			
			while(grid.getCell(gx, gy).getState() != 1 && gx != sx && gy != sy) {
				 gx = rand.nextInt(101) + 1;
				 gy = rand.nextInt(101) + 1;
			}
*/			
			
			/*int sx = rand.nextInt(5) + 1;
			int sy = rand.nextInt(5) + 1;
			
			while(grid.getCell(sx, sy).getState() != 1) {
				 sx = rand.nextInt(5) + 1;
				 sy = rand.nextInt(5) + 1;
			}
			
			int gx = rand.nextInt(5) + 1;
			int gy = rand.nextInt(5) + 1;
			
			while(grid.getCell(gx, gy).getState() != 1 && gx != sx && gy != sy) {
				 gx = rand.nextInt(5) + 1;
				 gy = rand.nextInt(5) + 1;
			}*/
			
			
			//System.out.println(sx + " " + sy);
			//System.out.println(gx + " " + gy);
			
			
			int sx = 1;
			int sy = 1;
			int gx = 5;
			int gy = 2;
			
			
			start = grid.getCell(sx, sy);
			goal = grid.getCell(gx, gy);
			curr = start;
			
			System.out.println("START" + "(" + start.getX() + ", " + start.getY() + ")");
			
			System.out.println("GOAL" + "(" + goal.getX() + ", " + goal.getY() + ")");
			System.out.println();
			
			open.add(start);
			
			
			
			curr.setH(gethuristic(sx,sy,gx,gy));
			curr.setG(counter);
			
			curr.setF(curr.getG() + curr.getH());
			
			
			Cell ret = aStar(grid, start, goal);
			//System.out.println("(" + ret.getX() + ", " + ret.getY() + ")");
			//System.out.println("(" + ret.getParent().getX() + ", " + ret.getParent().getY() + ")");
			Cell ptr = ret;
			
			while(ptr != start) {
				
				System.out.println("(" + ptr.getX() + ", " + ptr.getY() + ")");
				ptr = ptr.getParent();
				
			}
			System.out.println("(" + ptr.getX() + ", " + ptr.getY() + ")");
			
			
		
	}
	
	public static Cell aStar(Grid grid, Cell start, Cell goal){
		
		int count = 0;
		int ii = 0;
		
		Cell curr = new Cell();
		curr = open.delete(0);
		closed.add(curr);
		//System.out.println("(" + curr.getX() + ", " + curr.getY() + ")");
		
		
		while(curr.equals(goal) == 0){
			
			//System.out.println("4");
			//System.out.println("CURRENT  " +     "(" + curr.getX() + ", " + curr.getY() + ")");
			count++;
		if(grid.blocked(curr, 0) == 1) {//NORTH
		//	System.out.println("CUURRRRR" + curr.getX() + "    " + curr.getY());
			Cell n = new Cell();
			n.setX(curr.getX());
			n.setY(curr.getY() - 1);
			
			/*for(int i = 0; i < closed.size(); i++) {
				
		//	System.out.println("CLOOSED LIST "+ closed.get(i).getX() + "  " + closed.get(i).getY());
			
			}*/
		
			if(inClosedList(n) == 0) {
			
			if(ii == 3) {
				System.out.println("here North");
				
			}
			
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
			//Cell n = new Cell();
				
			n.setH(gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY()));
			//System.out.println("a star" + n.getH());
			
		
			n.setG(count);
			n.setF(n.getG() + n.getH());
			
			open.add(n);
			n.setParent(curr);
			System.out.println("Parent N, NORTH " + n.getParent().getX() + "  " + n.getParent().getY());
			System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
			
				
			}else{
				
				int h = gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY());
				int g = count;
				int f = h + g;
				
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.delete(openIndex);
					n.setH(gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY()));
					n.setG(count);
					n.setF(n.getG() + n.getH());
					open.add(n);
					n.setParent(curr);
				System.out.println("Parent N, NORTH " + n.getParent().getX() + "  " + n.getParent().getY());
				System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
					
				}
				
				
			}
			
		}
			
		}
	
	
		//System.out.println("HERE");
		if(grid.blocked(curr, 1) == 1) {//SOUTH
			
			
			/*for(int i = 0; i < closed.size(); i++) {
				
				System.out.println("(" + closed.get(i).getX() + ", " + closed.get(i).getY() + ")");
			}
			*/
			//System.out.println("a star SOUTH REACHING");
			
			Cell n = new Cell();
			n.setX(curr.getX());
			n.setY(curr.getY() + 1);
			//System.out.println("CUURRRRR" + curr.getX() + "    " + curr.getY());
		if(inClosedList(n) == 0) {
			
			
			//System.out.println("a star SOUTH REACHING");
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
			//Cell n = new Cell();
			n.setH(gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY()));
			//System.out.println("a star" + n.getH());
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);
			System.out.println("Parent N, SOUTH " + n.getParent().getX() + "  " + n.getParent().getY());
			System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
			}else{
				
				int h = gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY());
				int g = count;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.delete(openIndex);
					n.setH(gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY()));
					n.setG(count);
					n.setF(n.getG() + n.getH());
					open.add(n);
					n.setParent(curr);
				System.out.println("Parent N, SOUTH " + n.getParent().getX() + "  " + n.getParent().getY());
					
				System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());	
				}
				
				
			}
			
		}
			
		}
		
		if(grid.blocked(curr, 2) == 1) {//EAST
			//System.out.println("a star east REACHING");
			Cell n = new Cell();
			n.setX(curr.getX() + 1);
			n.setY(curr.getY());
		
		if(inClosedList(n) == 0) {
			
			//System.out.println("Here");
			/*if(ii == 3) {
				//System.out.println(grid.alreadyVisited(2,  n.getX() , n.getY()));
				//break;
			}*/
			
			if (grid.Visited(n.getX() , n.getY()) == 0 && inOpenList(n) == -1) {
				
			//Cell n = new Cell();
			n.setH(gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY()));
			
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);
			System.out.println("Parent N, EAST " + n.getParent().getX() + "  " + n.getParent().getY());
			System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
			
			
			
			}else{
				
				int h = gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY());
				int g = count;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.delete(openIndex);
					n.setH(gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY()));
					n.setG(count);
					n.setF(n.getG() + n.getH());
					open.add(n);
					n.setParent(curr);
			System.out.println("Parent N, EAST " + n.getParent().getX() + "  " + n.getParent().getY());
			System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
					
				}
				
				
			}
			
		}
			
		}
		
		if(grid.blocked(curr, 3) == 1) {//WEST
			//System.out.println("a star west REACHING");
			Cell n = new Cell();
			n.setX(curr.getX() - 1);
			n.setY(curr.getY());
		
		if(inClosedList(n) == 0) {
			
			
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
			//Cell n = new Cell();
			n.setH(gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY()));
			
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);
			System.out.println("Parent N, WEST " + n.getParent().getX() + "  " + n.getParent().getY());
			System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
			}else{
				
				int h = gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY());
				int g = count;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.delete(openIndex);
					n.setH(gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY()));
					n.setG(count);
					n.setF(n.getG() + n.getH());
					open.add(n);
					n.setParent(curr);
					System.out.println("Parent N, WEST " + n.getParent().getX() + "  " + n.getParent().getY());
					
					System.out.println("H " + n.getH() + " G " + n.getG() + " F "  + n.getF());
				}
				
				
			}
			
		}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		/*else if(grid.blocked(curr, 1) == 1 && grid.alreadyVisited(1) == 0){
			Cell n = new Cell();
			n.setH(gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY()));
			count++;
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);
			
		}else if(grid.blocked(curr, 2) == 1 && grid.alreadyVisited(2) == 0) {
			Cell n = new Cell();
			n.setH(gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY()));
			count++;
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);
			
		}else if(grid.blocked(curr, 3) == 1){
			if(grid.alreadyVisited(3) == 0) {
			Cell n = new Cell();
			n.setH(gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY()));
			count++;
			n.setG(count);
			n.setF(n.getG() + n.getH());
			open.add(n);
			n.setParent(curr);	
			
			
			}
			
			}
			*/
		
		/*for(int i = 0; i < open.size(); i++) {
				System.out.println("HEAP List   " + open.getCell(i).getX() + "   " +  open.getCell(i).getY());
		}*/
		
		
		 curr = open.delete(0);
		// System.out.println("CUUR AT END" + curr.getX() + "   " +  curr.getY());
		/* ii++;
			if(ii == 3) {
			open.printHeap();
			 System.out.println("CUUR AT END" + curr.getX() + "   " +  curr.getY());
			 System.out.println("CUUR AT END" + curr.getF());
			//break;
			}*/
		 closed.add(curr);
		 
		 
		//

		 //break;
		/* ii++;
		// System.out.println("BIG II" + ii);
		 if(ii == 4) {
			 System.out.println("FINAL PARENT " + curr.getParent().getX() + "  " + curr.getParent().getY());
			 System.out.println("Parent N, NORTH " + curr.getParent().getParent().getX() + "  " + curr.getParent().getParent().getY());
		 }*/
		 
		
		 
		}
		
		
		
		return curr;
	}
	
	public static int inClosedList(Cell a) {
		
		for(int i = 0; i < closed.size(); i++) {
			if(a.equals(closed.get(i)) == 1){
				return 1;
			}
			
		}
		
		return 0;
		
	}
	
	public static int inOpenList(Cell a) {
		
		for(int i = 0; i < open.size(); i++) {
			if(a.equals(open.getCell(i)) == 1){
				return i;
			}
			
		}
		
		return -1;
	}
	public static int gethuristic(int sx, int sy, int gx, int gy) {
		
		int ret = Math.abs(sx - gx) + Math.abs(sy - gy);
		
		//System.out.println(sx + "  " + sy);
		//System.out.println("this is herusitisc  " + ret);
		return ret;
		
		
	}
	

}
