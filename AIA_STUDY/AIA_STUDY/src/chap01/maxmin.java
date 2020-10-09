package chap01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class maxmin {
	
	
	
	public static void main(String[] args) {
		
		int max4= max4();
		System.out.println(max4);
		
		int min3=min3();
		System.out.println(min3);
		
		int min4=min4();
		System.out.println(min4);

		
		
		
	}

	static int max4(){
		Scanner sc = new Scanner(System.in);

		
		System.out.println("a값 입력해주세요"); int a= sc.nextInt(); sc.nextLine();
		System.out.println("b값 입력해주세요"); int b= sc.nextInt(); sc.nextLine();
		System.out.println("c값 입력해주세요"); int c= sc.nextInt(); sc.nextLine();
		System.out.println("d값 입력해주세요"); int d= sc.nextInt(); sc.nextLine();

		
		int max = a;
		
		if(a<b){max=b;}
		if(max<c){max=c;}
		if(max<d){max=d;}
		
		
		return max;
	}
	
	static int min3(){
		Scanner sc = new Scanner(System.in);

		
		System.out.println("a값 입력해주세요"); int a= sc.nextInt(); sc.nextLine();
		System.out.println("b값 입력해주세요"); int b= sc.nextInt(); sc.nextLine();
		System.out.println("c값 입력해주세요"); int c= sc.nextInt(); sc.nextLine();

		
		int max = a;
		
		if(a>b){max=b;}
		if(max>c){max=c;}
		
		
		return max;
	}
	static int min4(){
		Scanner sc = new Scanner(System.in);

		
		System.out.println("a값 입력해주세요"); int a= sc.nextInt(); sc.nextLine();
		System.out.println("b값 입력해주세요"); int b= sc.nextInt(); sc.nextLine();
		System.out.println("c값 입력해주세요"); int c= sc.nextInt(); sc.nextLine();
		System.out.println("d값 입력해주세요"); int d= sc.nextInt(); sc.nextLine();

		
		int max = a;
		
		if(a>b){max=b;}
		if(max>c){max=c;}
		if(max>d){max=d;}
		
		
		return max;
	}
	
		 
	
	
	
	
	
}
