package api.entity;

import api.game.Game;
import api.input.InputListener;

import java.awt.Dimension;
import api.physics.Position;

public class TopDownEntity extends Entity {

	public static final double VERTICAL_SPEED = 1;
	public static final double HORIZONTAL_SPEED = 1;
	
	@Override
	public void init() {
		setDim(new Dimension(16, 16));
		spritesArray = new Object[]{"Black Square", "images/preset/black.png"};
		loadSprites();
		activeSprite = "Black Square";
	}

	public TopDownEntity(Game game, Position pos, double angle, Dimension dim) {
		super(game, pos, angle, dim);
	}

	public TopDownEntity(Game game) {
		super(game);
	}

	public TopDownEntity(String name, Game game, Position pos, double angle,
			Dimension dim) {
		super(name, game, pos, angle, dim);
	}

	public TopDownEntity(String name, Game game) {
		super(name, game);
	}

	@Override
	public void update() {		
		if(InputListener.isKeyPressed('w')){
			translateY(-VERTICAL_SPEED);
		}
		if(InputListener.isKeyPressed('s')){
			translateY(VERTICAL_SPEED);
		}
		if(InputListener.isKeyPressed('a')){
			translateX(-HORIZONTAL_SPEED);
		}
		if(InputListener.isKeyPressed('d')){
			translateX(HORIZONTAL_SPEED);
		}
	}

	@Override
	public void disable() {		
	}

}
