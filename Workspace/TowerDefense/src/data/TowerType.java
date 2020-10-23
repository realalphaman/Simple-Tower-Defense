package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public enum TowerType {
	
	CannonBlue(new Texture[] {QuickLoad("BlueCannonBase"), QuickLoad("BlueCannonGun")},BulletType.CannonBall,100,1,20),
	CannonIce(new Texture[] {QuickLoad("iceCannon")},BulletType.IceBall,10000,2,30),
	CannonKing(new Texture[] {QuickLoad("TowerKing")},BulletType.KingBall,300,2,55),
	CannonQueen(new Texture[] {QuickLoad("TowerQueen")},BulletType.QueenBall,200,2,40); 
	
	Texture[] textures;
	BulletType projectileType;
	int damage, range, cost;
	float firingSpeed;
	
	TowerType(Texture[] textures, BulletType projectileType, int range, float firingSpeed, int cost){
		this.textures=textures;
		this.projectileType= projectileType;
		this.range= range;
		this.firingSpeed=firingSpeed;
		this.cost=cost;
	}
	
	public int getCost(TowerType towerType) {
		return towerType.cost;
	}

}
