package app;

//import java.util.Vector.add;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class historie implements grensesnitt_app{
	private static String hist;
	
	public static String toString(double svar) {
		String svar2 = String.valueOf(svar);
		return svar2;
	}
	
	public void vise(Integer input1, Integer input2, String operator, double svar, File fil) {
		// vil bruke toString fra kalkulator.java
		try {
			PrintWriter out = new PrintWriter(fil);
			hist = toString(input1) + operator + toString(input2) + "=" + svar + "\n";
			//out opprettes i controlleren
			out.println(hist);
			out.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		
		}
	}
	
	public String lese(File fil) {
		try {
			String line = "";
			Scanner inFile = new Scanner(new FileReader(fil));
			if (inFile.hasNextLine()) {
				line = inFile.nextLine();
			}
			inFile.close();
			return line;
		}
		
		catch(FileNotFoundException e) {
			return "File not found";
		}
	}

}
