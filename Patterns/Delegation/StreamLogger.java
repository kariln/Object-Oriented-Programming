package patterns.delegation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger{
	
	String formatString;
	OutputStream output;
	
	
	//konstruktør
	public StreamLogger(OutputStream stream) {
		formatString = "%s: %s (%s)"; 
		this.output = stream;
		
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		try (PrintStream p = new PrintStream (output)){ //må ha implementert closeable i parentes
			p.println(String.format(formatString, severity, message, exception));
			p.flush();	
			p.close();		}
	
		catch (Exception e){ 
			System.out.println("Could not log the output stream." );
		}
		
	}
	
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
	
	public static void main(String [] args) {

		ILogger logger = new StreamLogger(System.out);
		logger.log(ILogger.INFO, "Denne meldingen er til informasjon og skrives til System.out", null);
		System.out.println(logger);
	}
}
