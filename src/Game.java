//Paly Robotics - Team 8
//Game API

import input.InputListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
	/**
	 *	The possible states the game can be in
	**/
	public static enum State{
		RUNNING,
		PAUSED,
		FINISHED
	}
	/**
	 *	The current state of the game
	**/
	private State state;
	/**
	 *	A frame that will contain the game
	**/
	private JFrame frame;
	/**
	 * Input Listener
	 */
	private InputListener inputListener;
	/**
	 * Default constructor, creates an empty world
	 */
	public Game(){
		initFrame();
	}
	/**
	 * Initializes frame
	 */
	public void initFrame(){
		inputListener = new InputListener();
		frame = new JFrame();
		frame.setTitle("Paly Robotics Team 8 - Programming - Game API");
		frame.setSize(1000, 1000);
		frame.add(this);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(inputListener);
		frame.addMouseListener(inputListener);
		
	}
}