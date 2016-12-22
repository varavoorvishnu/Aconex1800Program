package main.java.com.Aconex.utility;

import java.util.LinkedHashMap;
import java.util.Map;
/*
 * Author: V.Vishnuvardhanan,
 * Description: This class contains encoding mapping for all the alphabet characters starting from A to Z.
 * Also, this class is made as a singleton class with lazy loading of the instance so that at any point of time only one instance will be provided to 
 * get the desired mapping of the character.
 * 
 */

public class EncodingMapping {
	private static Map<Character,Integer> encodeMap = new LinkedHashMap<Character,Integer>();
	private static EncodingMapping emObj=null;
	private EncodingMapping() {
		encodeMap.put('A',2);
		encodeMap.put('B',2);
		encodeMap.put('C',2);
		encodeMap.put('D',3);
		encodeMap.put('E',3);
		encodeMap.put('F',3);
		encodeMap.put('G',4);
		encodeMap.put('H',4);
		encodeMap.put('I',4);
		encodeMap.put('J',5);
		encodeMap.put('K',5);
		encodeMap.put('L',5);
		encodeMap.put('M',6);
		encodeMap.put('N',6);
		encodeMap.put('O',6);
		encodeMap.put('P',7);
		encodeMap.put('Q',7);
		encodeMap.put('R',7);
		encodeMap.put('S',7);
		encodeMap.put('T',8);
		encodeMap.put('U',8);
		encodeMap.put('V',8);
		encodeMap.put('W',9);
		encodeMap.put('X',9);
		encodeMap.put('Y',9);
		encodeMap.put('Z',9);
        
	}
	   		
	public int  returnCharValues(char numberEncode){
		int returnVal=0;
		try {
			//System.out.println("numberCode Before Failure :"+numberEncode+":");
				 returnVal=encodeMap.get(numberEncode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		   return returnVal;
	}
	
	public static EncodingMapping getInstance(){
		if(emObj == null){
			emObj = new EncodingMapping();
		}
		return emObj;
	}


}
