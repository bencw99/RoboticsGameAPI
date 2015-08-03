package api.entity;

import java.awt.Dimension;

import api.constants.Constants;
import api.constants.Direction;
import api.game.Game;
import api.physics.Position;

public class Wall extends Entity {
	
	public Wall(Game g) {
		super(g);
	}
	
	/**
	 * Constructor with arguments
	 * @param p
	 * @param direction
	 * @param length
	 */
	public Wall(Game g, Position p, Direction direction, double length){
		super(g, p, 0, Constants.DEFAULT_DIMENSION);
		switch(direction){
		case NORTH:
			setAngle(270 * 3.14159 / 180);
			break;
		case SOUTH:
			setAngle(90 * 3.14159 / 180);
			break;
		case EAST:
			setAngle(0 * 3.14159 / 180);
			break;
		case WEST:
			setAngle(180 * 3.14159 / 180);
			break;
		default:
			setAngle(0 * 3.14159 / 180);
			break;
		}
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
