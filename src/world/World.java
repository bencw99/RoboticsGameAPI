
	/**
	 * Disables this world instance
	 */
	public void disable() {
		for(Entity entity : entities) {
			entity.update();
		}
	}
	
	/**
	 * Draws this Entity on to the given graphics object
	 * 
	 * @param g the graphics object to be drawn on
	 */
	public void draw(Graphics g) {
		try{
			for(Entity entity : entities) {
				entity.draw(g);
			}
		}
		catch (ConcurrentModificationException e){
			// ignored, this is caught at the beginner of entity loading
		}
	}
	
	/**
	 * Add an entity to this world
	 * 
	 * @param ent	the entity to add
	 */
	public void add(Entity ent) {
		ent.init();
		ent.setWorld(this);
		entities.add(ent);
		ent.setWorld(this);
	}
	public void add(AbstractButton button){
		button.init();
		buttons.add(button);
	}
	/**
	 * Remove an entity from this world
	 * 
	 * @param ent	the entity to remove
	 */
	public void remove(Entity ent) {
		ent.disable();
		ent.setWorld(null);
		entities.remove(ent);
	}
	public void remove(AbstractButton button) {
		buttons.remove(button);
	}
	/**
	 * @return the entity list
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public ArrayList<AbstractButton> getButtons(){
		return buttons;
	}
}
