package entity;

import physics.*;
import world.World;

public class Entity {
	/** The position of this entity */
	private Position pos;
	/** The dimensions of this entity */
	private Dimension dim;
	
	/** Reference to the world this entity is in */
	private World world;

	public void init() {
		//TODO
	}

	public void disable() {
		//TODO
	}
	
	public Entity(World world) {
		this.world = world;
		this.setPos(new Position());
	}

	/**
	 * @return the position
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * @param pos the position to set
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * @return the dim
	 */
	public Dimension getDim() {
		return dim;
	}

	/**
	 * @param dim the dimension to set
	 */
	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}
}
