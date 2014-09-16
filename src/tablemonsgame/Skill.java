package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	private Image skillOne;
	private float x;
	private float y;	
	
	public Skill(float x, float y, int count) throws SlickException {
		this.x = x;
		this.y = y;
		skillOne = new Image("res/skill1/skill1-"+(count+1)+".png");
	}
	
	public void render() {
	    skillOne.draw(x,y);
	}

	

}
