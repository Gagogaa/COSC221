/*
 * Gregory Mann	
 * E01457245
 * COSC 211-1
 * Fall 2016
 * Lab-1
 * 
 * This lab is a menu driven program that takes input from the user
 * and either converts it from a binary representation of a number 
 * to a decimal number or vice versa taking a decimal number and 
 * converting it to a binary number.
 */
import java.util.Scanner;
import java.lang.*;
public class Lab1 {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		while(true){
			System.out.println();
			System.out.println("1: Convert Dec number to Bin");
			System.out.println("2: Convert Bin number to Dec");
			System.out.println("3: Quit");
			System.out.println();
			System.out.print("What would you like to do: ");
			switch(keyboard.nextInt()){
				case 1: 
					System.out.print("Enter the number you want to convert: ");
					System.out.println("That number in Binary is: " + reverse(decToBin(keyboard.nextInt(),8 ,0), "", 0));
					break;	

				case 2:
					System.out.print("Enter the number you want to convert: ");
					System.out.println("That number in Decimal is: " + binToDec(keyboard.next(), 0));
					break;
				
				case 3: 
					System.exit(0);
					break;
			}
		}
	}

	// returns an integer based on the binary representation of a number 
	// binToDec(String, 0)
	public static int binToDec(String number, int i){
		if(i == number.length()){
			return 0;
		}
		if(number.charAt((number.length() - i) - 1) == '1'){
			return pow(2, i) + binToDec(number, ++i);
		}
		return binToDec(number, ++i);
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

	// returns the binary representation of an integer as a String that needs to be reversed
	// decToBin(int, int, 0)
	public static String decToBin(int number,int bits, int i){
		if(i == bits){
			return "";
		}
		if((number % 2) != 0){
			return "1" + decToBin(number / 2, bits, ++i);
		}
		return "0" + decToBin(number / 2, bits, ++i);
	}
}
