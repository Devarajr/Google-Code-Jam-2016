import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Q2 {
	
	public static String flipper (StringBuilder flip , int startIndex){
		int j =1;
		int length = flip.length();
		for(j=startIndex; j <= length ; j++ ){
			if(String.valueOf(flip.charAt(j-1)).equals("-"))
				flip.setCharAt(j-1,'+');
			else
				flip.setCharAt(j-1,'-');
		}
		
		return flip.toString();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		

	//int tries = 0 ;

	int counter = 0 , i = 0 ;
	int stringlength = 0;
	StringBuilder sb = new StringBuilder(64);
	
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Devaraj\\Desktop\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\input\\B-large.in"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
	       // process the line.
		    	counter++;
		    	if (counter == 1)  continue;
		    	if (counter == 102) break ; 
		    	stringlength = line.length();
		    	StringBuffer a = new StringBuffer(line);
		    	a = a.reverse();
		    	line = a.toString();
		    	sb = new StringBuilder(line);
			//System.out.println("String is : " + sb);
				
				int tries = 0 ;
				int flag = 0;
			
				while(true){
			
					for (i = 1 ; i <= stringlength ; i++ ){
					
						if ( i == stringlength  && flag == 0 ) flag = 1;
						if (String.valueOf(sb.charAt(i-1)).equals("+")) continue;
							//flip rest of the character here
							sb = new StringBuilder(flipper(sb, i ));
							
							tries++;
							break;
						}
						if (flag == 1) 	{
							//System.out.println("No of tries is :" + tries);
							break;
						}

					}

				System.out.println("Case #" + (counter-1) + ": "+ tries);
				}				

			}
				
				
			}
			
		}
	


