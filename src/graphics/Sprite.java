package graphics;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import entity.Entity;

public class Sprite {
	private String imageLocation, name;
	private File imageFile;
	private BufferedImage image;
	//private int displayHeight, displayWidth;
	private Entity entity;
	
	public Sprite(Entity entity, String name, String imageLocation) {
		this.entity = entity;
		this.name = name;
		loadSprite(imageLocation);
		//loadDimensions();
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
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, (int) entity.getUpperLeftPos().getX(), (int) entity.getUpperLeftPos().getY(), 
				(int) entity.getDim().getWidth(), (int) entity.getDim().getHeight(), 
				null);
	}

//	private void loadDimensions() {
//	displayHeight = entity.getDim().getHeight();
//	displayWidth = entity.getDim().getWidth();
//}
//	public void setDisplayHeight(int height) {
//		displayHeight = height;
//	}
//	
//	public void setDisplayWidth(int width) {
//		displayWidth = width;
//	}
//	
//	public void scale(double scaleFactor) {
//		displayHeight *= scaleFactor;
//		displayWidth *= scaleFactor;
//	}
	
	public String getName() {
		return name;
	}
	
}
