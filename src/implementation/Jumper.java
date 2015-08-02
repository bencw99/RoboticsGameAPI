package implementation;

import entity.Entity;
import game.Game;
import implementation.Platform;
import input.InputListener;

import java.awt.Dimension;
import java.util.ArrayList;

import physics.Position;
import physics.Vector;
import constants.Constants;

public class Jumper extends Entity {
	private Vector vel;
	
	public Jumper(Game game, Position pos, Dimension dim)
	{
		super(game, pos, 0, dim);
		spritesArray = new String[]{"jumper", "images/preset/red.png"};
		loadSprites();
	}
	
	public void applyGravity() {
		vel.translate(Constants.GRAVITY.scale(1/(double) Constants.UPDATES_PER_SEC));
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
			
			ArrayList<Entity> collisions = collisionsWithType("implementation.Platform");
			if(collisions.size() > 0) {
				for(Entity e : collisions) {
					if(((Platform) e).isAlive()) {
						canJump = true;
					}
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
		
		ArrayList<Entity> collisions = collisionsWithType("implementation.Platform");
		if(collisions.size() > 0) {
			for(Entity e : collisions) {
				Vector force = collides(e);
				
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