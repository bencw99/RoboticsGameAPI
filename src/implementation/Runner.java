package implementation;

import java.awt.Dimension;

import constants.Constants;
import entity.Entity;
import game.Game;
import input.InputListener;
import physics.Position;

public class Runner extends Entity{
	Runner(Position pos, double angle, Dimension dim, Game game){
		super(game, pos, angle, dim);
	}
	public void init() {
		spritesArray = new Object[]{"happy", "images/skull-transparent.png", 50, "death", "images/happy.jpg"};
		loadSprites();
		activeSprite = "happy";
		
	}

	@Override
	public void update() {
		if(InputListener.isKeyNewPressed('w')){
			if(getY() > 0){
				this.setPos(new Position(getX(), getY() - Constants.DEFAULT_CELL_HEIGHT));
				if(doesCollideWithType("Entity.wall")){
					this.setPos(new Position(getX(), getY() + Constants.DEFAULT_CELL_HEIGHT));
				}
			}	
				
		}
		if(InputListener.isKeyNewPressed('s')){
			if(getY() < getGame().getHeight() - Constants.DEFAULT_CELL_HEIGHT){
				this.setPos(new Position(getX(), getY() + Constants.DEFAULT_CELL_HEIGHT));
				if(doesCollideWithType("Entity.wall")){
					this.setPos(new Position(getX(), getY() - Constants.DEFAULT_CELL_HEIGHT));
				}
			}
		}
		if(InputListener.isKeyNewPressed('a')){
			if(getX() > 0){
				this.setPos(new Position(getX() - Constants.DEFAULT_CELL_WIDTH, getY()));
				if(doesCollideWithType("Entity.wall")){
					this.setPos(new Position(getX() + Constants.DEFAULT_CELL_WIDTH, getY()));
				}
			}
		}
		if(InputListener.isKeyNewPressed('d')){
			if(getX() < getGame().getWidth() - Constants.DEFAULT_CELL_WIDTH){
				this.setPos(new Position(getX() + Constants.DEFAULT_CELL_WIDTH, getY()));
				if(doesCollideWithType("Entity.wall")){
					this.setPos(new Position(getX() - Constants.DEFAULT_CELL_WIDTH, getY()));
				}
			}
		}
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
	
}