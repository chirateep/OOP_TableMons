package tablemonsgame;

public class Time {

	private int time;

	public Time(int time) {
		this.time = time;
	}
	
	public void update(){
		time -= 1;
	}
	
	public int getTime(){
		return time/60;
	}

}
