package implementaion;
import java.util.ArrayList;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;

public class Mazerunner extends Implementor {
	private ArrayList<Wall> walls;
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void main() {
		walls = new ArrayList<Wall>();
		Wall testWall = new Wall(new Position(50, 50), Direction.SOUTH, 50);
		walls.add(testWall);
		
		for(Wall wall : walls){
			addEntity(wall);
		}
	}


}
