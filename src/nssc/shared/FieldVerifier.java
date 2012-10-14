package nssc.shared;

public class FieldVerifier {
	
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	public static boolean isValidNumber(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
}
