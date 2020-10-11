package chap02;

import java.util.Date;
import java.util.Scanner;

public class YMD {

	int y;
	int m;
	int d;
	
	public YMD(int y, int m, int d) {
		super();
		this.y = y;
		this.m = m;
		this.d = d;
	}

	 YMD after(int n) {
		
		int y=this.y;
		int m=this.m;
		int d=this.d;
		
	Date date1 = new Date(y,m,d);
	
	date1.setDate(d+n);
		 
	y=date1.getYear();
	m=date1.getMonth();
	d=date1.getDate();
		
	/* System.out.println(y+","+m+","+d); */
		
		 YMD ymd1 = new YMD(y,m,d);
		 
		return ymd1;
	}

	 YMD before(int n) {

				
				int y=this.y;
				int m=this.m;
				int d=this.d;
				
			Date date2 = new Date(y,m,d);
			
			date2.setDate(d-n);
				 
			y=date2.getYear();
			m=date2.getMonth();
			d=date2.getDate();

			/* System.out.println(y+","+m+","+d); */
				
				
				 YMD ymd2 = new YMD(y,m,d);
				 
				return ymd2;
	}




	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년을 입력해주세요"); int y=sc.nextInt();sc.nextLine();
		System.out.println("월을 입력해주세요"); int m=sc.nextInt();sc.nextLine();
		System.out.println("일을 입력해주세요"); int d=sc.nextInt();sc.nextLine();
		
		
		YMD ymd =  new YMD(y, m, d);
		
		System.out.println("며칠인지 입력해주세요"); int n=sc.nextInt();sc.nextLine();

		YMD af = ymd.after(n);
		YMD be = ymd.before(n);
		
		
		System.out.println(af.y+","+af.m+","+af.d);
		System.out.println(be.y+","+be.m+","+be.d);

		
		
		
		
		
		
		
		
		
		
	}
	
}

