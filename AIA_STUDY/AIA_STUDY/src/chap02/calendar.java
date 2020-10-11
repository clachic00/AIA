package chap02;

import java.util.Date;
import java.util.Scanner;

public class Calendar {

	//Q8,9
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("³â :");int y=sc.nextInt();sc.nextLine();
		System.out.println("¿ù :");int m=sc.nextInt();sc.nextLine();
		System.out.println("ÀÏ :");int d=sc.nextInt();sc.nextLine();
		
		Date date = new Date(y,m,d);
		Date date2 = new Date(y,1,1);
		Date date3 = new Date(y,12,31);
		
		long a = date.getTime();
		long b = date2.getTime();
		long c = date3.getTime();
		
		long f = (a-b)/1000/60/60/24;
		long g = (c-a)/1000/60/60/24;
		
		System.out.println(f);
		
		System.out.println(g);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
