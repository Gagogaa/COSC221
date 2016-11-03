/*
 * Gregory Mann * E01457245
 * COSC 211-1
 * Fall 2016
 * Lab-3
 *
 * This is a menu driven program for adding and subtracting two signed binary numbers given 
 * by the user.
 */

 import java.util.Scanner;
 import java.lang.*;
 public class Lab3 {
 	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		while(true){
			System.out.println("What would you like to do?");
			System.out.println("1: Add");
			System.out.println("2: Subtract");
			System.out.println("3: Quit");
			System.out.println();
			switch(keyboard.nextInt()){
				case 1:
					System.out.println("Please enter two binary numbers to Add");
					System.out.print("First Number: ");
					String one = keyboard .next();
					System.out.print("Second Number: ");
					String two = keyboard.next();
					String sum = reverse(binAdd(one, two), "", 0);
					System.out.println("You added: " + one + " (" + binToDec(one, 0) + ") + " + two + " (" + binToDec(two, 0) + ") = " + sum + " (" + binToDec(sum, 0) + ") ");
					System.out.println();
					break;

				case 2:
					System.out.println("Please enter two binary numbers to Subtract");
					System.out.print("First Number: ");
					one = keyboard .next();
					System.out.print("Second Number: ");
					two = keyboard.next();
					String sub = reverse(binAdd(one, reverse(twosComp(two), "", 0)), "", 0);
					System.out.println(reverse(twosComp(two), "", 0));
					System.out.println("You Subtracted: " + one + " (" + binToDec(one, 0) + ") - " + two + " (" + binToDec(two, 0) + ") = " + sub + " (" + binToDec(sub, 0) + ") ");
					System.out.println();
					break;

				case 3:
					System.out.println("Thank you for using the program!");
					System.exit(0);

				default:
					System.out.println("Sorry thats not a valid option");
					break;
			}
		}
	}

	// Adds two binary numbers in string form the out put needs to be reversed
	// binAdd(String, String)
	public static String binAdd(String newNumber, String newNumberOne){
		String out = "";
		boolean carryOut = false;
		String number = reverse(newNumber, "", 0);
		String numberOne = reverse(newNumberOne, "", 0);

		for(int i = 0; i < number.length(); i++){
			if(number.charAt(i) == '1' && numberOne.charAt(i) == '1' && carryOut){
				out = out + '1';
			} else if ((number.charAt(i) == '1' && numberOne.charAt(i) == '1') || (number.charAt(i) == '1' && carryOut) || (numberOne.charAt(i) == '1' && carryOut)) {
				carryOut = true;
				out = out + '0';
			} else if (number.charAt(i) == '1' || numberOne.charAt(i) == '1' || carryOut){
				carryOut = false;
				out = out + '1';
			} else {
				out = out + '0';
			}
		}
		return out;
	}

	// Adds one to a binary string number and returns it as a string that needs to be reversed
	// binAddOne(String)
	public static String binAddOne(String number){
		return binAdd(number, "00000001");
	}

	// Its a wraper method for bitFlip and binAddOne
	// takes the twos complement of a number and returns it as a binary string
	// TwosComp(String)
	public static String twosComp(String number){
		return binAddOne(bitFlip(number));	
	}

	// Converts a binary number to a decimal number 
	// binToDec(String, 0);
	public static int binToDec(String number, int i){
		if(number.charAt(0) == '1'){
			int x = innerBinToDec(reverse(twosComp(number), "", 0), i);
			if(x == 0){ // max negative number
			 return - pow(2, (number.length() - 1));
			}
			return x - (x * 2);
		} else {
			return innerBinToDec(number, i);
		}
	}

	// takes the binary representation of a string and returns the inverse of it
	// bitFlip(String)
	public static String bitFlip(String source){
		String out = "";
		for(int i = 0; i < source.length(); i++){
			if(source.charAt(i) == '1'){
				out = out + '0';
			} else {
				out = out + '1';
			}
		}
		return out;
	}

	// returns an integer based on the binary representation of a number excluding the sign bit
	// binToDec(String, 0)
	public static int innerBinToDec(String number, int i){
		if(i == number.length() - 1){
			return 0;
		}
		if(number.charAt((number.length() - i) - 1) == '1'){
			return pow(2, i) + innerBinToDec(number, ++i);
		}
		return innerBinToDec(number, ++i);
	}

	// this is an integer version of the Math.pow function
	// returns the first integer raised to the power of the second
	// pow(int, int)
	public static int pow(int x, int y) {
		int z = 1;
		for(y = y; y > 0; y--){
			z = z * x;
		}
		return z;
	}

	// returns a string that is the reverse of the first string passed
	// reverse(String, "", 0)
	public static String reverse(String x, String y, int i){
		if(i == x.length()){
			return "";
		}
		return y + x.charAt((x.length() - i) - 1) + reverse(x, y, ++i);
	}
}
