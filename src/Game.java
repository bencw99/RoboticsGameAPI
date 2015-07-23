//Paly Robotics - Team 8
//Game API

import input.InputListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.ArrayList;

import entity.*;
import addons.*;

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
	 * A list of entities in the Game
	 */
	private ArrayList<Entity> entities;
	/**
	 * A list of non-entities in the Game
	 * (buttons, timers, etc)s
	 */
	private ArrayList<NonEntityElements> nonEntities;
	/**
	 * Default constructor, creates an empty world
	 */
	public Game(){
		super();
		initFrame();
		initGUI();
		initWorld();
		state = State.RUNNING;
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
	/**
	 * Initializes GUI
	 */
	public void initGUI(){
		setVisible(true);
		setName("Robotics Game API - GUI");
		setBackground(Color.WHITE);
	}
	/**
	 * Initializes world
	 */
	public void initWorld(){
		entities = new ArrayList<Entity>();
		nonEntities = new ArrayList<NonEntityElements>();
	}
}