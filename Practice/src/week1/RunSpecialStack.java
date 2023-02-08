package week1;
import javax.management.AttributeNotFoundException;

/**
 * Program: RunSpecialStack.java
 * Author: Joey Maffiola
 * Class: COMPSCI 220-02
 * Date: Jan 29, 2023
 */

public class RunSpecialStack {

	/**
	 * @param args
	 * @throws AttributeNotFoundException 
	 */
	public static void main(String[] args) throws AttributeNotFoundException {
		SpecialStack testStack = new SpecialStack(6);
		testStack.size();
		testStack.push(5);
		testStack.size();
		testStack.push(-7);
		testStack.size();
		testStack.push(2);
		testStack.size();
		testStack.push(-82);
		testStack.size();
		testStack.push(18);
		testStack.size();
		testStack.push(9); 
		testStack.size();
		testStack.push(-1); 
		testStack.size();
	
		testStack.popNonNeg();
		testStack.size();
		
		testStack.push(-56);
		testStack.size();
		
		testStack.popNonNeg();
		testStack.size();
		
		testStack.push(-55);
		testStack.size();
		
		testStack.push(23);
		testStack.size();
		testStack.push(-76);
		testStack.size();
		
		testStack.popNeg();
		testStack.size();
		testStack.popNeg();
		
	}

}
