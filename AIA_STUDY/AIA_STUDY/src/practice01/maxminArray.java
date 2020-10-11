package practice01;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MaxMinArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] array;
		
		System.out.println("입력할 숫자의 갯수를 입력해주세요");int num=sc.nextInt(); sc.nextLine();
		
		array = new int[num];

		
		
		for(int i=0; i<num;i++) {
			System.out.println("숫자를 입력해주세요"+(i+1)+"번째"); int a=sc.nextInt(); sc.nextLine();
			
			array[i]=a;
			
		}
		
		int max=0;
		for(int i=0; i<array.length;i++) {
			if(max<array[i]) {
				max = array[i];
			}
		}
		
		
		int min=0;
		min = array[0];
		for(int i=0; i<array.length;i++) {
			
			if(min>array[i]) {
				min = array[i];
			}
		}
	
		
			System.out.println("최대값은 :"+max);
			System.out.println("최소값은 :"+min);
		
	}

}
