package implementation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import physics.Position;
import spriteless.AbstractButton;

public class Bounce extends Implementor {
    EntityMaker button = new EntityMaker(new Position(300, 300), new Dimension(300, 50));
    ScreenSwitcher switchButton1 = new ScreenSwitcher(new Position(900, 900), new Dimension(100, 50));
    ScreenSwitcher switchButton2 = new ScreenSwitcher(new Position(900, 900), new Dimension(100, 50));

    public void execute() {
		init();
		
		EvilSquare Edward;
		Edward = new EvilSquare("Edward", game);
		addEntity(Edward);

		EvilSquare Eric;
		Eric = new EvilSquare("Eric", game);
		addEntity(Eric, game.getScreenWithName("PAUSED"));

		
		for(int i = 1; i <= 128; i++) {
			addEntity(new PassiveShape(game));
			addEntity(new PassiveShape(game));
		}

		addSpritelessElement(button);
		addSpritelessElement(switchButton1);
		addSpritelessElement(switchButton2, game.getScreenWithName("PAUSED"));
		run();
	}
	
	public class EntityMaker extends AbstractButton {
		private static final long serialVersionUID = 1L;
		
		int clicks = 0;
		
		public EntityMaker(Position p, Dimension d) {
			super(p, d);
		}
		
		public void init() {
			super.init();
			setButtonText("Click Me");
		}
		
		public void update() {
			super.updateUI();
		}

		public void actionPerformed(ActionEvent e) {
			clicks++;
			if(clicks % 4 == 0) {
				addEntity(new PassiveShape(game));
				setButtonText("Adding Passive Shape");
			}
			else {
				setButtonText("Click Me");
			}
			
		}
	}
	
	public class ScreenSwitcher extends AbstractButton {
		private static final long serialVersionUID = 1L;		
		public ScreenSwitcher(Position p, Dimension d) {
			super(p, d);
		}
		
		public void init() {
			super.init();
			setButtonText("Switch Screens");
		}
		
		public void update() {
			super.updateUI();
		}

		public void actionPerformed(ActionEvent e) {
			if(game.getCurrentScreenName() == "PAUSED") {
				game.setCurrentScreen("START");
			}
			else {
				game.setCurrentScreen("PAUSED");
			}
			
		}
	}
}