package entity;

import physics.Dimension;
import physics.Position;
import world.World;

public abstract class Entity extends Element{	
	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Entity(World world) {
		super(world);
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Entity(World world, Position pos, Dimension dim) {
		super(world, pos, dim);
	}
}
