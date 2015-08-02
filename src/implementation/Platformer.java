package implementation;


import constants.*;
import entity.*;
import game.*;
import input.*;
import physics.*;
import spriteless.AbstractTimer;
public class Platformer extends Implementor{
	public static final Dimension DEFAULT_PLATFORM_DIMENSION = new Dimension(100, 20);
	public static final double DEFAULT_PLATFORM_ANGLE = 0;
	
	public static final Vector GRAVITY = new Vector(0, 600);
	
	/**
	 * Called when game starts
	 */
	public void execute() {
		//Ignore
		init();
		
		addEntity(new Jumper(game, new Position(100, 100), new Dimension()));
		
		for(int i = 100; i < Constants.SCREEN_WIDTH; i += Constants.SCREEN_WIDTH/5) {
			for(int j = 200; j < Constants.SCREEN_HEIGHT; j += Constants.SCREEN_HEIGHT/8) {
				Position platformPosition = new Position(i, j);
				Platform platform = new Platform(game, platformPosition);
				
				addEntity(platform);
			}
		}
		
		System.out.println("Entity addition completed");
		
		//Ignore
		run();
	}
	
	private class Platform extends Entity {
		public Platform(Game game, Position pos)
		{
			super(game, pos, DEFAULT_PLATFORM_ANGLE, DEFAULT_PLATFORM_DIMENSION);
			
			spritesArray = new String[]{"platform", "images/preset/black.png"};
			loadSprites();
		}

		@Override
		public void init()
		{
			activeSprite = "platform";
		}

		@Override
		public void update()
		{
			
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
					if(other instanceof Platform && doesCollide(other)) {
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
				if(other instanceof Platform && doesCollide(other)) {
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