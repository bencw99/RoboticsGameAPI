package implementaion;
import java.awt.event.ActionEvent;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
public class Implementation extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();
		//Ignore
		run();
	}
	
	private class ExampleEntity extends Entity {
		public ExampleEntity(Game game)
		{
			super(game);
		}

		@Override
		public void init()
		{
			System.out.println("ExampleEntity initialized");
		}

		@Override
		public void update()
		{
			System.out.println("ExampleEntity updated");
		}

		@Override
		public void disable()
		{
			
		}
	}
}

