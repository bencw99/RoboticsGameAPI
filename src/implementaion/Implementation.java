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
	
	private class ExampleButton extends AbstractButton {
		public void init(){
			getButton().setBounds(0,0,150,150);
			getButton().setText("Example Button");
			getButton().setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("ExampleButton pressed");
		}
	}
	
	private class ExampleEntity extends Entity {
		public ExampleEntity()
		{
			super();
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

