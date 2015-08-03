package entity;

import game.Game;
import input.InputListener;

import java.awt.Dimension;

import constants.Constants;
import physics.Position;
import physics.Vector;

public class PlatformerEntity extends Entity {
	private Vector vel;
	boolean canJump; // You need to tell this object when it canJump
	
	public static final int JUMP_SPEED = 400;
	public static final int HORIZONTAL_SPEED = 3;
	
	public PlatformerEntity(Game game, Position pos, double angle, Dimension dim) {
		super(game, pos, angle, dim);
	}

	public PlatformerEntity(Game game) {
		super(game);
	}

	public PlatformerEntity(String name, Game game, Position pos, double angle,
			Dimension dim) {
		super(name, game, pos, angle, dim);
	}

	public PlatformerEntity(String name, Game game) {
		super(name, game);
	}
	
	@Override
	public void init() {
		setDim(new Dimension(32, 32));
		spritesArray = new Object[]{"Black Square", "images/preset/black.png"};
		loadSprites();
		vel = new Vector(0, 0);
		activeSprite = "Black Square";
		
	}

	@Override
	public void update() {
		move();
		applyGravity();
		
		if(InputListener.isKeyNewPressed('w') && canJump) {		
			vel.setY(-JUMP_SPEED);
		}
		
		if(InputListener.isKeyPressed('a')) {
			translateX(-HORIZONTAL_SPEED);
		}
		if(InputListener.isKeyPressed('d')) {
			translateX(HORIZONTAL_SPEED);
		}
	}

	@Override
	public void disable() {
		
	}
	
	
	public void applyGravity() {
		vel.translate(Constants.GRAVITY.scale(1/(double) Constants.UPDATES_PER_SEC));
	}
	
	public void move() {
		translate(vel.scale(1/(double) Constants.UPDATES_PER_SEC));
	}
}
