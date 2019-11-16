/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	
    	System.out.println("Hi! This is FracCalc! Type \"quit\" to quit.");
    	System.out.print("Enter an equation: ");
    	
		String input = userInput.nextLine();
		
		System.out.println(produceAnswer(input));
    	   	
    }

    
    
    public static String produceAnswer(String input)
    {
    	int spaceIndex=input.indexOf(" ");
    	String firstNumStr=input.substring(0,spaceIndex);
    	String secondNumStr=input.substring(spaceIndex+3);
    	String operand=input.substring(spaceIndex+1,spaceIndex+2);
    	
    	//int i = Integer.parseInt(myString);
    	//int firstNum=Integer.parseInt(firstNumStr);
    	//int secondNum=Integer.parseInt(secondNumStr);
    	
    	//String str1 = Integer.toString(a);
    	
    	   	
		/*int fracIndex = input.indexOf("_");

		if (fracIndex != -1) {

			String wholeNumString = input.substring(0, fracIndex - 1);
			String frac = input.substring(fracIndex);
			int slashIndex = frac.indexOf("/");
			String numString = frac.substring(0, slashIndex - 1);
			String denomString = frac.substring(slashIndex);

			int wholeNum = Integer.parseInt(wholeNumString);
			int num = Integer.parseInt(numString);
			int denom = Integer.parseInt(denomString);   
		}*/
    	
    	
        return secondNumStr;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
