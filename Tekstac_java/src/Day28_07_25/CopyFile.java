package Day28_07_25;

import java.io.*;
public class CopyFile {
 
	public static void main(String[] args) {
 
		  // try block with multiple resources
	    try (
	      FileReader fileReader = new FileReader("src/Day28_07_25/Student.java");
	      BufferedReader bufferedReader = new BufferedReader(fileReader);
	      FileWriter fileWriter = new FileWriter("file2.txt");
	      PrintWriter printWriter = new PrintWriter(fileWriter)
	    )
	   {
	      String line;
	      while ((line = bufferedReader.readLine()) != null) {
	        // Read content line by line and write it
	        // to the output (file2.txt) file
	        printWriter.println(line);
	      }
	      System.out.println("Content copied.");
	    } catch (IOException e) {
	      System.err.println("error :"+e);
	    }
	  }
 
	
 
}