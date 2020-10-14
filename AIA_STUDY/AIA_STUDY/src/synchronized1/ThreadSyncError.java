package synchronized1;

class ThreadSyncError {
	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		it1.start();
		it2.start();
		it3.start();

	 try {
		 it1.join(); it2.join(); it3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		System.out.println(inc.getNum());
		System.out.println(inc.getNum());
		System.out.println(inc.getNum());
		System.out.println(inc.getNum());
		System.out.println(inc.getNum());
		System.out.println(inc.getNum());


        
		//실험할 코드 추가
		        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
	}
	
	
	
	
}
