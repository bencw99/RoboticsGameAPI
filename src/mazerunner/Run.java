package mazerunner;

import api.implementation.Implementor;

public class Run {

	public static void main(String[] args) {
		Implementor bounce = new Mazerunner();
		bounce.execute();
	}
}
