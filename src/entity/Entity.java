package entity;

import physics.*;

public class Entity {
	private Position pos;

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
}
