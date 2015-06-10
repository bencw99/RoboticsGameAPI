package entity;
import physics.*;
import java.awt.Graphics;

import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;

public class Element extends Entity implements Updateable
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
	public Element(World world, Position pos, Dimension dim, Vector vel) {
		super(world, pos, dim, vel);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		
		
	}
}
