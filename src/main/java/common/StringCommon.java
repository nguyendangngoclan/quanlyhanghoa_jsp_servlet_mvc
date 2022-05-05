package common;

import java.text.DecimalFormat;

public class StringCommon {
	public static String convertNumberToString(long number,int digit) {
		number = number + 10000000000000000L;
		String returnedStr = String.valueOf(number); 
		return returnedStr.substring(returnedStr.length() - digit);
	}
	public static String convertDoubleToString(double d) {
		return new DecimalFormat("#").format(d);
	}
	  public static String convertDoubleToStringWithComma(double d) {
          return new DecimalFormat("###,###").format(d);

  }
}
