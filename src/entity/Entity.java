package entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

import physics.*;
import world.World;

public abstract class Entity {
	/** The position of this Entity instance */
	private Position pos;
	
	/** The angle of this Entity instance **/
	private double angle;
	
	/** The dimensions of this entity */
	private Dimension dim;
	
	/** Reference to the world this entity is in */
	private World world;

	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 * 
	 * @param world the world of this entity
	 */
	public Entity(World world) {
		this.world = world;
		this.setPos(new Position());
		this.setDim(new Dimension());
		this.setAngle(0);
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 * 
	 * @param world the world of this entity
	 * @param angle the angle of this entity
	 * @param pos the position of this entity
	 * @param dim the dimension of this entity
	 */
	public Entity(World world, Position pos, double angle, Dimension dim) {
		this.world = world;
		this.pos = pos;
		this.angle = angle;
		this.dim = dim;
	}
	
	/**
	 * Initializes this entity
	 */
	public abstract void init();
	
	/**
	 * Updates this entity
	 */
	public abstract void update();
	
	/**
	 * Disables this entity
	 */
	public abstract void disable();
	
	/**
	 * Draws this entity on the given graphics object
	 * 
	 * @param g the graphics object to be drawn on
	 */
	public void draw(Graphics g) {
		
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
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param pos the position to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
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
	
	
	public boolean collide(Polygon a, Polygon b) {
		Rectangle aRectangle = a.getBounds();
		Rectangle bRectangle = b.getBounds();
		return(aRectangle.intersects(bRectangle));
	}

}
