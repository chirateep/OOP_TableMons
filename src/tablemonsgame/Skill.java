package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	private float x;
	private float y;
	private Image skillOne;

	public Skill(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;
		skillOne = new Image("res/skill1.png");
	}
	
	public void render() {
	    skillOne.draw((x/4),y/2);
	}

	

}
