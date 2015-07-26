package implementaion;
import entity.*;
import graphics.*;
import physics.*;
import world.*;
public class SkullBounce extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();

		//Write code here
		super.addEntity(new Skull(game.getWorld()));
		for(int i = 1; i <= 128; i++) {
			super.addEntity(new CrazyEntity(game.getWorld()));
		}

		//Ignore
		run();
	}

	private class CrazyEntity extends Entity {	
		final static double ACCEL_FACTOR = 0.1;
		final static double BOUNCE_FACTOR = 1;
		final static double RANDOM_FACTOR = 100;

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

		final static double KILL_LEFT_BOUND = -0.05 * SIZE;
		final static double KILL_RIGHT_BOUND = 1.05 * SIZE;
		final static double KILL_UPPER_BOUND = -0.05 * SIZE;
		final static double KILL_LOWER_BOUND = 1.05 * SIZE;

		Vector velocity = new Vector(0, 0);
		int timeAlive = 0;
		boolean dead = false;


		public CrazyEntity(World world) {
			super(world);
		}

		@Override
		public void init() {
			// The 50 here is the opacity of the happy Sprite
			// Opacity is optional, the default opacity is 100
			Animation explosion = newAnimation(new Object[]{"e0", "images/explosion/tmp-0.gif", "e1", "images/explosion/tmp-1.gif", "e2", "images/explosion/tmp-2.gif",
					"e3", "images/explosion/tmp-3.gif", "e4", "images/explosion/tmp-4.gif", "e5", "images/explosion/tmp-5.gif", "e6", "images/explosion/tmp-6.gif",
					"e7", "images/explosion/tmp-7.gif", "e8", "images/explosion/tmp-8.gif", "e9", "images/explosion/tmp-9.gif", "e10", "images/explosion/tmp-10.gif",
					"e11", "images/explosion/tmp-11.gif", "e12", "images/explosion/tmp-12.gif", "e13", "images/explosion/tmp-13.gif", "e14", "images/explosion/tmp-14.gif",
					"e15", "images/explosion/tmp-15.gif", "e16", "images/explosion/tmp-16.gif", "e17", "images/explosion/tmp-17.gif", "e18", "images/explosion/tmp-18.gif",});

			spritesArray = new Object[]{"happy", "images/happy.jpg", "explosion", explosion, "death", "images/skull-transparent.png", 100};
			loadSprites();
			activeSprite = "happy";
			setAutoMode(false);
			setCycleMode(false);

			resetVelocity();
			resetPosition();
		}

		@Override
		public void update() {
			if(!dead) {
				translate(velocity);
				if(collide(this.getWorld().getEntities().get(0))) {
					skullCollide();
				};

				if(getPos().getX() > BOUNCE_RIGHT_BOUND || getPos().getX() < BOUNCE_LEFT_BOUND) {
					velocity.setX(velocity.getX() * -BOUNCE_FACTOR);
					velocity.setY(velocity.getY() * BOUNCE_FACTOR);
				}

				if(getPos().getY() > BOUNCE_LOWER_BOUND || getPos().getY() < BOUNCE_UPPER_BOUND) {
					velocity.setY(velocity.getY() * -BOUNCE_FACTOR);
					velocity.setX(velocity.getX() * BOUNCE_FACTOR);
				}

				if(getPos().getX() > KILL_RIGHT_BOUND || getPos().getX() < KILL_LEFT_BOUND || 
						getPos().getY() > KILL_LOWER_BOUND || getPos().getX() < KILL_UPPER_BOUND) {
					kill();
				}
			}

			velocity.setX(velocity.getX() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
			velocity.setY(velocity.getY() + (Math.random() / RANDOM_FACTOR - (1 / (2 * RANDOM_FACTOR))) * (1 + timeAlive * 0.01 * ACCEL_FACTOR));
			timeAlive++;
		}

		private void resetPosition() {
			setPos(new Position(START_LEFT_BOUND + Math.random() * (START_RIGHT_BOUND - START_LEFT_BOUND), 
					START_UPPER_BOUND + Math.random() * (START_LOWER_BOUND - START_UPPER_BOUND)));
		}

		private void resetVelocity() {
			velocity.setX(0);
			velocity.setY(0);
		}

		private void skullCollide() {
			kill();
		}

		private void kill() {
			dead = true;
			setDim(new Dimension(32, 32));
			activeSprite = "explosion";
			setAutoMode(true);
			setTicksPerFrame(20);
			timeAlive = 0;
		}

		@Override
		public void disable() {

		}
	}

	private class Skull extends Entity {	
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
		final static double GROW_SIZE = 1.05;

		Vector velocity = new Vector(0, 0);
		int timeAlive = 0;

		public Skull(World world) {
			super(world);
		}

		@Override
		public void init() {
			setDim(new Dimension(16, 16));
			spritesArray = new Object[]{"skull", "images/skull-transparent.png"};
			loadSprites();
			activeSprite = "skull";
			resetPosition();
		}

		@Override
		public void update() {
			translate(velocity);

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
				setDim(new Dimension(getDim().getWidth() * 1.05, getDim().getHeight() * GROW_SIZE));
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

		@Override
		public void disable() {

		}
	}
}