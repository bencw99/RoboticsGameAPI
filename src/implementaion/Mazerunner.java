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
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void main() {
		cells = new Cell[ROWS][COLS];
		initCells();
	}
	/**
	 * Initializes the cells
	 */
	public void initCells(){
		for(int row = 0; row < ROWS; row++){
			for(int col = 0; col < COLS; col++){
				Position p = new Position(col * CELL_WIDTH, row*CELL_HEIGHT);
				Dimension d = new Dimension(CELL_WIDTH, CELL_HEIGHT);
				cells[row][col] = new Cell(game, p, d);
			}
		}
	}

}
