package game;
import javax.swing.JFrame;
import constants.Constants;
import implementaion.Implementor;
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
	
	private JFrame frame;
		
	/** 
	 * Default constructor, creates an empty world
	 */
	public Game(Implementor imp) {	
		this.world = new World();
		this.state = State.LOADING;
		GUI = new Gui(this);
		frame = new JFrame();
		frame.setTitle("Game");
		frame.setSize(1000, 1000);
		frame.add(GUI);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.state = State.RUNNING;
	}
	
	
	public void main() {
		while(state != State.FINISHED) {
			update();	
			try {
				Thread.sleep(10);
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
			break;
		case RUNNING:
			if(InputListener.isKeyNewPressed('p')) {
				state = State.PAUSED;
			}
			world.update();
			//world.draw(GUI.getGraphics());
			GUI.update(world.getButtons());
			break;
		case PAUSED:
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
			break;
		case FINISHED: 
			world.disable();
			break;
			//TODO Graphically close the game
		}
	}
	
	public void buttonClicked(AbstractButton button){
		
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
	public State getGameState() {
		return state;
	}
}
