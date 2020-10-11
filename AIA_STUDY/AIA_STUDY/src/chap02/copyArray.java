package chap02;

import java.util.Random;

public class CopyArray {

	public static void main(String[] args) {
		int[] a=null;
		int[] b=null;
		Random rand = new Random();
		int num=0;
		
		System.out.println("배열의 길이는 이래요");
		num = 2+rand.nextInt(9);
		System.out.println(num);
		a= new int[num];
		b= new int[num];
		
		System.out.println("b의 배열 요소는 이래요");
		for(int i=0;i<num;i++) {
			b[i] =rand.nextInt(100);
			System.out.print(b[i]+" ");
		}
		System.out.println();
		System.out.println("================================");
		
		
			a = copy(a, b);
		
		System.out.println("copy a의 배열 요소는 이래요");
		for(int i=0;i<num;i++) {
			System.out.print(a[i]+" ");
		}
		
		
		System.out.println();
		System.out.println("================================");
		
		
			a = rcopy(a, b);
		
			
		System.out.println("rcopy a의 배열 요소는 이래요");
		for(int i=0;i<num;i++) {
			System.out.print(a[i]+" ");
		}
		
		
		
		
	}

	
	//Q4
	static int[] copy(int[] a, int[] b) {
		 
		for(int i=0;i<b.length;i++){
			a[i]=b[i];
		}
		
		return a;
	
	
	}
	//Q5
	static int[] rcopy(int[] a, int[] b){
		for(int i=0;i<b.length;i++){
			a[b.length-1-i]=b[i];
		}
		return a;
	}
	
}
