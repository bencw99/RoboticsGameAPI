package game;

import javax.swing.JPanel;

import constants.Constants;
import input.*;
import world.*;
import gui.*;

/**
 * The class that starts up the game
 */
public class Game{
	//A Listener for this.buttonClicked(Button caller)
	private Listener<gui.Button> buttonClickedListenerInstance = new ButtonClickedListener<gui.Button>(this);
	/** The state enum of the game class **/
	public static enum State {
		LOADING,
		RUNNING,
		PAUSED,
		FINISHED
	}
	
	/** The world associated with this game **/
	private World world;
	
	/** The state of this game **/
	private State state;
	
	private Gui GUI;
	/** 
	 * Default constructor, creates an empty world
	 */
	public Game() {
		this.world = new World();
		this.state = State.LOADING;
		GUI = new Gui();
	}
	
	public void addButton(int x, int y, int width, int height, String text){
		GUI.addButton(buttonClickedListenerInstance, x, y, width, height, text);
	}
	
	public void main() {
		Game game = new Game();
		while(game.state != State.FINISHED) {
			game.update();	
			try {
				Thread.sleep(1000/Constants.UPDATES_PER_SEC);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}
	
	/** 
	 * Updates this game
	 */
	public void update() {
		//Different keys pressed to start stuff
		switch(state) {
		case LOADING:
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
		case RUNNING:
			if(InputListener.isKeyNewPressed('p')) {
				state = State.PAUSED;
			}
			world.update();
		case PAUSED:
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
		case FINISHED: 
			world.disable();
			//TODO Graphically close the game
		}
	}
	
	//to be completed
	public void buttonClicked(gui.Button button){
		
	}
	/**
	 * @return the world object
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @return the state of the game
	 */
	public State getState() {
		return state;
	}
}
