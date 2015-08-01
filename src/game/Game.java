package game;

import input.InputListener;

import javax.swing.JFrame;

import spriteless.*;
import constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;

import entity.*;
import gui.Screen;

public class Game extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Stores all the different game screens and which
	 * screen is currently being used
	 */
	HashMap<String, Screen> screens = new HashMap<String, Screen>();
	private Screen currentScreen;
	
	/**
	 * Input Listener
	 */
	private InputListener inputListener;



	//Constructors
	/**
	 * Default constructor, creates an empty world
	 */
	public Game() {
		super();
		initScreens();
		initFrame();
	}
	/**
	 * Initializes frame
	 */
	private void initFrame() {
		inputListener = new InputListener();
		setTitle("Paly Robotics Team 8 - Game");
		setResizable(false);
		setVisible(true);
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(inputListener);
		addMouseListener(inputListener);
		add(currentScreen);
	}

	/**
	 * Runs the game
	 */
	private void initScreens() {
		screens.put("START", new Screen());
		screens.put("PAUSED", new Screen());
		screens.put("FINISHED", new Screen());
		
		screens.get("START").init();
		
		currentScreen = screens.get("START");
	}
	/**
	 * Adds screens to the game
	 */
	public void addScreen(String screenName, Screen screen) {
		screens.put(screenName, screen);
	}
	
	/**
	 * Wipes the screen with screenName of all Elements/Entities
	 * @return false if the screenName is invalid
	 */
	public boolean resetScreen(String screenName) {
		if(screens.containsKey(screenName)) {
			screens.get(screenName).reset();
			return true;
		}
		return false;
	}
	
	/**
	 * Get available screens
	 */
	public HashMap<String, Screen> getScreens() {
		return screens;
	}

	/**
	 * Switches the current screen
	 * @return false if screenName was invalid
	 */
	public boolean setCurrentScreen(String screenName) {
		if(screens.containsKey(screenName)) {
			remove(currentScreen);
			currentScreen = screens.get(screenName);
			add(currentScreen);
			return true;
		}
		return false; 
	}
			
	//Methods

	/**
	 * Runs the game
	 */
	public void run() {
		while(true) {
			update();
			try {
				Thread.sleep(1000 / (int) Constants.UPDATES_PER_SEC);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}

	public void update() {
		currentScreen.update();
	}

	public void disbale() {
		currentScreen.disable();
	}
	
	//Getters / Setters
	
	/**
	 * @return the listener
	 */
	public InputListener getListener() {
		return inputListener;
	}
	/**
	 * Adds entity to the current screen
	 * @param ent	entity to add
	 */
	public void add(Entity ent) {
		ent.init();
		currentScreen.add(ent);
	}
	
	public void add(SpritelessElement se) {
		se.init();
		currentScreen.add(se);
	}

	/**
	 * Remove an entity from the current Screen
	 * 
	 * @param ent	the entity to remove
	 */
	public void remove(Entity ent) {
		currentScreen.remove(ent);
	}
	
	/**
	 * Returns entity list
	 * @return
	 */
	public ArrayList<Entity> getEntities() {
		return currentScreen.getEntities();
	}
	
	public Screen getCurrentScreen() {
		return currentScreen;
	}

}