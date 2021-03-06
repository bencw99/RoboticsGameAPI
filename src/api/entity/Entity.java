package api.entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import api.game.Game;
import api.graphics.Animation;
import api.graphics.Drawable;
import api.graphics.Sprite;
import api.graphics.SpriteManager;
import api.physics.Position;
import api.physics.Vector;

public abstract class Entity {
	/** The position of this Entity instance */
	private Position pos;

	/** The angle of this Entity instance **/
	private double angle;

	/** The dimensions of this entity */
	private Dimension dim;

	/** Draws and manages the graphics for this entity */
	private SpriteManager spriteManager;

	/** An array that will prestore the Sprite information in the form: name, filepath **/
	protected Object[] spritesArray;

	/** An ArrayList of the Drawabale to this object **/
	private ArrayList<Drawable> drawableList;

	/** Name **/
	private String name;

	/** The name of the current Sprite or Animation this Entity is displaying outside of animation mode **/
	protected String activeSprite;

	private Game game;

	/** An array that will hold information for constructing preset {@link  sprite.Sprite}s available to all Entities */
	public static final Object[] PRESET_SPRITE_ARRAY = {"RED", "images/preset/red.png", 
		"WHITE", "images/preset/white.png", "GREEN", "images/preset/green.jpg", "BLACK", "images/preset/black.png", 
		"TRANSPARENT", "images/preset/transparent.png"};

	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Entity(Game game) {
		this("anonymous", game, new Position(), 0, new Dimension());
	}

	public Entity(String name, Game game) {
		this(name, game, new Position(), 0, new Dimension());
	}

	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 * 
	 * @param angle the angle of this entity
	 * @param pos the position of this entity
	 * @param dim the dimension of this entity
	 */
	public Entity(Game game, Position pos, double angle, Dimension dim) {
		this("anonymous", game, pos, angle, dim);
	}

	public Entity(String name, Game game, Position pos, double angle, Dimension dim) {
		this.name = name;
		this.game = game;
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
	 * @param g the graphics object to be drawn on
	 */
	public void draw(Graphics g) {
		spriteManager.update(g, activeSprite);
	}

	/**
	 * Translates this position by the given x and y differentials
	 * @param dx the x differential
	 * @param dy the y differential
	 */
	public void translate(double dx, double dy) {
		pos.translate(dx, dy);
	}

	/**
	 * Translates this position by the given vector differentials
	 * @param vec the translation vector
	 */
	public void translate(Vector vec) {
		pos.translate(vec);
	}

	/**
	 * Translates the position by the given x differential
	 * @param dx the x differential
	 */
	public void translateX(double dx) {
		pos.translateX(dx);
	}

	/**
	 * Translates the position by the given y differential
	 * @param dy the y differential
	 */
	public void translateY(double dy) {
		pos.translateY(dy);
	}

	/**
	 * Returns the upper left position of this entity
	 * @return the upper left position
	 */
	public Position getUpperLeftPos() {
		return new Position(this.pos.getX() - this.dim.getWidth()/2, this.pos.getY() - this.dim.getHeight()/2);
	}

	/**
	 * Returns the upper right position of this entity
	 * @return the upper right position
	 */
	public Position getUpperRightPos() {
		return new Position(this.pos.getX() + this.dim.getWidth()/2, this.pos.getY() - this.dim.getHeight()/2);
	}

	/**
	 * Returns the lower left position of this entity
	 * @return the lower left position
	 */
	public Position getLowerLeftPos() {
		return new Position(this.pos.getX() - this.dim.getWidth()/2, this.pos.getY() + this.dim.getHeight()/2);
	}

	/**
	 * Returns the lower right position of this entity
	 * @return the lower right position
	 */
	public Position getLowerRightPos() {
		return new Position(this.pos.getX() + this.dim.getWidth()/2, this.pos.getY() + this.dim.getHeight()/2);
	}

	/**
	 * Returns the bounding polygon of this entity based off of its angle and dimension
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
	 * Returns true if the two entities collide
	 * @param other the entity colliding with
	 * @return the collision result
	 */
	public boolean doesCollide(Entity other) {
		return collides(other) != null;
	}

	/**
	 * Translates this angle by the given angle difference
	 * @param dAngle the angle to be translated by
	 */
	public void translateAngle(double dAngle) {
		this.angle += dAngle;
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
	
	/**
	 * Method that gets all the entities that collides with it and is of type Class
	 * @param c the Class type
	 * @return all the entities that collide with this entity
	 */
	public ArrayList<Entity> collisionsWithType(String classname){
		try {
			Class<?> c;
			c = Class.forName(classname);
			ArrayList<Entity> collisions = new ArrayList<Entity>();
			for(Entity e : game.getCurrentScreen().getEntities()){
				if(c.isInstance(e) && e.doesCollide(this)){
					collisions.add(e);
				}
			}
			if(collisions.size() > 0) {
				return collisions;
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Invallid classname " + classname + " for collidesWithType");
		}
		return new ArrayList<Entity>();

	}

	/**
	 * Checks if this Entity collides with any Entities of a specific type
	 * @param classname the type to check
	 * @return does collide
	 */
	public boolean doesCollideWithType(String classname) {
		if(collisionsWithType(classname).size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Hets all the entities that collides with this of a specific name
	 * @param name the name
	 * @return all the entities that collide with this entity of that name
	 */
	public ArrayList<Entity> collisionsWithName(String name) {
		ArrayList<Entity> collisions = new ArrayList<Entity>();
		for(Entity e : game.getCurrentScreen().getEntities()){
			if(e.getName() == name && e.doesCollide(this)){
				collisions.add(e);
			}
		}
		return collisions;
	}
	
	/**
	 * Checks if this Entity collides with any Entities of a specific name
	 * @param name the name to check
	 * @return does collide
	 */
	public boolean doesCollideWithName(String name) {
		if(collisionsWithName(name).size() == 0) {
			return false;
		}
		return true;
	}


	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public Dimension getDim() {
		return dim;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public void setSpriteManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
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

	public void stepFrame() {
		spriteManager.stepFrame();
	}

	public Position getPos() {
		return pos;
	}

	public double getX() {
		return pos.getX();
	}

	public double getY() {
		return pos.getY();
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}