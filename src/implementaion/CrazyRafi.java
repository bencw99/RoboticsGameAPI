package implementaion;
import java.awt.event.ActionEvent;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
import world.*;
public class CrazyRafi extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();
		
		//Write code here
		for(int i = 1; i <= 32; i++) {
			super.addEntity(new CrazyEntity(game.getWorld()));
		}
		super.addEntity(new Rafi(game.getWorld()));
		
		//Ignore
		run();
	}
	
	private class CrazyEntity extends Entity {	
		final static double DEATH_SPEED = 300;
		
		final static double ACCEL_FACTOR = 10;
		final static double BOUNCE_FACTOR = 1;
		final static double RANDOM_FACTOR = 200;
		
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
			spritesArray = new String[]{"happy", "images/happy.jpg", "death", "images/skull-transparent.png"};
			loadSprites();
			activeSprite = "happy";
			
			resetVelocity();
			resetPosition();
		}

		@Override
		public void update() {
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
			
			if(dead) {
				velocity = velocity.scale(0.95);
				return;
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

		private void kill() {
			dead = true;
			//resetVelocity();
			activeSprite = "death";
			timeAlive = 0;
		}
		
		@Override
		public void disable() {
			
		}
	}
	
	private class Rafi extends Entity {

		int cycle = 0;
		
		public Rafi(World world) {
			super(world);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void init() {
			spritesArray = new String[]{"rafi", "images/rafi.png", "ok-rafi", "images/rafi-2.png"};
			loadSprites();
			
			setPos(new Position(500, 500));
			setDim(new Dimension(128, 128));
			activeSprite = "TRANSPARENT";
		}

		@Override
		public void update() {
			cycle++;
			if(cycle == 600) {
				setFrameLength(100);
				setAnimationMode(true);
			}
		}

		@Override
		public void disable() {
			// TODO Auto-generated method stub
			
		}
	}
}