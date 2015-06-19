package world;

import java.awt.Graphics;
import java.util.*;

import entity.*;
import game.*;

/**
 * A class representing the world of a game
 * Contains all entities
 */
public class World {
	/** List of entities in this world */
	private ArrayList<Entity> entities;
	private ArrayList<AbstractButton> buttons;
	/** 
	 * Default constructor, initializes elements
	 */
	public World() {
		entities = new ArrayList<Entity>();
		buttons = new ArrayList<AbstractButton>();
	}
	
	/**
	 * Initializes this world instance
	 */
	public void init() {
		for(Entity entity : entities) {
			entity.init();
		}
		for(AbstractButton button : buttons){
			button.init();
		}
	}
	
	/**
	 * Updates this world instance
	 */
	public void update() {
		for(Entity entity : entities) {
			entity.update();
		}
	}
	
	/**
	 * Disables this world instance
	 */
	public void disable() {
		for(Entity entity : entities) {
			entity.update();
		}
	}
	
	/**
	 * Draws this Entity on to the given graphics object
	 * 
	 * @param g the graphics object to be drawn on
	 */
	public void draw(Graphics g) {
		System.out.println("draw called in world");

		for(Entity entity : entities) {
			entity.draw(g);
		}
	}
	
	/**
	 * Add an entity to this world
	 * 
	 * @param ent	the entity to add
	 */
	public void add(Entity ent) {
		ent.init();
		ent.setWorld(this);
		entities.add(ent);
		ent.setWorld(this);
	}
	public void add(AbstractButton button){
		button.init();
		buttons.add(button);
	}
	/**
	 * Remove an entity from this world
	 * 
	 * @param ent	the entity to remove
	 */
	public void remove(Entity ent) {
		ent.disable();
		ent.setWorld(null);
		entities.remove(ent);
	}
	public void remove(AbstractButton button) {
		buttons.remove(button);
	}
	/**
	 * @return the entity list
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public ArrayList<AbstractButton> getButtons(){
		return buttons;
	}
}
