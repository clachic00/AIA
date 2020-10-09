package practice01;

public class generic {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyArray<Integer> myarray = new MyArray();
		
		int a = 3;
		 myarray.setElement(a);
		 
		System.out.println(myarray.getElement()); 
	}
	
}


class MyArray<T> {

    T element;
    void setElement(T element) { this.element = element; }
    
    T getElement() { return element; }

}

