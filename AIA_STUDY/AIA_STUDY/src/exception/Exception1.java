package exception;

public class Exception1 {

	int c = 1;
	int d = 2;
	public Exception1() {
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	
	
	@Override
	public String toString() {
		return "Exception1 [c=" + c + ", d=" + d + "]";
	}

	public static void main(String[] args) {
		int a = 0;
		Exception1 ex = new Exception1();
		
		System.out.println(ex);
		
		
		newNum(ex);
		
		System.out.println(ex);
		
		
		
	}

	static void newNum(Exception1 ex ) throws ArithmeticException {

		int f=0;
		   
		f=ex.getC();
		ex.setC(ex.getD());
		ex.setD(f);
		
		
		}


	
}
