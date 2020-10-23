package data;

import static helpers.Artist.QuickLoad;

public class EnemyDevil extends Enemy{

	public EnemyDevil(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture(QuickLoad("Devil"));
		this.setSpeed(50);
		this.setHealth(25);
		
	}

}
