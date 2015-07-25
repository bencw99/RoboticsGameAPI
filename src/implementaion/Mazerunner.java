package implementaion;
import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;

public class Mazerunner extends Implementor {
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void main() {
		for(Cell[] CELLS : cells){
			for(Cell c : CELLS){
				c.setNorthernWallVisibility(true);
				c.setSouthernWallVisibility(true);
				c.setEasternWallVisibility(true);
				c.setWesternWallVisibility(true);
			}
		}
	}
}
