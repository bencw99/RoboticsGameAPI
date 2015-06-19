package entity;

import physics.Position;
import physics.Vector;
import world.World;
import graphics.Sprite;
import graphics.SpriteManager;

public class CrazyEntity extends Entity {
	
	Vector v;
	int i = 0;
	
	public CrazyEntity(World world) {
		super(world);
		setSpriteManager(new SpriteManager(this, new Sprite(this, "happy", "happy.jpg")));
	}

	@Override
	public void init() {
		v = new Vector(10, 10);
	}

	@Override
	public void update() {
		System.out.println("update in tent: " + this.getPos().getX() + " " + this.getPos().getY());
		if(i % 100 == 0) {
			translateX(1);
		}
		if(i % 125 == 0) {
			translateY(1);
		}
		if(getPos().getX() == 700) {
			flyBack();
		}
	}
	
	private void flyBack() {
		setPos(new Position(100, 100));
	}

	@Override
	public void disable() {
		
	}
}
