package entity;

import java.awt.Graphics;

import physics.Dimension;
import physics.Position;
import world.World;

public abstract class Entity implements Drawable {	
	/** The position of this Entity instance */
	private Position pos;
	
	/** The dimensions of this entity */
	private Dimension dim;
	
	/** Reference to the world this entity is in */
	private World world;
	
	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Entity(World world) {
		this.world = world;
		this.setPos(new Position());
		this.setDim(new Dimension());
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Entity(World world, Position pos, Dimension dim) {
		this.world = world;
		this.pos = pos;
		this.dim = dim;
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
	
	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	@Override
	public void draw(Graphics g)
	{
		
	}
}
