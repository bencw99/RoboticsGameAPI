package graphics;

import java.io.File;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	
	/** The Opacity of this Sprite, 0 being transparent, 100 being opaque **/
	private int opacity;
	
	/** The alpha value of this Sprite, 0 being transparent, 1 being opaque **/
	private float alpha;
	
	/**
	 * Constructs a Sprite object that can be displayed to the screen and managed by a 
	 * {@link  graphics.Graphics}, also loads the sprite.
	 * 
	 * @param entity the {@link  entity.Entity} to which this sprite belongs
	 * @param name the name of this sprite
	 * @param imageLocation the location in the file system where this sprite's image exists
	 * @param the opacity of this image, 0 being transparent, 100 being opaque
	 */
	public Sprite(Entity entity, String name, String imageLocation, int opacity) {
		this.entity = entity;
		this.name = name;
		this.opacity = opacity;
		loadSprite(imageLocation);
	}
	
	/**
	 * A constructor for when no opacity is specified, 100 is default
	 */
	public Sprite(Entity entity, String name, String imageLocation) {
		this(entity, name, imageLocation, 100);
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
		alpha = opacity * 0.01f;
	}
	
	/**
	 * Draws the Sprite onto the <code>JPanel</code> with {@link  physics.Position} and {@link  physics.Dimension} 
	 * corresponding to that of the {@link  entity.Entity} it corresponds to.
	 * 
	 * @param g an AWT <code>graphics</code> object.
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(composite);
		
		if(entity.getAngle() != 0) {
			g2d.fillPolygon(entity.getBounds());
		}
		else {
			g2d.drawImage(image, (int) entity.getUpperLeftPos().getX(), (int) entity.getUpperLeftPos().getY(), 
			(int) entity.getDim().getWidth(), (int) entity.getDim().getHeight(), null);
		}
		
		g2d.dispose();
	}
	
	public String getName() {
		return name;
	}
	
}
