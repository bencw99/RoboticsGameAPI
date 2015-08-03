package platformer;

import java.awt.Dimension;

import api.entity.Entity;
import api.game.Game;
import api.graphics.Animation;
import api.physics.Position;

public class Platform extends Entity {
	public static final Dimension DEFAULT_PLATFORM_DIMENSION = new Dimension(100, 20);
	public static final double DEFAULT_PLATFORM_ANGLE = 0;
	
	private Platformer plat;
	private boolean alive;
	private int contacts;
	
	public boolean isAlive() {
		return alive;
	}
	
	public Platform(Platformer plat, Game game, Position pos)
	{
		super(game, pos, DEFAULT_PLATFORM_ANGLE, DEFAULT_PLATFORM_DIMENSION);
		
		Animation explosion = newAnimation(new Object[]{"e0", "images/explosion/tmp-0.gif", "e1", "images/explosion/tmp-1.gif", "e2", "images/explosion/tmp-2.gif",
				"e3", "images/explosion/tmp-3.gif", "e4", "images/explosion/tmp-4.gif", "e5", "images/explosion/tmp-5.gif", "e6", "images/explosion/tmp-6.gif",
				"e7", "images/explosion/tmp-7.gif", "e8", "images/explosion/tmp-8.gif", "e9", "images/explosion/tmp-9.gif", "e10", "images/explosion/tmp-10.gif",
				"e11", "images/explosion/tmp-11.gif", "e12", "images/explosion/tmp-12.gif", "e13", "images/explosion/tmp-13.gif", "e14", "images/explosion/tmp-14.gif",
				"e15", "images/explosion/tmp-15.gif", "e16", "images/explosion/tmp-16.gif", "e17", "images/explosion/tmp-17.gif", "e18", "images/explosion/tmp-18.gif",});
		
		spritesArray = new Object[]{"platform", "images/preset/black.png", "stepped", "images/preset/green.jpg", "explosion", explosion};
		loadSprites();
		this.plat = plat;
	}

	@Override
	public void init()
	{
		alive = true;
		contacts = 0;
		activeSprite = "platform";
	}

	@Override
	public void update()
	{
		if(alive) {
			if(doesCollideWithType("platformer.Jumper")) {
				contacts++;
				activeSprite = "stepped";
			}

			if(contacts >= 300) {
				alive = false;
				activeSprite = "explosion";
				setAutoMode(true);
				setTicksPerFrame(5);
				plat.incrementPlatformsDestroyed();
			}
		}
	}

	@Override
	public void disable()
	{
		
	}
}