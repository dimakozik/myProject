package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {
	
	public String createRandomString(int stringLength) {
		
		
		return RandomStringUtils.randomAlphanumeric(stringLength).toUpperCase();
	}

}
