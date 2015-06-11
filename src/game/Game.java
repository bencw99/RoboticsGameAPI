package game;

import input.*;
import world.*;

/**
 * The class describing a game
 */
public class Game {
	/** The state enum of the game class **/
	public static enum State {
		WAITING,
		RUNNING,
		PAUSED,
		FINISHED
	}
	
	/** The world associated with this game **/
	private World world;
	
	/** The state of this game **/
	private State state;
	
	/** 
	 * Default constructor, creates an empty world
	 */
	public Game() {
		this.world = new World();
		this.state = State.WAITING;
	}
	
	/** 
	 * Updates this game
	 */
	public void update() {
		switch(state) {
		case WAITING: {
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
		}
		case RUNNING: {
			if(InputListener.isKeyPressed('p')) {
				state = State.PAUSED;
			}
			world.update();
		}
		case PAUSED: {
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
		}
		case FINISHED: {

		}
		
		}
	}

	/**
	 * @return the world
	 */
	public World getWorld()
	{
		return world;
	}

	/**
	 * @return the state
	 */
	public State getState()
	{
		return state;
	}
}
