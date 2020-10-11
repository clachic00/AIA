package chap01;

import java.util.Scanner;

public class tree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//Q15
		System.out.println("이등변 삼각형의 한 변의 별갯수를 입력해주세요"); int a = sc.nextInt();sc.nextLine();
		triangleLB(a);
		System.out.println("=====================");
		triangleLU(a);
		System.out.println("=====================");
		triangleRU(a);
		System.out.println("=====================");
		triangleRB(a);

		
		//Q16
		System.out.println("트리의 층 수를 입력해주세요"); int n = sc.nextInt();sc.nextLine();
		spira(n);
		
		//Q17
		System.out.println("트리의 층 수를 입력해주세요"); int m = sc.nextInt();sc.nextLine();
		npira(m);
		
		sc.close();
	}

	//Q15
	static void triangleLB(int a) {
		for(int j=1;j<=a;j++){
		
			for(int i=1;i<=a;i++){
				System.out.print("* ");
				if(i==j) {
					break;
				}
			}
			System.out.println();
		}
	}
	
	static void triangleLU(int a) {
		
		for(int j=1;j<=a;j++){
			for(int i=a;i>=1;i--){
				System.out.print("* ");
				if(i==j) {
					break;
				}
			}
			System.out.println();
		}
	}
	static void triangleRU(int a) {
		
		for(int j=1;j<=a;j++){
			
			for(int k=1;k<=a;k++) {
				if(k==j) {
					break;
				}
				System.out.print("  ");
			}
			
			for(int i=a;i>=1;i--){
				System.out.print("* ");
				if(i==j) {
					break;
				}
			}
			System.out.println();
		

		}
		
	}
	static void triangleRB(int a) {
		
		for(int j=1;j<=a;j++){
			
			for(int k=a;k>=1;k--) {
				if(k==j) {
					break;
				}
				System.out.print("  ");
			}
			
			for(int i=1;i<=a;i++){
				System.out.print("* ");
				if(i==j) {
					break;
				}
			}
			System.out.println();
		}
	}
	
	//Q16
	static void spira(int n) {
			for(int j=1;j<=n;j++){
			
			for(int k=n;k>=1;k--) {
				if(k==j) {
					break;
				}
				System.out.print(" ");
			}
			
			for(int i=1;i<=n*2-1;i++){
				System.out.print("*");
				if(i==j*2-1) {
					break;
				}
			}
			System.out.println();
		}
	}
	
	//Q17
	static void npira(int n) {
		for(int j=1;j<=n;j++){
			
			for(int k=n;k>=1;k--) {
				if(k==j) {
					break;
				}
				System.out.print(" ");
			}
			
			for(int i=1;i<=n*2-1;i++){
				if(j>=10) {int f=j%10;System.out.print(f);}
				else{System.out.print(j);}
				if(i==j*2-1) {
					break;
				}
			}
			System.out.println();
		}
	}

}
