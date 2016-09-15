/*
	Option one convert dec to bin
	Option two convert bin to dec
	Option three is quit
	
	NOTE: print out an array for option one
*/
import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) {
		
		while(true) {
			
		}
	}
	
	public static String decToBin(int number){
		
		return "";
	}
	public static int[] convertUInt(int num){
		int[] x = new int[8];
		for(int i = 0; i <=8; i++){
			x[i] = hasRemainder(num);
			num = num / 2;
		}
		return x;
	}
	public static int hasRemainder(int num){
		if(num % 2 > 0){
			return 1;
		}else{
			return 0;
		}
	}
}
