import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Q3 {
	
	public static String requiredString(int n){
		String endValue = "";
		StringBuilder sb = new StringBuilder("11");
		int i = 0;
		for ( i = 1  ; i < n -1 ; i++){
			endValue = sb.insert(1, "0").toString();
		}
		return endValue;
	}

	
	public static BigInteger sqrt(BigInteger n) {
		Double d=Math.sqrt(n.doubleValue());
		n=BigInteger.valueOf(d.longValue());
		return n;
		}
	
	public static BigInteger bigIntSqRootFloor(BigInteger x)
	        throws IllegalArgumentException {
	    if (x.compareTo(BigInteger.ZERO) < 0) {
	        throw new IllegalArgumentException("Negative argument.");
	    }
	    // square roots of 0 and 1 are trivial and
	    // y == 0 will cause a divide-by-zero exception
	    if (x .equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)) {
	        return x;
	    } // end if
	    BigInteger two = BigInteger.valueOf(2L);
	    BigInteger y;
	    // starting with y = x / 2 avoids magnitude issues with x squared
	    for (y = x.divide(two);
	            y.compareTo(x.divide(y)) > 0;
	            y = ((x.divide(y)).add(y)).divide(two));
	    return y;
	} // end bigIntSqRootFloor

	public static BigInteger bigIntSqRootCeil(BigInteger x)
	        throws IllegalArgumentException {
	    if (x.compareTo(BigInteger.ZERO) < 0) {
	        throw new IllegalArgumentException("Negative argument.");
	    }
	    // square roots of 0 and 1 are trivial and
	    // y == 0 will cause a divide-by-zero exception
	    if (x == BigInteger.ZERO || x == BigInteger.ONE) {
	        return x;
	    } // end if
	    BigInteger two = BigInteger.valueOf(2L);
	    BigInteger y;
	    // starting with y = x / 2 avoids magnitude issues with x squared
	    for (y = x.divide(two);
	            y.compareTo(x.divide(y)) > 0;
	            y = ((x.divide(y)).add(y)).divide(two));
	    if (x.compareTo(y.multiply(y)) == 0) {
	        return y;
	    } else {
	        return y.add(BigInteger.ONE);
	    }
	}
	
	public static BigInteger testDivisor (BigInteger num){
		BigInteger val1 = new BigInteger("1");
		BigInteger val2 = new BigInteger("2");
		BigInteger val0 = new BigInteger("0");
		BigInteger i = new BigInteger("10");
		BigInteger thousand = new BigInteger("10000000");
		for (i = val2 ; i.compareTo(thousand) <0 ; i = i.add(val1)){
			//for (i = val2 ; i.compareTo((sqrt(num).add(val1))) <0 ; i = i.add(val1)){
			if( num.mod(i).equals(val0)){
				return i ;
			}
		}
		return num;
	}
	
	public static String toBinary(BigInteger n) {
		BigInteger zero = new BigInteger("0");
		BigInteger valTwo = new BigInteger("2");
	       if (n.equals(zero)) {
	           return "0";
	       }
	       String binary = "";
	       while (n.compareTo(zero) > 0) {
	           BigInteger rem =   n.mod(valTwo);
	           binary = rem.toString() + binary;
	           n = n.divide(valTwo) ;
	       }
	       return binary;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		int counter = 0 , n = 0 , j =0;
	
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Devaraj\\Desktop\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\input\\C-large.in"))) {
		    String line;
		    String[] splited ;
		    String startNum;
		    String possibleNum;
		    int base = 2 ; 
		    BigInteger baseValue = new BigInteger("1");

		    while ((line = br.readLine()) != null) {
	       // process the line.
		    	counter++;
		    	if (counter == 1)  continue;
		    	if (counter == 102) break ; 
		    	splited = line.toString().split(" ");
		    	n = Integer.parseInt(splited[0]);
		    	j = Integer.parseInt(splited[1]);
		    	startNum = requiredString(n);
		    	boolean primeNum = false;
		    	//System.out.println("Starting string is : " + startNum);
		    	System.out.print("Case #" + (counter-1)+":");
		    	BigInteger startBigNumber = new BigInteger(startNum);
		    	BigInteger i = new BigInteger("1");
		    	//BigInteger two = new BigInteger("2");
		    	BigInteger val1 = new BigInteger("1");
		    	// generate possible integers
		  		    	
		    	BigInteger newEndValue = new BigInteger("11111111111111111111111111111111");
		    	
		    	startBigNumber = new BigInteger(startBigNumber.toString(),2);
		    	newEndValue = new BigInteger(newEndValue.toString(),2);
		    	
		    	for (i= startBigNumber; i.compareTo(newEndValue) <0 ; i = i.add(val1)) {
		    		if (j == 0 ) break;
		    		primeNum = false;
		    		possibleNum = toBinary(i);
  				    		
		    		//System.out.print("\n# "+ possibleNum );

		    		if (String.valueOf(possibleNum.charAt(n-1)).equals("0")) continue;
		           // System.out.print("\n" +possibleNum);
		    		baseValue = i ; 
		    		for (base = 2 ; base <=10 ; base ++){
		    			baseValue = new BigInteger(possibleNum , base);
		            	//System.out.print("\t" + baseValue + ":" + testDivisor(baseValue));
		            	if (baseValue == testDivisor(baseValue)) {
		            		primeNum = true;
		            		break;
		            	}
		            }
	
		            if ( primeNum == true) continue;
		            else{ 
		    			
		            	System.out.print("\n" +possibleNum);
		            	for (base = 2 ; base <=10 ; base ++){
		            		baseValue = new BigInteger(possibleNum , base);
		            		//baseValue = BinaryToDecimal(possibleNumVal, base);
		            		System.out.print(" " + testDivisor(baseValue));
		            	}
		            
		            }
		        	j--;
		            		            
		    	}
		    	
		    }
		}
	}
}