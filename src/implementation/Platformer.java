package implementation;



import constants.*;
import physics.*;
public class Platformer extends Implementor{
	private int platformsDestroyed = 0;
	
	/**
	 * Called when game starts
	 */
	public void execute() {
		//Ignore
		init();
		
		addEntity(new Jumper(game, new Position(100, 100), Constants.DEFAULT_DIMENSION));
		addSpritelessElement(new PlatformCount(this, "Hello"));
		
		for(int i = 100; i < Constants.SCREEN_WIDTH; i += Constants.SCREEN_WIDTH/5) {
			for(int j = 200; j < Constants.SCREEN_HEIGHT; j += Constants.SCREEN_HEIGHT/8) {
				Position platformPosition = new Position(i, j);
				Platform platform = new Platform(this, game, platformPosition);
				
				addEntity(platform);
			}
		}
		
		//Ignore
		run();
	}
	
	public void incrementPlatformsDestroyed() {
		platformsDestroyed++;
	}
	
	public int getPlatformsDestroyed() {
		return platformsDestroyed;
	} 
}
