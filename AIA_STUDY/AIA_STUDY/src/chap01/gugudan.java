package chap01;

import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		
		//Q12
		System.out.print("   |  1  2  3  4  5  6  7  8  9");
		System.out.println();
		System.out.print("---+---------------------------");
		System.out.println();
		
		for(int j=1; j<=9; j++) {
			System.out.print(j+"  |");
			for(int i=1; i<=9; i++) {
				System.out.printf("%3d",i*j);
			}
			System.out.println();
		}
		System.out.println("===============================");
		
		//Q13		
		System.out.print("   |  1  2  3  4  5  6  7  8  9");
		System.out.println();
		System.out.print("---+---------------------------");
		System.out.println();
		
		for(int j=1; j<=9; j++) {
			System.out.print(j+"  |");
			for(int i=1; i<=9; i++) {
				System.out.printf("%3d",i+j);
			}
			System.out.println();
		}
		
		//Q14
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		
		System.out.println("정사각형의 한 변의 길이를 입력해주세요"); int a = sc.nextInt();sc.nextLine();
		if(a==0) {
			break;
		}
		starSquare(a+1);
		
		}
		sc.close();
	}
	
	static void starSquare(int a) {
		
		String star ="*";
		
		for(int j=1;j<=a;j++) {
			for(int i=1;i<=a;i++) {
				System.out.printf(" "+star);
			}
			System.out.println();
		}
	}

}
