package chap02;

import java.util.Scanner;

public class RadixConversion {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		System.out.println("10������ ��� ��ȯ�մϴ�.");
		
		System.out.println("��ȯ�ϴ� ���� �ƴ� ������ �Է����ּ���");int x=sc.nextInt();sc.nextLine();
		System.out.println("� ������ ��ȯ�ұ��");int r=sc.nextInt();sc.nextLine();
		
		System.out.println(r+" |   "+x);
		int[] d=cardConv(x, r);
	
		System.out.print(r+"������ ");
		for(int i=0;i<d.length;i++) {
			System.out.print(d[i]);
		}
		System.out.println(" �Դϴ�.");
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
