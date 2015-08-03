package api.implementation;
import java.awt.Dimension;

import api.constants.*;
import api.entity.*;
import api.physics.*;

public class Mazerunner extends CelledImplementor {
	public final static double WALL_CHANCE = 0.9;
	
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void execute() {
		init();
		Runner Runner = new Runner(new Position(Constants.DEFAULT_CELL_WIDTH / 2, Constants.DEFAULT_CELL_HEIGHT / 2), 0, 
				new Dimension(Constants.DEFAULT_CELL_WIDTH / 2, Constants.DEFAULT_CELL_HEIGHT / 2), game);
		addEntity(Runner);
		for(Cell[] CELLS : cells){
			for(Cell c : CELLS){
				double addRand = Math.random();
				int random = (int)(Math.random() * 4);
				if(addRand < WALL_CHANCE) {
					switch(random){
					case 0:
						c.setNorthernWallVisibility(true);
						break;
					case 1:
						c.setSouthernWallVisibility(true);
						break;
					case 2:
						c.setWesternWallVisibility(true);
						break;
					case 3:
						c.setEasternWallVisibility(true);
						break;
					}
				}
			}
		}
		run();
	}
}
