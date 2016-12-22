package main.java.test.com.Aconex.utility;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

import main.java.com.Aconex.utility.ReadWordsLineByLineFromFile;
import main.java.com.Aconex.utility.StaticHolder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class ReadWordsLineByLineFromFileTest {
	private List<String> dictionaryFilteredValues = new LinkedList<String>();
	private List<String> phoneNumbersList  =new LinkedList<String>();
	
	@Before
	public void setUp() throws Exception {

	}
	
	//Dictionary words text file test cases
	
	@Test
	public void readFile_with_valid_Dictionary_filepath_fileName_regExpression_test()throws Exception {
		String filePath=StaticHolder.getDictionaryfilepath();
		String fileName=StaticHolder.getDictionaryfilename();
		String regEx=StaticHolder.getDictwordpattern();
		
		List<String> actual = new LinkedList<String>();
		dictionaryFilteredValues.add("call");
		dictionaryFilteredValues.add("king");
		dictionaryFilteredValues.add("monkey");
		dictionaryFilteredValues.add("liog");
		dictionaryFilteredValues.add("monk");
		dictionaryFilteredValues.add("cat");
		dictionaryFilteredValues.add("ca");
		dictionaryFilteredValues.add("be");
		dictionaryFilteredValues.add("bat");
		dictionaryFilteredValues.add("dlower");
		dictionaryFilteredValues.add("blowers");
		dictionaryFilteredValues.add("flower");
		dictionaryFilteredValues.add("me");
		dictionaryFilteredValues.add("nonkey");
		dictionaryFilteredValues.add("oonkey");
		dictionaryFilteredValues.add("oEEEonkey");
		dictionaryFilteredValues.add("ooSSDnkey");
		dictionaryFilteredValues.add("testme");
		dictionaryFilteredValues.add("act");
		dictionaryFilteredValues.add("donk");
		dictionaryFilteredValues.add("a");
		dictionaryFilteredValues.add("b");
		dictionaryFilteredValues.add("c");
		dictionaryFilteredValues.add("d");
		dictionaryFilteredValues.add("e");
		dictionaryFilteredValues.add("f");
		dictionaryFilteredValues.add("g");
		dictionaryFilteredValues.add("h");
		dictionaryFilteredValues.add("i");
		dictionaryFilteredValues.add("j");
		dictionaryFilteredValues.add("k");
		dictionaryFilteredValues.add("l");
		dictionaryFilteredValues.add("m");
		dictionaryFilteredValues.add("n");
		dictionaryFilteredValues.add("o");
		dictionaryFilteredValues.add("p");
		dictionaryFilteredValues.add("q");
		dictionaryFilteredValues.add("r");
		dictionaryFilteredValues.add("s");
		dictionaryFilteredValues.add("t");
		dictionaryFilteredValues.add("u");
		dictionaryFilteredValues.add("v");
		dictionaryFilteredValues.add("w");
		dictionaryFilteredValues.add("x");
		dictionaryFilteredValues.add("y");
		dictionaryFilteredValues.add("z");
		dictionaryFilteredValues.add("coding");
		dictionaryFilteredValues.add("challenge");

		actual.addAll(ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx));
		Assert.assertEquals(dictionaryFilteredValues,actual);
	}
	@Test
	public void readFile_with_valid_Dictionary_filepath_fileName_and_invalid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getDictionaryfilepath();
		String fileName=StaticHolder.getDictionaryfilename();
		String regEx="1";
		List<String> actual = new LinkedList<String>();
		dictionaryFilteredValues.add("call");
		dictionaryFilteredValues.add("king");
		dictionaryFilteredValues.add("monkey");
		dictionaryFilteredValues.add("liog");
		dictionaryFilteredValues.add("monk");
		dictionaryFilteredValues.add("cat");
		dictionaryFilteredValues.add("ca");
		dictionaryFilteredValues.add("be");
		dictionaryFilteredValues.add("bat");
		dictionaryFilteredValues.add("dlower");
		dictionaryFilteredValues.add("flower");
		dictionaryFilteredValues.add("me");
		dictionaryFilteredValues.add("nonkey");
		dictionaryFilteredValues.add("oonkey");
		dictionaryFilteredValues.add("act");
		dictionaryFilteredValues.add("donk");
		dictionaryFilteredValues.add("a");
		dictionaryFilteredValues.add("b");
		dictionaryFilteredValues.add("c");
		dictionaryFilteredValues.add("d");
		dictionaryFilteredValues.add("e");
		dictionaryFilteredValues.add("f");
		dictionaryFilteredValues.add("g");
		dictionaryFilteredValues.add("h");
		dictionaryFilteredValues.add("i");
		dictionaryFilteredValues.add("j");
		dictionaryFilteredValues.add("k");
		dictionaryFilteredValues.add("l");
		dictionaryFilteredValues.add("m");
		dictionaryFilteredValues.add("n");
		dictionaryFilteredValues.add("o");
		dictionaryFilteredValues.add("p");
		dictionaryFilteredValues.add("q");
		dictionaryFilteredValues.add("r");
		dictionaryFilteredValues.add("s");
		dictionaryFilteredValues.add("t");
		dictionaryFilteredValues.add("u");
		dictionaryFilteredValues.add("v");
		dictionaryFilteredValues.add("w");
		dictionaryFilteredValues.add("x");
		dictionaryFilteredValues.add("y");
		dictionaryFilteredValues.add("z");
		dictionaryFilteredValues.add("coding");
		dictionaryFilteredValues.add("challenge");

		
		actual.addAll(ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx));
		Assert.assertEquals(dictionaryFilteredValues,actual);
		
	}
	@Test
	public void readFile_with_valid_Dictionary_filepath_invalid_fileName_valid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getDictionaryfilepath();
		String fileName="hello.txt";
		String regEx=StaticHolder.getDictwordpattern();
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void readFile_with_invalid_Dictionary_filepath_valid_fileName_valid_regExpression_test()throws Exception {
		String filePath="/Users/govind/";
		String fileName="phonenumbers.txt";
		String regEx=StaticHolder.getDictwordpattern();
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_all_invalid_Dictionary_filepath_fileName_regExpression_test()throws Exception {
		String filePath="/users/govind/";
		String fileName="hello.txt";
		String regEx="1";
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_all_empty_Dictionary_filepath_fileName_regExpression_test()throws Exception {
		String filePath="";
		String fileName="";
		String regEx="";
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_empty_Dictionary_filepath_valid_fileName_valid_regExpression_test()throws Exception {
		String filePath="";
		String fileName="phonenumbers.txt";
		String regEx=StaticHolder.getDictwordpattern();
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_valid_Dictionary_filepath_empty_fileName_valid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getDictionaryfilepath();
		String fileName="";
		String regEx=StaticHolder.getDictwordpattern();
		
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_valid_Dictionary_filepath_valid_fileName_empty_regExpression_test()throws Exception {
		String filePath=StaticHolder.getDictionaryfilepath();
		String fileName=StaticHolder.getDictionaryfilename();
		
		String regEx="";
		
	String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Phone Numbers text file test cases
	
	@Test
	public void readFile_with_valid_Phonenumbers_filepath_fileName_regExpression_test()throws Exception {
		String filePath=StaticHolder.getPhonenumbersfilepath();
		String fileName=StaticHolder.getPhonenumbersfilename();
		String regEx=StaticHolder.getPhonenumberpattern();
		
		List<String> actual = new LinkedList<String>();
		phoneNumbersList.add("2255");
		phoneNumbersList.add("0");
		phoneNumbersList.add("@#%");
		phoneNumbersList.add("666539.0");
		phoneNumbersList.add("356 937");
		phoneNumbersList.add("288.68");
		phoneNumbersList.add("2255.63");
		phoneNumbersList.add("666539.228");
		phoneNumbersList.add("228");
		phoneNumbersList.add("23.4");
		phoneNumbersList.add("0.0");
		phoneNumbersList.add(".");
		phoneNumbersList.add("-23434");
		phoneNumbersList.add("23");
		phoneNumbersList.add("23#$.22323");
		phoneNumbersList.add("345.3");
		phoneNumbersList.add("228#$.2@8");
		phoneNumbersList.add(".228");
		phoneNumbersList.add("1.9");
		phoneNumbersList.add("228.23");
		phoneNumbersList.add("2255.");
		phoneNumbersList.add("263464.242553643");
		
		actual.addAll(ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx));
		Assert.assertEquals(phoneNumbersList,actual);
	}
	@Test
	public void readFile_with_valid_Phonenumbers_filepath_fileName_and_invalid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getPhonenumbersfilepath();
		String fileName=StaticHolder.getPhonenumbersfilename();
		String regEx="1";
		List<String> actual = new LinkedList<String>();
		phoneNumbersList.add("2255");
		phoneNumbersList.add("0");
		phoneNumbersList.add("@#%");
		phoneNumbersList.add("666539.0");
		phoneNumbersList.add("356 937");
		phoneNumbersList.add("288.68");
		phoneNumbersList.add("2255.63");
		phoneNumbersList.add("666539.228");
		phoneNumbersList.add("228");
		phoneNumbersList.add("23.4");
		phoneNumbersList.add("0.0");
		phoneNumbersList.add(".");
		phoneNumbersList.add("-23434");
		phoneNumbersList.add("23");
		phoneNumbersList.add("23#$.22323");
		phoneNumbersList.add("345.3");
		phoneNumbersList.add("228#$.2@8");
		phoneNumbersList.add(".228");
		phoneNumbersList.add("1.9");
		phoneNumbersList.add("228.23");
		phoneNumbersList.add("2255.");
		phoneNumbersList.add("263464.242553643");
		
		actual.addAll(ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx));
		Assert.assertEquals(phoneNumbersList,actual);
		
	}
	@Test
	public void readFile_with_valid_Phonenumbers_filepath_invalid_fileName_valid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getPhonenumbersfilepath();
		String fileName="hello.txt";
		String regEx=StaticHolder.getPhonenumberpattern();
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void readFile_with_invalid_Phonenumbers_filepath_valid_fileName_valid_regExpression_test()throws Exception {
		String filePath="/Users/govind/";
		String fileName="phonenumbers.txt";
		String regEx=StaticHolder.getDictwordpattern();
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_all_invalid_Phonenumbers_filepath_fileName_regExpression_test()throws Exception {
		String filePath="/users/govind/";
		String fileName="hello.txt";
		String regEx="1";
		
		String error ="No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !\n";
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_all_empty_Phonenumbers_filepath_fileName_regExpression_test()throws Exception {
		String filePath="";
		String fileName="";
		String regEx="";
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_empty_Phonenumbers_filepath_valid_fileName_valid_regExpression_test()throws Exception {
		String filePath="";
		String fileName=StaticHolder.getPhonenumbersfilename();
		String regEx=StaticHolder.getPhonenumberpattern();
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_valid_Phonenumbers_filepath_empty_fileName_valid_regExpression_test()throws Exception {
		String filePath=StaticHolder.getPhonenumbersfilepath();
		String fileName="";
		String regEx=StaticHolder.getPhonenumberpattern();
		
		String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readFile_with_valid_Phonenumbers_filepath_valid_fileName_empty_regExpression_test()throws Exception {

		
		String filePath=StaticHolder.getPhonenumbersfilepath();
		String fileName=StaticHolder.getPhonenumbersfilename();
		
		String regEx="";
		
	String error="Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx+"\n";
		
		try {
			TestHelperSysOut.captureOutput( new CaptureTest() {
			    @Override
			    public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {
			    	ReadWordsLineByLineFromFile.readFile(filePath, fileName, regEx);
			    	Assert.assertEquals(error, outContent.toString());
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
