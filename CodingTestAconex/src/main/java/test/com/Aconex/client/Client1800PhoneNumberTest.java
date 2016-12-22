package main.java.test.com.Aconex.client;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

import main.java.com.Aconex.client.Client1800PhoneNumber;
import main.java.test.com.Aconex.utility.CaptureTest;
import main.java.test.com.Aconex.utility.TestHelperSysOut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Client1800PhoneNumberTest {
	 Client1800PhoneNumber client= new Client1800PhoneNumber();
	 List<String> phoneNumbersCopyForTesting = new  LinkedList<String>();
	 public Client1800PhoneNumberTest() {
		 phoneNumbersCopyForTesting.add("0");
		 phoneNumbersCopyForTesting.add("@#%");
		 phoneNumbersCopyForTesting.add("666539.0");
		 phoneNumbersCopyForTesting.add("356 937");
		 phoneNumbersCopyForTesting.add("288.68");
		 phoneNumbersCopyForTesting.add("2255.63");
		 phoneNumbersCopyForTesting.add("666539.228");
		 phoneNumbersCopyForTesting.add("228");
		 phoneNumbersCopyForTesting.add("23.4");
		 phoneNumbersCopyForTesting.add("0.0");
		 phoneNumbersCopyForTesting.add(".");
		 phoneNumbersCopyForTesting.add("-23434");
		 phoneNumbersCopyForTesting.add("23");
		 phoneNumbersCopyForTesting.add("23#$.22323");
		 phoneNumbersCopyForTesting.add("345.3");
		 phoneNumbersCopyForTesting.add("228#$.2@8");
		 phoneNumbersCopyForTesting.add(".228");
		 phoneNumbersCopyForTesting.add("1.9");
		 phoneNumbersCopyForTesting.add("228.23");
		 phoneNumbersCopyForTesting.add("2255.");
		 phoneNumbersCopyForTesting.add("263464.242553643");	 
	 }
	
@Before
public void setup()throws Exception{
	
}

@Test
public void invoke1800PhoneNumberClient_is_phoneNumbers_text_file_data_loaded_with_phoneNumbers_with_no_commandline_inputs()throws Exception{
	String[] args={};
	String expected="Result for Phone Number 2255 is :\n"+
			"1-800-CALL\n"+
			"Result for Phone Number 0 is :\n"+
			"1-800-0\n"+
			"Result for Phone Number @#% is :\n"+
			"\"@#%\" is NOT a Valid Data.Please Enter a Valid Data\n"+
			"Result for Phone Number 666539.0 is :\n"+
			"1-800-MONKEY-0\n"+
			"1-800-NONKEY-0\n"+
			"1-800-OONKEY-0\n"+
			"Result for Phone Number 356 937 is :\n"+
			"1-800-DLOWER\n"+
			"1-800-FLOWER\n"+
			"Result for Phone Number 288.68 is :\n"+
			"1-800-288-68\n"+
			"Result for Phone Number 2255.63 is :\n"+
			"1-800-CALL-ME\n"+
			"Result for Phone Number 666539.228 is :\n"+
			"1-800-MONKEY-CAT\n"+
			"1-800-MONKEY-BAT\n"+
			"1-800-MONKEY-ACT\n"+
			"1-800-NONKEY-CAT\n"+
			"1-800-NONKEY-BAT\n"+
			"1-800-NONKEY-ACT\n"+
			"1-800-OONKEY-CAT\n"+
			"1-800-OONKEY-BAT\n"+
			"1-800-OONKEY-ACT\n"+
			"Result for Phone Number 228 is :\n"+
			"1-800-CAT\n"+
			"1-800-BAT\n"+
			"1-800-ACT\n"+
			"Result for Phone Number 23.4 is :\n"+
			"1-800-BE-G\n"+
			"1-800-BE-H\n"+
			"1-800-BE-I\n"+
			"Result for Phone Number 0.0 is :\n"+
			"1-800-0-0\n"+
			"Result for Phone Number . is :\n"+
			"1-800-0-0\n"+
			"Result for Phone Number -23434 is :\n"+
			"1-800-23434\n"+
			"Result for Phone Number 23 is :\n"+
			"1-800-BE\n"+
			"Result for Phone Number 23#$.22323 is :\n"+
			"1-800-BE-22323\n"+
			"Result for Phone Number 345.3 is :\n"+
			"1-800-345-D\n"+
			"1-800-345-E\n"+
			"1-800-345-F\n"+
			"Result for Phone Number 228#$.2@8 is :\n"+
			"1-800-CAT-28\n"+
			"1-800-BAT-28\n"+
			"1-800-ACT-28\n"+
			"Result for Phone Number .228 is :\n"+
			"1-800-0-CAT\n"+
			"1-800-0-BAT\n"+
			"1-800-0-ACT\n"+
			"Result for Phone Number 1.9 is :\n"+
			"1-800-1-W\n"+
			"1-800-1-X\n"+
			"1-800-1-Y\n"+
			"1-800-1-Z\n"+
			"Result for Phone Number 228.23 is :\n"+
			"1-800-CAT-BE\n"+
			"1-800-BAT-BE\n"+
			"1-800-ACT-BE\n"+
			"Result for Phone Number 2255. is :\n"+
			"1-800-CALL-0\n"+
			"Result for Phone Number 263464.242553643 is :\n"+
			"1-800-CODING-CHALLENGE\n";
	
try {
		TestHelperSysOut.captureOutput( new CaptureTest() {
		    @Override
		    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
		    	Client1800PhoneNumber.invoke1800PhoneNumberClient(args);
		    	Assert.assertEquals(expected, outContent.toString());
		    }
		});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

//***************NOTE NOTE NOTE NOTE*********:
//This test case will work only when there is NO DATA in the phonenumber.txt , otherwise if there is data , below test cases will fail as it is calling the 
// Client1800PhoneNumber directly. Hence commenting this test case. You can test this test case by removing the phone numbers from phonenumbers.txt file/
/*
	@Test
	public void invoke1800PhoneNumberClient_is_phoneNumbers_text_file_data_with_NO_phoneNumbers_with_no_commandline_inputs()throws Exception{
		String[] args={};
		
		String expected="Please enter the phone numbers as arguments as there is no data in the phonenumber.txt file.\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	Client1800PhoneNumber.invoke1800PhoneNumberClient(args);
			    	Assert.assertEquals(expected, outContent.toString());
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Test
	public void invoke1800PhoneNumberClient_phoneNumbers_with_no_command()throws Exception{
		String[] args={};
		Client1800PhoneNumber.invoke1800PhoneNumberClient(args);
		phoneNumbersCopyForTesting.addAll(client.getPhoneNumbers());
		Assert.assertTrue(phoneNumbersCopyForTesting.size()!=0);
	}
	*/
}
