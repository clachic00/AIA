package chap02;

import java.util.Random;

public class random {
	//Q1
	public static void main(String[] args) {
		int[] height=null;
		Random rand = new Random();
		int num=0;
		
		System.out.println("숫자의 갯수는 이래요");
		num = 1+rand.nextInt(9);

		System.out.println(num);
		height= new int[num];
		
		for(int i=0;i<num;i++) {
			
		
		System.out.println("키는 이래요");
		
		height[i] =120+ rand.nextInt(70);
		
		
		System.out.println(height[i]);
		
		}
		
		
		int max = max(height);
		
		System.out.println("제일 큰 키는 "+max+"입니다.");
		
	}

	//Q1
	static int max(int[] a) {
		
		int max = a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max;
	}
	
	
	
}
