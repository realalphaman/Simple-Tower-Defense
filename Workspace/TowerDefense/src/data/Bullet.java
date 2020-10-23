package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;
import static helpers.Artist.*;

public abstract class Bullet implements Entity {
	
	private Texture texture;
	private float x,y,  speed, xVelocity, yVelocity;
	private int width, height,damage;
	private Enemy target;
	private boolean alive;
	
	public Bullet(BulletType type, Enemy target, float x, float y, int width, int height) {
		this.texture=type.texture;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height= height;
		this.speed=type.speed;
		this.damage=type.damage;
		this.target=target;
		this.alive=true;
		this.xVelocity=0f;
		this.yVelocity=0;
		calculateDirection();
	}
	
	private void calculateDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistanceFromTarget = Math.abs(target.getX() -x + TILE_SIZE/4);
		float yDistanceFromTarget = Math.abs(target.getY() -y + TILE_SIZE/4);
		float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
		float xPercentOfMovement = xDistanceFromTarget / totalDistanceFromTarget;
		xVelocity = xPercentOfMovement;
		yVelocity = totalAllowedMovement -xPercentOfMovement;
		//Cai dat vi tri dua tren vi tri hien tai cua muc tieu so voi tower
		if(target.getX()<x)
			xVelocity *=-1;
		if(target.getY() <y)
			yVelocity *=-1;
	}
	
	// Gay dame cho Enemy
	public void damage() {
		target.damage(damage);
		alive = false;
	}

	public void update() {
		if(alive) {
			calculateDirection();
			x+= xVelocity* speed * Delta();
			y+= yVelocity* speed * Delta();
			if(CheckCollision(x,y,width,height,target.getX(), target.getY(), target.getWidth(), target.getHeight())) 
				damage();
			draw();
		}
	}
	public void draw() {
		DrawQuadTex(texture,x,y,32,32);
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}
	
	public Enemy getTarget() {
		return target;
	}
	
	public void setAlive(boolean status) {
		alive = status;
	}
}
