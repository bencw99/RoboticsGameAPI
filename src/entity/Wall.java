package entity;

import physics.Position;
import physics.Dimension;
import constants.Direction;
import constants.Constants;

public class Wall extends Entity {
	/**
	 * Default constructor
	 */
	public Wall(){
		super();
	}
	/**
	 * Constructor with arguments
	 * @param p
	 * @param direction
	 * @param length
	 */
	public Wall(Position p, Direction direction, double length){
		super();
		double angle;
		Dimension d = new Dimension(Constants.DEFAULT_WALL_WIDTH, length);
		switch(direction){
		case NORTH:
			angle = 270;
			break;
		case SOUTH:
			angle = 90;
			break;
		case EAST:
			angle = 0;
			break;
		case WEST:
			angle = 180;
			break;
		default:
			angle = 0;
			break;
		}
		setAngle(angle);
		setPos(p);
		setDim(d);

	}
	/**
	 *  Constructor with arguments
	 * @param p
	 * @param angle
	 * @param length
	 */
	public Wall(Position p, double angle, double length){
		super();
		Dimension d = new Dimension(Constants.DEFAULT_WALL_WIDTH, length);
		setPos(p);
		setAngle(angle);
		setDim(d);
	}
	/**
	 *  Constructor with arguments
	 * @param p
	 * @param direction
	 * @param d
	 */
	public Wall(Position p, Direction direction, Dimension d){
		super();
		double angle;
		switch(direction){
		case NORTH:
			angle = 270;
			break;
		case SOUTH:
			angle = 90;
			break;
		case EAST:
			angle = 0;
			break;
		case WEST:
			angle = 180;
			break;
		default:
			angle = 0;
			break;
		}
		setAngle(angle);
		setPos(p);
		setDim(d);
	}
	/**
	 *  Constructor with arguments
	 * @param p
	 * @param angle
	 * @param d
	 */
	public Wall(Position p, double angle, Dimension d){
		super(p, angle, d, null);
	}
	/**
	 * Initializes this wall
	 */
	public void init() {
		spritesArray = new Object[]{};
		activeSprite = "black";
		loadSprites();

	}

	/**
	 * Updates this wall
	 */
	public void update() {


	}

	/**
	 * Disables this wall
	 */
	public void disable() {
		setPos(new Position(0,0));
		setDim(new Dimension(0,0));
		setAngle(0);

	}

}
