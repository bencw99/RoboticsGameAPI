package implementation;
import java.awt.Dimension;

import constants.*;
import entity.*;
import physics.*;

public class Mazerunner extends CelledImplementor {
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void execute() {
		Runner Runner = new Runner(new Position(Constants.DEFAULT_CELL_WIDTH / 2, Constants.DEFAULT_CELL_HEIGHT / 2), 0, 
				new Dimension(Constants.DEFAULT_CELL_WIDTH, Constants.DEFAULT_CELL_HEIGHT), game);
		game.add(Runner);
		for(Cell[] CELLS : cells){
			for(Cell c : CELLS){
				int random = (int)(Math.random() * 4);
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
}