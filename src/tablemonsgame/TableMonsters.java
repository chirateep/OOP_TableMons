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
	private Example example;
	private MoveEmpty empty;
	

	public TableMonsters(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		renderSkillOne();
		empty.render();
		example.render();
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
		example = new Example(450,150);
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
		updateSkillOne();
	}

	private void updateSkillOne() {
		skillOne[0].update();
		skillOne[1].update();
		skillOne[2].update();
		skillOne[3].update();
		skillOne[4].update();
		skillOne[5].update();
		skillOne[6].update();
		skillOne[7].update();
	}
	
	@Override
	public void keyPressed(int key, char c){
		controllEmpty(key);
	}

	private void controllEmpty(int key) {
		if(key == Input.KEY_UP){
			empty.up();
			downSkillOne();
		}
		if(key == Input.KEY_DOWN){
			empty.down();
			upSkillOne();
		}
		if(key == Input.KEY_LEFT){
			empty.left();
			rightSkillOne();
		}
		if(key == Input.KEY_RIGHT){
			empty.right();
			leftSkillOne();
		}
	}

	private void leftSkillOne() {
		skillOne[0].left(empty.getX(),empty.getY());
		skillOne[1].left(empty.getX(),empty.getY());
		skillOne[2].left(empty.getX(),empty.getY());
		skillOne[3].left(empty.getX(),empty.getY());
		skillOne[4].left(empty.getX(),empty.getY());
		skillOne[5].left(empty.getX(),empty.getY());
		skillOne[6].left(empty.getX(),empty.getY());
		skillOne[7].left(empty.getX(),empty.getY());
	}

	private void rightSkillOne() {
		skillOne[0].right(empty.getX(),empty.getY());
		skillOne[1].right(empty.getX(),empty.getY());
		skillOne[2].right(empty.getX(),empty.getY());
		skillOne[3].right(empty.getX(),empty.getY());
		skillOne[4].right(empty.getX(),empty.getY());
		skillOne[5].right(empty.getX(),empty.getY());
		skillOne[6].right(empty.getX(),empty.getY());
		skillOne[7].right(empty.getX(),empty.getY());
	}

	private void upSkillOne() {
		skillOne[0].up(empty.getX(),empty.getY());
		skillOne[1].up(empty.getX(),empty.getY());
		skillOne[2].up(empty.getX(),empty.getY());
		skillOne[3].up(empty.getX(),empty.getY());
		skillOne[4].up(empty.getX(),empty.getY());
		skillOne[5].up(empty.getX(),empty.getY());
		skillOne[6].up(empty.getX(),empty.getY());
		skillOne[7].up(empty.getX(),empty.getY());
	}

	private void downSkillOne() {
		skillOne[0].down(empty.getX(),empty.getY());
		skillOne[1].down(empty.getX(),empty.getY());
		skillOne[2].down(empty.getX(),empty.getY());
		skillOne[3].down(empty.getX(),empty.getY());
		skillOne[4].down(empty.getX(),empty.getY());
		skillOne[5].down(empty.getX(),empty.getY());
		skillOne[6].down(empty.getX(),empty.getY());
		skillOne[7].down(empty.getX(),empty.getY());
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
