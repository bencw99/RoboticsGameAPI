package implementation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;


import physics.Position;
import spriteless.AbstractButton;

public class Bounce extends Implementor {
    MyButton button = new MyButton(new Position(300, 300), new Dimension(100, 200));
	
	public void execute() {
		init();
		
		EvilSquare Edward;
		Edward = new EvilSquare("Edward", game);
		addEntity(Edward);
		
		EvilSquare Eric;
		Eric = new EvilSquare("Eric", game);
		addEntity(Eric);
		
		for(int i = 1; i <= 128; i++) {
			addEntity(new PassiveShape(game));
		}
		addSpritelessElement(button);
		run();
	}


	public class MyButton extends AbstractButton {
		private static final long serialVersionUID = 1L;
		
		public MyButton(Position p, Dimension d) {
			super(p, d);
		}
		
		public void init() {
			super.init();
			setText("IT WORKS");
		}
		
		public void update() {
			super.update(game.getGraphics());
		}

		public void actionPerformed(ActionEvent e) {
		}
		
	}
}