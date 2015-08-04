package api.practice;

import api.implementation.Implementor;

public class PracticeGame extends Implementor {
	@Override
	public void execute() {
		init();
		
		addEntity(new PracticeEntity(game));
		
		run();
	}

	public static void main(String[] args) {
		Implementor game = new PracticeGame();
		game.execute();
	}
}
