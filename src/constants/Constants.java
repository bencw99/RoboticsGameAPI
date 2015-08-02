package constants;

import java.awt.Dimension;

import physics.Vector;

/** 
 * A class holding constants
 */
public class Constants {
	/** The constant describing the updates per second of a game **/
	public final static int UPDATES_PER_SEC = 120;
	
	/** The default dimension size **/
	public final static Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
	
	// ***************************************
	// SCREENS
	// ***************************************
	public final static int SCREEN_WIDTH = 1000;
	public final static int SCREEN_HEIGHT = 1000;
	
	// ***************************************
	// GRAPHICS
	// ***************************************
	
	/** Default behavior for animations looping around **/
	public final static boolean DEFAULT_CYCLE_MODE = false;
	
	/** Default behavior for animations automatically stepping **/
	public final static boolean DEFAULT_AUTO_MODE = false;
	
	/** Default ticks till animation steps in auto mode **/
	public final static int DEFAULT_ANIMATION_TICKS_PER_FRAME = 10;
	
	// ***************************************
	// PHYSICS
	// ***************************************
	public static final Vector GRAVITY = new Vector(0, 600);

}
