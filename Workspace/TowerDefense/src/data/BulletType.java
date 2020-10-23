package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public enum BulletType {
	
	CannonBall(QuickLoad("bullet"),3,600),
	IceBall(QuickLoad("blueIceBall"),2,450),
	KingBall(QuickLoad("bullet"),10,400),
	QueenBall(QuickLoad("bullet"),6,800);
	
	Texture texture;
	int damage;
	float speed;
	
	BulletType(Texture texture, int damage, float speed){
		this.texture=texture;
		this.damage=damage;
		this.speed=speed;
	}

}
