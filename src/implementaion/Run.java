package implementaion;
public class Run {

	public static void main(String[] args) {
		Implementor imp = new CrazyRafi();
		imp.init();
		imp.main();
		imp.run();
	}
}
