package input;

import java.awt.event.*;

import physics.*;

/**
 * A class responsible for listening for mouse and keyboard input
 */
public class InputListener implements KeyListener, MouseListener, MouseMotionListener {
	/** The array of booleans determining whether or not the given key is pressed **/
	private static boolean keysPressed[] = new boolean[100000];
	
	/** The array of booleans determining if the key was pressed last cycle **/
	private static boolean newPressed[] = new boolean[100000];
	
	/** The boolean describing the mouse state **/
	private static boolean mousePressed = false;
	
	/** The boolean describing the mouse position **/
	private static Position mousePos = new Position();
	
	/**
	 * Returns the pressed state of the given key
	 * 
	 * @param key the key to be tested
	 * @return the pressed state of the given key
	 */
	public static boolean isKeyPressed(char key) {
		newPressed[(int) key] = false;
		return keysPressed[(int) key];
	}
	
	/**
	 * Returns true on the initial press of a key
	 * (Pressed for the first time and not on the last)
	 * 
	 * @param key The key to check
	 * @return If the key is pressed for the first time
	 */
	public static boolean isKeyNewPressed(char key) {
		boolean value = newPressed[(int) key];
		newPressed[(int) key] = false;
		return value;
	}
	
	/** 
	 * Returns the state of the mouse 
	 * 
	 * @return the mouse state
	 */
	public static boolean isMousePressed() {
		return mousePressed;
	}
	
	/**
	 * Returns the x position of the mouse
	 * 
	 * @return the x position of the mouse
	 */
	public static double getMouseX() {
		return mousePos.getX();
	}
	
	/**
	 * Returns the y position of the mouse
	 * 
	 * @return the y position of the mouse
	 */
	public static double getMouseY() {
		return mousePos.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos.setX(e.getX());
		mousePos.setY(e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int index = (int) e.getKeyChar();
		if(!keysPressed[index]) {
			newPressed[index] = true;
		}
		keysPressed[index] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int index = (int) e.getKeyChar();
		keysPressed[index] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
