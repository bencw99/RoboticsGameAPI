package entity;

import physics.*;

public class Entity {
	/** The position of this entity */
	private Position pos;
	/** The dimensions of this entity */
	private Dimension dim;

	public void init() {
		//TODO
	}

	public void disable() {
		//TODO
	}
	
	public Entity() {
		this.setPos(new Position());
	}

	/**
	 * @return the position
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * @param pos the position to set
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * @return the dim
	 */
	public Dimension getDim() {
		return dim;
	}

	/**
	 * @param dim the dimension to set
	 */
	public void setDim(Dimension dim) {
		this.dim = dim;
	}
}
