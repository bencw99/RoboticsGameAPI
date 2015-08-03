package platformer;

import api.implementation.Implementor;

public class Run {

	public static void main(String[] args) {
		Implementor bounce = new Platformer();
		bounce.execute();
	}
}
