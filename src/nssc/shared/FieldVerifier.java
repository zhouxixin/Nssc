package nssc.shared;





public class FieldVerifier {
	
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	public static boolean isValidDecimal(String input) {
		if (input == null) {
			return false;
		} else if (input.length() == 0) {
			return false;
		} else if (input.matches("\\p{L}+")){
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean generalValidation(String input) {
		if(!isValidDecimal(input)) {
			return false;
		}
		
		return true;
	}
		
}
