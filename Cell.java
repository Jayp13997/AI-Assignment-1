package structures;

public class Cell {
	
	int state; //-1 = undefined; 0 = blocked; 1 = unblocked;
	int visit; //0 = unvisited; 1 = visited;
	int x, y;
	
	
	public Cell() {
		this.state = -1;// undefined
		this.visit = 0;
		this.x = -1;
		this.y = -1;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		
		return state;
	}
	
	public void setVisited(int visit) {
		this.visit = visit;
	}
	
	public int getVisited() {
		return visit;
	}
	
	public void setX(int x) {
		this.x = x;
		
	}
	
	public void setY(int y) {
		this.y = y;
		
	}
	
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	
}
