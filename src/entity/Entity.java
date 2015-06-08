package entity;

import physics.*;

public class Entity {
	/** The position of this Entity instance */
	private Position pos;

	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Entity(Position pos) {
		this.pos = pos;
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
