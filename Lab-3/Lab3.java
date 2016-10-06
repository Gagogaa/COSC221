/*
 * Gregory Mann
 * E01457245
 * COSC 211-1
 * Fall 2016
 * Lab-3
 *
 * 
 * 
 * 
 * 
 * 
 */

 import java.util.Scanner;
 import java.lang.*;
 public class Lab3 {
 	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println(binAdd("00001011", "10010011"));

	}

	public static String binAdd(String number, String numberOne){
		String out = "";
		boolean carryOut = false;

		for(int i = 0; i < number.length(); i++){
			if(number.charAt(i) == '1' && numberOne.charAt(i) == '1' && carryOut){
				out = out + '1';
				continue;
				// this is stupid i need to find a better way to do this
			} else if ((number.charAt(i) == '1' && numberOne.charAt(i) == '1') || (number.charAt(i) == '1' && carryOut) || (numberOne.charAt(i) == '1' && carryOut)) {
				System.out.println(number.charAt(i) == '1' && numberOne.charAt(i) == '1');
				carryOut = true;
				out = out + '0';
				continue;
			} else if (number.charAt(i) == '1' || numberOne.charAt(i) == '1' || carryOut){
				carryOut = false;
				out = out + '1';
				continue;
			} else {
				carryOut = false;
				out = out + '0';
				continue;
			}
		}
		return out;
	}
	
	public static String binAddOne(String number){
		return binAdd(number, "00000001");
	}

	// Its a wraper method for bitFlip and binAddOne
	public static String twosComp(String number){
		return binAddOne(bitFlip(number));	
	}

	//TODO: rework this method to not convert to decimal
	// binToDec(String, 0);
	public static int binToDec(String number, int i){
		if(number.charAt(0) == '1'){
			int x = innerBinToDec(twosComp(number), i);
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

	// returns the inverse binary representation of an integer as a String that needs to be reversed
	// revDecToBin(int, int, 0)
	public static String revDecToBin(int number, int bits, int i){
		if(i == bits){
			return "";
		}
		if((number % 2) != 0){
			return "0" + revDecToBin(number / 2, bits, ++i);
		}
		return "1" + revDecToBin(number / 2, bits, ++i);
	}

	// returns the binary representation of an integer as a String that needs to be reversed
	// decToBin(int, int, 0)
	public static String decToBin(int number,int bits, int i){
		if(number < 0){
			return revDecToBin(number + 1, bits, i);
		}
		if(i == bits){
			return "";
		}
		if((number % 2) != 0){
			return "1" + decToBin(number / 2, bits, ++i);
		}
		return "0" + decToBin(number / 2, bits, ++i);
	}
 }
