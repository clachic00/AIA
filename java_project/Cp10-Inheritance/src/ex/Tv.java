package ex;

public class Tv {

	boolean power;
	int channel;
	
	void power() {
		power = !power;
		
	}
	
	void channel1Up() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	void display() {
		System.out.println("TV를 재생합니다");
		
	
	
	
	}
	
}
