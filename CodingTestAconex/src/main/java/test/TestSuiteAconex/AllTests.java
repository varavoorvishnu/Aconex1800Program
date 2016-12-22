package main.java.test.TestSuiteAconex;

import main.java.test.com.Aconex.api.facade.FacadePhoneNumberGeneratorTest;
import main.java.test.com.Aconex.api.phoneNumberGeneration.GeneratePhoneNumberTest;
import main.java.test.com.Aconex.client.Client1800PhoneNumberTest;
import main.java.test.com.Aconex.utility.EncodingMappingTest;
import main.java.test.com.Aconex.utility.PhoneApiUtilsTest;
import main.java.test.com.Aconex.utility.ReadWordsLineByLineFromFileTest;
import main.java.test.com.Aconex.utility.StaticHolderTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Client1800PhoneNumberTest.class,
	FacadePhoneNumberGeneratorTest.class,
	GeneratePhoneNumberTest.class,
	EncodingMappingTest.class,
	PhoneApiUtilsTest.class,
	ReadWordsLineByLineFromFileTest.class,
	StaticHolderTest.class
	
})
public class AllTests {

}
