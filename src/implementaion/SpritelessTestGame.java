package implementaion;

import java.awt.event.ActionEvent;

import addons.*;

public class SpritelessTestGame extends Implementor {
	
	public void main() {
		init();
		
		/** Button test - WORKS!
		MyButton button = new MyButton();
		addSpritelessElement(button);
		*/
		
		/** Timer test - WORKS!
		MyTimer timer = new MyTimer();
		addSpritelessElement(timer);
		*/
		
		/** Textbox test - WORKS!
		MyTextArea text = new MyTextArea("INSERT TEXT HERE");
		addSpritelessElement(text);
		*/
		
		/** Menu test - FAILED :(
		MyMenu menu = new MyMenu();
		MyTimer timer = new MyTimer();
		addSpritelessElement(menu);
		menu.addSpritelessElement(timer);
		*/
		
		run();
	}
	
	
	private class MyMenu extends AbstractMenu {
		MyMenu() {
			super();
		}
		
	}
	//MENU CLASS ENDS HERE
	
	private class MyButton extends AbstractButton {

		public void show() {
			//should put show stuff here
		}

		
		public void hide() {
			//should put hide stuff here
		}

		public void update() {
		}

		public void actionPerformed(ActionEvent e) {
			this.setText("IT WORKS");
		}
		
	}
	//BUTTON CLASS ENDS HERE
	
	private class MyTimer extends AbstractTimer {

		MyTimer() {
			super();
		}
		
		public void disable() {
			//should probably put disable stuff here but it works.
		}
		
	}
	//TIMER CLASS ENDS HERE
	
	private class MyTextArea extends AbstractTextBox {

		MyTextArea(String s) {
			super(s);
		}
		
		public void update() {
			
		}
		
	}
	//TEXTBOX CLASS ENDS HERE
	
}
//WHOLE CLASS ENDS HERE
