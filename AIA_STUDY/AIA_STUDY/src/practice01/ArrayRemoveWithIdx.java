package practice01;

public class ArrayRemoveWithIdx {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 4, 1, 21 };
		arr = solution(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
	}

	public static int[] solution(int[] arr) {
		if (arr.length <= 1) {
			int[] answer = {-1};
			return answer;
		}
		
		int a = 0;
		int index=0;
		int count = 0;
		a = arr[0];
		for (int i = 0; i < arr.length; i++) {

			if (a > arr[i]) {
				a = arr[i];
			}
		}

		for (int l = 0; l < arr.length; l++) {
			if (a == arr[l]) {
				count++;
			}

		}
		int[]answer = new int[arr.length - count];
		for (int j = 0; j < arr.length; j++) {

			if (a != arr[j]) {
				answer[index]=arr[j];
				index++;
			}
		}
		return answer;
	}
}
