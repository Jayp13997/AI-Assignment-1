package structures;

public class Cell {
	
	int state; //-1 = undefined; 0 = blocked; 1 = unblocked;
	int visit; //0 = unvisited; 1 = visited;
	int x, y;
	int h, g;
	int f;
	int search;
	int dir;
	public Cell parent;
	public Cell child;
	
	public Cell() {
		this.state = 1;// undefined
		this.visit = 0;
		this.x = -1;
		this.y = -1;
		this.h = 0;
		this.g = 0;
		this.f = g+h;
		this.search = 0;
		this.dir = 0;
		this.parent = null;
		this.child = null;
		
		
	}
	
	
	public void setParent(Cell c){
		
		this.parent = c;
		
	}
	
	public Cell getParent() {
		
		
		return parent;
		
	}
	
public void setChild(Cell c){
		
		this.child = c;
		
	}
	
	public Cell getChild(){
		
		
		return child;
		
	}
		
		
		
	public void setS(int s) {
		
		this.search = s;
		
	}
	
	public int getS() {
		
		return search;
	}
	
	
	public void setG(int g) {
		
		this.g = g;
		
	}
	
	public int getG() {
		
		return this.g;
	}
	
	public void setH(int h) {
		
		this.h = h;
		
	}
	
	public int getH() {
		
		return this.h;
	}
	
	public void setF(int f) {
		
		this.f = f;
		
	}
	
	public int getF() {
		
		return this.f;
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
	
	public int equals(Cell b) {
		
		if(this.getX() == b.getX() && this.getY() == b.getY()) {
			return 1;
		}
		
		
		return 0;
	}
	
	
		
		
	}
	
	

