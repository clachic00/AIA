package practice01;

public class ShowThread extends Thread {

	String threadName;
	
	public ShowThread(String name) {
		threadName=name;
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("쓰레드의 이름 :"+threadName);
			
			try {sleep(100);}
				catch(InterruptedException e) {
					e.printStackTrace();
			}
		}
	}

}
