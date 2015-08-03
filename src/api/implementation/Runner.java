package api.implementation;

import java.awt.Dimension;

import api.constants.Constants;
import api.entity.Entity;
import api.game.Game;
import api.input.InputListener;
import api.physics.Position;

public class Runner extends Entity{
	public Position start = new Position(Constants.DEFAULT_CELL_WIDTH / 2, Constants.DEFAULT_CELL_HEIGHT / 2);
	
	Runner(Position pos, double angle, Dimension dim, Game game){
		super(game, pos, angle, dim);
	}
	
	public void init() {
		spritesArray = new Object[]{"black", "images/preset/red.png"};
		loadSprites();
		activeSprite = "black";
		
	}

	@Override
	public void update() {
		if(InputListener.isKeyPressed('w')){
			if(getY() > 0){
				this.setPos(new Position(getX(), getY() - 1));
				if(doesCollideWithType("entity.Wall")){
					this.setPos(start);
				}
			}	
				
		}
		if(InputListener.isKeyPressed('s')){
			if(getY() < getGame().getHeight() - Constants.DEFAULT_CELL_HEIGHT){
				this.setPos(new Position(getX(), getY() + 1));
				if(doesCollideWithType("entity.Wall")){
					this.setPos(start);
				}
			}
		}
		if(InputListener.isKeyPressed('a')){
			if(getX() > 0){
				this.setPos(new Position(getX() - 1, getY()));
				if(doesCollideWithType("entity.Wall")){
					this.setPos(start);
				}
			}
		}
		if(InputListener.isKeyPressed('d')){
			if(getX() < getGame().getWidth() - Constants.DEFAULT_CELL_WIDTH){
				this.setPos(new Position(getX() + 1, getY()));
				if(doesCollideWithType("entity.Wall")){
					this.setPos(start);
				}
			}
		}
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
	
}