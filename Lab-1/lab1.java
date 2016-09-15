/*
	Option one convert dec to bin
	Option two convert bin to dec
	Option three is quit
	
	NOTE: print out an array for option one
*/
import java.util.Scanner;

public class Lab1 {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("please enter an int:");
			System.out.println("your number in bin is: " + decToBin(keyboard.nextInt()));
		}
	}
	
	public static int binToDec(String number){
		return 0;
	}
	public static int conv(String number, int i){
		return Character.getNumericValue(number.charAt());
	}
// the below is for dec to bin
	public static int charToInt(){
	}
	public static String decToBin(int number){
		return arrToString(convertUInt(number), 7); 
	}
	public static int[] convertUInt(int num){
		int[] x = new int[8];
		for(int i = 0; i < x.length; i++){
			x[i] = hasRemainder(num);
			num = num / 2;
		}
		return x;
	}
	public static int hasRemainder(int num){
		if((num % 2) > 0){
			return 1;
		}else{
			return 0;
		}
	}
	public static String arrToString(int[] x, int i){
		if(i == -1){
			return "";
		}
		return Integer.toString(x[i]) + arrToString(x, (i = i-1));
	}
}
