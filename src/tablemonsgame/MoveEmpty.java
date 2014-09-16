package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MoveEmpty {
	private Image skill_Empty;
	
	public MoveEmpty() throws SlickException {
		skill_Empty =  new Image("res/empty.png");
	}

	public void render() {
		skill_Empty.draw(350,550);
	}
	
	
}
