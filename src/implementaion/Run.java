package implementaion;
public class Run {

	public static void main(String[] args) {
		Implementor imp = new Mazerunner();
		imp.init();
		imp.main();
		imp.run();
	}
}
