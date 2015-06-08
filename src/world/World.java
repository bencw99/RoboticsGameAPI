package world;

import java.util.*;

import entity.*;

public class World {
	/** List of entities in this world */
	private ArrayList<Entity> entities;

	/**
	 * Add an entity to this world
	 * @param e	the entity to add
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}

	/**
	 * @return the entity list
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
