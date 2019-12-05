package main;

import java.util.ArrayList;
import java.util.Random;

import structures.*;



public class astarBackwards{
	

	 int counter = 0;
	 int search = 0;
	 BinaryHeap open = new BinaryHeap();
	 ArrayList<Cell> closed = new ArrayList<Cell>();
	
	 Grid newGrid = new Grid();
	 Grid grid = new Grid();
	static int totalExpanded = 0;
 	 int sx = 3;
	 int sy = 5;
	 int gx = 5;
	 int gy = 5;


public astarBackwards(Grid g, int sx, int sy, int gx, int gy) {
	grid = g;
	this.sx = sx;
	this.sy = sy;
	this.gx = gx;
	this.gy = gy;
	
}
	
public int totalBackward() {
	return totalExpanded;
}
	
	
	
	public void runRepeatedBackwards() {
	

			
			Cell start = new Cell();
			Cell goal = new Cell();
			Cell curr = new Cell();
			
			
			start = grid.getCell(sx, sy);
			goal = grid.getCell(gx, gy);
			curr = goal;
			
			System.out.println("START" + "(" + start.getX() + ", " + start.getY() + ")");
			
			System.out.println("GOAL" + "(" + goal.getX() + ", " + goal.getY() + ")");
			System.out.println();
			
			open.add(goal);
			
			
			
			int countAstar = 0;
			curr.setH(gethuristic(sx,sy,gx,gy));
			curr.setG(counter);
			goal.setG(Integer.MAX_VALUE);
			curr.setF(curr.getG() + curr.getH());
			Cell ret = new Cell();
			ret = start;
			Cell newGoal = new Cell();
			newGoal = newGrid.getCell(gx, gy);
			Cell newRet = new Cell();
			newRet = newGrid.getCell(sx, sy);
	
			
		
			
			while(ret.equals(goal) == 0) {
				
				if(grid.blocked(ret, 0) == 0) {
					newGrid.setCellB(ret.getX(), ret.getY() - 1);
				}
				
				if(grid.blocked(ret, 1) == 0) {
					newGrid.setCellB(ret.getX(), ret.getY() + 1);
				}
				if(grid.blocked(ret, 2) == 0) {
					newGrid.setCellB(ret.getX() + 1, ret.getY());
					
				}
				if(grid.blocked(ret, 3) == 0) {
					newGrid.setCellB(ret.getX() - 1, ret.getY());
				}
				
				
			
			if(countAstar != 0 && newGrid.getCell(newRet.getParent().getX(), newRet.getParent().getY()).getState() == 1) {
			
				newRet = newRet.getParent();
				
				
			}else{
			open.deleteHeap();
			closed.clear();
			open.add(newGoal);
			newRet.setG(0);
			newRet.setF(0);
			
			countAstar++;
			Cell ptr = aStar(newGrid, newGoal , newRet);
			
			if(ptr.equals(newRet) == 0 && open.isEmpty() == 1) {
				System.out.println("THERE IS NO PATH TO GOAL");
				System.out.println("A STAR COUNT :   " +  countAstar);
				return;
			}
			Cell prev = ptr.getParent();
			
				while(ptr.equals(newGoal) != 1) {
					
					System.out.println("(" + ptr.getX() + ", " + ptr.getY() + ")");
					//prev = ptr;
					ptr = ptr.getParent();
					//ptr.setChild(prev);
					
					
				
			}
				
				System.out.println("(" + ptr.getX() + ", " + ptr.getY() + ")");
				System.out.println();
				newRet = prev;
				
				//System.out.println("(" + prev.getX() + ", " + prev.getY() + ")");
				//System.out.println();
			
			}	
			
			ret.setParent(grid.getCell(newRet.getX(), newRet.getY()));
			ret = ret.getParent();
			
	}
			
	
			System.out.println("A STAR COUNT :   " +  countAstar);
			
			System.out.println("TOTAL EXPANDED Backwards A " +  totalExpanded);
			
		
	}
	
	
	
	
	public Cell aStar(Grid grid, Cell start, Cell goal){
		
		int count = 0;
		int ii = 0;
		
		Cell curr = new Cell();
		
		
		
		
		while(curr.equals(goal) == 0) {
				
			
				
			if(ii == 0) {
				
				curr = open.deleteMaxG(0);
				closed.add(curr);
				
			}
			ii++;
			
			
			count++;
		if(grid.blocked(curr, 0) == 1) {//NORTH
		
			Cell n = new Cell();
			n.setX(curr.getX());
			n.setY(curr.getY() - 1);
			n.setParent(curr);
			
		
			if(inClosedList(n) == 0) {
			
			
			
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
		
				
			n.setH(gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY()));
		
			
		
			n.setG(n.getParent().getG() + 1);
			n.setF(n.getG() + n.getH());
			
			open.add(n);
		
				
			}else{
				
				int h = gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY());
				int g = n.getParent().getG() + 1;
				int f = h + g;
				
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.deleteMaxG(openIndex);
					n.setH(gethuristic(curr.getX(), curr.getY() - 1, goal.getX(), goal.getY()));
					n.setG(n.getParent().getG() + 1);
					n.setF(n.getG() + n.getH());
					open.add(n);
				
				}
				
				
			}
			
		}
			
		}
	
	
		if(grid.blocked(curr, 1) == 1) {//SOUTH
			
			

			Cell n = new Cell();
			n.setX(curr.getX());
			n.setY(curr.getY() + 1);
			n.setParent(curr);
		
		if(inClosedList(n) == 0) {
			
			
			
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
			
			n.setH(gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY()));
		
			n.setG(n.getParent().getG() + 1);
			n.setF(n.getG() + n.getH());
			open.add(n);
			
			}else{
				
				int h = gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY());
				int g = n.getParent().getG() + 1;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.deleteMaxG(openIndex);
					n.setH(gethuristic(curr.getX(), curr.getY() + 1, goal.getX(), goal.getY()));
					n.setG(n.getParent().getG() + 1);
					n.setF(n.getG() + n.getH());
					open.add(n);
				
				}
				
				
			}
			
		}
			
		}
		
		if(grid.blocked(curr, 2) == 1) {//EAST
			
			Cell n = new Cell();
			n.setX(curr.getX() + 1);
			n.setY(curr.getY());
			n.setParent(curr);
		
		if(inClosedList(n) == 0) {
			
			
			
			if (grid.Visited(n.getX() , n.getY()) == 0 && inOpenList(n) == -1) {
				
			//Cell n = new Cell();
			n.setH(gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY()));
			
			n.setG(n.getParent().getG() + 1);
			n.setF(n.getG() + n.getH());
			open.add(n);
			
			
			
			}else{
				
				int h = gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY());
				int g = n.getParent().getG() + 1;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.deleteMaxG(openIndex);
					n.setH(gethuristic(curr.getX() + 1, curr.getY(), goal.getX(), goal.getY()));
					n.setG(n.getParent().getG() + 1);
					n.setF(n.getG() + n.getH());
					open.add(n);
				}
				
				
			}
			
		}
			
		}
		
		if(grid.blocked(curr, 3) == 1) {//WEST
			
			Cell n = new Cell();
			n.setX(curr.getX() - 1);
			n.setY(curr.getY());
			n.setParent(curr);
		
		if(inClosedList(n) == 0) {
			
			
			if (grid.Visited(n.getX(), n.getY()) == 0 && inOpenList(n) == -1) {
			
			n.setH(gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY()));
			
			n.setG(n.getParent().getG() + 1);
			n.setF(n.getG() + n.getH());
			open.add(n);
			
			}else{
				
				int h = gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY());
				int g = n.getParent().getG() + 1;
				int f = h + g;
				if(f < n.getF()) {
					
					
					int openIndex = inOpenList(n);
					open.deleteMaxG(openIndex);
					n.setH(gethuristic(curr.getX() - 1, curr.getY(), goal.getX(), goal.getY()));
					n.setG(n.getParent().getG() + 1);
					n.setF(n.getG() + n.getH());
					open.add(n);
				
				}
				
				
			}
			
		}
			
		}
		
		
		if(open.isEmpty() == 1) {
			 break;
		 }
		
		 curr = open.deleteMaxG(0);
		 closed.add(curr);
		 
		}
		
		totalExpanded += closed.size();
		return curr;
	}
	
	public int inClosedList(Cell a) {
		
		for(int i = 0; i < closed.size(); i++) {
			if(a.equals(closed.get(i)) == 1){
				return 1;
			}
			
		}
		
		return 0;
		
	}
	
	public int inOpenList(Cell a) {
		
		for(int i = 0; i < open.size(); i++) {
			if(a.equals(open.getCell(i)) == 1){
				return i;
			}
			
		}
		
		return -1;
	}
	public int gethuristic(int sx, int sy, int gx, int gy) {
		
		int ret = Math.abs(sx - gx) + Math.abs(sy - gy);
		
	
		return ret;
		
		
	}
	

}
