package tablemonsgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class TableMonsters extends BasicGame{

	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 700;
	private Skill skill;

	public TableMonsters(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		skill.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		skill = new Skill(GAME_WIDTH,GAME_HEIGHT);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
	}
	
	public static void main(String[] args) {
	    try {
	      TableMonsters game = new TableMonsters("Flappy Dot Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	}

}
