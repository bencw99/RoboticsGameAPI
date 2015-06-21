package entity;

import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;
import graphics.Sprite;
import graphics.SpriteManager;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
	/** The position of this Entity instance */
	private Position pos;
	
	/** The angle of this Entity instance **/
	private double angle;
	
	/** The dimensions of this entity */
	private Dimension dim;
	
	/** Reference to the world this entity is in */
	private World world;
	
	/** Draws and manages the graphics for this entity */
	private SpriteManager spriteManager;
	
	/** An array that will prestore the Sprite information in the form name, filepath **/
	protected String[] spritesArray;
	
	/** An <code>ArrayList<code> of the Sprites corresponding to this object **/
	private ArrayList<Sprite> spritesList;
	
	/** The current Sprite this Entity is displaying outside of animation mode **/
	protected String activeSprite;

	/**
	 * Default constructor, initializes entity world to null
	 */
	public Entity() {
		this(null);
	}
	
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
		spriteManager.update(g, activeSprite);
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
	 * Translates this position by the given x and y differentials
	 * 
	 * @param dx the x differential
	 * @param dy the y differential
	 */
	public void translate(double dx, double dy) {
		pos.translate(dx, dy);
	}
	
	/**
	 * Translates this position by the given vector differentials
	 * 
	 * @param vec the translation vector
	 */
	public void translate(Vector vec) {
		pos.translate(vec);
	}
	
	/**
	 * Translates the position by the given x differential
	 * 
	 * @param dx the x differential
	 */
	public void translateX(double dx) {
		pos.translateX(dx);
	}
	
	/**
	 * Translates the position by the given y differential
	 * 
	 * @param dy the y differential
	 */
	public void translateY(double dy) {
		pos.translateY(dy);
	}
	
	/**
	 * Returns the upper left position of this entity
	 * 
	 * @return the upper left position
	 */
	public Position getUpperLeftPos() {
		return new Position(this.pos.getX() - this.dim.getWidth()/2, this.pos.getY() - this.dim.getHeight()/2);
	}
	
	/**
	 * Returns the upper right position of this entity
	 * 
	 * @return the upper right position
	 */
	public Position getUpperRightPos() {
		return new Position(this.pos.getX() + this.dim.getWidth()/2, this.pos.getY() - this.dim.getHeight()/2);
	}
	
	/**
	 * Returns the lower left position of this entity
	 * 
	 * @return the lower left position
	 */
	public Position getLowerLeftPos() {
		return new Position(this.pos.getX() - this.dim.getWidth()/2, this.pos.getY() + this.dim.getHeight()/2);
	}
	
	/**
	 * Returns the lower right position of this entity
	 * 
	 * @return the lower right position
	 */
	public Position getLowerRightPos() {
		return new Position(this.pos.getX() + this.dim.getWidth()/2, this.pos.getY() + this.dim.getHeight()/2);
	}
	
	/**
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	/**
	 * Translates this angle by the given angle difference
	 * 
	 * @param dAngle the angle to be translated by
	 */
	public void translateAngle(double dAngle) {
		this.angle += dAngle;
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

	/**
	 * Tests if the two given polygons collide
	 * 
	 * @param a the first polygon to be tested
	 * @param b the second polygon to be tested
	 * @return the result of the collision test
	 */
	public static boolean collide(Polygon a, Polygon b) {
		return(a.getBounds().intersects(b.getBounds()));
	} 

	/**
	 * Tests if this entity collides with the given entity
	 * 
	 * @param ent the entity that we are testing to see if it collides with this one
	 * @return the result of the collision test
	 */
	public boolean collide(Entity ent) {
        Rectangle a = new Rectangle((int) this.getUpperLeftPos().getX(), (int) this.getUpperLeftPos().getY(), (int) this.dim.getWidth(), (int) this.dim.getHeight());
        Rectangle b = new Rectangle((int) ent.getUpperLeftPos().getX(), (int) ent.getUpperLeftPos().getY(), (int) ent.getDim().getWidth(), (int) ent.getDim().getHeight());
        return(a.intersects(b));
	}

    /**
     * Tests the direction of an existing collision
     *
     * @param ent the entity that this entity is colliding with
     * @return the direction the other entity is colliding from
     */
	public Vector directionalCollide(Entity ent) {
		if(collide(ent)) {
			//The distance between the left side of this entity and the right side of the colliding one
			double leftDistance = Math.abs((pos.getX() - dim.getWidth()/2) - (ent.pos.getX() + ent.dim.getWidth()/2));
			//The distance between the right side of this entity and the left side of the colliding one
			double rightDistance = Math.abs((pos.getX() + dim.getWidth()/2) - (ent.pos.getX() - ent.dim.getWidth()/2));
			//The distance between the upper side of this entity and the lower side of the colliding one
			double upperDistance = Math.abs((pos.getY() - dim.getHeight()/2) - (ent.pos.getY() + ent.dim.getHeight()/2));
			//The distance between the lower side of this entity and the upper side of the colliding one
			double lowerDistance = Math.abs((pos.getY() + dim.getHeight()/2) - (ent.pos.getY() - ent.dim.getHeight()/2));
			
			//Compares to find the lowest of the four distances
			double minimumDistance = Math.min(Math.min(leftDistance, rightDistance), Math.min(upperDistance, lowerDistance));
			
			//Returns the vector matching the lowest distance
			if(minimumDistance == leftDistance) {
				return new Vector(0, 1);
			}
			if(minimumDistance == rightDistance) {
				return new Vector(0, -1);
			}
			if(minimumDistance == upperDistance) {
				return new Vector(1, 0);
			}
			if(minimumDistance == lowerDistance) {
				return new Vector(-1, 0);
			}
			
			System.out.println("Collision detection failed: directionalCollide minimum not found");
		}	
		return null;
	}

	// GRAPHICS:
	
	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public void setSpriteManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
	}
	
	public void setAnimationMode(boolean animationMode) {
		spriteManager.setAnimationMode(animationMode);
	}
	
	public void setFrameLength(int length) {
		spriteManager.setTicksPerFrame(length);
	}
	
	/**
	 * Takes the easy to use array that the user makes when extending
	 * this class and loads it into an <code>ArrayList<code> of {@link  sprite.Sprite}s
	 */
	public void loadSprites() {
		spritesList = new ArrayList<Sprite>();
		for(int i = 0; i < spritesArray.length; i += 2) {
			spritesList.add(new Sprite(this, spritesArray[i], spritesArray[i + 1]));
		}
		spriteManager = new SpriteManager(this, spritesList);
	}
}
