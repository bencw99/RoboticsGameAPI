package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JPanel;

import spriteless.SpritelessElement;
import constants.Constants;
import entity.Entity;

/**
 * A screen is a JPanel, shows various entities and non-entities
 *
 */
public class Screen extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<SpritelessElement> spritelessElements = new ArrayList<SpritelessElement>();

	/**
	 * Update being called means this is the current screen, so updates all
	 * entities/spriteless elements
	 */
	public void update() {
		for (Entity ent : entities) {
			ent.update();
		}
		for (SpritelessElement se : spritelessElements) {
			se.update();
		}
		super.repaint();
	}
	
	/**
	 * Initializes this screen, making it visible
	 * And setting its dimensions to the default in constants
	 */
	public void init() {
		setVisible(true);
		setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		setBackground(Color.WHITE);
	}

	/**
	 * Redraws the screens
	 * 
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (Entity entity : entities) {
				entity.draw(g);
			}
		} catch (ConcurrentModificationException e) {
		}
	}

	/**
	 * Allows you to add an entity to the screen
	 * 
	 * @param ent
	 */
	public void add(Entity ent) {
		entities.add(ent);
	}

	/**
	 * Add a spriteless element to the screen
	 */
	public void add(SpritelessElement se) {
		spritelessElements.add(se);
		super.add((Component) se);
	}

	/**
	 * Remove an entity from the current Screen
	 * 
	 * @param ent
	 *            the entity to remove
	 */
	public void remove(Entity ent) {
		ent.disable();
		entities.remove(ent);
	}

	/**
	 * Remove an spriteless element from this screen
	 * 
	 * @param ent
	 *            the entity to remove
	 */
	public void remove(SpritelessElement ent) {
		ent.disable();
		spritelessElements.remove(ent);
		super.remove((Component) ent);
	}

	/**
	 * Returns entity list
	 * 
	 * @return ArrayList containing all entities in this screen
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	/**
	 * Returns the SpritelessElements
	 * @return ArrayList containing all SpritelessElements of the screen
	 */
	public ArrayList<SpritelessElement> getSpritelessElements() {
		return spritelessElements;
	}
	
	/**
	 * Removes all entities and elements from this screen
	 */
	public void reset() {
		for(Entity ent : entities) {
			this.remove(ent);
		}
		for(SpritelessElement element : spritelessElements) {
			this.remove(element);
		}
	}
	
	/**
	 * Disables all the entities and elements in this screen
	 * Can be reactivated
	 */
	public void disable() {
		for (Entity entity : entities) {
			entity.disable();
		}
		for (SpritelessElement e : spritelessElements) {
			e.disable();
		}
	}
}
