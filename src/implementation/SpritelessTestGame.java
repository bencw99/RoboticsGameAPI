package implementation;

import spriteless.AbstractButton;
import spriteless.AbstractMenu;
import spriteless.AbstractTextBox;
import spriteless.AbstractTimer;

import java.awt.event.ActionEvent;

public class SpritelessTestGame extends Implementor {

    MyMenu menu = new MyMenu(500, 500);
    MyTextArea text = new MyTextArea("HELLO HELLO HELLO");
    MyTimer timer = new MyTimer();
    MyButton button = new MyButton();

    public void execute() {
		init();

		addSpritelessElement(menu);
		
		menu.addSpritelessElement(text);
		menu.addSpritelessElement(timer);
		menu.addSpritelessElement(button);

		run();
	}

	private class MyMenu extends AbstractMenu {
		private static final long serialVersionUID = 1L;
		
		public MyMenu(double xPos, double yPos) {
			super(xPos, yPos);
		}
		
	}
	//MENU CLASS ENDS HERE
	
	private class MyButton extends AbstractButton {
		private static final long serialVersionUID = 1L;

		public void update() {
		}

		public void actionPerformed(ActionEvent e) {
			this.setText("IT WORKS");
		}
		
	}
	//BUTTON CLASS ENDS HERE
	
	private class MyTimer extends AbstractTimer {
		private static final long serialVersionUID = 1L;

		MyTimer() {
			super();
		}
		
		public void disable() {
			//should probably put disable stuff here but it works.
		}
		
	}
	//TIMER CLASS ENDS HERE
	
	private class MyTextArea extends AbstractTextBox {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyTextArea(String s) {
			super(s);
		}
		
		public void update() {
			
		}
		
	}
	//TEXTBOX CLASS ENDS HERE
	
}
//WHOLE CLASS ENDS HERE
