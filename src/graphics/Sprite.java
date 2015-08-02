package graphics;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import entity.Entity;

/**
 * Implements Drawable will hold a Sprite object which consists of a pointer to a BufferedImage and a
 * name associated with the object. This class can draw the image associated with itself.
 * 
 * @author Jonathan Zwiebel
 * @version June 26th, 2015
 */
public class Sprite implements Drawable {
	/** A class ArrayList holding the filenames of the previously loaded Sprites **/
	private static ArrayList<String> filenames = new ArrayList<String>();
	
	/** A class ArrayList holding pointers to the BufferdImages **/
	private static ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
	
	/** The name of this Sprite **/
	private String name;

	/** The File of the image of this Sprite **/
	private File imageFile;

	/** The BufferedImage that this Sprite will display **/
	private BufferedImage image;

	/** The Entity to which this Sprite belongs **/
	private Entity entity;

	/** The Opacity of this Sprite, 0 being transparent, 100 being opaque **/
	private int opacity;

	/** The alpha value of this Sprite, 0 being transparent, 1 being opaque **/
	private float alpha;
	
	/** The address of this Sprite in the static ArrayList **/
	private int address;
	
	/**
	 * Constructor
	 * @param entity the Entity to which this sprite belongs
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
	 * Overloaded constructor 
	 * @param entity the Entity to which this sprite belongs
	 * @param name the name of this sprite
	 * @param imageLocation the location in the file system where this sprite's image exist
	 */
	public Sprite(Entity entity, String name, String imageLocation) {
		this(entity, name, imageLocation, 100);
	}

	// Inherited from Drawable

	/**
	 * Draws the Sprite onto the Japne with  Postion, Dimension of associated Sprite and
	 * Opacity and Buffered Image of this Sprite
	 * @param g an AWT graphics object.
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		if(entity.getAngle() != 0) {
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
			g2d.setComposite(composite);
			AffineTransform rotation = AffineTransform.getRotateInstance(entity.getAngle(), entity.getX(), entity.getY());
			g2d.setTransform(rotation);
			g2d.drawImage(bufferedImages.get(address), (int) entity.getUpperLeftPos().getX(), (int) entity.getUpperLeftPos().getY(), 
					(int) entity.getDim().getWidth(), (int) entity.getDim().getHeight(), null);
			g2d.dispose();
		} else {
			g2d.drawImage(bufferedImages.get(address), (int) entity.getUpperLeftPos().getX(), (int) entity.getUpperLeftPos().getY(), 
					(int) entity.getDim().getWidth(), (int) entity.getDim().getHeight(), null);
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Takes a file location and loads it into a BufferedImage if it is the first instance of that filename
	 * otherwise sets the address to the existing filename location. Also sets the alpha value.
	 * @param load the location to check for the file
	 */
	private void loadSprite(String load) {
		boolean found = false;
		for(int i = 0; i < filenames.size(); i++) {
			if(load == filenames.get(i)) {
				address = i;
				found = true;
				break;
			}
		}
		
		if(!found) {			
			String imageLocation = load;
			imageFile = new File(imageLocation);
			try {
				image = ImageIO.read(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Illegal path for " + name + ": " + imageLocation);
				System.exit(0);
			}
			filenames.add(load);
			bufferedImages.add(image);
			address = filenames.size() - 1;
		}
		alpha = opacity * 0.01f;

	}
}
