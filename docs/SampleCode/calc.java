import java.util.*;
/**
 * 
 * @author Kevin
 *
 */

/* I decided to use two data structures. A stack to organize my infix expression to a post fix expression, a linkedlist to save the expression
 * and back to the stack to do the actual mathematical operations. The purpose of this program is to allow a user to input a string of a mathematical expression.
 * The program converts the mathematical operation into a postfix expression and solves the expression. The program also allows the use of value x as a 
 * constant.
 */
public class calc {
	//Scanner class is imported for user input
	//String e is the mathematical expression. String end is checking for q to end program
	public static Scanner sc = new Scanner(System.in);
	public static String e,end;
	//boolean maybe is used to check if constant x is used in program. Takes a different path if true
	public static boolean maybe;
	//two data structures stack to organize and do math. Linkedlist to save post fix expression.
	public static Stack<String> stack = new Stack<String>();;
	public static LinkedList<String> output = new LinkedList<String>();
	
	public static void main(String[] args) {
		// end must be declared
		 end = " ";
		 //basic system input
		System.out.print("Please enter an equation: ");
		 e = sc.nextLine();
		 System.out.println("Infix Expression: " + e);
		 //check method is called to insure the mathematical expression is valid
		 check();
		 //work method converts the mathematical expression into a postfix expression
		 work();
		 //if an x value was used
		 if(maybe){
			 //while user does not end program
			 while(!end.equals("q")){
				 //basic user input
				 System.out.print("What is the value of 'x': (q to quit): ");
				  end = sc.nextLine();
				  //ends program is end =q
				  if(end.equals("q")) System.exit(0);
				  //math method calculates answer
				  math();
				  System.out.println("FINAL: " + stack.pop());
			 }
		 }else{
			 //no x input so normal steps
			 math();
			 System.out.println("FINAL: " + stack.pop());
			 }
	}
	public static void work(){
		// int y declared to terminate while loop
		// char c runs through switch statements
		int y =0;
		char c;
		while(y<e.length()){
			// c is value of char at String y
			c = e.charAt(y);
			
			switch(c){  
			//case numbers or x are automatically pushed into stack
			    case '0': case '1': case '2': case '3': case '4':
	            case '5': case '6': case '7': case '8': case '9': case 'x': output.add(String.valueOf(c)); break;
				//test higher precedence if true pushed into stack if not entire stack is popped into linked list
	            // the same for every case
	            //while loops are necessary because every in the stack that has higher precedence must be popped
	            case '+': if(hasHigherPrecedence('+'))
								stack.push(String.valueOf(c));
							else{ while(!stack.isEmpty() && !hasHigherPrecedence('+'))
										output.add(stack.pop());
							
								  stack.push(String.valueOf(c));} break;
						 
				case '-': if(hasHigherPrecedence('-'))
								stack.push(String.valueOf(c));
							else{ while(!stack.isEmpty() && !hasHigherPrecedence('-'))
										output.add(stack.pop());
				
								stack.push(String.valueOf(c));} break;
				case '*': if(hasHigherPrecedence('*'))
								stack.push(String.valueOf(c));
							else{ while(!stack.isEmpty()&& !hasHigherPrecedence('*'))
										output.add(stack.pop());
				
								stack.push(String.valueOf(c));} break;
				// case ' ' to adjust for users who enter spaces in their expression				
				case ' ': break;
				case '/': if(hasHigherPrecedence('/'))
								stack.push(String.valueOf(c));
							else{ while(!stack.isEmpty()&& !hasHigherPrecedence('/'))
										output.add(stack.pop());
				
								stack.push(String.valueOf(c));} break;
				case '%': if(hasHigherPrecedence('+'))
								stack.push(String.valueOf(c));
							else{ while(!stack.isEmpty()&& !hasHigherPrecedence('%'))
										output.add(stack.pop());
				
								stack.push(String.valueOf(c));} break;
					// case ( is automatically popped into string
				case '(': stack.push(String.valueOf(c));  break;
				case ')': while(!stack.isEmpty()){
						//while loop continues until stack has (
							if(stack.peek().equals("(")){
								//it is not added to the linkedlist just removed from stack
							stack.pop(); break;	
							}
							else
								//everything is added to linkedlist until ( appears
								output.add(stack.pop());
							}break;
				default: System.out.println("Invalid Character. " + c);			
			}
			//increment
			y++;
		}
		//while loop of everything remaining in stack is added to linked list
		while(!stack.isEmpty())
			output.add(stack.pop());
		
		System.out.print("Post-Fix Expression: ");
		//for loop prints linkedlist
		for(int i=0;i<output.size();i++)
			System.out.print(output.get(i)+ " ");
		
		System.out.println();

	}
	//checks to see if has higher precedence using case statements
	public static boolean hasHigherPrecedence(char value){
		//if stack has no elements
		if(stack.size() == 0)
			return true;
		else{
			//simple switch returns true if certain conditions apply and false if they don't
			switch(value){
			case '+': if(stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%") || stack.peek().equals("+") || stack.peek().equals("-")) return false;
					    else return true; 
			case '-': if(stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%") || stack.peek().equals("+") || stack.peek().equals("-")) return false;
			  		    else return true;
			case '*': if(stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%")) return false;
					    else return true;
			case '/': if(stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%")) return false;
			  		    else return true;
			case '%': if(stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%")) return false;
			  		  	else return true;
			default: System.out.println("Error."); return false;
			}
		}
	}
	public static void math(){
		int i=0;
		//while loop runs while i is less than output size
	try{	while(i < output.size()){
			//if the output is equal to a digit or x, is added back into the stack
			if(containsDigit(output.get(i)) || output.get(i).equals("x")){ 
				stack.push(output.get(i)); 
				}
			//if it is not a digit it must be an apprend
			else{
				//apprend is pushed into stack
				stack.push(output.get(i));
				//apprend method pops top 3 items in stack (apprend, digit,digit)
				apprend(stack.pop(),stack.pop(),stack.pop());
			}
			
			i++;
		}}catch(EmptyStackException e){
			//try catch statment if it doesn't work then the expression was wrong
			System.out.println("Error in Expression");
			System.exit(0);
		}
		
		
	}
	public static void apprend(String z, String y, String x){
		//simple switch statment to run through which apprend was used
		//value x is assigned based on user input
		if(y.equals("x")) y = end ;
		if(x.equals("x")) x = end;
		
		//string is converted to int
		int x2 = Integer.valueOf(x);
		int y2 = Integer.valueOf(y);
	
		//int must be converted back to string because stack is string 
		switch(z){
		case "+": stack.push(String.valueOf(x2+y2)); break;
		case "-": stack.push(String.valueOf(x2-y2)); break;
		case "/": stack.push(String.valueOf(x2/y2)); break;
		case "*": stack.push(String.valueOf(x2*y2)); break;
		case "%": stack.push(String.valueOf(x2%y2)); break;
		}
		
	}
	public static boolean containsDigit(String s){  
		//simple boolean that converts string to char to check if it is a digit
	    boolean containsDigit = false;

	    if(s != null && !s.isEmpty()){
	        for(char c : s.toCharArray()){
	            if(containsDigit = Character.isDigit(c)){
	                break;
	            }
	        }
	    }

	    return containsDigit;
	}
	//method checks to see if expression is correct
	public static void check(){
		//cp and op counts number of parenthese
		int cp=0, op=0;
		char[] check = e.toCharArray();
		
		
		for(int i=0;i<check.length;i++){
			//periods are not accepted
			if(check[i] == '.'){
				System.out.println("Sorry Cannot Accept Floating Point Numbers.");
				System.exit(0);
			}
			if(check[i] == '(') cp++;
			if(check[i] == ')') op++;
			//tells program x was used
			if(check[i] == 'x') maybe =true;
			
		}
		//parenthese count must be equal
		if(cp != op){ 
			System.out.println("Parenthese Do Not Match Up.");
			System.exit(0);
		}
		
		
	}

}