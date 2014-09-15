package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	private float x;
	private float y;
	private Image skillOne_1;
	private Image skillOne_2;
	private Image skillOne_3;
	private Image skillOne_4;
	private Image skillOne_5;
	private Image skillOne_6;
	private Image skillOne_7;
	private Image skillOne_8;
	private Image skillOne_9;
	private Image skillOne_Empty;
	
	public Skill(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;
		skillOne_1 = new Image("res/skill1/skill1-1.png");	
		skillOne_2 = new Image("res/skill1/skill1-2.png");	
		skillOne_3 = new Image("res/skill1/skill1-3.png");	
		skillOne_4 = new Image("res/skill1/skill1-4.png");	
		skillOne_5 = new Image("res/skill1/skill1-5.png");	
		skillOne_6 = new Image("res/skill1/skill1-6.png");	
		skillOne_7 = new Image("res/skill1/skill1-7.png");	
		skillOne_8 = new Image("res/skill1/skill1-8.png");	
		skillOne_9 = new Image("res/skill1/skill1-9.png");
		skillOne_Empty = new Image("res/skill1/empty.png");	
	}
	
	public void render() {
	    
		skillOne_1.draw(150,350);	
		skillOne_2.draw(250,350);	
		skillOne_3.draw(350,350);	
		skillOne_4.draw(150,450);	
		skillOne_5.draw(250,450);	
		skillOne_6.draw(350,450);	
		skillOne_7.draw(150,550);	
		skillOne_8.draw(350,550);
		skillOne_Empty.draw(250,550);
	}

	

}
