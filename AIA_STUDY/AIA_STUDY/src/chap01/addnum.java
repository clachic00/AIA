package chap01;

import java.util.Scanner;

public class addnum {

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		
		System.out.println("���ڸ� �Է����ּ���");int a = sc.nextInt();sc.nextLine();
		int add= addnum1(a);
		System.out.println("������ :"+add);
		
		
		System.out.println("���ڸ� �Է����ּ���");int b = sc.nextInt();sc.nextLine();
		int add2= addnum2(b);
		System.out.println("������ :"+add2);
		
		
		System.out.println("���� ���� �Է����ּ���"); int c = sc.nextInt();sc.nextLine();
		System.out.println("ū ���� �Է����ּ���"); int d = sc.nextInt();sc.nextLine();
		int add3 = addnum3(c, d);
		System.out.println("������ :"+add3);

		
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
