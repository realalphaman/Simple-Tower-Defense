package data;

import java.util.concurrent.CopyOnWriteArrayList;

public class TowerQueen extends Tower{

	public TowerQueen(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}
	
	public void shoot(Enemy target) {
		super.projectiles.add(new BulletCannonBall(super.type.projectileType, super.target, super.getX(), super.getY(), 32,32));
		super.target.reduceHiddenHealth(super.type.projectileType.damage);
	}
}
