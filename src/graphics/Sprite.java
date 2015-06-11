package graphics;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sprite {
	private String imageLocation, name;
	private File imageFile;
	private BufferedImage image;
	
	public Sprite(String name) {
		this.name = name;
	}
	
	public Sprite(String name, String imageLocation) {
		this(name);
		loadSprite(imageLocation);
	}
	
	private void loadSprite(String imageLocation) {
		this.imageLocation = imageLocation;
		imageFile = new File(imageLocation);
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Illegal path for " + name + " : " + imageLocation);
			e.printStackTrace();
		}
	}
}
