package main.java.test.com.Aconex.api.facade;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.com.Aconex.api.facade.FacadePhoneNumberGenerator;
import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhone1800withNumberName;
import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhoneNumber;
import main.java.test.com.Aconex.utility.CaptureTest;
import main.java.test.com.Aconex.utility.TestHelperSysOut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FacadePhoneNumberGeneratorTest {
FacadePhoneNumberGenerator facade;
GeneratePhoneNumber generatePhoneNum;
List<String> memberNames=new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		memberNames.add(null);
		memberNames.add("  @## ");
			memberNames.add("call");
			memberNames.add("king");
			memberNames.add("monkey");
			memberNames.add("liog");
			memberNames.add("monk");
			memberNames.add("cat");
			memberNames.add("ca");
			memberNames.add("be");
			memberNames.add("Sal9man");
			memberNames.add("Yana");
			memberNames.add("bat");
			memberNames.add("dlower");
			memberNames.add("blowers");
			memberNames.add("flower");
			memberNames.add("Lokesh");
			memberNames.add("me");
			memberNames.add("nonkey");
			memberNames.add("oonkey");
			memberNames.add("-oEEEonkey");
			memberNames.add("oo  SSD nkey");
			memberNames.add("act");
			memberNames.add("donk");
			memberNames.add("d");

	}

	@Test
	public void displayResult_test_with_no_phoneNumber() {
		String inputNumber="";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		String expected="\""+inputNumber+"\" is NOT a Valid Data.Please Enter a Valid Data\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	Assert.assertEquals(expected, outContent.toString());
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void displayResult_test_with_phoneNumber_but_no_dictionary_values() {
		String inputNumber="123";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		facade.getMemberNames().clear();
		String expected="There is no data in the dictionary.txt file. Please add some values\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	Assert.assertEquals(expected, outContent.toString());
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void displayResult_test_with_no_phoneNumber_with_punctuations() {
		String inputNumber="@#$#%";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		String expected="\""+inputNumber+"\" is NOT a Valid Data.Please Enter a Valid Data\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	Assert.assertEquals(expected, outContent.toString());
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_whitespaces_in_between_no_matching_in_dictionary() {
		String inputNumber="12  34";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_whitespaces_in_front_no_matching_in_dictionary() {
		String inputNumber="   1234";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_whitespaces_at_end_of_phoneNumber_no_matching_in_dictionary() {
		String inputNumber="1234  ";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_whitespaces_at_both_sidesof_phoneNumber_no_matching_in_dictionary() {
		String inputNumber="  1234  ";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_punctuations_in_between_phoneNumber_no_matching_in_dictionary() {
		String inputNumber="12@#$&34";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_punctuations_and_spaces_in_phoneNumber_no_matching_in_dictionary() {
		String inputNumber=" 12@#$& 34 ";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1234\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_phoneNumber_with_singledigit_with_no_value_matching_in_dictionary() {
		String inputNumber="1";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-1\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	@Test
	public void displayResult_test_with_phoneNumber_as_null_with_no_matching_value_in_dictionary() {
		String inputNumber=null;
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		String expected="\""+inputNumber+"\" is NOT a Valid Data.Please Enter a Valid Data\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	Assert.assertEquals(expected, outContent.toString());
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber__with_matching_values_in_dictionary() {
		String inputNumber="666539.0";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-MONKEY-0\n"+"1-800-NONKEY-0\n"+"1-800-OONKEY-0\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_with_spacing_between_numbers_with_matching_values_in_dictionary() {
		String inputNumber="356 937";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-DLOWER\n"+"1-800-FLOWER\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_matching_values_in_dictionary() {
		String inputNumber="2255.63";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-CALL-ME\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_partial_matching_values_in_dictionary() {
		String inputNumber="23.4";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-BE-G\n"+"1-800-BE-H\n"+"1-800-BE-I\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_no_matching_values_in_dictionary() {
		String inputNumber="0.4";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			        Assert.assertEquals( "1-800-0-G\n"+"1-800-0-H\n"+"1-800-0-I\n", outContent.toString() );
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_multiple_matching_values_in_dictionary() {
		String inputNumber="666539.228";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	
			    	String finalResult="1-800-MONKEY-CAT\n"+"1-800-MONKEY-BAT\n"+"1-800-MONKEY-ACT\n"+"1-800-NONKEY-CAT\n"+"1-800-NONKEY-BAT\n"+"1-800-NONKEY-ACT\n"+"1-800-OONKEY-CAT\n"+"1-800-OONKEY-BAT\n"+"1-800-OONKEY-ACT\n";
			        Assert.assertEquals( finalResult, outContent.toString() );
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_jst_dot_with_no_digits_after_dot_matching_values_in_dictionary() {
		String inputNumber="666539.";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	
			    	String finalResult="1-800-MONKEY-0\n"+"1-800-NONKEY-0\n"+"1-800-OONKEY-0\n";
			        Assert.assertEquals( finalResult, outContent.toString() );
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_jst_dot_with_no_digits_before_dot_matching_values_in_dictionary() {

		String inputNumber=".666539";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	
			    	String finalResult="1-800-0-MONKEY\n"+"1-800-0-NONKEY\n"+"1-800-0-OONKEY\n";
			        Assert.assertEquals( finalResult, outContent.toString() );
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_punctuations_spaces_inbetween_with_decimal_digits_matching_values_in_dictionary() {

		String inputNumber="0.6  66 %^&*539";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	
			    	String finalResult="1-800-0-MONKEY\n"+"1-800-0-NONKEY\n"+"1-800-0-OONKEY\n";
			        Assert.assertEquals( finalResult, outContent.toString() );
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void displayResult_test_with_valid_phoneNumber_decimal_with_punctuations_spaces_infront_back_inbetween_with_decimal_digits_matching_values_in_dictionary() {

		String inputNumber="  0.6  66 %^&*539  ";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	facade.displayResult();
			    	
			    	String finalResult="1-800-0-MONKEY\n"+"1-800-0-NONKEY\n"+"1-800-0-OONKEY\n";
			        Assert.assertEquals( finalResult, outContent.toString() );
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Need to write for other methods
	@Test
	public void filteredDictionaryValuesWithSameLengthAsPhoneNumber_one_digits_test()throws Exception{
		String inputNumber="2";
		List<String> al = new LinkedList<String>();
		al.add("d");
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		Assert.assertEquals(al,facade.filteredDictionaryValuesWithSameLengthAsPhoneNumber(inputNumber, memberNames));
		
	}
	@Test
	public void filteredDictionaryValuesWithSameLengthAsPhoneNumber_two_digits_test()throws Exception{
		String inputNumber="22";
		List<String> al = new LinkedList<String>();
		al.add("ca");
		al.add("be");
		al.add("me");
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		Assert.assertEquals(al,facade.filteredDictionaryValuesWithSameLengthAsPhoneNumber(inputNumber, memberNames));
		
	}
	@Test
	public void filteredDictionaryValuesWithSameLengthAsPhoneNumber_three_digits_test()throws Exception{
		String inputNumber="224";
		List<String> al = new LinkedList<String>();
		al.add("cat");
		al.add("bat");
		al.add("act");
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		Assert.assertEquals(al,facade.filteredDictionaryValuesWithSameLengthAsPhoneNumber(inputNumber, memberNames));
		
	}
	@Test
	public void filteredDictionaryValuesWithSameLengthAsPhoneNumber_invalid_phoneNumber_Dictionary_words_test()throws Exception{
		String inputNumber="";
		memberNames.clear();
		List<String> al = new LinkedList<String>();
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		Assert.assertEquals(memberNames ,facade.filteredDictionaryValuesWithSameLengthAsPhoneNumber(inputNumber, memberNames));
		
	}
	@Test
	public void getMemberNames_test()throws Exception{
		String inputNumber="123";
		facade = new FacadePhoneNumberGenerator(inputNumber, new GeneratePhone1800withNumberName());
		Assert.assertTrue(facade.getMemberNames().size()!=0);
		
	}
}

