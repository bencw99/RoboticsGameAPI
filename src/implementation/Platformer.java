package implementation;

import java.awt.event.ActionEvent;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
public class Platformer extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();
		
		
		
		addEntity(new Jumper(game, new Position(100, 100), new Dimension()));
		addEntity(new Platform(game, new Position(100, 200), new Dimension(100, 20), 0));
		
		for(int i = 0; i < 30; i ++) {
			Platform p = null;
			
			boolean possible = false;
			
			while(!possible) {
				p = new Platform(game, new Position(Math.random()*1000, Math.random()*800), new Dimension(100, 20), 0);
				possible = true;
				for(Entity other : getEntities()) {
					if(p.doesCollide(other)) {
						possible = false;
					}
				}
			}
			
			addEntity(p);
		}
		
		//Ignore
		run();
	}
	
	private class Platform extends Entity {
		public Platform(Game game, Position pos, Dimension dim, double angle)
		{
			super(game, pos, 0, dim);
			
			spritesArray = new String[]{"smile", "images/happy.jpg"};
			loadSprites();
			activeSprite = "smile";
		}

		@Override
		public void init()
		{

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
		
		private final Vector gravity = new Vector(0, 800);
		
		public Jumper(Game game, Position pos, Dimension dim)
		{
			super(game, pos, 0, dim);
			
			spritesArray = new String[]{"rafi", "images/rafi.png"};
			loadSprites();
			activeSprite = "rafi";
		}

		@Override
		public void init()
		{
			vel = new Vector(0, 0);
		}

		@Override
		public void update()
		{
			translate(vel.scale(1/Constants.UPDATES_PER_SEC));
			
			vel.translate(gravity.scale(1/Constants.UPDATES_PER_SEC));
			
			if(InputListener.isKeyNewPressed('w')) {
				boolean canJump = false;
				for(Entity other : game.getEntities()) {
					if(other instanceof Platform && doesCollide(other)) {
						canJump = true;
					}
				}
				
				if(canJump)
					vel.setY(-400);
			}
			
			if(InputListener.isKeyPressed('a')) {
				translateX(-3);
			}
			if(InputListener.isKeyPressed('d')) {
				translateX(3);
			}
			for(Entity other : game.getEntities()) {
				if(other instanceof Platform && doesCollide(other)) {
					Vector dir = collides(other);
					
					if(dir.getY() > 0.5) {
						vel.setY(Math.max(vel.getY(), 0));
					}
					if(dir.getY() < -0.5) {
						vel.setY(Math.min(vel.getY(), 0));
					}
					
					if(dir.getX() > 0.5) {
						vel.setX(Math.max(vel.getX(), 0));
						if(InputListener.isKeyPressed('a')) {
							translateX(3);
						}
					}
					if(dir.getX() < -0.5) {
						vel.setX(Math.min(vel.getX(), 0));
						if(InputListener.isKeyPressed('d')) {
							translateX(-3);
						}
					}
				}
			}
		}

		@Override
		public void disable()
		{
			System.out.println("ExampleEntity disabled");
		}
	}
}