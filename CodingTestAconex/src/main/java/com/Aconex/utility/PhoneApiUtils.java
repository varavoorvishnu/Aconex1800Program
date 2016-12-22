package main.java.com.Aconex.utility;

import java.util.List;
import java.util.regex.Pattern;
/*
 * Author: V.Vishnuvardhanan,
 * Description: This class contains all the utility functions required by the application.
 * 
 */

public class PhoneApiUtils {
	private static Pattern pattern; 
	
	
	/* Method 1 - justTrim ; Input Parameters : 1 , Type : String ; return Type : boolean
	 * Description : Trims given String  
	 */
	public static String justTrim(String phoneNum){
			return phoneNum.trim();
		}
	
	/* Method 2 - justTrim ; Input Parameters : 1 , Type : String ; return Type : boolean
	 * Description : Trims and does upperCase of given string  
	 */
	public static String trimWithUpperCase(String dictValue){
		return dictValue.trim().toUpperCase();
	}
	
	/* Method 3 - splitStringOnDot ; Input Parameters : 1 , Type : String ; return Type : String[]
	 * Description : Splits the given string delimited by "."  
	 */
	public static String[] splitStringOnDot(String inputString){
		 inputString=inputString.replace(".", "-");
		 return (inputString.split("-"));
	}

	/* Method 4 - isEmptyList ; Input Parameters : 1 , Type : List<String> ; return Type : boolean
	 * Description : Check if the given LIST is null or empty or no values and if not any one of these returns true  
	 */
	public static boolean isEmptyList(List<String> inputList){
		return ((inputList!=null) && (inputList.size()!=0) && (!inputList.isEmpty()));
	}

	/* Method 5 - isEmptyList ; Input Parameters : 1 , Type : String ; return Type : boolean
	 * Description : Check if the given STRING is null or 	empty or no values and if not any one of these returns true  
	 */
	public static boolean isEmptyString(String inputString){
		return ((inputString!=null) && (!(inputString.isEmpty()) && (inputString!="") && (inputString.length()!=0)));
	}

	/* Method 6 - join1800Number ; Input Parameters : n , Type : String ; return Type : String
	 * Description : Prefixes  1-800 with the result value  
	 */
    public static String join1800Number(String... elements) {
        final StringBuilder builder = new StringBuilder("1-800");
        for (String element : elements) {
            builder.append("-").append(element);
        }
        return builder.toString();
    }

    /* Method 7 - printResultWith1800ForIntegerWithValueAndZeroSize ; Input Parameters : 2 , Type : List<String> ,String ; return Type : void
	 * Description : Appends 1-800 depending on the size of the list. Uses  join1800Number method  
	 */
    public static void printResultWith1800ForIntegerWithValueAndZeroSize(List<String> new_list,String phoneNum) {
    	if(new_list.size()!=0){
    		for(String a: new_list){
    			System.out.println(join1800Number(a));
    		}
    	}else{
    			System.out.println(join1800Number(phoneNum));
    	}
    }

    /* Method 8 - isDotFound ; Input Parameters : 1 , Type : String ; return Type : boolean
   	 * Description : Searchers for "." in a given String and returns true if it is not found.  
   	 */
    public static boolean isDotFound(String phoneNum){
    	return (justTrim(phoneNum).indexOf(".")!=-1);
    }
    
    /* Method 9 - validateGivenNumberForWholeAndDigits ; Input Parameters : 1 , Type : String ; return Type : boolean
   	 * Description : Checks the given number and returns true if it matches pattern. Allows only integer and decimal numbers.  
   	 */
    public static boolean validateGivenNumberForWholeAndDigits(String inputNumber) {
	pattern= Pattern.compile("(\\d+(?:\\.\\d+)?)");
	return (pattern.matcher(justTrim(inputNumber)).matches());
}	
    /* Method 10 - validateDictionaryValues ; Input Parameters : 1 , Type : String ; return Type : boolean
   	 * Description : Validate the values read from dictionary are only words or characters  
   	 */
    public static boolean validateDictionaryValues(String dictValue) {
    	Pattern pat = Pattern.compile("\\w+\\.?");
		return pat.matcher(trimWithUpperCase(dictValue)).matches();
}

    /* Method 10 - removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers ; Input Parameters : 2 , Type : String,String ; return Type : String
   	 * Description :  Removes white space and punctuation in the given string and returns the stripped string  
   	 */
    public static String remvePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(String orgValue,String stringpattern) {
		 String replacedValue ="";
        replacedValue = orgValue.replaceAll(stringpattern,"");
        return replacedValue;
	   }
    
    /* Method 11 - boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers ; Input Parameters : 2 , Type : String,String ; return Type : boolean
   	 * Description :  Checks if the given string is having white space and punctuation in the given string and returns boolean.  
   	 */
    public static boolean boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(String orgValue,String stringpattern) {
    	Pattern pat = Pattern.compile(PhoneApiUtils.getPhoneNumberPattern());
    	return pat.matcher(orgValue).matches();
	   }

    /* Method 12 - getDictWordPattern ; Input Parameters : 0 , Type : None ; return Type : String
   	 * Description :  returns word pattern required to read from dictionary words  
   	 */
	public static String getDictWordPattern() {
		return StaticHolder.getDictwordpattern();
	}
	
	/* Method 13 - getPhoneNumberPattern ; Input Parameters : 0 , Type : None ; return Type : String
   	 * Description :  returns word pattern required to read from phone numbers words  
   	 */
	public static String getPhoneNumberPattern() {
		return StaticHolder.getPhonenumberpattern();
	}
}
