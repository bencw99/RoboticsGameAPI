package implementaion;

import java.awt.event.ActionEvent;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
import world.*;
public class Platformer extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();
		
		addEntity(new Jumper(new Position(100, 100), new Dimension()));
		
		//Ignore
		run();
	}
	
	private class ExampleButton extends AbstractButton {
		public void init(){
			getButton().setBounds(0,0,50,50);
			getButton().setText("Button1");
			getButton().setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("ExampleButton pressed");
		}
	}
	
	private class Jumper extends Entity {
		private Vector vel;
		
		private final Vector gravity = new Vector(0, 100);
		
		public Jumper(Position pos, Dimension dim)
		{
			super(game.getWorld(), pos, 0, dim);
			
			spritesArray = new String[]{"smile", "images/happy.jpg"};
			loadSprites();
			activeSprite = "smile";
		}

		@Override
		public void init()
		{
			vel = new Vector(0, 0);
		}

		@Override
		public void update()
		{
			translate(vel.scale(1/Constants.UPDATES_PER_SEC));
			
			vel.translate(gravity.scale(1/Constants.UPDATES_PER_SEC));
			
			if(InputListener.isKeyNewPressed('w')) {
				vel.setY(-200);
			}
			if(InputListener.isKeyPressed('a')) {
				translateX(-3);
			}
			if(InputListener.isKeyPressed('d')) {
				translateX(3);
			}
		}

		@Override
		public void disable()
		{
			System.out.println("ExampleEntity disabled");
		}
	}
}