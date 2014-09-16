package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MoveEmpty {
	private Image skillEmptyOne;
	private float x;
	private float y;
	private float vx;
	private float vy;
	
	public MoveEmpty(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = x;
		this.vy = y;
		skillEmptyOne =  new Image("res/empty.png");
	}

	public void render() {
		skillEmptyOne.draw(x,y);
	}

	public void up() {
		vy -= 100;
	}

	public void down() {
		vy += 100;
	}

	public void left() {
		vx -= 100;
	}

	public void right() {
		vx += 100;
	}

	public void update() {
		x = vx;
		y = vy;
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
}
