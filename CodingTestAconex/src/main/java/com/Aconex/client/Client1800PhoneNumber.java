package main.java.com.Aconex.client;
import java.util.LinkedList;
import java.util.List;

import main.java.com.Aconex.api.facade.FacadePhoneNumberGenerator;
import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhone1800withNumberName;
import main.java.com.Aconex.utility.PhoneApiUtils;
import main.java.com.Aconex.utility.ReadWordsLineByLineFromFile;
import main.java.com.Aconex.utility.StaticHolder;
/*
* Class Name:Client1800PhoneNumber ; Constructor Parameters: None
* Author: V.Vishnuvardhanan
* Description: This class is the starting point of the 1800-coding-challenge program. 
* This class reads the phone numbers from phonenumber.txt file if the data is available else throws a message to read from the commandline argument.
* So there are 2 ways of reading the phone numbers done in this class.
* 1) reading from the phonenumber.txt file if data available
* 2) If no data is available, phone numbers can be given through command line arguments 
* 3) It also does a display of the output of the generated result for both valid and invalid data at one shot.
* 	
*/

public class Client1800PhoneNumber {
	private static List<String> phoneNumbers;


public static void main(String[] args) throws Exception{
	
	invoke1800PhoneNumberClient(args);
	
}

/*
 * Method : invoke1800PhoneNumberClient; Input Parameters : 1 ; Type : void ;return Type : None
 * 
 * Description:
 * 1) This method reads the data of phone numbers from phonenumber.txt file or takes command line arguments for further processing.
 * 2) Displays the results for both valid and invalid data at one shot.
 */
public static void invoke1800PhoneNumberClient(String[] args){
	phoneNumbers = new LinkedList<String>();
	
	try {
		
			loadPhoneNumbers();
		
		if(!PhoneApiUtils.isEmptyList(phoneNumbers)){
			if(args.length==0){
					System.out.println("Please enter the phone numbers as arguments as there is no data in the "+StaticHolder.getPhonenumbersfilename()+ " file.");
			}
			for(String inputNumber:args){
				phoneNumbers.add(inputNumber);
			}
		
		}
		for(String inputNumber: phoneNumbers){
			System.out.println("Result for Phone Number "+inputNumber+ " is :");
			FacadePhoneNumberGenerator facade = new FacadePhoneNumberGenerator(inputNumber,new GeneratePhone1800withNumberName());
			facade.displayResult();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
/*
 * Method : loadPhoneNumbers; Input Parameters : 0  ;return Type : List<String>
 * 
 * Description:
 * 1) This method is returns the list of phone numbers that are taken from the phonenumber.txt file..
 */
public static List<String> loadPhoneNumbers(){
	try {
			phoneNumbers.addAll(ReadWordsLineByLineFromFile.readFile(StaticHolder.getPhonenumbersfilepath(), StaticHolder.getPhonenumbersfilename(), StaticHolder.getPhonenumberpattern()));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return phoneNumbers;
}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
}
}
