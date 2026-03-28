package validation;

public class App {

	public static void main(String[] args) {
		if(Validation.nummberonly("12345")) {
			System.out.println("correct");
		}
		else {
			System.out.println("invalid");
		}
		
	}

}
