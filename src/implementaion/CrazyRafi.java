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
		for(int i = 1; i <= 64; i++) {
			super.addEntity(new CrazyEntity(game.getWorld()));
		}

		//Ignore
		run();
	}

	private class CrazyEntity extends Entity {	
		final static double DEATH_SPEED = 150;

		final static double ACCEL_FACTOR = 25;
		final static double BOUNCE_FACTOR = 1;
		final static double RANDOM_FACTOR = 200;

		final static double SIZE = 1000;

		final static double START_LEFT_BOUND = 0.4 * SIZE;
		final static double START_RIGHT_BOUND = 0.6 * SIZE;
		final static double START_UPPER_BOUND = 0.4 * SIZE;
		final static double START_LOWER_BOUND = 0.6 * SIZE;

		final static double BOUNCE_LEFT_BOUND = 0.05 * SIZE;
		final static double BOUNCE_RIGHT_BOUND = 0.95 * SIZE;
		final static double BOUNCE_UPPER_BOUND = 0.05 * SIZE;
		final static double BOUNCE_LOWER_BOUND = 0.95 * SIZE;

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
					"e15", "images/explosion/tmp-15.gif", "e16", "images/explosion/tmp-16.gif", "e17", "images/explosion/tmp-17.gif", "e18", "images/explosion/tmp-18.gif"});
			
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
			setDim(new Dimension(64, 64));
			activeSprite = "explosion";
			setAutoMode(true);
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
		}

		@Override
		public void init() {
			spritesArray = new Object[]{"rafi", "images/rafi.png", "ok-rafi", "images/rafi-2.png"};
			loadSprites();

			setPos(new Position(0, 0));
			setDim(new Dimension(32, 32));
			activeSprite = "rafi";
		}

		@Override
		public void update() {
			cycle++;
		}

		@Override
		public void disable() {

		}
	}
}