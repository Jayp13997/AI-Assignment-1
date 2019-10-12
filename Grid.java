package structures;

import java.util.*;

public class Grid {
	
	Cell cells[][]; 
	int x, y;
	Stack<Cell> s = new Stack<Cell>();
	
	
	public Grid() {// creates grid and sets all cells as unvisited(state = 0)
		 cells = new Cell[103][103];
		 
		 for(int i = 0; i < 103; i++) {
			 for(int j = 0; j < 103; j++) {
				 cells[i][j] = new Cell();
			 
			 }
		 }
		
		for(int i = 0; i < 103;i++) {
			for(int j = 0; j < 103; j++){
				cells[i][j].setX(i);
				cells[i][j].setY(j);
				if(i == 0 || j == 0 || i == 102 || j == 102) {
					cells[i][j].setState(-1);
					cells[i][j].setVisited(1);
					
					
				}else{
				cells[i][j].setState(1);
				cells[i][j].setVisited(0);
				
				}
			}
		}
	}
	
	
	public int blocked(Cell c, int dir) {
		
		if(dir == 0){
				
			return this.state(c.getX(), c.getY() - 1);
		}else if (dir == 1){
			
			return this.state(c.getX(), c.getY() + 1);
		}else if(dir == 2) {
			
		
			return this.state(c.getX() + 1, c.getY());
		}else{
			
			return this.state(c.getX() - 1, c.getY());
		}
		
}
			
			
	
	public int state(int x, int y) {
		
		if(cells[x][y].getState() == 1) {
			return 1;
		}
		
		return 0;
	}
	
	public Cell getCell(int x, int y) {
		
		return cells[x][y];
		
	}
	
	public int outofBounds() {
		
		if(x == 0 || y == 0 || x == 102 || y == 102) {
			return 1;
		}
		
		return 0;
	}
	
	//NEGATIVE 1 FOR CELLS THAT DONT EXIST
	public int alreadyVisited(int dir) {
		
		if(dir == 0){
			
			if(cells[x][y-1].getVisited() == 1) {
				return 1;
			}
			
		
		}else if(dir == 1) {
			if(cells[x][y+1].getVisited() == 1) {
				return 1;
			}
			
			
		}else if(dir == 2) {
			if(cells[x+1][y].getVisited() == 1) {
				return 1;
			}
			
		}else if(dir == 3){
			if(cells[x-1][y].getVisited() == 1) {
				return 1;
			}
			
		}
			
		
		return 0;
	}
	
	public int randomChance() {
		Random r = new Random();
		int rand = r.nextInt(10) + 1;
		if(rand <= 7) {
			return 0;
		}
		
		return 1;
		
	}
	
	public int deadEnd(Cell c){
		int x = c.getX();
		int y = c.getY();
				
		if(cells[x][y - 1].getVisited() == 1 && cells[x -1][y].getVisited() == 1 &&
				cells[x][y + 1].getVisited() == 1 && cells[x + 1][y].getVisited() == 1){
			
			return 1;
			
		}
			
		return 0;
		
	}
	
	public Cell firstParent() {
		
		while(s.size() != 0) {
			
			if(deadEnd(s.peek()) != 1) {
				return s.peek();
			}else{
				s.pop();
			}
			
		}
		
		return null;
		
	}
	
	public void visitRandomCell() {
		Random r = new Random();
		
		
		int i = 0;
		
		
		int dir; 
		
		x = r.nextInt(101) + 1;
		y = r.nextInt(101) + 1;
		
		while(i < (101 * 101)){
			
			while(cells[x][y].getVisited() == 1){
				
				x = r.nextInt(101) + 1;
				y = r.nextInt(101) + 1;
				
				}
				
			cells[x][y].setState(1);
			cells[x][y].setVisited(1);
			s.push(cells[x][y]);
			i += 1;
			
		
		while(!s.isEmpty()) {
			
			dir = r.nextInt(4);
			
			if((x == 1 && dir == 3)|| 
				(x == 101 && dir == 2)||
				(y == 1 && dir == 0)||
				(y == 101 && dir == 1)){ //dead end
				
			
			 continue;
				
		
			}else if(deadEnd(cells[x][y]) == 1){
				
				
				
					
					x = s.peek().getX();
					y = s.peek().getY();
					
					
					
				while(!s.empty() && deadEnd(cells[x][y]) == 1) {
					
					
					s.pop();
					
					if(!s.isEmpty()) {
					
					x = s.peek().getX();
					y = s.peek().getY();
					}
				
				}
				
				
				
				 continue;
			
			}else if(alreadyVisited(dir) == 1) {
				
				 continue;
			
			}else{		
				i++;
				if(randomChance() == 1) {
				
					
					if(dir == 0) {//North
						y = y - 1;
					
						cells[x][y].setVisited(1);
						cells[x][y].setState(0);
						
						//add to stack
			
				}else if(dir == 1) {//South 
						y = y + 1;
						cells[x][y].setVisited(1);
						cells[x][y].setState(0);
						
						// add to stack
			
				}else if(dir == 2) {//East
						x = x + 1;
						cells[x][y].setVisited(1);
						cells[x][y].setState(0);
						
					
					//add to stack
				}else if(dir == 3) {//West
						x = x - 1;
						cells[x][y].setVisited(1);
						cells[x][y].setState(0);
					
						//add to stack
				}
			}else {
				
				
				if(dir == 0) {//North
					y = y - 1;
					
					
					//add to stack
		
			}else if(dir == 1) {//South 
					y = y + 1;
					
					
					// add to stack
		
			}else if(dir == 2) {//East
					x = x + 1;
					
					
				
				//add to stack
			}else if(dir == 3) {//West
					x = x - 1;
					
				
					//add to stack
			}
				
				cells[x][y].setState(1);
				cells[x][y].setVisited(1);
				s.push(cells[x][y]);
				
			}
			
			
		
		}
		}
		}
		
	
	}


}
