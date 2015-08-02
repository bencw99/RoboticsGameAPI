package implementation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;


import physics.Position;
import spriteless.AbstractButton;

public class Bounce extends Implementor{
    MyButton addButton = new MyButton(new Position(300, 300), new Dimension(100, 200));
	
	public void execute() {
		init();
		EvilSquare Edward;
		Edward = new EvilSquare(game);
		addEntity(Edward);
		for(int i = 1; i <= 128; i++) {
			addEntity(new PassiveShape(game));
		}
		addSpritelessElement(addButton);
		run();
	}


	
	private class MyButton extends AbstractButton {
		private static final long serialVersionUID = 1L;

		public MyButton(Position p, Dimension d) {
			super(p, d);
		}
		
		public void init() {
			super.init();
			this.setText("IT WORKS");
		}
		
		public void update() {
		
		}

		public void actionPerformed(ActionEvent e) {
		}
		
	}
}