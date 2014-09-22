package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	private Image skillOne;
	private float x;
	private float y;
	private float vx;
	private float vy;
	private float xStart;
	private float yStart;
	
	public Skill(float x, float y, int count) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = x;
		this.vy = y;
		this.xStart = x;
		this.yStart = y;
		skillOne = new Image("res/skill1/skill1-"+(count+1)+".png");
	}
	
	public void render() {
	    skillOne.draw(x,y);
	}
	
	public void update() {
		x = vx;
		y = vy;
	}
	
	public void up(float xEmpty, float yEmpty) {
		if(x == xEmpty && y == yEmpty+100){
			vy -= 100;
		}
	}
	
	public void down(float xEmpty, float yEmpty) {
		if(x == xEmpty && y == yEmpty-100){
			vy += 100;
		}
	}
	
	public void right(float xEmpty, float yEmpty) {
		if(x == xEmpty-100 && y == yEmpty){
			vx += 100;
		}
	}

	public void left(float xEmpty, float yEmpty) {
		if(x == xEmpty+100 && y == yEmpty){
			vx -= 100;
		}
	}

	public boolean check() {
		if(x == xStart && y == yStart){
			return true;
		}else{
			return false;
		}
		
	}

	

}
