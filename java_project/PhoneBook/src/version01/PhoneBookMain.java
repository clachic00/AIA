package version01;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneInfor info = new PhoneInfor("손흥민","000-9999-0000","2000.11.11");
		
		info.showInfo();
		
		
		info = new PhoneInfor("박지성", "010-7777-5555");
		info.showInfo();
				
	}

}
