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
	}
	/**
	 * Starts the game
	 */
	public void run(){
		game.run();
	}

}
