package extendsThread;

public class ThreadUnderstand {

	public static void main(String[] args) {

		ShowThread st1 = new ShowThread("������1");
		ShowThread st2 = new ShowThread("������2");
		
		st1.start();
		st2.start();
		
		
	}

}
