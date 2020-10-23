package data;


public class BulletIceBall extends Bullet {

	public BulletIceBall(BulletType type, Enemy target, float x, float y, int width, int height) {
		super(type, target, x, y, width, height);
	}
	
	public void damage() {
		super.getTarget().setSpeed(20);
		super.damage();
	}

}
