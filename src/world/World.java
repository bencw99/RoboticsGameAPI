package world;

import java.awt.Graphics;
import java.util.*;

import entity.*;

public class World implements Drawable {
	/** List of entities in this world */
	private ArrayList<Entity> entities;

	/** 
	 * Default constructor, initializes elements
	 */
	public World() {
		entities = new ArrayList<Entity>();
	}
	
	public void update() {
		
	}
	
	/**
	 * Add an entity to this world
	 * @param e	the entity to add
	 */
	public void addEntity(Element ent) {
		entities.add(ent);
	}

	/**
	 * @return the entity list
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}
}
