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
	
	private Game game;
	
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
	 * Initializer
	 * -call this in subclass's main
	 */
	public void main() {
		game = new Game(this);
	}
	public void begin(){
		game.main();
	}
	
	public abstract void buttonPressed(AbstractButton button);

}
