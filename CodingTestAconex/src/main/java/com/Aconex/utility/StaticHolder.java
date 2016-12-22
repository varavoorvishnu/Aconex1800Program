package main.java.com.Aconex.utility;

public class StaticHolder {

	public StaticHolder() {
		// TODO Auto-generated constructor stub
	}
	private final static String dictWordPattern="[\\p{Punct}\\s\\d]+";
	private final static String phoneNumberPattern="[^0-9\\.]+";
	
	private final static String dictionaryfilePath ="/Users/vvishnuvardhanan/Documents/workspace/CodingTestAconex/bin/main/java/com/Aconex/files/";
	private final static String dictionaryfileName="dictionary.txt";
	
	
	private final static String phoneNumbersfilePath ="/Users/vvishnuvardhanan/Documents/workspace/CodingTestAconex/bin/main/java/com/Aconex/files/";
	private final static String phoneNumbersfileName="phonenumber.txt";
	
	
	public static String getDictwordpattern() {
		return dictWordPattern;
	}
	public static String getPhonenumberpattern() {
		return phoneNumberPattern;
	}
	public static String getDictionaryfilepath() {
		return dictionaryfilePath;
	}
	public static String getDictionaryfilename() {
		return dictionaryfileName;
	}
	
	public static String getPhonenumbersfilepath() {
		return phoneNumbersfilePath;
	}
	public static String getPhonenumbersfilename() {
		return phoneNumbersfileName;
	}
	
	


}
