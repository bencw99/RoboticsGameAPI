package implementation;


import java.awt.Dimension;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import input.*;
import physics.*;
import spriteless.*;
public class Platformer extends Implementor{
	public static final Dimension DEFAULT_PLATFORM_DIMENSION = new Dimension(100, 20);
	public static final double DEFAULT_PLATFORM_ANGLE = 0;
	
	public static final Vector GRAVITY = new Vector(0, 600);
	private int platformsDestroyed = 0;
	
	/**
	 * Called when game starts
	 */
	public void execute() {
		//Ignore
		init();
		
		addEntity(new Jumper(game, new Position(100, 100), Constants.DEFAULT_DIMENSION));
		addSpritelessElement(new PlatformCount("Hello"));
		
		for(int i = 100; i < Constants.SCREEN_WIDTH; i += Constants.SCREEN_WIDTH/5) {
			for(int j = 200; j < Constants.SCREEN_HEIGHT; j += Constants.SCREEN_HEIGHT/8) {
				Position platformPosition = new Position(i, j);
				Platform platform = new Platform(game, platformPosition);
				
				addEntity(platform);
			}
		}
		
		//Ignore
		run();
	}
	
	private class PlatformCount extends AbstractTextBox {
		public PlatformCount(String string) {
			super(string);
		}

		@Override
		public void update() {
			setText("Platforms Destryed: " + platformsDestroyed);
		}
	}
	
	private class Platform extends Entity {
		private boolean alive;
		private int contacts;
		
		public boolean isAlive() {
			return alive;
		}
		
		public Platform(Game game, Position pos)
		{
			super(game, pos, DEFAULT_PLATFORM_ANGLE, DEFAULT_PLATFORM_DIMENSION);
			
			Animation explosion = newAnimation(new Object[]{"e0", "images/explosion/tmp-0.gif", "e1", "images/explosion/tmp-1.gif", "e2", "images/explosion/tmp-2.gif",
					"e3", "images/explosion/tmp-3.gif", "e4", "images/explosion/tmp-4.gif", "e5", "images/explosion/tmp-5.gif", "e6", "images/explosion/tmp-6.gif",
					"e7", "images/explosion/tmp-7.gif", "e8", "images/explosion/tmp-8.gif", "e9", "images/explosion/tmp-9.gif", "e10", "images/explosion/tmp-10.gif",
					"e11", "images/explosion/tmp-11.gif", "e12", "images/explosion/tmp-12.gif", "e13", "images/explosion/tmp-13.gif", "e14", "images/explosion/tmp-14.gif",
					"e15", "images/explosion/tmp-15.gif", "e16", "images/explosion/tmp-16.gif", "e17", "images/explosion/tmp-17.gif", "e18", "images/explosion/tmp-18.gif",});
			
			spritesArray = new Object[]{"platform", "images/preset/black.png", "stepped", "images/preset/green.jpg", "explosion", explosion};
			loadSprites();
		}

		@Override
		public void init()
		{
			alive = true;
			contacts = 0;
			activeSprite = "platform";
		}

		@Override
		public void update()
		{
			if(alive) {
				translateAngle(0.003);
				for(Entity other : getEntities()) {
					if(other instanceof Jumper && doesCollide(other)) {
						contacts ++;
						activeSprite = "stepped";
					}
				}
				if(contacts >= 300) {
					System.out.println("Platform destroyed");
					alive = false;
					activeSprite = "explosion";
					setAutoMode(true);
					setTicksPerFrame(5);
					platformsDestroyed ++;
				}
			}
		}

		@Override
		public void disable()
		{
			
		}
	}
	
	private class Jumper extends Entity {
		private Vector vel;
		
		public Jumper(Game game, Position pos, Dimension dim)
		{
			super(game, pos, 0, dim);
			
			spritesArray = new String[]{"jumper", "images/preset/red.png"};
			loadSprites();
		}
		
		public void applyGravity() {
			vel.translate(GRAVITY.scale(1/(double) Constants.UPDATES_PER_SEC));
		}
		
		public void move() {
			translate(vel.scale(1/(double) Constants.UPDATES_PER_SEC));
		}
		
		@Override
		public void init()
		{
			vel = new Vector(0, 0);
			activeSprite = "jumper";
		}

		@Override
		public void update()
		{
			move();
			applyGravity();
			
			if(InputListener.isKeyNewPressed('w')) {
				boolean canJump = false;
				
				for(Entity other : getEntities()) {
					if(other instanceof Platform && ((Platform) other).isAlive() && doesCollide(other)) {
						canJump = true;
					}
				}
				
				if(canJump) {
					vel.setY(-400);
				}
			}
			
			if(InputListener.isKeyPressed('a')) {
				translateX(-3);
			}
			if(InputListener.isKeyPressed('d')) {
				translateX(3);
			}
			
			for(Entity other : getEntities()) {
				if(other instanceof Platform && ((Platform) other).isAlive() && doesCollide(other)) {
					Vector force = collides(other);
					
					if(force.getY() > 0.5) {
						vel.setY(Math.max(vel.getY(), 0));
					}
					if(force.getY() < -0.5) {
						vel.setY(Math.min(vel.getY(), 0));
					}
					
					if(force.getX() > 0.5) {
						vel.setX(Math.max(vel.getX(), 0));
						if(InputListener.isKeyPressed('a')) {
							translateX(3);
						}
					}
					if(force.getX() < -0.5) {
						vel.setX(Math.min(vel.getX(), 0));
						if(InputListener.isKeyPressed('d')) {
							translateX(-3);
						}
					}
				}
			}
		}

		@Override
		public void disable() {
			
		}
	}
}