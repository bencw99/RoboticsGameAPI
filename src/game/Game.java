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
	/**
	 * A reference to the current screen
	 */
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
		screens.get("PAUSED").init();
		screens.get("FINISHED").init();

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
			super.validate();
			return true;
		}
		return false; 
	}
	
	/**
	 * Returns name of requested screen
	 */
	public String getScreenName(Screen screen) {
		for(String name : screens.keySet()) {
			if(screens.get(name).equals(screen)) {
				return name;
			}
		}
		return null;
	}
	
	/**
	 * Gets the current screen of the game
	 * 
	 * @return the current screen of the game
	 */
	public Screen getCurrentScreen() {
		return currentScreen;
	}
	
	/**
	 * Returns reference to screen with specified name
	 */
	public Screen getScreenWithName(String name) {
		return screens.get(name);
	}

	//Methods

	/**
	 * Runs the game
	 */
	public void run() {
		while(true) {
			long start = System.currentTimeMillis();
			update();
			long diff = System.currentTimeMillis() - start;
			long timeToSleep = (1000 / (int) Constants.UPDATES_PER_SEC) - diff;
			if(timeToSleep > 0) {
				try {
					Thread.sleep(timeToSleep);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * update the current screen
	 */
	public void update() {
		currentScreen.update();
	}
	/**
	 * disable the current screen
	 */
	public void disable() {
		currentScreen.disable();
	}

	//Getters / Setters

	/**
	 * @return the listener (key listener)
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
	
	/**
	 * Adds spriteless element to current screen
	 * @param se SpritelessElement to add
	 */
	public void add(SpritelessElement se) {
		se.init();
		currentScreen.add(se);
	}
	
	/**
	 * Adds entity to specified screen
	 * @param ent entity to add
	 * @param screen screen to add to
	 */
	public void add(Entity ent, Screen screen) {
		ent.init();
		screen.add(ent);
	}
	
	/**
	 * Adds spriteless element to specified screen
	 * @param se spriteless element to add
	 * @param screen screen to add to
	 */
	public void add(SpritelessElement se, Screen screen) {
		se.init();
		screen.add(se);
	}

	/**
	 * Remove an entity from the current screen
	 * @param ent	the entity to remove
	 */
	public void remove(Entity ent) {
		currentScreen.remove(ent);
	}

	/**
	 * Returns all the entities currently on the current screen
	 * @see getCurrentScreen()
	 * @return entities
	 */
	public ArrayList<Entity> getEntities() {
		return currentScreen.getEntities();
	}
<<<<<<< HEAD
	
	/**
	 * Returns a reference to the current screen shown. The screen keeps 
	 * a reference to all the existing objects on screen. 
	 * @see Screen
	 * @return the current screen shown
	 */
	public Screen getCurrentScreen() {
		return currentScreen;
	}
=======
>>>>>>> 7d5f6c817abf8cbb9532587dd65f17209c632d2b

}