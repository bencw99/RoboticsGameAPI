package platformer;

import api.spriteless.AbstractTextBox;


public class PlatformCount extends AbstractTextBox {
	private static final long serialVersionUID = 1L;
	private Platformer plat;

	public PlatformCount(Platformer plat, String string) {
		super(string);
		this.plat = plat;
	}

	@Override
	public void update() {
		setText("Platforms Destryed: " + plat.getPlatformsDestroyed());
	}
}