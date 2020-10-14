package synchronized1;

public class Increment {

	int num = 0;

	public void increment() {
		
		 synchronized(this) {
		num++;
		 }
		
		
		for(long i=0;i<10000000;i++) {
		int a= 321;
		a+=22;
	
		}


		
		
	}

	public int getNum() {
		return num;
	}
}
