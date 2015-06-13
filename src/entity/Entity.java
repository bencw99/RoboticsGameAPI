package entity;

import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;

import java.awt.*;

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
	public Entity(World world, Position pos, double angle, Vector vector, Dimension dim) {
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
     *
     * @param ent the entity that we are colliding with
     * @return the direction the other entity is coming from
     */
	public Vector directionalCollide(Entity ent) {
		Rectangle c = new Rectangle((int) this.getUpperLeftPos().getX(), (int) this.getUpperLeftPos().getY(), (int) this.dim.getWidth(), (int) this.dim.getHeight());
        Rectangle d = new Rectangle((int) ent.getUpperLeftPos().getX(), (int) ent.getUpperLeftPos().getY(), (int) ent.getDim().getWidth(), (int) ent.getDim().getHeight());

        //Tests cases where the other entity is above this one
        if(ent.getUpperLeftPos().getY() < ent.getUpperLeftPos().getY()) {
		    if(ent.getLowerLeftPos().getX() < this.getLowerLeftPos().getX()) {
                if(d.createIntersection(c).getWidth() > d.createIntersection(c).getHeight()) {
                    return new Vector(0, -1);
                }
                else return new Vector(-1, 0);
            }

            if(ent.getLowerRightPos().getX() > this.getLowerRightPos().getX()) {
                if(d.createIntersection(c).getWidth() > d.createIntersection(c).getHeight()) {
                    return new Vector(0, -1);
                }
                else return new Vector(1, 0);
            }

            else return new Vector(0, -1);

		}

        //Tests cases where the other entity is below this one
        if(ent.getLowerLeftPos().getY() > this.getLowerLeftPos().getY()) {
            if(ent.getLowerLeftPos().getX() < this.getLowerLeftPos().getX()) {
                if(d.createIntersection(c).getWidth() > d.createIntersection(c).getHeight()) {
                    return new Vector(0, 1);
                }
                else return new Vector(-1, 0);
            }

            if(ent.getLowerRightPos().getX() > this.getLowerRightPos().getX()) {
                if(d.createIntersection(c).getWidth() > d.createIntersection(c).getHeight()) {
                    return new Vector(0, 1);
                }
                else return new Vector(1, 0);
            }

            else return new Vector(0, 1);
        }

        //Tests cases where the other entity is to the left of this one
        if(ent.getLowerLeftPos().getX() < this.getLowerLeftPos().getX()) {
            if(ent.getUpperLeftPos().getY() < this.getUpperLeftPos().getY()) {
                if(d.createIntersection(c).getWidth() < d.createIntersection(c).getHeight()) {
                    return new Vector(-1, 0);
                }
                else return new Vector(0, -1);
            }

            if(ent.getLowerLeftPos().getY() > this.getLowerLeftPos().getY()) {
                if(d.createIntersection(c).getWidth() < d.createIntersection(c).getHeight()) {
                    return new Vector(-1, 0);
                }
                else return new Vector(0, 1);
            }

            else return new Vector(-1, 0);
        }

        //Tests cases where the other entity is to the right of this one
        if(ent.getLowerRightPos().getX() > this.getLowerRightPos().getX()) {
            if(ent.getUpperRightPos().getY() < this.getUpperRightPos().getY()) {
                if(d.createIntersection(c).getWidth() < d.createIntersection(c).getHeight()) {
                    return new Vector(1, 0);
                }
                else return new Vector(0, -1);
            }

            if(ent.getLowerRightPos().getY() > this.getLowerRightPos().getY()) {
                if(d.createIntersection(c).getWidth() < d.createIntersection(c).getHeight()) {
                    return new Vector(1, 0);
                }
                else return new Vector(0, 1);
            }

            else return new Vector(1, 0);
        }

        //idk what to put here i have all the cases but i have to put an else statement so yeah
        else return null;
	}

}
