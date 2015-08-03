package implementation;
import java.awt.Dimension;

import physics.Position;
import constants.Constants;
import entity.Cell;
import game.Game;

public abstract class CelledImplementor extends Implementor {
	/**
	 * A matrix of cells
	 */
	protected Cell[][] cells;
	/**
	 * Number of rows
	 */
	protected int rows;
	/**
	 * Number of columns
	 */
	protected int cols;
	
	
	public void init() {
		super.init();
		game = new Game();
		rows = game.getHeight()/Constants.DEFAULT_CELL_HEIGHT;
		cols = game.getWidth()/Constants.DEFAULT_CELL_WIDTH;
		cells = new Cell[rows][cols];
		initCells();
	}
	
	public void initCells(){
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				Position p = new Position(col * Constants.DEFAULT_CELL_WIDTH + Constants.DEFAULT_CELL_WIDTH / 2, row * Constants.DEFAULT_CELL_HEIGHT + Constants.DEFAULT_CELL_HEIGHT / 2);
				Dimension d = new Dimension(Constants.DEFAULT_CELL_WIDTH, Constants.DEFAULT_CELL_HEIGHT);
				cells[row][col] = new Cell(game, p, d);
			}
		}
	}
	
	/**
	 * Returns the number of rows
	 * @return
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Returns the number of columns
	 * @return
	 */
	public int getCols(){
		return cols;
	}
	
	/**
	 * Returns cells (Cell[][])
	 * @return
	 */
	public Cell[][] getCells(){
		return cells;
	}
	
	public Game getGame(){
		return game;
	}
}
