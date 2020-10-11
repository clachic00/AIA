package extendsThread;

public class ThreadUnderstand {

	public static void main(String[] args) {

		ShowThread st1 = new ShowThread("쓰레드1");
		ShowThread st2 = new ShowThread("쓰레드2");
		
		st1.start();
		st2.start();
		
		
	}

}
