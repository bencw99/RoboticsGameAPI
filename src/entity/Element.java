package entity;

import java.awt.Graphics;

import physics.Dimension;
import physics.Position;
import world.World;

public class Element extends Entity
{
	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Element(World world) {
		super(world);
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Element(World world, Position pos, Dimension dim) {
		super(world, pos, dim);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}
}
