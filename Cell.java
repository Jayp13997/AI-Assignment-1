package structures;

public class Cell {
	
	int state; //-1 = undefined; 0 = blocked; 1 = unblocked;
	int visit; //0 = unvisited; 1 = visited;
	
	
	public Cell() {
		state = -1;// undefined
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
	
	
}
