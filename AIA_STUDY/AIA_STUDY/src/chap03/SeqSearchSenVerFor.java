package chap03;

import java.util.Scanner;

public class SeqSearchSenVerFor {
	//Q1,Q2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"]:");
			x[i]=sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int idx = seqSearchSen(x, num, ky);
		
		if(idx==-1)System.out.println("그 값의 요소가 없습니다.");
		else System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
	}

	static int seqSearchSen(int[] a, int n, int key) {
		System.out.print("   |");
		for(int j=0;j<n;j++) {
			System.out.print("  "+j);
		}
		System.out.println();
		System.out.println("---+----------------------------------------");
		
		int i=0;
		a[n]=key;
//		while(true) {
//			if(a[i]==key)break;
//			i++;
//		}
		
		for(i=0;i<n;i++) {
			
			System.out.print("   |");
			for(int f=0; f<i;f++){
				
				System.out.print("   ");
		
			}
			System.out.printf("%3s","*");
	
			System.out.println();
			System.out.printf("%3d",i);
			System.out.print("|");
			for(int k=0;k<n;k++) {
				System.out.printf("%3d",a[k]);
			}
			System.out.println();
			
			
			if(a[i]==key)break;
		}
		
		
		return i==n?-1:i;
	}
	
	
	
	
	
	
	
	
	
}
