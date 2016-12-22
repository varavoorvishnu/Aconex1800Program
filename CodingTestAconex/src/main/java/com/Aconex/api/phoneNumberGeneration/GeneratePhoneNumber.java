package main.java.com.Aconex.api.phoneNumberGeneration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.java.com.Aconex.exceptions.ExceptionHandler;
import main.java.com.Aconex.utility.EncodingMapping;
import main.java.com.Aconex.utility.PhoneApiUtils;

/*
 * Author: V.Vishnuvardhanan,
 * Description: This is an abstract class that contain all the generic functionalities. The classes can use this class if 
 * 	1) As for the current requirement , if there is need to create 1800 number for the given phone number , the subclass can 
 *  extend this abstract and use it.
 *  2) In future, if there is another requirement that says it should append 080 with given phone number with change in logic,
 *  create a subclass and implement them.
 *  3) This is Template Pattern.
 */
public abstract class GeneratePhoneNumber{
	
	@SuppressWarnings("unused")
	private List<String> memberNames = new ArrayList<String>();
	protected List<String> resultList = new ArrayList<String>();
	protected Map<Integer,List<String>> myMap = new LinkedHashMap<Integer,List<String>>();
	
	public Map<Integer, List<String>> getMyMap() {
		return myMap;
	}

	protected String phoneNum="";
	private String[] splitValues;		
	
/*	Method : processGnNumber/processGivenNumber; input Parameters : 2 , Type : String,List<String> ; return Type : void
 
* 
*Description : 
*		
*		processGnNumber internally calls processGivenNumber
*
*		1)Takes the input decimal number and dictionary words filtered List as input. 
*		2) Routes the function based on if the string phone number is having decimal dot or not. 
*		3) If Decimal dot available in phone number then calls generateFinalNamesToMap method
*		4) If only integer number is available then calls returnValidDictionaryNames
*		
*		NOTE: For decimal numbers, only one decimal point is considered.
*/
	public String processGnNumber(String phoneNum,List<String> memberNames){
		return processGivenNumber (phoneNum,memberNames);
	}
	private String processGivenNumber(String phoneNum,List<String> memberNames){
	this.memberNames=memberNames;
	String msg = "";
	try {
		this.phoneNum=PhoneApiUtils.justTrim(phoneNum);
				if(PhoneApiUtils.isEmptyString(phoneNum) && PhoneApiUtils.isEmptyList(memberNames)){
					if(PhoneApiUtils.isDotFound(phoneNum)){
									generateFinalNamesToMap(phoneNum,memberNames);
									msg="re-routing to generateFinalNamesToMap";
						}else{
								resultList.addAll(returnValidDictionaryNames(phoneNum, memberNames));
								msg="re-routing to returnValidDictionaryNames";
						}
				}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
	
}


/*	Method : generateFinalNamesToMap/splitInsertFinalNamesToMap; input Parameters : 2 , Type : String,List<String> ; return Type : boolean 
 * 
 *Description : 
 *	This method internally calls splitInsertFinalNamesToMap method that does the following:
 *		1)Takes the input decimal number and dictionary words filtered List as input. 
 *		2) splits them first by replacing with '-' and then with splitting the strings
 *		3) Match the input split string with the dictionary value 
 *		4) Append the result as list for each part of split strings
 *		5) Put the resulting 2 lists to Map
 *
 *NOTE: For decimal numbers, only one decimal point is considered.
 * */
public boolean generateFinalNamesToMap(String inputNumber,List<String> memberNames){
	return splitInsertFinalNamesToMap( inputNumber,memberNames);
}
private boolean splitInsertFinalNamesToMap(String inputNumber,List<String> memberNames){
	boolean mapInsert=false;
	
	try {
			if(PhoneApiUtils.isDotFound(inputNumber)){
				int index = inputNumber.indexOf(".");
				
				if(index!=-1){
						inputNumber=inputNumber.replace(".", "-");
						 splitValues=inputNumber.split("-");
						
						if(splitValues.length!=0){
										for(int i=0;i<splitValues.length;i++){
											myMap.put(i, returnValidDictionaryNames(splitValues[i],memberNames));
										}
										mapInsert=(myMap.size()!=0)?true:false;
											
						}
				}
			}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return mapInsert;
}



/*
 * Method : addUpStrings/concatStrings1800; Input Parameters : 1 , Type : Object ; return Type : void 
 * 
 *Description : 
 *		addUpStrings internally calls concatStrings1800 which does the following:
 *		1)Takes the resultant list or map based on integer or decimal number. 
 *		2) If Integer appends the list to 1-800
 *		3) If decimal as string , takes map as input ,extracts list from the map and appends with 1-800
 *
 *NOTE: For decimal numbers, only one decimal point is considered.
 */
public void addUpStrings(Object obj){
	concatStrings1800(obj);
}
@SuppressWarnings("unchecked")
private void concatStrings1800(Object obj){
	
	List<String> al1 = new ArrayList<String>();
	List<String> al2 = new ArrayList<String>();
	
try{
	if(obj!=null){
		if (obj instanceof List) {
			List<String> new_list = new ArrayList<String>();
			new_list=(ArrayList<String>) obj;
			PhoneApiUtils.printResultWith1800ForIntegerWithValueAndZeroSize(new_list,phoneNum);
	
		}else{
			
			Map<Integer,List<String>> new_map = new LinkedHashMap<Integer,List<String>>();
			
			new_map=(LinkedHashMap<Integer,List<String>>)obj;
			if(new_map.size()!=0 && (!new_map.isEmpty())){	
				al1=(List<String>)new_map.values().toArray()[0];
				al2=(List<String>)new_map.values().toArray()[1];
				
				//System.out.println("al1 :"+ al1 +" al2 : "+al2);
				if((al1.size()!=0 && !(al1.isEmpty()) && al1 !=null) || ((al2.size()!=0 && !(al2.isEmpty()) && al2 !=null))){
						for(int i=0;i<al1.size();i++){
							for(int j=-0;j<al2.size();j++){
								System.out.println(PhoneApiUtils.join1800Number(al1.get(i) + "-"+ al2.get(j)));
							}
						}
				}
			}	
			
			if(al1.size()==0 && al2.size()==0){
					System.out.println(PhoneApiUtils.join1800Number(phoneNum.replace(".","-")));
			}	
				
			if(al1.size()==0 && al2.size()!=0){
				//	System.out.println(al1.size());
				for(String s:al2){
							
							System.out.println(PhoneApiUtils.join1800Number(splitValues[0]+"-"+s));
				}
			}
			if(al1.size()!=0 && al2.size()==0){
				//	System.out.println(al1.size());
				for(String s:al1){
						System.out.println(PhoneApiUtils.join1800Number(s+"-"+splitValues[1]));
				}
			}
		}
	}
		if(obj==null){
			throw new ExceptionHandler("Object is Null. No List or Map passed to addUpStrings of GeneratePhoneNumber");
		}
	}catch(Exception e){e.printStackTrace();}
}

/*
 * Method : returnValidDictionaryNames; Input Parameters : 2 ; Type : String,List<String> ;return Type : List<String>
 * 
 * Description:
 * 	Calls internally returnValidatedDictionaryNames which does the following:
 * 1) Returns if the given phone number matches matching string from the dictionary
 * 2) Appends the matching values for the number to the list 
 * 3) Checks for the length of the given phone number and returns only list containing the same length of phone number.
 */

public List<String> returnValidDictionaryNames(String inputNumber,List<String> memberNames){
	 return returnValidatedDictionaryNames(inputNumber,memberNames);
}
private List<String> returnValidatedDictionaryNames(String inputNumber,List<String> memberNames){
	List<String> returnDictList = new ArrayList<String>();

	if(PhoneApiUtils.isEmptyString(inputNumber) && PhoneApiUtils.isEmptyList(memberNames)){
				try{
						for (String getDictionaryValues : memberNames) {
							String result = "";
							if (PhoneApiUtils.isEmptyString(getDictionaryValues)) {
									if (inputNumber.length() == getDictionaryValues.length()) {
										for (int i = 0; i < getDictionaryValues.length(); i++) {
											if (EncodingMapping.getInstance().returnCharValues(
													getDictionaryValues.toUpperCase().charAt(i)) == (inputNumber.charAt(i) - '0')) {
												result = result + getDictionaryValues.toUpperCase().charAt(i);
												if (result.length() == inputNumber.length()) {
													returnDictList.add(result);
												}
											}
										}
								}
							}
						}
				}catch(Exception ex){ex.printStackTrace();}
	}
		return returnDictList;
}



public abstract void displayResult();


}
