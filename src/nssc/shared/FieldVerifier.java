package nssc.shared;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

public class FieldVerifier {
	
	public static boolean isValidDecimal(String input) {		
		RegExp regExp = RegExp.compile("[^.'0-9]");
		MatchResult matcher = regExp.exec(input);
		boolean matchFound = (matcher != null); // equivalent to regExp.test(inputStr); 
		if (input == null) {
			return false;
		} else if (input.length() == 0) {
			return false;
		} else if (matchFound){
			return false;
		} else {
			return true;
		}
	}		
}
