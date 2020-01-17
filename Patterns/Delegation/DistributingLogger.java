package patterns.delegation;

public class DistributingLogger implements ILogger{
	
	private ILogger errorLogger;
	private ILogger warningLogger;
	private ILogger infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		// TODO Auto-generated method stub
		if (severity == ILogger.ERROR) {
			errorLogger.log(severity, message, exception);
		}
		
		else if (severity == ILogger.WARNING) {
			warningLogger.log(severity, message, exception);
		}
		
		else if (severity == ILogger.INFO) {
			infoLogger.log(severity, message, exception);
		}
		
		else {
			throw new IllegalArgumentException("Feil input!");
		}
	}
	
	public void setLogger(String severity, ILogger logger) {
		if (severity == ILogger.ERROR) {
			this.errorLogger = logger;
		}
		
		else if(severity == ILogger.INFO) {
			this.infoLogger = logger;
		}
		
		else if (severity == ILogger.WARNING) {
			this.warningLogger = logger;
		}
		
		else {
			throw new IllegalArgumentException("Feil input!");
		}
	}

}
