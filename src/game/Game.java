package game;
//Paly Robotics - Team 8
//Game API

import input.InputListener;

import javax.swing.JFrame;

import constants.Constants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import entity.*;
import gui.Screen;
import addons.*;

public class Game {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Stores all the different game screens and which
	 * screen is currently being used
	 */
	ArrayList<Screen> screens;
	Screen currentScreen;
	
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
		screens = new ArrayList<Screen>();
		initScreens();
		initFrame();
	}
	/**
	 * Initializes frame
	 */
	private void initFrame() {
		inputListener = new InputListener();
		currentScreen.setTitle("Paly Robotics Team 8 - Programming - Game API");
		currentScreen.setSize(1000, 1000);
		currentScreen.setVisible(true);
		currentScreen.setLayout(null);
		currentScreen.setLocationRelativeTo(null);
		currentScreen.setResizable(false);
		currentScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentScreen.addKeyListener(inputListener);
		currentScreen.addMouseListener(inputListener);
		currentScreen.setName("Robotics Game API - GUI");
		currentScreen.setBackground(Color.WHITE);
	}

	/**
	 * Runs the game
	 */
	private void initScreens() {
		Screen start = new Screen("START");
		Screen paused = new Screen("PAUSED");
		Screen finished = new Screen("FINISHED");
		currentScreen = start;
		//TODO Add the actual game screen text/buttons/etc
		screens.add(start);
		screens.add(paused);
		screens.add(finished);
	}
	/**
	 * Adds screens to the game
	 */
	public void addScreen(Screen screen) {
		screens.add(screen);
	}
	
	/**
	 * Get available screens
	 */
	public ArrayList<Screen> getScreens() {
		return screens;
	}

	/**
	 * Switches the current screen
	 */
	public void switchScreen(String screenName) {
		currentScreen.disable();
		for(Screen screen : screens) {
			if(screen.getName() == screenName) {
				currentScreen = screen;
			}
		}
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
	 * @return the frame
	 */
	public JFrame getFrame() {
		return currentScreen;
	}
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
		ent.disable();
		currentScreen.remove(ent);
	}

	/**
	 * Returns entity list
	 * @return
	 */
	public ArrayList<Entity> getEntities() {
		return currentScreen.getEntities();
	}
}