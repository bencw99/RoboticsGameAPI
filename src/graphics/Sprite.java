package graphics;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sprite {
	private String imageLocation, name;
	private File imageFile;
	private BufferedImage image;
	private int displayHeight, displayWidth;
	
	public Sprite(String name, String imageLocation) {
		this.name = name;
		loadSprite(imageLocation);
	}
	
	// takes a sprite location and sets the IV for this class
	private void loadSprite(String imageLocation) {
		this.imageLocation = imageLocation;
		imageFile = new File(imageLocation);
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Illegal path for " + name + " : " + imageLocation);
			e.printStackTrace();
		}
		displayHeight = image.getHeight();
		displayWidth = image.getWidth();
	}

	public void setDisplayHeight(int height) {
		displayHeight = height;
	}
	
	public void setDisplayWidth(int width) {
		displayWidth = width;
	}
	
	public void scale(double scaleFactor) {
		displayHeight *= scaleFactor;
		displayWidth *= scaleFactor;
	}
	
	public String getName() {
		return name;
	}
	
}
