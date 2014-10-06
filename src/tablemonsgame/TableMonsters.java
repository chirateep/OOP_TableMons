package tablemonsgame;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class TableMonsters extends BasicGame {

	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 700;
	private Skill[] skillOne = new Skill[9];
	private Example example;
	private MoveEmpty empty;
	private Time time;
	private Monster monster;
	private boolean isReset;
	private boolean[] checkCompleteSkillOne = new boolean[8];
	private boolean isCountTime;
	private int countCheckSkill;
	private int countResetSkill;
	private boolean isFinish;
	private boolean isNotFinish;
	private boolean isStart;
	private boolean isDeadMonster;

	public TableMonsters(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		renderSkillOne();
		empty.render();
		example.render();
		g.drawString("" + time.getTime(), 400, 0);
		g.drawString("HP Monster : " + monster.getHP(), 400, 100);
		if (isDeadMonster) {
			g.drawString("AweSome!!!", 250, 0);
		}
	}

	private void renderSkillOne() {
		for (int i = 0; i < 8; i++) {
			skillOne[i].render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		initSkillOne();
		empty = new MoveEmpty(350, 550);
		example = new Example(450, 150);
		time = new Time(3600);
		monster = new Monster(60);
		isReset = false;
		isCountTime = false;
		isFinish = false;
		isNotFinish = false;
		isStart = false;
	}

	private void initSkillOne() throws SlickException {
		skillOne[0] = new Skill(150, 350, 0);
		skillOne[1] = new Skill(250, 350, 1);
		skillOne[2] = new Skill(350, 350, 2);
		skillOne[3] = new Skill(150, 450, 3);
		skillOne[4] = new Skill(250, 450, 4);
		skillOne[5] = new Skill(350, 450, 5);
		skillOne[6] = new Skill(150, 550, 6);
		skillOne[7] = new Skill(250, 550, 7);
		skillOne[8] = new Skill(350, 550, 8);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if (isStart) {
			if (!isFinish) {
				empty.update();
				updateSkillOne();
				reset();
				if (isCountTime) {
					time.update();
					checkSkillOne();
				}
			} else {
				monster.decreaseHP(time.getTime());
				isFinish = false;
				time = new Time(3600);
				isDeadMonster = monster.check();
			}
		}
	}

	private void reset() {
		if (isReset) {
			countResetSkill++;
			resetSkill();
			if (countResetSkill >= 200) {
				isReset = false;
				countResetSkill = 0;
				isCountTime = true;
			}
		}
	}

	private void checkSkillOne() {
		for (int i = 0; i < 8; i++) {
			checkCompleteSkillOne[i] = skillOne[i].check();
		}
		if (checkSkill()) {
			countCheckSkill++;
			if (countCheckSkill >= 10) {
				isFinish = true;
				isCountTime = false;
			}
		}
	}

	private boolean checkSkill() {
		return checkCompleteSkillOne[0] && checkCompleteSkillOne[1]
				&& checkCompleteSkillOne[2] && checkCompleteSkillOne[3]
				&& checkCompleteSkillOne[4] && checkCompleteSkillOne[5]
				&& checkCompleteSkillOne[6] && checkCompleteSkillOne[7];
	}

	private void updateSkillOne() {
		for(int i = 0 ; i < 8 ; i++){
			skillOne[i].update();
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		controllEmpty(key);
		if (key == Input.KEY_ENTER) {
			isStart = true;
			isReset = true;
		}
	}

	private void controllEmpty(int key) {
		if (key == Input.KEY_UP) {
			upMovement();
		}
		if (key == Input.KEY_DOWN) {
			downMovement();
		}
		if (key == Input.KEY_LEFT) {
			leftMovement();
		}
		if (key == Input.KEY_RIGHT) {
			rightMovement();
		}
	}

	private void upMovement() {
		if (empty.getY() < 550) {
			empty.down();
			upSkillOne();
		}
	}

	private void downMovement() {
		if (empty.getY() > 350) {
			empty.up();
			downSkillOne();
		}
	}

	private void leftMovement() {
		if (empty.getX() < 350) {
			empty.right();
			leftSkillOne();
		}
	}

	private void rightMovement() {
		if (empty.getX() > 150) {
			empty.left();
			rightSkillOne();
		}
	}

	private void leftSkillOne() {
		for(int i = 0 ; i < 8 ; i++){
			skillOne[i].left(empty.getX(), empty.getY());
		}
	}

	private void rightSkillOne() {
		for(int i = 0 ; i < 8 ; i++){
			skillOne[i].right(empty.getX(), empty.getY());
		}
	}

	private void upSkillOne() {
		for(int i = 0 ; i < 8 ; i++){
			skillOne[i].up(empty.getX(), empty.getY());
		}
	}

	private void downSkillOne() {
		for(int i = 0 ; i < 8 ; i++){
			skillOne[i].down(empty.getX(), empty.getY());
		}
	}

	private void resetSkill() {
		Random random = new Random();
		int count;
		count = random.nextInt(4);
		if (count == 0) {
			upMovement();
		}
		if (count == 1) {
			downMovement();
		}
		if (count == 2) {
			leftMovement();
		}
		if (count == 3) {
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
