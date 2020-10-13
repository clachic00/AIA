package synchronized1;

public class Increment {

	int num=0; 
	public synchronized void increment() {num++;}
	public int getNum() {return num;}
	}
