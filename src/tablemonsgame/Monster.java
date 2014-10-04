package tablemonsgame;

public class Monster {
	
	private int HP;
	

	public Monster(int HP) {
		this.HP = HP;
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
