package game;
//Paly Robotics - Team 8
//Game API

import input.InputListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Constants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

import entity.*;
import gui.Screen;
import addons.*;

public class Game extends JFrame {
	
	/**
	 * Stores all the different game screens and which
	 * screen is currently being used
	 */
	ArrayList<Screen> screens = new ArrayList<Screen>();
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
		initFrame();
		initGUI();
		initScreens();
	}
	/**
	 * Initializes frame
	 */
	private void initFrame() {
		inputListener = new InputListener();
		super.setTitle("Paly Robotics Team 8 - Programming - Game API");
		super.setSize(1000, 1000);
		super.add(this);
		super.setVisible(true);
		super.setLayout(null);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.addKeyListener(inputListener);
		super.addMouseListener(inputListener);
	}
	/**
	 * Initializes GUI
	 */
	private void initGUI() {
		setVisible(true);
		setName("Robotics Game API - GUI");
		setBackground(Color.WHITE);
	}
	/**
	 * Adds default start, paused, and finished screens
	 */
	private void initScreens() {
		Screen start = new Screen("START");
		Screen paused = new Screen("PAUSED");
		Screen finished = new Screen("FINISHED");
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
	/**
	 * Updates the game
	 */
	public void update() {
		currentScreen.update();
	}
	
	/**
	 * Disables the game
	 */
	public void disable() {
		switchScreen("FINISHED");
	}

	//Getters / Setters
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return this;
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
	/**
	 * Adds nonEntity to the current screen
	 * @param ent	non entity to add
	 */
	public void add(NonEntityElements ent){
		ent.init();
		currentScreen.add(ent);
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
	 * Remove an nonEntity from this world
	 * 
	 * @param ent	the entity to remove
	 */
	public void remove(NonEntityElements ent) {
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
	public ArrayList<NonEntityElements> getNonEntities() {
		return currentScreen.getNonEntities();
	}
}