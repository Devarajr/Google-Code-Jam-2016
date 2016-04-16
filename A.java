import java.io.*;
import java.util.*;

public class A{
  private static InputReader in;
  private static PrintWriter out;
  public static boolean ready = true;
  public static final String fileName = "A-large";

  
  public static void main3()throws IOException {
	 //out.println(in.nextInt() + " , " +  in.nextInt()  + " , " +  in.nextInt());
	  String input = in.nextInt();
	  int len = input.length();
	  int i = 0 ;
	  String out = String.valueOf(input.charAt(i));
	  
	  for(i=0 ; i < len -1 ; i++){
		  
		  //System.out.println(input.charAt(i));
		  if (out.length() == 1){
			  if(out.charAt(0)  < input.charAt(i+1)){
				  
				  out =  String.valueOf(input.charAt(i+1)) + out ;
			  }
			  else{
				  out = out + String.valueOf(input.charAt(i+1)) ; 
			  }
		  }
		  else {
			  if( input.charAt(i+1) < out.charAt(0)  ){
				  out = out + String.valueOf(input.charAt(i+1));
			  }
			  else{
				  out = String.valueOf(input.charAt(i+1)) + out; 
				  
			  }
			  
		  }

	  }
	 
	  System.out.println(out);
  }

  public static void main(String[] args) throws IOException {
    if (ready) {
      in = new InputReader(new FileInputStream(new File(fileName + ".in")));
      out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
    } else {
      in = new InputReader(System.in);
      out = new PrintWriter(System.out, true);
    }

    // first line from the input file gives the number of testCaseNumcases
    int testCaseCount = Integer.parseInt(in.nextInt());  
    for (int testCaseNum = 1; testCaseNum <= testCaseCount; testCaseNum ++) {
      out.print("Case #" + testCaseNum + ": ");
      System.out.print("Case #" + testCaseNum + ": ");
      main3();
    }

    out.close();
    System.exit(0);
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
     reader = new BufferedReader(new InputStreamReader(stream), 32768);
     tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public String nextInt() {
     // return Integer.parseInt(next());
    	return next();
    }
  }
}
