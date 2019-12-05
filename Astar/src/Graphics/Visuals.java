package Graphics;

import java.awt.*;
import javax.swing.*;
import structures.Grid;


public class Visuals  extends JPanel  {
		
	Grid grid;
	int sx, sy, gx, gy;
	
	public Visuals(Grid g, int sx, int sy, int gx, int gy){
		grid = g;
		this.sx = sx;
		this.sy = sy;
		this.gx = gx;
		this.gy = gy;
       
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int s = 10;
		int xshift = 100;
		g.setColor(Color.BLACK);
		g.fillRect(0 + xshift, 0, 103 * s, 103* s);
		
		
		
		/*g.fillRect(0, 0, 1 *s, 102 *s);
		g.fillRect(0, 0, 102 * s, 1 *s);
		g.fillRect(0, 102* s, 102 *s, s);
		g.fillRect(102 * s, 0,  s, 102 *s);*/
		
		//g.setColor(Color.RED);
		//g.drawLine(0, s * 2,  102 * s, s * 2);
	
		
		g.setColor(Color.WHITE);
		
		/*Grid grid = new Grid();
		grid.initializeGrid();*/
	 
		//grid.visitRandomCell();
		int counter = 0;
		int other = 0;
		
		for(int i = 1; i < 102; i++) {
						
			
			for(int j = 1; j < 102; j++) {
				if(grid.state(i, j) == 1) {
					counter++;
					g.fillRect(((i) * s) + xshift, (j) * s, 1 * s, 1 *s);
				}else {
					other++;
				}
				
			}
		
			
		}
		
		g.setColor(Color.GREEN);
		g.fillRect((gx * s) + xshift, gy * s , 1 * s, 1 * s);
		
		g.setColor(Color.RED);
		
		g.fillRect((sx * s) + xshift, sy * s , 1 * s, 1 * s);
		
		double d = (double)counter/(101 * 101);
		
		//System.out.println(d);
		
	//	System.out.println(counter);
		
		
		
		
		
		
	}

}
