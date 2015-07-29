package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import spriteless.SpritelessElement;
import entity.Entity;

/**
 * A screen is a JPanel, shows various entities and non-entities
 *
 */
public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Entity> entities;
	private ArrayList<SpritelessElement> spritelessElements;

	private String screenName;

	public Screen(String screenName) {
		super();
		this.screenName = screenName;
		entities = new ArrayList<Entity>();
		spritelessElements = new ArrayList<SpritelessElement>();
	}

	public String getName() {
		return screenName;
	}

	/**
	 * Update being called means this is the current screen, so updates all
	 * entities/non-entities
	 */
	public void update() {
		for (Entity ent : entities) {
			ent.update();
		}
		for (SpritelessElement ent : spritelessElements) {
			ent.update();
		}
		updateGui();
	}

	/**
	 * Adds in missing gui elements if new ones are added
	 */
	public void updateGui() {
		for (SpritelessElement e : spritelessElements) {
			if (!contains(e, getComponents())) {
				try {
					add((Component) e);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	/**
	 * Helper method Checks if key is in list
	 * 
	 * @param key
	 * @param list
	 * @return true if yes
	 */
	private boolean contains(Object key, Object[] list) {
		for (Object o : list) {
			if (o.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Redraws the screens
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		try {
			for (Entity entity : entities) {
				entity.draw(g);
			}
		} catch (ConcurrentModificationException e) {
		}
		repaint();
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
	 * Add a non entity to the screen
	 */
	public void add(SpritelessElement ent) {
		spritelessElements.add(ent);
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
	 * Remove an nonEntity from this world
	 * 
	 * @param ent
	 *            the entity to remove
	 */
	public void remove(SpritelessElement ent) {
		ent.disable();
		spritelessElements.remove(ent);
	}

	/**
	 * Returns entity list
	 * 
	 * @return
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public ArrayList<SpritelessElement> getNonEntities() {
		return spritelessElements;
	}

	public void disable() {
		for (Entity entity : entities) {
			entity.disable();
		}
		for (SpritelessElement e : spritelessElements) {
			e.disable();
		}
	}
}
