package main.java.com.Aconex.api.facade;
import java.util.LinkedList;
import java.util.List;

import main.java.com.Aconex.api.phoneNumberGeneration.GeneratePhoneNumber;
import main.java.com.Aconex.utility.PhoneApiUtils;
import main.java.com.Aconex.utility.ReadWordsLineByLineFromFile;
import main.java.com.Aconex.utility.StaticHolder;


public class FacadePhoneNumberGenerator {
private GeneratePhoneNumber generatePhNum;
private String inputNumber="";
private String displayInvalidinputNumber="";

private List<String> memberNames;
private List<String> newMemberlst ;
private List<String> lst = new LinkedList<String>();


/*
 * Class Name:FacadePhoneNumberGenerator ; Constructor Parameters: String inputNumber,GeneratePhoneNumber generatePhNum
* Author: V.Vishnuvardhanan
* Description: This class acts as a Facade pattern covering the complex functionalities of the GeneratePhoneNumber class. 
* 	
*/


public FacadePhoneNumberGenerator(String inputNumber,GeneratePhoneNumber generatePhNum) {
		this.generatePhNum= generatePhNum;
		this.inputNumber=inputNumber;
		this.displayInvalidinputNumber=inputNumber;
		
		

		memberNames = new LinkedList<String>();
		try {
			// Reading the dictionary values while loading the dictionary words from the dictionary.txt file when FacadePhoneNumberGenerator is invoked.
			memberNames.addAll(ReadWordsLineByLineFromFile.readFile(StaticHolder.getDictionaryfilepath(), StaticHolder.getDictionaryfilename(), StaticHolder.getDictwordpattern()));	
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		// Added list here..for temporary checking, removed it now.
}
/*
 * Method : getMemberNames; Input Parameters : 0 ; Type : None ;return Type : List<String>
 * 
 * Description:
 * 1) This method is returns the list of dictionary words that are taken from the dictionary.txt file..
 */
public List<String> getMemberNames() {
	return memberNames;
}

/*
 * Method : displayResult; Input Parameters : 0 ; Type : None ;return Type : void
 * 
 * Description:
 * 1) This method does the validation of the input phone number and sends for further processing if its valid phone numbers and rightly read dictionary values.
 */

public void displayResult(){
	try {
		if(!PhoneApiUtils.isEmptyString(displayInvalidinputNumber)){
			System.out
					.println("\"" + displayInvalidinputNumber + "\" is NOT a Valid Data.Please Enter a Valid Data");
		}else{
			if(PhoneApiUtils.boolean_removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(PhoneApiUtils.justTrim(inputNumber),PhoneApiUtils.getPhoneNumberPattern()))
			{
				System.out
					.println("\""+displayInvalidinputNumber+"\" is NOT a Valid Data.Please Enter a Valid Data");
			}
			
			inputNumber=PhoneApiUtils.remvePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(PhoneApiUtils.justTrim(inputNumber),PhoneApiUtils.getPhoneNumberPattern());
			inputNumber=PhoneApiUtils.justTrim(inputNumber);
			 
			if(PhoneApiUtils.isEmptyString(inputNumber) && PhoneApiUtils.isEmptyList(memberNames)){  
				
				filteredDictionaryValuesWithSameLengthAsPhoneNumber(inputNumber,memberNames);
				
				if(inputNumber.indexOf(".")==0){
					inputNumber='0'+inputNumber;
				}
				
				if(inputNumber.indexOf(".")==(inputNumber.length()-1)){
					inputNumber=inputNumber+'0';
				}

				// This is where the program is going to enter into GeneratePhoneNumber Object
				if(PhoneApiUtils.validateGivenNumberForWholeAndDigits(PhoneApiUtils.justTrim(inputNumber))){
					
					generatePhNum.processGnNumber(inputNumber, newMemberlst);
					generatePhNum.displayResult();
				
				}else{
					System.out
					.println("\""+displayInvalidinputNumber+"\" is NOT a Valid Data.Please Enter a Valid Data");
				}
				
			}
		}
	
		if(!PhoneApiUtils.isEmptyList(memberNames)){
			System.out
			.println("There is no data in the "+StaticHolder.getDictionaryfilename()+" file. Please add some values");
		}
	} catch (Exception e) {
			e.printStackTrace();
	}
}

/*
 * Method : filteredDictionaryValuesWithSameLengthAsPhoneNumber ; Input Parameters : 2 ;return Type : List<String>
 * 
 * Description:
 * 1) This method does the filtering of the dictionary words based on the size of the phone number  and sends for further processing after being validated.
 */
public List<String> filteredDictionaryValuesWithSameLengthAsPhoneNumber(String inputNumber,List<String> memberNames){
		
		newMemberlst = new LinkedList<String>();
		int phoneNumLength=inputNumber.length();
		
	try{
		if(PhoneApiUtils.isEmptyList(memberNames)){
			for(int i=0;i<memberNames.size();i++){
				if(PhoneApiUtils.isEmptyString(memberNames.get(i))){
										newMemberlst.add(memberNames.get(i));
				}
			}
		}
		
		if(PhoneApiUtils.isEmptyList(newMemberlst)){
			for(int i=0;i<newMemberlst.size();i++){
				if(PhoneApiUtils.isEmptyString(newMemberlst.get(i))){
			
					if(inputNumber.indexOf(".")!=-1){ //Decimal number is found
							if(newMemberlst.get(i).length()!=0 && (PhoneApiUtils.splitStringOnDot(inputNumber).length!=0 && PhoneApiUtils.splitStringOnDot(inputNumber).length!=1)){
										if(newMemberlst.get(i).length()==PhoneApiUtils.splitStringOnDot(inputNumber)[0].length() || newMemberlst.get(i).length()==PhoneApiUtils.splitStringOnDot(inputNumber)[1].length()  ){
											lst.add(newMemberlst.get(i));
										}
							}
					}else{
					
							if(phoneNumLength!=0 && newMemberlst.get(i).length()!=0){
									if(phoneNumLength==newMemberlst.get(i).length()){
										lst.add(newMemberlst.get(i));
									}
							}
					}
				}
			}
		  }
/*
		System.out.println(memberNames);
		System.out.println(newMemberlst);
		System.out.println(lst);
*/		
			

	}catch(Exception e){
		e.printStackTrace();}
	
		return lst;
}
	/*100-104 line number commented and taken out
	 * //	newDictionaryValue=PhoneApiUtils.removePunctuationsWhiteSpacesForDictWords_exceptDotsForPhoneNumbers(memberNames.get(i),PhoneApiUtils.getDictWordPattern());
				//	System.out.println(newDictionaryValue +" : "+memberNames.get(i));
					//	if(PhoneApiUtils.isEmptyString(newDictionaryValue)){
					
						//	if(PhoneApiUtils.validateDictionaryValues(newDictionaryValue)){
	 * 
	 */
}
