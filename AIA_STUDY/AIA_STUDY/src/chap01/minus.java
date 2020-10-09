package chap01;

import java.util.Scanner;

public class minus {

	public static void main(String[] args) {

		
		
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("작은 숫자 a를 입력해주세요"); int a=sc.nextInt(); sc.nextLine();
		System.out.println("큰 숫자 b를 입력해주세요"); int b=sc.nextInt(); sc.nextLine();

		while(true) {
		if(a>=b) {System.out.println("a보다 큰 숫자 b를 입려개훚세요"); b=sc.nextInt(); sc.nextLine();}
			else {
				break;
			}
		}
		int minus=minus1(a, b);
		System.out.println("정답은1 :"+minus);
		System.out.println("정답은2 :"+minus1(a, b));
		
		System.out.println("자리 수가 궁금한 숫자 c를 입력해주세요"); int c=sc.nextInt(); sc.nextLine();
		int digit = countDigits(c);
		System.out.println("정답은 : "+digit);
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
