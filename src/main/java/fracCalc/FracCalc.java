/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String input = "";

		System.out.println("Hi! This is FracCalc! Type \"quit\" to quit.");

		while (!("quit   ".equals(input))) {
			System.out.print("Enter an equation: ");
			input = userInput.nextLine();
			input = input + "   ";
			System.out.println(produceAnswer(input));

		}

	}

	public static String produceAnswer(String input) { // returns the answer

		/*String firstNumStr = firstNum(input);
		String firstWhole = fracSplitWhole(firstNumStr);
		String firstNumerator = fracSplitNumerator(firstNumStr);
		String firstDenominator = fracSplitDenominator(firstNumStr);

		String secondNumStr = secondNum(input);
		String secondWhole = fracSplitWhole(secondNumStr);
		String secondNumerator = fracSplitNumerator(secondNumStr);
		String secondDenominator = fracSplitDenominator(secondNumStr);*/
		
		String firstNumStr = firstNum(input);
		String secondNumStr = secondNum(input);
		String something ="";
		
		String operand=operand(input);
		//if ("quit   ".equals(input))
		if("*".equals(operand)) {
			something=multiplication(input, firstNumStr, secondNumStr);
		}
		if("/".equals(operand)) {
			something=division(input, firstNumStr, secondNumStr);
		}
		if("+".equals(operand)) {
			something=addition(input, firstNumStr, secondNumStr);
		}
		if("-".equals(operand)) {
			something=subtraction(input, firstNumStr, secondNumStr);
		}
		if ("quit   ".equals(input)) {
			something = "You've quit >:(";
		}
		
		return something;
	}

	public static String firstNum(String input) { // returns the entire first number

		int spaceIndex = input.indexOf(" ");
		String firstNumStr = input.substring(0, spaceIndex);

		return firstNumStr;
	}

	
	public static String secondNum(String input) { // returns the entire second number

		int spaceIndex = input.indexOf(" ");
		String secondNumStr = input.substring(spaceIndex + 3);

		return secondNumStr;
	}

	
	public static String operand(String input) { // returns the operand

		int spaceIndex = input.indexOf(" ");
		String operand = input.substring(spaceIndex + 1, spaceIndex + 2);

		return operand;
	}

	
	public static String fracSplitWhole(String firstNumStr) { // if there is a whole number component, returns it

		int fracIndex = firstNumStr.indexOf("_");
		String whole = "";

		if (fracIndex != -1) { // for x_y/z
			whole = firstNumStr.substring(0, fracIndex);
		}

		else { // for y/z and x
			int slashIndex = firstNumStr.indexOf("/");
			if (slashIndex != -1) { // for y/z, returns whole=0
				whole = "0";
			} else { // for x, returns whole=x
				whole = firstNumStr;
			}
		}

		return whole;

	}

	
	public static String fracSplitNumerator(String firstNumStr) { // if there is a fraction component, returns the
																	// numerator

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

	
	public static String fracSplitDenominator(String firstNumStr) { // if there is a fraction component, returns the
																	// denominator

		int fracIndex = firstNumStr.indexOf("_");
		String denominator = "";

		if (fracIndex != -1) { // for x_y/z, returns z
			String frac = firstNumStr.substring(fracIndex + 1);
			int slashIndex = frac.indexOf("/");
			denominator = frac.substring(slashIndex + 1);
		}

		else { // either y/z or x
			int slashIndex = firstNumStr.indexOf("/");
			if (slashIndex != -1) { // for y/z, returns z
				denominator = firstNumStr.substring(slashIndex + 1);
			} else { // for x, returns denominator=1
				denominator = "1";
			}

		}
		return denominator;
	}

	
	public static String newNumerator(String whole, String numerator, String denominator) { // whole*denom+num FIX
		
		//String firstNumStr=firstNum(input);
		//String whole=fracSplitWhole(firstNumStr);
		
		int wholeInt = Integer.parseInt(whole);
		int numeratorInt = Integer.parseInt(numerator);
		int denominatorInt = Integer.parseInt(denominator);

		int newNumeratorInt = wholeInt * denominatorInt + numeratorInt;

		String newNumerator = "" + newNumeratorInt;

		return newNumerator;
	}

	
	public static String multiplication(String input, String firstNumStr, String secondNumStr) { //returns the mixed, unsimplified product
		
		String firstWhole = fracSplitWhole(firstNumStr);
		String firstNumerator = fracSplitNumerator(firstNumStr);
		String firstDenominator = fracSplitDenominator(firstNumStr); //
		String firstNewNumerator=newNumerator(firstWhole, firstNumerator, firstDenominator); //

		String secondWhole = fracSplitWhole(secondNumStr);
		String secondNumerator = fracSplitNumerator(secondNumStr);
		String secondDenominator = fracSplitDenominator(secondNumStr); //
		String secondNewNumerator=newNumerator(secondWhole, secondNumerator, secondDenominator); //
		
		//int wholeInt = Integer.parseInt(whole);
		int firstNewNumeratorInt=Integer.parseInt(firstNewNumerator);
		int firstDenominatorInt=Integer.parseInt(firstDenominator);
		int secondNewNumeratorInt=Integer.parseInt(secondNewNumerator);
		int secondDenominatorInt=Integer.parseInt(secondDenominator);
		
		int productNumerator=firstNewNumeratorInt*secondNewNumeratorInt;
		int productDenominator=firstDenominatorInt*secondDenominatorInt;
		
		String mixedProduct=productNumerator+"/"+productDenominator;
		
		return mixedProduct;
		
	}

	
	public static String division(String input, String firstNumStr, String secondNumStr) { // returns the mixed, unsimplified quotient
		String firstWhole = fracSplitWhole(firstNumStr);
		String firstNumerator = fracSplitNumerator(firstNumStr);
		String firstDenominator = fracSplitDenominator(firstNumStr); //
		String firstNewNumerator=newNumerator(firstWhole, firstNumerator, firstDenominator); //

		String secondWhole = fracSplitWhole(secondNumStr);
		String secondNumerator = fracSplitNumerator(secondNumStr);
		String secondDenominator = fracSplitDenominator(secondNumStr); //
		String secondNewNumerator=newNumerator(secondWhole, secondNumerator, secondDenominator); //
		
		//int wholeInt = Integer.parseInt(whole);
		int firstNewNumeratorInt=Integer.parseInt(firstNewNumerator);
		int firstDenominatorInt=Integer.parseInt(firstDenominator);
		int secondNewNumeratorInt=Integer.parseInt(secondNewNumerator);
		int secondDenominatorInt=Integer.parseInt(secondDenominator);
		
		int quotientNumerator=firstNewNumeratorInt*secondDenominatorInt;
		int quotientDenominator=firstDenominatorInt*secondNewNumeratorInt;
		
		String mixedQuotient=quotientNumerator+"/"+quotientDenominator;
		
		return mixedQuotient;
	}

	
	public static String addition(String input, String firstNumStr, String secondNumStr) { //returns the mixed, unsimplified sum
		String firstWhole = fracSplitWhole(firstNumStr);
		String firstNumerator = fracSplitNumerator(firstNumStr);
		String firstDenominator = fracSplitDenominator(firstNumStr); //
		String firstNewNumerator=newNumerator(firstWhole, firstNumerator, firstDenominator); //

		String secondWhole = fracSplitWhole(secondNumStr);
		String secondNumerator = fracSplitNumerator(secondNumStr);
		String secondDenominator = fracSplitDenominator(secondNumStr); //
		String secondNewNumerator=newNumerator(secondWhole, secondNumerator, secondDenominator); //
		
		//int wholeInt = Integer.parseInt(whole);
		int firstNewNumeratorInt=Integer.parseInt(firstNewNumerator);
		int firstDenominatorInt=Integer.parseInt(firstDenominator); //lcm
		int secondNewNumeratorInt=Integer.parseInt(secondNewNumerator);
		int secondDenominatorInt=Integer.parseInt(secondDenominator); //lcm
		
		int gcf=gcf(firstDenominatorInt, secondDenominatorInt);
		int commonDenominator=firstDenominatorInt*secondDenominatorInt/gcf;
		
		int firstNewNumeratorIntCommon=firstNewNumeratorInt*(commonDenominator/firstDenominatorInt);
		int secondNewNumeratorIntCommon=secondNewNumeratorInt*(commonDenominator/secondDenominatorInt);
		
		String mixedSum=(firstNewNumeratorIntCommon+secondNewNumeratorIntCommon)+"/"+commonDenominator;
		
		return mixedSum;
	}

	
	public static String subtraction(String input, String firstNumStr, String secondNumStr) { //returns the mixed, unsimplified difference
		String firstWhole = fracSplitWhole(firstNumStr);
		String firstNumerator = fracSplitNumerator(firstNumStr);
		String firstDenominator = fracSplitDenominator(firstNumStr); //
		String firstNewNumerator=newNumerator(firstWhole, firstNumerator, firstDenominator); //

		String secondWhole = fracSplitWhole(secondNumStr);
		String secondNumerator = fracSplitNumerator(secondNumStr);
		String secondDenominator = fracSplitDenominator(secondNumStr); //
		String secondNewNumerator=newNumerator(secondWhole, secondNumerator, secondDenominator); //
		
		//int wholeInt = Integer.parseInt(whole);
		int firstNewNumeratorInt=Integer.parseInt(firstNewNumerator);
		int firstDenominatorInt=Integer.parseInt(firstDenominator); //lcm
		int secondNewNumeratorInt=Integer.parseInt(secondNewNumerator);
		int secondDenominatorInt=Integer.parseInt(secondDenominator); //lcm
		
		int gcf=gcf(firstDenominatorInt, secondDenominatorInt);
		int commonDenominator=firstDenominatorInt*secondDenominatorInt/gcf;
		
		int firstNewNumeratorIntCommon=firstNewNumeratorInt*(commonDenominator/firstDenominatorInt);
		int secondNewNumeratorIntCommon=secondNewNumeratorInt*(commonDenominator/secondDenominatorInt);
		
		String mixedDifference=(firstNewNumeratorIntCommon-secondNewNumeratorIntCommon)+"/"+commonDenominator;
		
		return mixedDifference;
	}
	
	
	public static int gcf(int a, int b) {
		/*public static int GCF(int a, int b) {
    		if (b == 0) {
      			return a;
		 	} else {
      		return (GCF(b, a % b));
    	 	}
  		}*/
		
		if (a==1 || b==1) {
			if (a!=1) {
				return a;
			} else {
				return b;
			}
		} else {
			return gcf(b, a%b);
		}
		
	}


}
