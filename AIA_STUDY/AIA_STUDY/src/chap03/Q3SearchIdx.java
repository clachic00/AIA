package chap03;

import java.util.Scanner;

public class Q3SearchIdx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ���");
		int num = sc.nextInt(); sc.nextLine();
		int[] x = new int[num]; // ��ڼ� num�� �迭
		int[] y = new int[num]; // ��ڼ� num�� �迭

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = sc.nextInt(); sc.nextLine();
		}
		System.out.print("ã�� ����"); // Ű ���� �Է� ����
		int ky = sc.nextInt(); sc.nextLine();

		int count = searchIdx(x, num, ky, y);

		if (count == 0)
			System.out.println("��Ұ� �����ϴ�.");
		else
			for (int i = 0; i < count; i++)
				System.out.println("���� " + "x[" + y[i] + "]�� �ֽ��ϴ�.");
	}

	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int cnt = 0; 
		for (int i = 0; i < n; i++)
			if (a[i] == key)
				idx[cnt++] = i;
		return cnt;
	}
	
	
	
	
}
