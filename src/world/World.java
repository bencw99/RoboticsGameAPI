package world;

import java.awt.Graphics;
import java.util.*;

import entity.*;

public class World {
	/** List of entities in this world */
	private ArrayList<Entity> entities;

	/** 
	 * Default constructor, initializes elements
	 */
	public World() {
		entities = new ArrayList<Entity>();
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
	 * Add an entity to this world
	 * @param e	the entity to add
	 */
	public void addEntity(Entity ent) {
		entities.add(ent);
	}

	/**
	 * @return the entity list
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * Draws this Entity on to the given graphics object
	 * 
	 * @param g the graphics object to be drawn on
	 */
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}
}
