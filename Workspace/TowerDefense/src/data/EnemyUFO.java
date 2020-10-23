package data;

import static helpers.Artist.QuickLoad;

public class EnemyUFO extends Enemy{

	public EnemyUFO(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture(QuickLoad("UFO64"));
		this.setHealth(60);
	}

}
