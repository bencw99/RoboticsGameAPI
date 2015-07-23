package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JPanel;

import addons.NonEntityElements;
import entity.Entity;

/**
 * A screen is a JPanel, shows various entities and non-entities
 *
 */
public class Screen extends JPanel {
	/**
	 * A list of entities in the Game
	 */
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	/**
	 * A list of non-entities in the Game (buttons, timers, etc)s
	 */
	private ArrayList<NonEntityElements> nonEntities = new ArrayList<NonEntityElements>();

	private String screenName;

	public Screen(String screenName) {
		super();
		this.screenName = screenName;
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
		for (NonEntityElements ent : nonEntities) {
			ent.update();
		}
		updateGui();
	}

	/**
	 * Adds in missing gui elements if new ones are added
	 */
	public void updateGui() {
		// If the component is not in the list, add it
		for (NonEntityElements e : nonEntities) {
			if (!contains(e, getComponents())) {
				// If component is not type Component
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
			// ignored, this is caught at the beginner of entity loading
		}
		repaint();
	}

	// ADDITION AND REMOVAL OF ELEMENTS
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
	public void add(NonEntityElements ent) {
		nonEntities.add(ent);
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
	public void remove(NonEntityElements ent) {
		ent.disable();
		nonEntities.remove(ent);
	}

	/**
	 * Returns entity list
	 * 
	 * @return
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public ArrayList<NonEntityElements> getNonEntities() {
		return nonEntities;
	}

	public void disable() {
		for (Entity entity : entities) {
			entity.disable();
		}
		for (NonEntityElements e : nonEntities) {
			e.disable();
		}
	}
}
