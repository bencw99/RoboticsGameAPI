package entity;

import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;
import graphics.Animation;
import graphics.Drawable;
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

	/** An array that will prestore the Sprite information in the form: name, filepath **/
	protected Object[] spritesArray;

	/** An ArrayList of the Drawabale to this object **/
	private ArrayList<Drawable> drawableList;

	/** The name of the current Sprite or Animation this Entity is displaying outside of animation mode **/
	protected String activeSprite;

	/** An array that will hold information for constructing preset {@link  sprite.Sprite}s available to all Entities */
	public static final Object[] PRESET_SPRITE_ARRAY = {"RED", "images/preset/red.png", 
		"WHITE", "images/preset/white.png", "GREEN", "images/preset/green.jpg", "BLACK", "images/preset/black.png", 
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
	
	/**
	 * Rotates the given polygon by the given angle about the given pivot
	 * 
	 * @param poly
	 * @param pivot
	 * @param angle
	 * @return
	 */
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
	 * Collision detection function. Returns the vector in the direction of the force applied by the other colliding entity on this one. If the entities don't collide, returns null
	 *
	 * @param other	the entity colliding with
	 * @return	the collision result (see above for details)
	 */
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
			
			return collisionVector.scale(1/collisionVector.magnitude());
		}
		
		return null;
	}
	
	/**
	 * Returns true of the two entities collide
	 * 
	 * @param other the entity colliding with
	 * @return the collision result
	 */
	public boolean doesCollide(Entity other) {
		return collides(other) != null;
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
	
	
	// ***************************************
	// GRAPHICS
	// ***************************************
	
	// Call Downs
	// GRAPHICS:
	
	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public void setSpriteManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
	}
	
	public void stepFrame() {
		spriteManager.stepFrame();
	}
	
	public void setCycleMode(boolean cycleMode) {
		spriteManager.setCycleMode(cycleMode);
	}

	
	public void setAutoMode(boolean autoMode) {
		spriteManager.setAutoMode(autoMode);
	}
	
	public void setTicksPerFrame(int ticks) {
		spriteManager.setTicksPerFrame(ticks);
	}
	
	/**
	 * Creations a new animation out of an array of Strings and opacity Integers
	 * @param inputArray array of Strings and Integer
	 * @return end Animation
	 */
	public Animation newAnimation(Object[] inputArray) {
		ArrayList<Drawable> spritesList = new ArrayList<Drawable>();
		int i = 0;
		while(i < inputArray.length) { 
			if(i + 2 == inputArray.length || inputArray[i + 2].getClass().getName() == "java.lang.String") {
				spritesList.add(new Sprite(this, (String) inputArray[i], (String) inputArray[i + 1]));
				i += 2;
			}
			else {
				spritesList.add(new Sprite(this, (String) inputArray[i], (String) inputArray[i + 1], (Integer) inputArray[i + 2]));
				i += 3;
			}
		}
		spritesList.add(new Sprite(this, "animationEnd", "images/preset/transparent.png"));
		return new Animation(this, spritesList);
	}

	/**
	 * Takes the easy to use array that the user makes when extending
	 * this class and loads it into an ArrayList of Sprites and Animations
	 */
	public void loadSprites() {
		Object[] concatArray = Arrays.copyOf(PRESET_SPRITE_ARRAY, PRESET_SPRITE_ARRAY.length + spritesArray.length);
		System.arraycopy(spritesArray, 0, concatArray, PRESET_SPRITE_ARRAY.length, spritesArray.length);

		drawableList = new ArrayList<Drawable>();

		int i = 0;
		while(i < concatArray.length) { 
			if(i + 2 == concatArray.length || concatArray[i + 2].getClass().getName() == "java.lang.String") {
				if(concatArray[i + 1] instanceof String) {
					drawableList.add(new Sprite(this, (String) concatArray[i], (String) concatArray[i + 1]));
					i += 2;
				}
				else {
					Animation a = (Animation) concatArray[i + 1];
					a.setName((String) concatArray[i]);
					drawableList.add(a);
					i += 2;
				}
			}
			else {
				drawableList.add(new Sprite(this, (String) concatArray[i], (String) concatArray[i + 1], (Integer) concatArray[i + 2]));
				i += 3;
			}
		}

		spriteManager = new SpriteManager(this, drawableList);
		activeSprite = (String) concatArray[0];
	}
}
