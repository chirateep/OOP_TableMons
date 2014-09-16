package tablemonsgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class TableMonsters extends BasicGame{

	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 700;
	private Skill[] skillOne = new Skill [9];
	private MoveEmpty empty;
	

	public TableMonsters(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		renderSkillOne();
		empty.render();
	}

	private void renderSkillOne() {
		skillOne[0].render();
		skillOne[1].render();
		skillOne[2].render();
		skillOne[3].render();
		skillOne[4].render();
		skillOne[5].render();
		skillOne[6].render();
		skillOne[7].render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		initSkillOne();
		empty = new MoveEmpty(350,550);
	}

	private void initSkillOne() throws SlickException {
		skillOne[0] = new Skill(150,350,0);
		skillOne[1] = new Skill(250,350,1);
		skillOne[2] = new Skill(350,350,2);
		skillOne[3] = new Skill(150,450,3);
		skillOne[4] = new Skill(250,450,4);
		skillOne[5] = new Skill(350,450,5);
		skillOne[6] = new Skill(150,550,6);
		skillOne[7] = new Skill(250,550,7);
		skillOne[8] = new Skill(350,550,8);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		empty.update();
	}
	
	@Override
	public void keyPressed(int key, char c){
		if(key == Input.KEY_UP){
			empty.up();
		}
		if(key == Input.KEY_DOWN){
			empty.down();
		}
		if(key == Input.KEY_LEFT){
			empty.left();
		}
		if(key == Input.KEY_RIGHT){
			empty.right();
		}
	}
	
	
	public static void main(String[] args) {
	    try {
	      TableMonsters game = new TableMonsters("Table Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	}

}
