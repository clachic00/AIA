package practice01;

import java.util.ArrayList;

public class ternary {

	public static void main(String[] args) {

		int a = solution(45);
		System.out.println(a);
		
	}
	
	  public static int solution(int n) {
	        int answer = 0;
	        int rest=0;
	        ArrayList<Integer> array = new ArrayList<>();
	        
	        for(int i=0;n!=0;i++){
	            rest=n%3;
	            n=n/3;
	            System.out.println(rest);
	            System.out.println(array);
	            array.add(rest);
	            System.out.println(array);
	        }
	      
	        System.out.println(array);
	        for(int j=0;j<array.size();j++) {
	        answer*= 3;
	        System.out.println("answer1:"+answer);
	        answer+=array.get(j);
	        
	        System.out.println("answer2:"+answer);
	        
	        }
	        return answer;
	    }
}
