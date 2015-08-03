package api.implementation;

import java.awt.Dimension;

import api.entity.Entity;
import api.game.Game;
import api.physics.Position;
import api.physics.Vector;

public class EvilSquare extends Entity {	
	final static double ACCEL_FACTOR = 2;
	final static double BOUNCE_FACTOR = 1;
	final static double RANDOM_FACTOR = 1000;

	final static double START_BOX_SCALAR = 0.8;
	final static double SIZE = 1000;

	final static double START_LEFT_BOUND = (1 - START_BOX_SCALAR) / 2 * SIZE;
	final static double START_RIGHT_BOUND = (1 + START_BOX_SCALAR) / 2 * SIZE;
	final static double START_UPPER_BOUND = (1 - START_BOX_SCALAR) / 2 * SIZE;
	final static double START_LOWER_BOUND = (1 + START_BOX_SCALAR) / 2 * SIZE;

	final static double BOUNCE_LEFT_BOUND = 0.01 * SIZE;
	final static double BOUNCE_RIGHT_BOUND = 0.99 * SIZE;
	final static double BOUNCE_UPPER_BOUND = 0.01 * SIZE;
	final static double BOUNCE_LOWER_BOUND = 0.99 * SIZE;

	final static int GROW_TIME = 120;
	final static double GROW_FACTOR = 1.06;

	final static double ROTATIONAL_ACCELERATION = 0.0000045;

	Vector velocity = new Vector(0, 0);
	int timeAlive = 0;
	double rotationalVelocity = 0;

	public EvilSquare(Game game) {
		super(game);
	}
	
	public EvilSquare(String name, Game game) {
		super(name, game);
	}

	@Override
	public void init() {
		setDim(new Dimension(16, 16));
		spritesArray = new Object[]{"Black Square", "images/preset/black.png"};
		loadSprites();
		activeSprite = "Black Square";
		resetPosition();
	}

	@Override
	public void disable() {

	}

	@Override
	public void update() {
		translate(velocity);
		rotationalVelocity += ROTATIONAL_ACCELERATION;
		setAngle(getAngle() + rotationalVelocity);

		if(getPos().getX() > BOUNCE_RIGHT_BOUND || getPos().getX() < BOUNCE_LEFT_BOUND) {
			velocity.setX(velocity.getX() * -BOUNCE_FACTOR);
			velocity.setY(velocity.getY() * BOUNCE_FACTOR);
		}

		if(getPos().getY() > BOUNCE_LOWER_BOUND || getPos().getY() < BOUNCE_UPPER_BOUND) {
			velocity.setY(velocity.getY() * -BOUNCE_FACTOR);
			velocity.setX(velocity.getX() * BOUNCE_FACTOR);
		}

		velocity.setX(velocity.getX() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
		velocity.setY(velocity.getY() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
		timeAlive++;

		if(timeAlive % GROW_TIME == 0) {
			setDim(new Dimension((int) (getDim().getWidth() * GROW_FACTOR) + timeAlive / 1000,(int) (getDim().getHeight() * GROW_FACTOR) + timeAlive / 1000));
		}
	}

	private void resetPosition() {
		setPos(new Position(START_LEFT_BOUND + Math.random() * (START_RIGHT_BOUND - START_LEFT_BOUND), 
				START_UPPER_BOUND + Math.random() * (START_LOWER_BOUND - START_UPPER_BOUND)));
	}
}