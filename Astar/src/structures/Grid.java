package structures;

import java.util.Random;

public class Grid {
	
	Cell cells[][]; 
	int x, y;
	
	
	public Grid() {// creates grid and sets all cells as unvisited(state = 0)
		cells = new Cell[101][101];
		
		for(int i = 0; i < 101;i++) {
			for(int j = 0; j < 101; j++) {
				cells[i][j].state = 0;
			}
		}
	}
	
	public void generateGrid() {
		
		//Random r = new Random();
		//int x = r.nextInt(101);
		//int y = r.nextInt(102);
		
		
		
		
	}	
	
	public void visitRandomCell() {
		Random r = new Random();
		int dir = r.nextInt(4);
		
		while(true) {
			
			if((x == 0 && dir == 0)|| 
				(x == 100 && dir == 1)||
				(y == 0 && dir == 3)||
				(y == 100 && dir == 2)){ 
				
			

				
			}
				if(dir == 0) {//North
			
			
				}else if(dir == 1) {//South 
			
				}else if(dir == 2) {//East
			
				}else if( dir == 3) {//West
				
				}
			
		
		}
		
	
	}
	
	

}