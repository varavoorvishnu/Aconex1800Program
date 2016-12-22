package main.java.com.Aconex.api.phoneNumberGeneration;

import main.java.com.Aconex.utility.PhoneApiUtils;

/*
 * Class Name:GeneratePhone1800withNumberName; Constructor Parameters: None ; Class Type: Sub-Class
* Author: V.Vishnuvardhanan
* Description: This is subclass,extended from GeneratePhoneNumber abstract class that contain overridden method display() 
* All other complex generic functionalities is written in its abstract class,GeneratePhoneNumber.
* 	
*/

public class GeneratePhone1800withNumberName extends GeneratePhoneNumber {
	/*
	 * Method : displayResult; Input Parameters : 0 ; Type : None ;return Type : String
	 * 
	 * Description:
	 * 
	 * 1) This method is overridden.
	 * 2) Calls the addStrings method in GeneratePhoneNumber based on whether its integer or decimal string
	 * 
	 * 
	 */
	public void displayResult(){
		try {
				if(PhoneApiUtils.isEmptyString(super.phoneNum)){
						if(PhoneApiUtils.isDotFound(phoneNum)){
							//System.out.println(myMap);
							addUpStrings(myMap);
						}else{
							//System.out.println(resultList);
							addUpStrings(resultList);
						}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
