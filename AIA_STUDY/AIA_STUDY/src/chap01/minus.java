package chap01;

import java.util.Scanner;

public class minus {

	public static void main(String[] args) {

		
		
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("���� ���� a�� �Է����ּ���"); int a=sc.nextInt(); sc.nextLine();
		System.out.println("ū ���� b�� �Է����ּ���"); int b=sc.nextInt(); sc.nextLine();

		while(true) {
		if(a>=b) {System.out.println("a���� ū ���� b�� �Է����j����"); b=sc.nextInt(); sc.nextLine();}
			else {
				break;
			}
		}
		int minus=minus1(a, b);
		System.out.println("������1 :"+minus);
		System.out.println("������2 :"+minus1(a, b));
		
		System.out.println("�ڸ� ���� �ñ��� ���� c�� �Է����ּ���"); int c=sc.nextInt(); sc.nextLine();
		int digit = countDigits(c);
		System.out.println("������ : "+digit);
	}
	 
	static int minus1(int a, int b){
		
		int minus = 0;
		minus= b-a;
		return minus;
	}
	
	static int countDigits(int c){

		int digit = 0;
		if(c==0) {
			return 1;
		}
		while(c>0) {
			c= c/10;
			digit++;
			/* if(c<10) { digit++; break; } */
		}
		return digit;
	}
	
}
