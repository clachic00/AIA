package chap01;

import java.util.Scanner;

public class addnum {

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요");int a = sc.nextInt();sc.nextLine();
		int add= addnum1(a);
		System.out.println("정답은 :"+add);
		
		
		System.out.println("숫자를 입력해주세요");int b = sc.nextInt();sc.nextLine();
		int add2= addnum2(b);
		System.out.println("정답은 :"+add2);
		
		
		System.out.println("작은 수를 입력해주세요"); int c = sc.nextInt();sc.nextLine();
		System.out.println("큰 수를 입력해주세요"); int d = sc.nextInt();sc.nextLine();
		int add3 = addnum3(c, d);
		System.out.println("정답은 :"+add3);

		
		sc.close();
	}

	static int addnum1(int a) {
		int add=0;
		for(int i=1; i<=a; i++)add+=i;
		
		return add;
	}
	
	static int addnum2(int b) {
		int add=0;
		add=(1+b)*b/2;
		
		return add;
	}
	
	static int addnum3(int c, int d) {
		int add=0;
		add=(c+d)*(d-c+1)/2;
		
		
		return add;
	}
}
