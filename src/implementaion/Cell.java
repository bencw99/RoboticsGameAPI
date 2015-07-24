package implementaion;

import entity.Wall;
import game.Game;
import physics.Dimension;
import physics.Position;
import constants.Constants;

public class Cell {
	private Game game;
	/**
	 * Position of Cell
	 */
	private Position position;
	/**
	 * Dimension of cell
	 */
	private Dimension dimension;
	/**
	 * Northern wall
	 */
	private Wall northWall;
	/**
	 * Northern wall's visibility
	 */
	private boolean northWallVisible;
	/**
	 * Southern wall
	 */
	private Wall southWall;
	/**
	 * Southern wall's visibility
	 */
	private boolean southWallVisible;
	/**
	 * Western wall
	 */
	private Wall westWall;
	/**
	 * Western wall's visibility
	 */
	private boolean westWallVisible;
	/**
	 * Eastern wall
	 */
	private Wall eastWall;
	/**
	 * Eastern wall's visibility
	 */
	private boolean eastWallVisible;
	/**
	 * Fill wall
	 */
	private Wall fillWall;
	/**
	 * Fill's visibility
	 */
	private boolean fillWallVisible;
	/**
	 * Initializer
	 * @param p (Position of Cell)
	 * @param d (Dimension of Cell)
	 */
	public Cell(Game game, Position p, Dimension d) {
		this.position = p;
		this.dimension = d;
		this.game = game;
		northWall = new Wall();
		northWall.setAngle(0);
		northWall.setPos(p);
		northWall.setDim(new Dimension(d.getWidth(), Constants.DEFAULT_WALL_WIDTH));
		southWall = new Wall();
		southWall.setAngle(0);
		southWall.setPos(new Position(p.getX(), p.getY()+d.getHeight()));
		southWall.setDim(new Dimension(d.getWidth(), Constants.DEFAULT_WALL_WIDTH));
		westWall = new Wall();
		westWall.setPos(p);
		westWall.setAngle(90);
		westWall.setDim(new Dimension(Constants.DEFAULT_WALL_WIDTH, d.getHeight()));
		eastWall = new Wall();
		eastWall.setAngle(90);
		eastWall.setPos(new Position(p.getX() + d.getWidth(), d.getHeight()));
		fillWall = new Wall();
		fillWall.setAngle(0);
		fillWall.setPos(p);
		fillWall.setDim(d);
		northWallVisible = false;
		southWallVisible = false;
		eastWallVisible = false;
		westWallVisible = false;
		fillWallVisible = false;
	}
	
	//Getters / Setters
	/**
	 * Returns the position of this Cell
	 * @return
	 */
	public Position getPosition(){
		return position;
	}
	/**
	 * Returns the dimension of this Cell
	 * @return
	 */
	public Dimension getDimension(){
		return dimension;
	}
	/**
	 * Returns the game
	 * @return
	 */
	public Game getGame(){
		return game;
	}
	/**
	 * Returns the northern wall
	 * @return
	 */
	public Wall getNorthernWall(){
		return northWall;
	}
	/**
	 * Returns the southern wall
	 * @return
	 */
	public Wall getSouthernWall(){
		return southWall;
	}
	/**
	 * Returns the western wall
	 * @return
	 */
	public Wall getWesternWall(){
		return westWall;
	}
	/**
	 * Returns the eastern wall
	 * @return
	 */
	public Wall getEasternWall(){
		return eastWall;
	}
	/**
	 * Returns the fill wall
	 * @return
	 */
	public Wall getFillWall(){
		return fillWall;
	}
	/**
	 * Returns if the northern wall is visible
	 * @return
	 */
	public boolean isNorthernWallVisible(){
		return northWallVisible;
	}
	/**
	 * Returns if the southern wall is visible
	 * @return
	 */
	public boolean isSouthernWallVisible(){
		return southWallVisible;
	}
	/**
	 * Returns if the western wall is visible
	 * @return
	 */
	public boolean isWesternWallVisible(){
		return westWallVisible;
	}
	/**
	 * Returns if the eastern wall is visible
	 * @return
	 */
	public boolean isEasternWallVisible(){
		return eastWallVisible;
	}
	/**
	 * Returns if the fill wall is visible
	 * @return
	 */
	public boolean isFillWallVisible(){
		return fillWallVisible;
	}
	/**
	 * Sets the position to position
	 * @param position
	 */
	public void setPosition(Position position){
		this.position = position;
	}
	/**
	 * Sets the dimension to dimension
	 * @param dimension
	 */
	public void setDimension(Dimension dimension){
		this.dimension = dimension;
	}
	/**
	 * Sets the game
	 * @param game
	 */
	public void setGame(Game game){
		this.game = game;
	}
	/**
	 * Sets the northern wall
	 * @param northWall
	 */
	public void setNorthernWall(Wall northWall){
		this.northWall = northWall;
	}
	/**
	 * Sets the southern wall
	 * @param southWall
	 */
	public void setSouthernWall(Wall southWall){
		this.southWall = southWall;
	}
	/**
	 * Sets the western wall
	 * @param westWall
	 */
	public void setWesternWall(Wall westWall){
		this.westWall = westWall;
	}
	/**
	 * Sets the eastern wall
	 * @param eastWall
	 */
	public void setEasternWall(Wall eastWall){
		this.eastWall = eastWall;
	}
	/**
	 * Sets the fill wall
	 * @param fillWall
	 */
	public void setFillWall(Wall fillWall){
		this.fillWall = fillWall;
	}
	/**
	 * Sets the walls visibility
	 * @param visible
	 */
	public void setSouthernWallVisibility(boolean visible){
		if(!this.southWallVisible == visible){
			if(visible){
				game.add(southWall);
			}
			else{
				game.remove(southWall);
			}
		}
	}
	/**
	 * Sets the walls visibility
	 * @param visible
	 */
	public void setWesternWallVisibility(boolean visible){
		if(!this.westWallVisible == visible){
			if(visible){
				game.add(westWall);
			}
			else{
				game.remove(westWall);
			}
		}
	}
	/**
	 * Sets the walls visibility
	 * @param visible
	 */
	public void setEasternWallVisibility(boolean visible){
		if(!this.eastWallVisible == visible){
			if(visible){
				game.add(eastWall);
			}
			else{
				game.remove(eastWall);
			}
		}
	}
	/**
	 * Sets the walls visibility
	 * @param visible
	 */
	public void setNorthernWallVisibility(boolean visible){
		if(!this.northWallVisible == visible){
			if(visible){
				game.add(northWall);
			}
			else{
				game.remove(northWall);
			}
		}
	}
	/**
	 * Sets the walls visibility
	 * @param visible
	 */
	public void setFillWallVisibility(boolean visible){
		if(!this.fillWallVisible == visible){
			if(visible){
				game.add(fillWall);
			}
			else{
				game.remove(fillWall);
			}
		}
	}
}
