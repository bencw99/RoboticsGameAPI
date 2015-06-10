package entity;

import java.awt.Graphics;
import java.awt.Polygon;

import physics.Dimension;
import physics.Position;
import world.World;

public class Immobile extends Entity implements Interactable {

	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Immobile(World world) {
		super(world);
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Immobile(World world, Position pos, Dimension dim) {
		super(world, pos, dim);
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Polygon getInteractionRegion()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
