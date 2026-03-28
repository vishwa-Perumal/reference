package validation;

public class Validation {
	
	public static boolean nummberonly(String s){
		if(s.matches("^[0-9]+")) {
			return true;
		}
		return false;
	}

}
