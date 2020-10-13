package chap03;

import java.util.Scanner;

public class SeqSearchSenVerFor {
	//Q1,Q2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"]:");
			x[i]=sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();
		
		int idx = seqSearchSen(x, num, ky);
		
		if(idx==-1)System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
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
