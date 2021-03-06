package api.implementation;

import java.util.ArrayList;

import api.entity.*;
import api.game.*;
import api.gui.Screen;
import api.spriteless.SpritelessElement;

public abstract class Implementor {
	
	//Private instance variables used to control the Game
	
	protected Game game;
	
	/**
	 * The main function of this implementor
	 */
	public abstract void execute();
	
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
	 * Adds a element without a sprite to world
	 * 
	 * @param spriteLess
	 * -the spriteless element to add
	 * @return
	 * -success?
	 */
	public boolean addSpritelessElement(SpritelessElement spriteLess){
		if(game != null){
			game.add(spriteLess);
			return true;
		}
		return false;
	}
	
	public boolean addEntity(Entity entity, Screen screen){
		if(game != null){
			game.add(entity, screen);
			return true;
		}
		return false;
	}

	
	public boolean addSpritelessElement(SpritelessElement spriteLess, Screen screen){
		if(game != null){
			game.add(spriteLess, screen);
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

