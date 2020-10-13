package synchronized1;

class ThreadSyncError {
public static void main(String[] args) {
	
	Increment inc=new Increment(); 
	IncThread it1=new IncThread(inc); 
	IncThread it2=new IncThread(inc); 
	IncThread it3=new IncThread(inc); 
	it1.start(); it2.start(); it3.start();
	
//	 try {
//		 it1.join(); it2.join(); it3.join();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	System.out.println(inc.getNum());
	System.out.println(inc.getNum());
	System.out.println(inc.getNum());
	System.out.println(inc.getNum());
	System.out.println(inc.getNum());

	}
}
