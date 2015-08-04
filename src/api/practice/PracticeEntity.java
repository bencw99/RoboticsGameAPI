package api.practice;

import java.awt.Dimension;

import api.entity.*;
import api.game.*;
import api.input.InputListener;
import api.physics.*;

public class PracticeEntity extends Entity {
	public PracticeEntity(Game game) {
		super(game);
	}

	@Override
	public void init() {
		Position pos = new Position(200, 200);
		setPos(pos);
		
		Dimension dim = new Dimension(50, 50);
		setDim(dim);
		
		spritesArray = new Object[]{"black", "images/preset/black.png", "red", "images/preset/red.png", "green", "images/preset/green.jpg"};
		loadSprites();
		
		activeSprite = "black";
	}

	@Override
	public void update() {
		if(InputListener.isKeyPressed('d')) {
			translateX(2);
		}
		
		if(InputListener.isKeyPressed('a')) {
			translateX(-2);
		}
		
		if(InputListener.isKeyPressed('s')) {
			translateY(2);
		}
		
		if(InputListener.isKeyPressed('w')) {
			translateY(-2);
		}
	}

	@Override
	public void disable() {
		
	}
}
