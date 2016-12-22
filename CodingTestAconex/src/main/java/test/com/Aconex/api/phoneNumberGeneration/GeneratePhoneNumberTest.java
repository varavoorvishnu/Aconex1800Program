package main.java.test.com.Aconex.api.phoneNumberGeneration;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhone1800withNumberName;
import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhoneNumber;
import main.java.test.com.Aconex.utility.CaptureTest;
import main.java.test.com.Aconex.utility.TestHelperSysOut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GeneratePhoneNumberTest {
private GeneratePhoneNumber generatePhNum;
private List<String> memberNames ;

	@Before
	public void init() throws Exception {
		generatePhNum = new GeneratePhone1800withNumberName() ;
		memberNames = new ArrayList<String>();
		memberNames.add("call");
		memberNames.add("king");
		memberNames.add("monkey");
		memberNames.add("liog");
		memberNames.add("monk");
		memberNames.add("cat");
		memberNames.add("ca");
		memberNames.add("be");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("bat");
		memberNames.add("dlower");
		memberNames.add("blowers");
		memberNames.add("flower");
		memberNames.add("Lokesh");
		memberNames.add("me");
		memberNames.add("nonkey");
		memberNames.add("oonkey");
		memberNames.add("oEEEonkey");
		memberNames.add("oo  SSD nkey");
		memberNames.add("act");
		memberNames.add("donk");
		
	}


@Test
	public void processGnNumber_valid_integer_string()throws Exception{
String phoneNum="2255";
String result="re-routing to returnValidDictionaryNames";
Assert.assertEquals(result,generatePhNum.processGnNumber(phoneNum, memberNames));
	
}
@Test
	public void processGnNumber_valid_decimal_string()throws Exception{
	String phoneNum="2255.23";
	String result="re-routing to generateFinalNamesToMap";
	Assert.assertEquals(result,generatePhNum.processGnNumber(phoneNum, memberNames));
}
@Test
	public void processGnNumber_empty_integer_string()throws Exception{
String phoneNum="";
String result="";
Assert.assertEquals(result,generatePhNum.processGnNumber(phoneNum, memberNames));
	
}
@Test
	public void processGnNumber_empty_decimal_string()throws Exception{
	String phoneNum="";
	String result="";
	Assert.assertEquals(result,generatePhNum.processGnNumber(phoneNum, memberNames));
}

	@Test
	public void returnValidDictionaryNames_returns_oneValue_matching_String_from_Dictionary_for_given_PhoneNum()throws Exception {
		String inputNumber="2255";
		List<String> expected = new ArrayList<String>();
		expected.add("CALL");
		 Assert.assertEquals(expected,generatePhNum.returnValidDictionaryNames(inputNumber, memberNames));
	}
	@Test
	public void returnValidDictionaryNames_returns_matching_List_from_Dictionary_for_given_PhoneNum()throws Exception {
		String inputNumber="228";
		List<String> expected = new ArrayList<String>();
		expected.add("CAT");
		expected.add("BAT");
		expected.add("ACT");
		 Assert.assertEquals(expected,generatePhNum.returnValidDictionaryNames(inputNumber, memberNames));
	}
	@Test
	public void returnValidDictionaryNames_for_a_given_integerString__Not_matching_return_the_given_Phone_Number()throws Exception {
		String inputNumber="22551";
		List<String> expected = new ArrayList<String>();
		expected.add("");
		 Assert.assertEquals(0,generatePhNum.returnValidDictionaryNames(inputNumber, memberNames).size());
	}
	@Test
	public void returnValidDictionaryNames_for_a_given_Empty_String__Not_matching_return_the_given_Phone_Number()throws Exception {
		String inputNumber="";
		List<String> expected = new ArrayList<String>();
		expected.add("");
		 Assert.assertEquals(0,generatePhNum.returnValidDictionaryNames(inputNumber, memberNames).size());
	}
	@Test
	public void returnValidDictionaryNames_for_given_String_matching_return_the_given_Phone_Number() {
		String inputNumber="356937";
		List<String> expected = new ArrayList<String>();
		expected.add("DLOWER");
		expected.add("FLOWER");
		 Assert.assertEquals(expected,generatePhNum.returnValidDictionaryNames(inputNumber, memberNames));
	}
	
	@Test
	public void generateFinalNamesToMap_with_left_String_value_and_no_right_String()throws Exception{
		String inputNumber="23.4";
		Map<Integer,List<String>> expectedMap = new LinkedHashMap<Integer,List<String>>();
		List<String> al1 = new ArrayList<String>();
		List<String> al2 = new ArrayList<String>();
		al1.add("BE");
		expectedMap.put(0,al1);
		expectedMap.put(1, al2);
		generatePhNum.generateFinalNamesToMap(inputNumber, memberNames);
		 Assert.assertEquals(expectedMap,generatePhNum.getMyMap());
	}
	@Test
	public void generateFinalNamesToMap_with_no_String()throws Exception{
		String inputNumber=".";
		Map<Integer,List<String>> expectedMap = new LinkedHashMap<Integer,List<String>>();
		generatePhNum.generateFinalNamesToMap(inputNumber, memberNames);
		 Assert.assertEquals(expectedMap,generatePhNum.getMyMap());
	}
	@Test
	public void generateFinalNamesToMap_with_left_String_value_and_right_String() throws Exception{
		String inputNumber="23.2255";
		Map<Integer,List<String>> expectedMap = new LinkedHashMap<Integer,List<String>>();
		List<String> al1 = new ArrayList<String>();
		List<String> al2 = new ArrayList<String>();
		al1.add("BE");
		al2.add("CALL");
		expectedMap.put(0,al1);
		expectedMap.put(1, al2);
		generatePhNum.generateFinalNamesToMap(inputNumber, memberNames);
		 Assert.assertEquals(expectedMap,generatePhNum.getMyMap());
	}
	@Test
	public void generateFinalNamesToMap_with_left_String_value_and_right_String_multiple_value_available_combinations() throws Exception
	{
		String inputNumber="666539.228";
		Map<Integer,List<String>> expectedMap = new LinkedHashMap<Integer,List<String>>();
		List<String> al1 = new ArrayList<String>();
		List<String> al2 = new ArrayList<String>();
		al1.add("MONKEY");
		al1.add("NONKEY");
		al1.add("OONKEY");
		al2.add("CAT");
		al2.add("BAT");
		al2.add("ACT");
		expectedMap.put(0,al1);
		expectedMap.put(1, al2);
		generatePhNum.generateFinalNamesToMap(inputNumber, memberNames);
		 Assert.assertEquals(expectedMap,generatePhNum.getMyMap());
	}
	
@Test	
	public void addUpStrings_with_list()throws Exception{
	String phoneNum="2255";
	String result="1-800-call\n"+
			"1-800-king\n"+
			"1-800-monkey\n"+
			"1-800-liog\n"+
			"1-800-monk\n"+
			"1-800-cat\n"+
			"1-800-ca\n"+
			"1-800-be\n"+
			"1-800-Salman\n"+
			"1-800-Yana\n"+
			"1-800-bat\n"+
			"1-800-dlower\n"+
			"1-800-blowers\n"+
			"1-800-flower\n"+
			"1-800-Lokesh\n"+
			"1-800-me\n"+
			"1-800-nonkey\n"+
			"1-800-oonkey\n"+
			"1-800-oEEEonkey\n"+
			"1-800-oo  SSD nkey\n"+
			"1-800-act\n"+
			"1-800-donk\n";
			
			
	try {
		TestHelperSysOut.captureOutput( new CaptureTest() {
		    @Override
		    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
		    	generatePhNum.addUpStrings(memberNames);
		    	Assert.assertEquals(result, outContent.toString());
		    }
		});
	} catch (Exception e) {
		e.printStackTrace();
	}
}
@Test	
	public void addUpStrings_with_Map()throws Exception{
	
	String result="1-800-CALL-CAT\n"+
			"1-800-CALL-BAT\n"+
			"1-800-CALL-ACT\n";
	
	List<String> al1 = new LinkedList<String>();
	List<String> al2 = new LinkedList<String>();
	
	al1.add("CALL");
	al2.add("CAT");
	al2.add("BAT");
	al2.add("ACT");
			
	Map<Integer,List<String>> myMap= new LinkedHashMap<Integer, List<String>>();
	myMap.put(0, al1);
	myMap.put(1, al2);
	
	try {
		TestHelperSysOut.captureOutput( new CaptureTest() {
		    @Override
		    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
		    	generatePhNum.addUpStrings(myMap);
		    	Assert.assertEquals(result, outContent.toString());
		    }
		});
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
}
