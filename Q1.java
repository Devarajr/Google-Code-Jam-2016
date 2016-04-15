import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {
	
	public static char[] split(int num){
		
		String number = String.valueOf(num);

		char[] digits1 = number.toCharArray();
		
	
		return digits1;

		}
	
	public static boolean digits(char digits1[]){
		
		if (
				!(new String(digits1).contains("0")) ||
				!(new String(digits1).contains("1")) ||
				!(new String(digits1).contains("2")) ||
				!(new String(digits1).contains("3")) ||
				!(new String(digits1).contains("4")) ||
				!(new String(digits1).contains("5")) ||
				!(new String(digits1).contains("6")) ||
				!(new String(digits1).contains("7")) ||
				!(new String(digits1).contains("8")) ||
				!(new String(digits1).contains("9"))
							
				) {
			//System.out.println("Does not contain atleast one number :" + new String(digits1));

			return true;
			}
		
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
	int i =1, j =1, t = 0;
	char [] resultDigits ;
	int result = 0 ;

	int counter = 0 ;
	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Devaraj\\Desktop\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\input\\A-small-attempt8.in"))) {
	    String line;
	    while ((line = br.readLine()) != null) {
       // process the line.
	    	counter++;
	    	if (counter == 1)  continue;
	    	if (counter == 102) break ; 
	   t = Integer.parseInt(line);
	for ( i =t ; i <= t  ; i++ ){
		
		if (i == 0) {System.out.println("Case #" + (counter-1) + ": INSOMNIA");}
		else{
		j = i;
		resultDigits = split(j);
		StringBuilder sb = new StringBuilder(64);
		sb.append("");
		while(true){
		
		if (digits(resultDigits)){
			sb.append(split(j));
			result = j;
			j = j + i;
			resultDigits = sb.toString().toCharArray();
			//System.out.println("result digit is : " + new String(resultDigits));
		}
		else{
						System.out.println("Case #" + (counter-1) + ": "+ result);
			break;
		}
		
		}
		}
	}
		
	}
	}
	}
}

