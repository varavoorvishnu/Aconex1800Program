package main.java.test.com.Aconex.utility;

import main.java.com.Aconex.utility.StaticHolder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StaticHolderTest {
	
	@Before
	public void setup()throws Exception{
		
	}
	@Test
	public void getDictwordpattern_test()throws Exception{
		String expected="[\\p{Punct}\\s\\d]+";
		Assert.assertEquals(expected, StaticHolder.getDictwordpattern());
	}
	public void getPhonenumberpattern_test()throws Exception{
		String expected="[^0-9\\.]+";
		Assert.assertEquals(expected, StaticHolder.getPhonenumberpattern());
	}
	public void getDictionaryfilepath_test()throws Exception{
		String expected="/Users/vvishnuvardhanan/Documents/workspace/CodingTestAconex/bin/main/java/com/Aconex/files/";
		Assert.assertEquals(expected, StaticHolder.getDictionaryfilepath());
	}
	public void getDictionaryfilename_test()throws Exception{
		String expected="dictionary.txt";
		Assert.assertEquals(expected, StaticHolder.getDictionaryfilepath());
	}
	public void getPhonenumbersfilepath_test()throws Exception{
		String expected="/Users/vvishnuvardhanan/Documents/workspace/CodingTestAconex/bin/main/java/com/Aconex/files/";
		Assert.assertEquals(expected, StaticHolder.getPhonenumbersfilepath());
	}
	public void getPhonenumbersfilename_test()throws Exception{
		String expected="phonenumber.txt";
		Assert.assertEquals(expected, StaticHolder.getPhonenumbersfilename());
	}
	
}

