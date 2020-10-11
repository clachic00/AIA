package chap02;

import java.util.Random;

public class ChangeOrder {

	public static void main(String[] args) {
	
		int[] n=null;
		Random rand = new Random();
		int num=0;
		int sum=0;
		
		System.out.println("배열의 길이는 이래요");
		num = 2+rand.nextInt(9);
		System.out.println(num);
		n= new int[num];
		
		System.out.println("배열 요소는 이래요");
		for(int i=0;i<num;i++) {
			n[i] =rand.nextInt(100);
		}

		changeArrayOrder(n);
		sum = sumOf(n);
		System.out.println(sum);
	}
	
	//Q2
	static void changeArrayOrder(int[] n) {
		
		int c=0;
		
		for(int i=0;i<n.length;i++)System.out.print(n[i]+" ");
		System.out.println();
		
		for(int j=0;j<n.length/2;j++) {
			
			c=n[j];
			n[j]=n[(n.length-1-j)];
			n[n.length-1-j]=c;
			
			System.out.println("Array["+(j)+"]과(와) Array["+(n.length-1-j)+"]를 교환");
			for(int i=0;i<n.length;i++) System.out.print(n[i]+" ");
			System.out.println();
			
		}
	
	}
	
	
	//Q3	
	static int sumOf(int[] n) {
		int sum=0;
		for(int i=0;i<n.length;i++)sum+=n[i];
		return sum;
	}

	
	
	
	
	
	
	
	
	
	
	

}
