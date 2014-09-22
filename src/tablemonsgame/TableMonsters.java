package tablemonsgame;

import java.util.Random;

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
	private boolean isReset;
	private boolean[] checkComp = new boolean [8];
	private boolean isStart;
	private int countCheck;
	private boolean isFinish;
	
	public TableMonsters(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		renderSkillOne();
		empty.render();
		example.render();
		if(isFinish){
			g.drawString("Fuck",300,0);
			skillOne[8].render();
		}
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
		isReset = false;
		isStart = false;
		isFinish = false;
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
		if(!isFinish){
			empty.update();
			updateSkillOne();
			if(isReset){
				resetSkill();
				isStart = true;
			}
			if(isStart){
				checkSkillOne();
			}
		}
	}

	private void checkSkillOne() {
		checkComp[0] = skillOne[0].check();
		checkComp[1] = skillOne[1].check();
		checkComp[2] = skillOne[2].check();
		checkComp[3] = skillOne[3].check();
		checkComp[4] = skillOne[4].check();
		checkComp[5] = skillOne[5].check();
		checkComp[6] = skillOne[6].check();
		checkComp[7] = skillOne[7].check();
		if(checkComp[0] && checkComp[1] && checkComp[2] && checkComp[3] && checkComp[4] && checkComp[5] && checkComp[6] && checkComp[7]){
			countCheck++;
			if(countCheck >= 10){
				isFinish = true;
			}
		}
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
			upMovement();
		}
		if(key == Input.KEY_DOWN){
			downMovement();
		}
		if(key == Input.KEY_LEFT){
			leftMovement();
		}
		if(key == Input.KEY_RIGHT){
			rightMovement();
		}
		if(key == Input.KEY_ENTER){
			isReset =! isReset;
		}
	}

	private void upMovement() {
		if(empty.getY() < 550){
			empty.down();
			upSkillOne();
		}
	}

	private void downMovement() {
		if(empty.getY() > 350){
			empty.up();
			downSkillOne();
		}
	}

	private void leftMovement() {
		if(empty.getX() < 350){
			empty.right();
			leftSkillOne();
		}
	}

	private void rightMovement() {
		if(empty.getX() > 150){
			empty.left();
			rightSkillOne();
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
	
	private void resetSkill(){
		Random random = new Random();
		int count;
		count = random.nextInt(4);
		if(count == 0){
			upMovement();
		}
		if(count == 1){
			downMovement();
		}
		if(count == 2){
			leftMovement();
		}
		if(count == 3){
			rightMovement();
		}
	}
	public static void main(String[] args) {
	    try {
	      TableMonsters game = new TableMonsters("Table Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 30);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	}

}
