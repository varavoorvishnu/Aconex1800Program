package main.java.test.com.Aconex.utility;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import main.java.com.Aconex.utility.PhoneApiUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneApiUtilsTest {
	PhoneApiUtils utils;
	String  result="";
	@Before
	public void init() throws Exception{
		 utils = new PhoneApiUtils();
			Assert.assertNotNull(utils);
	}
//For Method1-justTrim_String-cases:
	
	@Test
	public void justTrim_String_with_front_Space_Trailing() throws Exception{
		String trimmedValue=PhoneApiUtils.justTrim(" 234");
		Assert.assertEquals("234",trimmedValue );
	}
	@Test
	public void justTrim_String_with_back_space_Trailing() throws Exception{
		String trimmedValue=PhoneApiUtils.justTrim("234 ");
		Assert.assertEquals("234",trimmedValue );
	}
	@Test
	public void justTrim_String_with_frontAnd_back_space_Trailing() throws Exception{
		String trimmedValue=PhoneApiUtils.justTrim(" 234 ");
		Assert.assertEquals("234",trimmedValue );
	}
	
//For Method2-trimWithUpperCase-cases
	
	@Test
	public void trimWithUpperCase_String_with_back_space_Trailing_with_LowerCase() throws Exception{
		String trimmedValue=PhoneApiUtils.trimWithUpperCase("abc ");
		Assert.assertEquals("ABC",trimmedValue );
	}
	@Test
	public void trimWithUpperCase_String_with_front_space_Trailing_with_LowerCase() throws Exception{
		String trimmedValue=PhoneApiUtils.trimWithUpperCase(" abc");
		Assert.assertEquals("ABC",trimmedValue );
	}
	@Test
	public void trimWithUpperCase_String_with_front_and_back_space_Trailing_with_LowerCase() throws Exception{
		String trimmedValue=PhoneApiUtils.trimWithUpperCase(" abc ");
		Assert.assertEquals("ABC",trimmedValue );
	}
	
//Method 3 - splitStringOnDot-case
	
	@Test
	public void splitStringOnDot_with_valid_String() throws Exception{
		String[] splitValue=PhoneApiUtils.splitStringOnDot("123.45");
		Assert.assertEquals("123",splitValue[0] );
		Assert.assertEquals("45",splitValue[1] );
	}
	
//Method 4- isEmptyList-cases
	
	@Test
	public void isEmptyList_with_null_list() throws Exception{
		List<String> al = null;
		Assert.assertFalse(PhoneApiUtils.isEmptyList(al));
	}
	@Test
	public void isEmptyList_with_valid_list() throws Exception{
		List<String> al = new ArrayList<String>();
		al.add("a");
		Assert.assertTrue(PhoneApiUtils.isEmptyList(al));
	}
	@Test
	public void isEmptyList_with_valid_list_with_size_zero() throws Exception{
		List<String> al = new ArrayList<String>();
		Assert.assertFalse(PhoneApiUtils.isEmptyList(al));
	}
	@Test
	public void isEmptyList_with_valid_list_empty() throws Exception{
		List<String> al = new ArrayList<String>();
		Assert.assertFalse(PhoneApiUtils.isEmptyList(al));
	}

// Method 5- isEmptyString-cases
	
	@Test
	public void isEmptyString_with_size_zero_string() throws Exception{
		Assert.assertFalse(PhoneApiUtils.isEmptyString(""));
	}
	@Test
	public void isEmptyString_with_empty_string() throws Exception{
		Assert.assertFalse(PhoneApiUtils.isEmptyString(""));
	}
	@Test
	public void isEmptyString_with_null_string() throws Exception{
		Assert.assertFalse(PhoneApiUtils.isEmptyString(null));
	}
	
// Method 6 -join1800Number-cases
	
	@Test
	public void join1800Number_concating_with_1800_with_given_String_with_hypen() throws Exception{
		String str ="CAT";
		Assert.assertEquals("1-800-CAT",PhoneApiUtils.join1800Number(str));
	}

// Method 7-printResultWith1800ForIntegerWithValueAndZeroSize - cases
	
	@Test
	public void printResultWith1800ForIntegerWithValueAndZeroSize_with_Zero_size() throws Exception{
		List<String> al = new ArrayList<String>();
		String phoneNum="2558";
		TestHelperSysOut.captureOutput( new CaptureTest() {
	            @Override
	            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
	                PhoneApiUtils.printResultWith1800ForIntegerWithValueAndZeroSize(al, phoneNum);
	                Assert.assertEquals( "1-800-2558\n", outContent.toString() );
	            }
	        });

	
	}
	@Test
	public void printResultWith1800ForInteger_with_values_in_List_non_zero() throws Exception{
		List<String> al1 = new ArrayList<String>();
		al1.add("ABC");
		al1.add("DEF");
		String[] listArray={"1-800-ABC\n","1-800-DEF\n"};
		
		String phoneNum="2558";
		TestHelperSysOut.captureOutput( new CaptureTest() {
	            @Override
	            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
	            	PhoneApiUtils.printResultWith1800ForIntegerWithValueAndZeroSize(al1, phoneNum);
	            	
	            		Assert.assertEquals(listArray[0]+listArray[1],outContent.toString());	
					
	            	
	            }
	        });
	}
	
// Method 8-isDotFound - cases
	
	@Test
	public void isDotFound_find_dot_location_in_String() throws Exception{
		String str ="2345.678";
		Assert.assertEquals(true,PhoneApiUtils.isDotFound(str));
	}
	@Test
	public void isDotFound_find_dot_location_withoutDOT_in_String() throws Exception{
		String str ="2345678";
		Assert.assertEquals(false,PhoneApiUtils.isDotFound(str));
	}

	// Method-9-validateGivenNumberForWholeAndDigits
	
	@Test
	public void validateGivenNumberForWholeAndDigits_without_dot() throws Exception{
		String str ="2345678";
		Assert.assertEquals(true,PhoneApiUtils.validateGivenNumberForWholeAndDigits(str));
	}
	@Test
	public void validateGivenNumberForWholeAndDigits_with_dot() throws Exception{
		String str ="2345678.9";
		Assert.assertEquals(true,PhoneApiUtils.validateGivenNumberForWholeAndDigits(str));
	}
	@Test
	public void validateGivenNumberForWholeAndDigits_with_dot_no_number() throws Exception{
		String str ="2345678.";
		Assert.assertEquals(false,PhoneApiUtils.validateGivenNumberForWholeAndDigits(str));
	}
	@Test
	public void validateGivenNumberForWholeAndDigits_NumberBefore_dot() throws Exception{
		String str =".2345678";
		Assert.assertEquals(false,PhoneApiUtils.validateGivenNumberForWholeAndDigits(str));
	}
	@Test
	public void validateGivenNumberForWholeAndDigits_Only_dot() throws Exception{
		String str =".";
		Assert.assertEquals(false,PhoneApiUtils.validateGivenNumberForWholeAndDigits(str));
	}

	// Method-10 -validateDictionaryValues
	
	@Test
	public void validateDictionaryValues_Only_words() throws Exception{
		String str ="ABCD";
		Assert.assertEquals(true,PhoneApiUtils.validateDictionaryValues(str));
	}
	@Test
	public void validateDictionaryValues_Only_words_with_dot() throws Exception{
		String str ="ABCD.";
		Assert.assertEquals(true,PhoneApiUtils.validateDictionaryValues(str));
	}
	@Test
	public void validateDictionaryValues_Only_words_with_punctuations() throws Exception{
		String str ="AB,C-D@#$";
		Assert.assertEquals(false,PhoneApiUtils.validateDictionaryValues(str));
	}
	@Test
	public void validateDictionaryValues_Only_string_integers() throws Exception{
		String str ="2344";
		Assert.assertEquals(true,PhoneApiUtils.validateDictionaryValues(str));
	}
	@Test
	public void validateDictionaryValues_Only_string_integers_decimal() throws Exception{
		String str ="2344.34";
		Assert.assertEquals(false,PhoneApiUtils.validateDictionaryValues(str));
	}
	
	// Method -11 - removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers
	
	@Test
	public void removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers_valid_decimal_string() throws Exception{
		String str ="2344.34";String stringPattern=PhoneApiUtils.getPhoneNumberPattern();
		Assert.assertEquals(str,PhoneApiUtils.remvePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(str,stringPattern));
	}
	@Test
	public void removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers_valid_integer_string() throws Exception{
		String str ="2344";String stringPattern=PhoneApiUtils.getPhoneNumberPattern();
		Assert.assertEquals(str,PhoneApiUtils.remvePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(str,stringPattern));
	}
	@Test
	public void removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers_decimal_with_punctuations() throws Exception{
		String str ="2 3@44##.34";String stringPattern=PhoneApiUtils.getPhoneNumberPattern();
		Assert.assertEquals("2344.34",PhoneApiUtils.remvePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(str,stringPattern));
	}
	
	//Method 11 (a)- case
	
	@Test
	public void boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers_decimal_with_punctuations() throws Exception{
		String str ="2 3@44##.34";String stringPattern=PhoneApiUtils.getPhoneNumberPattern();
		Assert.assertEquals(false,PhoneApiUtils.boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(str,stringPattern));
	}
	@Test
	public void boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers_string_integer_with_punctuations() throws Exception{
		String str ="2 3@44##34";String stringPattern=PhoneApiUtils.getPhoneNumberPattern();
		Assert.assertEquals(false,PhoneApiUtils.boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(str,stringPattern));
	}
	
	//Method 12-getDictWordPattern- case
	
	@Test
	public void getDictWordPattern_return_phoneNumber_pattern(){
		Assert.assertEquals("[^0-9\\.]+",PhoneApiUtils.getPhoneNumberPattern());
	}
	
	//Method 13 - getDictWordPattern - case
	
	@Test
	public void getDictWordPattern_return_dictionaryWords_pattern(){
		Assert.assertEquals("[\\p{Punct}\\s\\d]+",PhoneApiUtils.getDictWordPattern());
	}
}
