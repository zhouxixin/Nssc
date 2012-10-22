package nssc.shared;





public class FieldVerifier {
	
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
}
