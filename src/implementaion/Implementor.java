package implementaion;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
import world.*;

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
			World world = game.getWorld();
			world.add(entity);
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
	public boolean addButton(AbstractButton button){
		if(game != null){
			World world = game.getWorld();
			world.add(button);
			return true;
		}
		return false;
	}
	/**
	 * @param buttonName
	 * @return button with matching name
	 */
	public AbstractButton getButton(String buttonName){
		for(AbstractButton button : game.getWorld().getButtons()){
			if(button.getName().equals(buttonName)){
				return button;
			}
		}
		return null;
	}
	/**
	 * 
	 * @param index
	 * @return button at index (index)
	 */
	public AbstractButton getButton(int index){
		return game.getWorld().getButtons().get(index);
	}
	/**
	 * 
	 * @param index
	 * @return entity at index (index)
	 */
	public Entity getEntity(int index){
		return game.getWorld().getEntities().get(index);
	}
	/**
	 * Initializer
	 * -call this in subclass's main
	 */
	public void init() {
		game = new Game(this);
	}
	/**
	 * Starts the game
	 */
	public void run(){
		game.main();
	}

}
