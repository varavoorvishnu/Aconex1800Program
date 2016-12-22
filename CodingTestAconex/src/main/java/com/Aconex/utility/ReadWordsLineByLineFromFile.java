package main.java.com.Aconex.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Class Name: ReadWordsLineByLineFromFile ; Constructor Parameters: None
* 
* Author: V.Vishnuvardhanan
* 
* Description: 
* 
* 1) This program uses JDK 1.8 version along with STREAM package.
* 2)This class is used for reading both the dictionary.txt and phonenumber.txt files.
* 3) For dictionary.txt file, it ignores punctuation and white spaces and returns valid dictionary words
* 4) For phonenumber.txt file, it reads the phone numbers as is and the further  punctuation and white spaces is done in the calling method.
*  
* 	
*/
public class ReadWordsLineByLineFromFile {

	/*
	 * Method : readFile; Input Parameters : 3 ; Type : None ;return Type : String filePath,String fileName,String regEx
	 * 
	 * Description:
	 * 1) This method is returns the list of dictionary words or phone number list that are taken from the dictionary.txt and phonenumber.txt files respectively only if the file path,file name exists.
	 */
	
	public static List<String> readFile(String filePath,String fileName,String regEx){
		//System.out.println("filePath :"+filePath+" : "+"fileName :"+fileName+" : "+" extension:"+extension+" : RegEx :"+regEx);
		 
		List<String> list = new ArrayList<String>();
		
		if(PhoneApiUtils.isEmptyString(filePath) && PhoneApiUtils.isEmptyString(fileName) && PhoneApiUtils.isEmptyString(regEx)){
			
				String finalPathWithFileName=filePath+fileName;
				Path path = Paths.get(finalPathWithFileName);
				
						if(!Files.exists(path)){
							System.out.println("No "+fileName +" file found in the "+filePath+" path.Please provide valid file or check for file path !");
						}else{
							try(Stream<String> stream = Files.lines(path)){
				
								if(fileName.equals(StaticHolder.getDictionaryfilename())){
												list = stream
														.map(line-> line.replaceAll(regEx, ""))
														.filter(line -> PhoneApiUtils.validateDictionaryValues(line))
														.collect(Collectors.toList());
								}
							
								if(fileName.equals(StaticHolder.getPhonenumbersfilename())){
												list = stream
														.collect(Collectors.toList());
								}
								stream.close();
						
							} catch (IOException e) {e.printStackTrace();}
						}
		}
			if(!PhoneApiUtils.isEmptyString(filePath) || !PhoneApiUtils.isEmptyString(fileName) ||  !PhoneApiUtils.isEmptyString(regEx)){
					System.out.println("Please provide valid values for reading files. You have provided : file path = "+filePath +" ; file Name = "+fileName+" ; regExpression = "+ regEx);
			}
		
		return list;
	}
}