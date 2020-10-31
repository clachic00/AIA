package practice01;

import java.util.ArrayList;

public class FindPrimeNumber {

	public static void main(String[] args) {

		int a = solution(10);
		System.out.println(a);
	}

	public static int solution(int n) {
		int answer = 0;
		int a;
		ArrayList<Boolean> array = new ArrayList<Boolean>();
		
		for(int i=0;i<n;i++) {
		array.add(false);
		array.add(false);
		}
		for(int j=2;j*j<n;j++) {
			for(int i=j*j;i<n;i++) {
				
			}
		}
	
		return answer;
	}

}

//public static int solution(int n) {
//	int answer = 0;
//	int cnt = 0;
//
//	for (int j = 3; j <= n; j++) {
//	
//		for (int i = 2; i <= j / 2; i++) {
//			if (j % i == 0) {
//				System.out.println("J:"+j);
//				System.out.println("I:"+i);
//				cnt++;
//				break;
//			}
//
//		}
//		}
//	
//
//	answer = n - cnt -1;
//	return answer;
//}

//if(j%2==0||j%3==0||j%5==0||j%7==0||j%11==0) {
//	continue;
//}else {}
