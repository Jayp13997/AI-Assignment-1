package main;

import java.util.Random;

import javax.swing.JFrame;

import Graphics.Visuals;
import structures.Grid;

public class mainMinMax {
	
	public static void main(String[] args) {
		Random rand = new Random();
		Grid g = new Grid();
	
		g.visitRandomCell();
		
		int sx, sy, gx, gy;
		
		JFrame frame; 
		Visuals grids;
		
		
        int maxExpanded = 0;
        int minExpanded = 0;
        
       for(int i = 0; i < 50; i++) {
        	
         System.out.println("NEW GRID");
		
		g = new Grid();
		g.visitRandomCell();
		
		sx = rand.nextInt(101) + 1;
		sy = rand.nextInt(101) + 1;
		
		while(g.getCell(sx, sy).getState() != 1) {
			 sx = rand.nextInt(101) + 1;
			 sy = rand.nextInt(101) + 1;
		}
		
		 gx = rand.nextInt(101) + 1;
		 gy = rand.nextInt(101) + 1;
		
		while(g.getCell(gx, gy).getState() != 1 && gx != sx && gy != sy) {
			 gx = rand.nextInt(101) + 1;
			 gy = rand.nextInt(101) + 1;
		}
		
		frame = new JFrame("Grids");
		grids = new Visuals(g, sx, sy, gx, gy);
        frame.add(grids);
        frame.setSize(1200, 1200);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        astarMaxG max = new astarMaxG(g, sx , sy, gx, gy);
		max.runRepeatedMax();
		
		astarMinG min = new astarMinG(g, sx , sy, gx, gy);
		min.runRepeatedMin();
		
		maxExpanded = max.totalMax();
		minExpanded = min.totalMin();
       
        }
		
       
       System.out.println();
       System.out.println("MAX G ASTAR: " + maxExpanded);
       System.out.println("MIN G ASTAR: " + minExpanded);
		
	}

}
