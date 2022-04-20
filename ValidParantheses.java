import java.util.*;
import java.io.*;

class ValidParantheses {
	private static boolean isValidParantheses(String paraString) {
		if(paraString == null)
			return true;
		int paraLength = paraString.length();
		Stack<Character> paranthStack = new Stack<Character>();
		
		for(int iterator = 0; iterator<paraLength ; iterator++) {
			Character tempParanth = paraString.charAt(iterator); 
			if(tempParanth == '(' || tempParanth == '{' || tempParanth == '[')
				paranthStack.push(tempParanth);
			else if(!paranthStack.isEmpty() && tempParanth == ')' && paranthStack.peek() == '(')
				paranthStack.pop();
			else if(!paranthStack.isEmpty() && tempParanth == '}' && paranthStack.peek() == '{')
				paranthStack.pop();
			else if(!paranthStack.isEmpty() && tempParanth == ']' && paranthStack.peek() == '[')
				paranthStack.pop();
			else
				return false;
		}
		if(paranthStack.isEmpty())
			return true;
		else 
			return false;
	}
	
	public static void main(String args[]) {
		boolean result = isValidParantheses("()()(");
		if(result)
			System.out.println("valid");
		else	
			System.out.println("invalid");
		
	}

}