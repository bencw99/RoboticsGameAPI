//Paly Robotics - Team 8
//Game API

import input.InputListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Constants;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

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

	//Constructors

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

	//Methods

	/**
	 * Runs the game
	 */
	public void run(){
		while(state == State.RUNNING || state == State.PAUSED){
			update();
			try {
				Thread.sleep(1000 / (int) Constants.UPDATES_PER_SEC);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}
	/**
	 * Updates the game
	 */
	public void update(){
		if(state == State.RUNNING){
			if(InputListener.isKeyPressed('p')) {
				state = State.PAUSED;
			}
			updateWorld();
			updateGUI();
		}
		else{
			if(InputListener.isKeyPressed(' ')) {
				state = State.RUNNING;
			}
		}
	}
	/**
	 * Update world
	 */
	public void updateWorld(){
		for(Entity ent : entities){
			ent.update();
		}
		for(NonEntityElements ent : nonEntities){
			ent.update();
		}
	}
	/**
	 * Updates GUI
	 */
	public void updateGUI(){
		//If the component is not in the list, add it
		for(NonEntityElements e : nonEntities){
			if(!contains(e, getComponents())){
				//If component is not type Component
				try{
					add((Component)e);
				}
				catch(Exception exception){
					exception.printStackTrace();
				}
			}
		}
	}
	public boolean contains(Object key, Object[] list){
		for(Object o : list){
			if(o.equals(key)){
				return true;
			}
		}
		return false;
	}
}