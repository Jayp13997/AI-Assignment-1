package Graphics;

import java.awt.*;
import javax.swing.*;
import structures.Grid;


public class Visuals  extends JPanel  {
		
	public Visuals() {
		
		// this.setFocusable(true);
	}
	
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Grids");
        Visuals grids = new Visuals();
        frame.add(grids);
        frame.setSize(1020, 1020);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int s = 100;
		int xshift = 100;
		g.setColor(Color.BLACK);
		g.fillRect(0 + xshift, 0, 7 * s, 7* s);
		
		
		
		/*g.fillRect(0, 0, 1 *s, 102 *s);
		g.fillRect(0, 0, 102 * s, 1 *s);
		g.fillRect(0, 102* s, 102 *s, s);
		g.fillRect(102 * s, 0,  s, 102 *s);*/
		
		//g.setColor(Color.RED);
		//g.drawLine(0, s * 2,  102 * s, s * 2);
	
		
		g.setColor(Color.WHITE);
		
		Grid grid = new Grid();
	
		grid.visitRandomCell();
		int counter = 0;
		int other = 0;
		
		for(int i = 1; i < 6; i++) {
			
			for(int j = 1; j < 6; j++) {
				if(grid.state(i, j) == 1) {
					counter++;
					g.fillRect(((i) * s) + xshift, (j) * s, 1 * s, 1 *s);
				}else {
					other++;
				}
				
			}
		
			
		}
		
		double d = (double)counter/(5 * 5);
		
		System.out.println(d);
		
		System.out.println(counter);
		
		
		
		
		
		
	}

}
