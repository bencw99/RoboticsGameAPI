package implementation;
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
