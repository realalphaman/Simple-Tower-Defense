package data;

public class BulletCannonBall extends Bullet {

	public BulletCannonBall(BulletType type, Enemy target, float x, float y, int width, int height) {
		super(type, target, x, y, width, height);
	}
	
	@Override
	public void damage() {
		super.damage();
	}

}
