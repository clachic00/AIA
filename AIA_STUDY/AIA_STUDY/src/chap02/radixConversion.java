package chap02;

import java.util.Scanner;

public class RadixConversion {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		System.out.println("10진수를 기수 변환합니다.");
		
		System.out.println("변환하는 음이 아닌 정수를 입력해주세요");int x=sc.nextInt();sc.nextLine();
		System.out.println("어떤 진수로 변환할까요");int r=sc.nextInt();sc.nextLine();
		
		System.out.println(r+" |   "+x);
		int[] d=cardConv(x, r);
	
		System.out.print(r+"진수로 ");
		for(int i=0;i<d.length;i++) {
			System.out.print(d[i]);
		}
		System.out.println(" 입니다.");
	}

	//Q6,7
	static int[] cardConv(int x, int r) {
		
		int i=0;
		int a=0;
		int f=0;
		int[] b;
		int[] d;
		f=x;
		while(f!=0) {
			f=f/r;
			i++;
			
		}
		
		b = new int[i];
		d = new int[i];
		
		for(int j=0;j<b.length;j++) {
			a= x%r;
			x= x/r;
			b[j]=a;
		
			System.out.println("  +-------");
			if(x==0) {System.out.print("      ");}
				else {System.out.print(r+" |   ");}
			System.out.printf("%3d",x);
			System.out.println("..."+a);
			
		}
		
		int g=b.length-1; 
		
		for(int k=0;k<b.length;k++) {
			
			d[k]=b[g];
			g--;
		}	
		
		return d;
	}
	
	
	
}
