package implementaion;

import java.util.ArrayList;

import addons.NonEntityElements;
import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;

public abstract class Implementor {
	
	//Private instance variables used to control the Game
	
	/**
	 * A matrix of cells
	 */
	protected Cell[][] cells;
	/**
	 * Cells width (pixels)
	 */
	protected final int CELL_WIDTH = 30;
	/**
	 * Cell height (pixels)
	 */
	protected final int CELL_HEIGHT = 30;
	/**
	 * Number of rows
	 */
	protected int ROWS;
	/**
	 * Number of columns
	 */
	protected int COLS;
	
	/**
	 * The game
	 */
	protected Game game;
	
	/**
	 * The main function of this implementor
	 */
	public abstract void main();
	
	/**
	 * Adds an entity to world
	 * 
	 * @param entity
	 * -the entity to add
	 * @return
	 * -success?
	 */
	public boolean addEntity(Entity entity){
		if(game != null){
			game.add(entity);
			return true;
		}
		return false;
	}
	/**
	 * Adds a button to world
	 * 
	 * @param button
	 * -the button to add
	 * @return
	 * -success?
	 */
	public boolean addNonEntity(NonEntityElements nonEntity){
		if(game != null){
			game.add(nonEntity);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param index
	 * @return entity at index (index)
	 */
	public ArrayList<Entity> getEntities(){
		return game.getEntities();
	}
	public ArrayList<NonEntityElements> getNonEntities(){
		return game.getNonEntities();
	}
	/**
	 * Initializer
	 * -call this in subclass's main
	 */
	public void init() {
		game = new Game();
		ROWS = game.getHeight()/CELL_HEIGHT;
		COLS = game.getWidth()/CELL_WIDTH;
	}
	/**
	 * Starts the game
	 */
	public void run(){
		game.run();
	}
	
	//Setters and getters
	
	/**
	 * Returns the number of rows
	 * @return
	 */
	public int ROWS(){
		return ROWS;
	}
	/**
	 * Returns the number of columns
	 * @return
	 */
	public int COLS(){
		return COLS;
	}
	/**
	 * Returns cells (Cell[][])
	 * @return
	 */
	public Cell[][] cells(){
		return cells;
	}
	/**
	 * Returns CELL_WIDTH
	 * @return
	 */
	public int CELL_WIDTH(){
		return CELL_WIDTH;
	}
	/**
	 * Returns CELL_HEIGHT
	 * @return
	 */
	public int CELL_HEIGHT(){
		return CELL_HEIGHT;
	}
	public Game game(){
		return game;
	}
}

