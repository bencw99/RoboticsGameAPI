package implementaion;
import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;

public class Mazerunner extends Implementor {
	/**
	 * The first method called in the program (After Run.java)
	 * Initialize everything here
	 */
	public void main() {
		Man man = new Man(new Position(CELL_WIDTH/2,CELL_HEIGHT/2), 0, new Dimension(CELL_WIDTH, CELL_HEIGHT), game);
		game.add(man);
		for(Cell[] CELLS : cells){
			for(Cell c : CELLS){
				int random = (int)(Math.random() * 4);
				switch(random){
				case 0:
					c.setNorthernWallVisibility(true);
					break;
				case 1:
					c.setSouthernWallVisibility(true);
					break;
				case 2:
					c.setWesternWallVisibility(true);
					break;
				case 3:
					c.setEasternWallVisibility(true);
					break;
				}
			}
		}
	}
	public class Man extends Entity{
		Man(){
			super();
		}
		Man(Position pos, double angle, Dimension dim, Game game){
			super(pos, angle, dim, game);
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
					this.setPos(new Position(getX(), getY() - CELL_HEIGHT));
					if(collidesWithEntity()){
						this.setPos(new Position(getX(), getY() + CELL_HEIGHT));
					}
				}	
					
			}
			if(InputListener.isKeyNewPressed('s')){
				if(getY() < getGame().getHeight() - CELL_HEIGHT){
					this.setPos(new Position(getX(), getY() + CELL_HEIGHT));
					if(collidesWithEntity()){
						this.setPos(new Position(getX(), getY() - CELL_HEIGHT));
					}
				}
			}
			if(InputListener.isKeyNewPressed('a')){
				if(getX() > 0){
					this.setPos(new Position(getX() - CELL_WIDTH, getY()));
					if(collidesWithEntity()){
						this.setPos(new Position(getX() + CELL_WIDTH, getY()));
					}
				}
			}
			if(InputListener.isKeyNewPressed('d')){
				if(getX() < getGame().getWidth() - CELL_WIDTH){
					this.setPos(new Position(getX() + CELL_WIDTH, getY()));
					if(collidesWithEntity()){
						this.setPos(new Position(getX() - CELL_WIDTH, getY()));
					}
				}
			}
		}

		@Override
		public void disable() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
