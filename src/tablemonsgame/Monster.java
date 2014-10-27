package tablemonsgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Monster {
	
	private int HP;
	private Image monster;
	

	public Monster(int HP) throws SlickException {
		this.HP = HP;
		monster = new Image("res/monster.png");
	}
	
	public void render(){
		monster.draw(200,125);
	}

	public void decreaseHP(int time){
		HP -= time ; 
	}
	
	public int getHP() {
		if(HP <= 0){
			return 0;
		}else{
			return HP;
		}
	}

	public boolean check() {
		if(HP <= 0)
		{
			return true;
		}else{
			return false;
		}
	}

	

	

	
}
