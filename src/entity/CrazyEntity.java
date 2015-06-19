package entity;


import physics.Position;
import physics.Vector;
import world.World;

public class CrazyEntity extends Entity {	
	
	
	final static double DEATH_SPEED = 300;
	
	final static double ACCEL_FACTOR = 3;
	final static double BOUNCE_FACTOR = 1;
	final static double RANDOM_FACTOR = 100;
	
	final static double START_LEFT_BOUND = 400;
	final static double START_RIGHT_BOUND = 600;
	final static double START_UPPER_BOUND = 400;
	final static double START_LOWER_BOUND = 600;
	
	final static double BOUNCE_LEFT_BOUND = 25;
	final static double BOUNCE_RIGHT_BOUND = 975;
	final static double BOUNCE_UPPER_BOUND = 25;
	final static double BOUNCE_LOWER_BOUND = 975;
	
	final static double KILL_LEFT_BOUND = -25;
	final static double KILL_RIGHT_BOUND = 1025;
	final static double KILL_UPPER_BOUND = -25;
	final static double KILL_LOWER_BOUND = 1025;
	
	Vector velocity = new Vector(0, 0);
	int cycle = 0, timeAlive = 0;
	boolean dead = false;

	
	public CrazyEntity(World world) {
		super(world);
	}
	
	@Override
	public void init() {
		
		// Game API user must do the following
		spritesArray = new String[]{"happy", "happy.jpg", "death", "skull-transparent.png"};
		loadSprites();
		activeSprite = "happy";
		// This is it
		
		resetVelocity();
		resetPosition();
	}

	@Override
	public void update() {
		if(dead) {
			return;
		}
		velocity.setX(velocity.getX() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
		velocity.setY(velocity.getY() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
		timeAlive++;
		
		translate(velocity);
		
		if(getPos().getX() > BOUNCE_RIGHT_BOUND || getPos().getX() < BOUNCE_LEFT_BOUND) {
			velocity.setX(velocity.getX() * -BOUNCE_FACTOR);
		}
		
		if(getPos().getY() > BOUNCE_LOWER_BOUND || getPos().getY() < BOUNCE_UPPER_BOUND) {
			velocity.setY(velocity.getY() * -BOUNCE_FACTOR);
		}
		
		if(getPos().getX() > KILL_RIGHT_BOUND || getPos().getX() < KILL_LEFT_BOUND || 
				getPos().getY() > KILL_LOWER_BOUND || getPos().getX() < KILL_UPPER_BOUND) {
			kill();
		}
		
		if(velocity.getX() * velocity.getX() + velocity.getY() * velocity.getY() > DEATH_SPEED) {
			kill();
		}
	}
	
	private void resetPosition() {
		setPos(new Position(START_LEFT_BOUND + Math.random() * (START_RIGHT_BOUND - START_LEFT_BOUND), 
				START_UPPER_BOUND + Math.random() * (START_LOWER_BOUND - START_UPPER_BOUND)));
	}
	
	private void resetVelocity() {
		velocity.setX(0);
		velocity.setY(0);
	}

	private void kill() {
		dead = true;
		resetVelocity();
		activeSprite = "death";
	}
	
	@Override
	public void disable() {
		
	}
}
