package patterns.delegation;

import java.util.ArrayList;
import java.util.List;

public class FilteringLogger implements ILogger{
	
	//private boolean value;
	private List <String>  liste = new ArrayList<>();
	private ILogger logger;
	
	public FilteringLogger(ILogger logger, String... severities) {
		for (String severity : severities) { //for each loop
			liste.add(severity);
		}
		this.logger = logger; //hva gjør denne og loggeren?
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		// TODO Auto-generated method stub
		if (isLogging(severity)) {
			logger.log(severity, message, exception);
		}
		
		else {
			return;
		}
	}
	
	public boolean isLogging(String severity) {
		if (liste.contains(severity)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void setIsLogging(String severity, boolean value) {
		if (isLogging(severity) && value == false) {
			liste.remove(severity);
		}
		
		else if ((isLogging(severity) && value == true) || (!isLogging(severity) && value == false) ) {
			return;
		}
		
		else if (!isLogging(severity) && value == true) {
			liste.add(severity);
		}
		
		else {
			throw new IllegalArgumentException("Feil input!");
		}
		
	}

}
