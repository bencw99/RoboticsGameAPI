package graphics;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import entity.Entity;

/**
 * This class will hold a Sprite object which consists of a <code>BufferedImage</code> and a
 * name associated with the object. This class can draw the image associated with itself.
 * 
 * @author Jonathan Zwiebel
 * @version June 19th, 2015
 */
public class Sprite {
	/** The name of this Sprite **/
	private String name;
	
	/** The <code>File</code> of the image of this Sprite **/
	private File imageFile;
	
	/** The <code>BufferedImage</code> that this Sprite will display **/
	private BufferedImage image;
	
	/** The {@link  entity.Entity} to which this Sprite belongs **/
	private Entity entity;
	
	/**
	 * Constructs a Sprite object that can be displayed to the screen and managed by a 
	 * {@link  graphics.Graphics}, also loads the sprite.
	 * 
	 * @param entity the {@link  entity.Entity} to which this sprite belongs
	 * @param name the name of this sprite
	 * @param imageLocation the location in the file system where this sprite's image exists
	 */
	public Sprite(Entity entity, String name, String imageLocation) {
		this.entity = entity;
		this.name = name;
		loadSprite(imageLocation);
	}
	
	/**
	 * Takes a file location and loads it into a <code>BufferedImage</code> while also
	 * checking to make sure the location points to a valid file
	 * 
	 * @param load the location to check for the file
	 */
	private void loadSprite(String load) {
		String imageLocation = load;
		imageFile = new File(imageLocation);
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Illegal path for " + name + ": " + imageLocation);
			System.exit(0);
		}
	}
	
	/**
	 * Draws the Sprite onto the <code>JPanel</code> with {@link  physics.Position} and {@link  physics.Dimension} 
	 * corresponding to that of the {@link  entity.Entity} it corresponds to.
	 * 
	 * @param g an AWT <code>graphics</code> object.
	 */
	public void draw(Graphics g) {
		g.drawImage(image, (int) entity.getUpperLeftPos().getX(), (int) entity.getUpperLeftPos().getY(), 
				(int) entity.getDim().getWidth(), (int) entity.getDim().getHeight(), null);
	}
	
	public String getName() {
		return name;
	}
	
}
