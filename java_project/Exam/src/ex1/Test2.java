package ex1;

public class Test2 {

	public static void main(String[] args) {

//		문제2. 
//		숫자 15를 총 5회 출력하는 프로그램을 작성해 보자.
//		단 총 5회에 걸쳐서 출력이 이루어 져야 하고, 이를 위해서 구성이 되는 다섯
//		문장 모두 차이가 있어야 한다.

		System.out.println(15);
		System.out.println(3 * 5);
		System.out.println("15");

		for (int a = 0; a < 16; a += 1) {
			if (a == 15) {
				System.out.println(a);
			}

		}
		int c = 5;
		int d = 3;
		System.out.println(c * d);

		System.out.println(1 + "5");
		System.out.println("1" + "5");

	}

}
