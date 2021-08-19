package by.tc.task01.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean requestValidator(String request) {
		
		Pattern pattern = Pattern.compile("^(add|find|remove)\stype="
				+ "(null|laptop|oven|refrigerator|speakers|tabletpc|vacuumcleaner)"
				+ "(\\s\\w+\\=\\S+)+");
		Matcher matcher = pattern.matcher(request);
		boolean result = matcher.matches();
				
		return result;
	}

}


