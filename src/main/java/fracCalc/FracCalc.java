/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);

		System.out.println("Hi! This is FracCalc! Type \"quit\" to quit.");
		System.out.print("Enter an equation: ");

		String input = userInput.nextLine();
		
		System.out.println(produceAnswer(input));

	}

	public static String produceAnswer(String input) { // returns the answer
		
		String firstNumStr=firstNum(input);		
		String firstWhole=fracSplitWhole(firstNumStr);
		String firstNumerator=fracSplitNumerator(firstNumStr);
		String firstDenominator=fracSplitDenominator(firstNumStr);
		
		String secondNumStr=secondNum(input);		
		String secondWhole=fracSplitWhole(secondNumStr);
		String secondNumerator=fracSplitNumerator(secondNumStr);
		String secondDenominator=fracSplitDenominator(secondNumStr);
		
		String temporaryAnswer="whole:"+secondWhole+" numerator:"+secondNumerator+" denominator:"+secondDenominator;
		
		return temporaryAnswer;
	}
	
	public static String firstNum(String input) { //returns the entire first number
		int spaceIndex = input.indexOf(" ");
		String firstNumStr = input.substring(0, spaceIndex);
		
		return firstNumStr;
	}
	
	public static String secondNum(String input) { //returns the entire second number

		int spaceIndex = input.indexOf(" ");
		String secondNumStr = input.substring(spaceIndex + 3);
		
		return secondNumStr;
	}
	
	public static String operand(String input) { //returns the operand

		int spaceIndex = input.indexOf(" ");
		String operand = input.substring(spaceIndex + 1, spaceIndex + 2);
		
		return operand;
	}

	public static String fracSplitWhole(String firstNumStr) { // if there is a whole number component, returns it

		int fracIndex = firstNumStr.indexOf("_");
		String whole = "";

		if (fracIndex != -1) { //for x_y/z
			whole = firstNumStr.substring(0, fracIndex);
		}

		else { //for y/z and x
			int slashIndex=firstNumStr.indexOf("/");
			if (slashIndex!=-1) { //for y/z, returns whole=0
				whole="0";
			}
			else { //for x, returns whole=x
				whole = firstNumStr;
			}
		}

		return whole;

	}

	public static String fracSplitNumerator(String firstNumStr) { // if there is a fraction component, returns the numerator

		int fracIndex = firstNumStr.indexOf("_");
		String numerator = "";

		if (fracIndex != -1) { // for x_y/z, returns y
			String frac = firstNumStr.substring(fracIndex + 1);
			int slashIndex = frac.indexOf("/");
			numerator = frac.substring(0, slashIndex);
		}

		else { // either y/z or x
			int slashIndex = firstNumStr.indexOf("/");
			if (slashIndex != -1) { // for y/z, returns y
				numerator = firstNumStr.substring(0, slashIndex);
			} else { // for x, returns numerator=0
				numerator = "0";
			}

		}
		return numerator;

	}

	public static String fracSplitDenominator(String firstNumStr) { //if there is a fraction component, returns the denominator
    	
    	int fracIndex = firstNumStr.indexOf("_");
    	String denominator="";
    	
    	if (fracIndex!=-1) { //for x_y/z, returns z
    		String frac=firstNumStr.substring(fracIndex+1);
    		int slashIndex=frac.indexOf("/");
    		denominator=frac.substring(slashIndex+1);
    	}
    	
    	else { //either y/z or x
    		int slashIndex=firstNumStr.indexOf("/");
    		if (slashIndex!=-1) { //for y/z, returns z
    			denominator=firstNumStr.substring(slashIndex+1);
    		}
    		else { //for x, returns denominator=1
    			denominator="1";
    		}
    	
    	}
    	return denominator;
	}
     
    
}
