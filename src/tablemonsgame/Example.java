package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Example {

	private float x;
	private float y;
	private Image exampleOne;

	public Example(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;
		exampleOne = new Image("res/skill1/skill1.png");
	}

	public void render() {
		exampleOne.draw(x,y);
	}
	

}
