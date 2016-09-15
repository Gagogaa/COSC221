import java.util.Scanner;
import java.lang.*;
public class test {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		while(true){
//			System.out.print("please input a number:");	
//			System.out.println("your number in bin is: " + reverse(numberConv(keyboard.nextInt(), 0), "", 0));
//			System.out.println("Plese input a bin number:");
//			System.out.println(binToDec(keyboard.next(), 0));
//			System.out.println(pow(2, 6));
			System.out.println("1: Convert Dec number to Bin");
			System.out.println("2: Convert Bin number to Dec");
			System.out.println("3: quit");
		}
	}

// returns an integer based on the binary representation of a number 
// the args should be (binNumberAsAString, 0)
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
	public static int pow(int x, int y) {
		int z = 1;
		for(y = y; y > 0; y--){
			z = z * x;
		}
		return z;
	}

	// returns a string that is the rverse of the first string passed
	// the args should be (yourString, "", 0)
	public static String reverse(String x, String y, int i){
		if(i == x.length()){
			System.out.println(i);
			return "";
		}
		return y + x.charAt((x.length() - i) - 1) + reverse(x, y, ++i);
	}

	// returns the binary representation of an interger as a String that needs to be reversed
	// the args should be (yourInt, 0)
	
	public static String numberConv(int number, int i){
		if(i == 8){
			return "";
		}
		if((number % 2) != 0){
			return "1" + numberConv(number / 2, ++i);
		}
		return "0" + numberConv(number / 2, ++i);
	}
}
