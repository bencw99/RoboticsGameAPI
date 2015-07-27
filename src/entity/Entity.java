package entity;

import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;
import graphics.Sprite;
import graphics.SpriteManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	/** An array that will prestore the {@link  sprite.Sprite} information in the form name, filepath **/
	protected Object[] spritesArray;
	
	/** An <code>ArrayList<code> of the {@link  sprite.Sprite}s corresponding to this object **/
	private ArrayList<Sprite> spritesList;
	

	/** The current {@link  sprite.Sprite} this Entity is displaying outside of animation mode **/
	protected String activeSprite;

	/** An array that will hold information for constructing preset {@link  sprite.Sprite}s available to all Entities */
	public static final Object[] PRESET_SPRITE_ARRAY = {"RED", "images/preset/red.png", 
		"WHITE", "images/preset/white.png", "BLACK", "images/preset/black.png", 
		"TRANSPARENT", "images/preset/transparent.png"};
	
	
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
	 * @return the x position
	 */
	public double getX() {
		return pos.getX();
	}
	
	/**
	 * @return the y position
	 */
	public double getY() {
		return pos.getY();
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
	 * Returns the bounding polygon of this entity based off of its angle and dimension
	 * 
	 * @return the bounding polygon of this entity
	 */
	public Polygon getBounds() {
		int xPoints[] = {(int) getUpperLeftPos().getX(), (int) getLowerLeftPos().getX(), (int) getLowerRightPos().getX(), (int) getUpperRightPos().getX()};
		int yPoints[] = {(int) getUpperLeftPos().getY(), (int) getLowerLeftPos().getY(), (int) getLowerRightPos().getY(), (int) getUpperRightPos().getY()};
		
		Polygon unrotatedBounds = new Polygon(xPoints, yPoints, xPoints.length);
	
		return rotate(unrotatedBounds, pos, angle);
	}
	
	private static Polygon rotate(Polygon poly, Position pivot, double angle) {
		int xPoints[] = new int[poly.npoints];
		int yPoints[] = new int[poly.npoints];
		
		for(int i = 0; i < poly.npoints; i ++)
		{
			double xCoord = poly.xpoints[i] - pivot.getX();
			double yCoord = poly.ypoints[i] - pivot.getY();
			double cos = Math.cos(angle);
			double sin = Math.sin(angle);
			
			xPoints[i] = (int) (xCoord*cos - yCoord*sin + pivot.getX());
			yPoints[i] = (int) (xCoord*sin + yCoord*cos + pivot.getY());
		}
		
		return new Polygon(xPoints, yPoints, poly.npoints);
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

	public Vector collides(Entity other) {
		ArrayList<Position> intersectionPoints = new ArrayList<Position>();
		
		Polygon thisBound = this.getBounds();
		Polygon otherBound = other.getBounds();
		
		for(int i = 0; i < thisBound.npoints; i ++) {
			for(int j = 0; j < otherBound.npoints; j++) {
				Vector p = new Vector(thisBound.xpoints[i], thisBound.ypoints[i]);
				Vector r = new Vector(thisBound.xpoints[i + 1 == thisBound.npoints ? 0 : i + 1] - p.getX(), thisBound.ypoints[i + 1 == thisBound.npoints ? 0 : i + 1] - p.getY());
				
				Vector q = new Vector(otherBound.xpoints[j], otherBound.ypoints[j]);
				Vector s = new Vector(otherBound.xpoints[j + 1 == thisBound.npoints ? 0 : j + 1] - q.getX(), otherBound.ypoints[j + 1 == thisBound.npoints ? 0 : j + 1] - q.getY());
				
				if(!(Math.abs(Vector.cross(r, s)) == 0.0)) {
					
					double t = Vector.cross((Vector.add(q, p.scale(-1))), s)/Vector.cross(r, s);
					double u = Vector.cross((Vector.add(q, p.scale(-1))), r)/Vector.cross(r, s);
					
					if(0 <= t && t <= 1 && 0 <= u && u <= 1) {
						Vector intersection = Vector.add(p, r.scale(t));
						intersectionPoints.add(new Position((int) intersection.getX(), (int) intersection.getY()));
					}
				}
			}
		}
		
		if(!intersectionPoints.isEmpty()) {
			int distanceSum[] = new int[thisBound.npoints];
			
			for(int i = 0; i < thisBound.npoints; i ++) {
				for(Position intersection : intersectionPoints) {
					Vector perpendicular = new Vector(thisBound.ypoints[i + 1 == thisBound.npoints ? 0 : i + 1] - thisBound.ypoints[i], thisBound.xpoints[i] - thisBound.xpoints[i + 1 == thisBound.npoints ? 0 : i + 1]);
					Vector connecting = new Vector(intersection.getX() - thisBound.xpoints[i], intersection.getY() - thisBound.ypoints[i]);
					double distance = Math.abs(Vector.dot(perpendicular, connecting)/perpendicular.magnitude());
					distanceSum[i] += distance;
				}
			}
			
			double minDist = distanceSum[0];
			int minDistIndex = 0;
			
			for(int i = 0; i < distanceSum.length; i ++) {
				if(distanceSum[i] < minDist) {
					minDist = distanceSum[i];
					minDistIndex = i;
				}
			}
			
			Vector collisionVector = new Vector( - thisBound.ypoints[minDistIndex] + thisBound.ypoints[minDistIndex + 1 == thisBound.npoints ? 0 : minDistIndex + 1],  - thisBound.xpoints[minDistIndex + 1 == thisBound.npoints ? 0 : minDistIndex + 1] + thisBound.xpoints[minDistIndex]);
			
			System.out.print("(" + collisionVector.scale(1/collisionVector.magnitude()).getX());
			System.out.println(", " + collisionVector.scale(1/collisionVector.magnitude()).getY() + ")");
			
			return collisionVector.scale(1/collisionVector.magnitude());
		}
		
		return null;
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
				return new Vector(1, 0);
			}
			if(minimumDistance == rightDistance) {
				return new Vector(-1, 0);
			}
			if(minimumDistance == upperDistance) {
				return new Vector(0, 1);
			}
			if(minimumDistance == lowerDistance) {
				return new Vector(0, -1);
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
		Object[] concatArray = Arrays.copyOf(PRESET_SPRITE_ARRAY, PRESET_SPRITE_ARRAY.length + spritesArray.length);
		System.arraycopy(spritesArray, 0, concatArray, PRESET_SPRITE_ARRAY.length, spritesArray.length);

		spritesList = new ArrayList<Sprite>();
		
		int i = 0;
		while(i < concatArray.length) { 
			if(i + 2 == concatArray.length || concatArray[i + 2].getClass().getName() == "java.lang.String") {
				spritesList.add(new Sprite(this, (String) concatArray[i], (String) concatArray[i + 1]));
				i += 2;
			}
			else {
				spritesList.add(new Sprite(this, (String) concatArray[i], (String) concatArray[i + 1], (Integer) concatArray[i + 2]));
				i += 3;
			}
		}
		
		spriteManager = new SpriteManager(this, spritesList);
		activeSprite = (String) concatArray[0];
	}
}
