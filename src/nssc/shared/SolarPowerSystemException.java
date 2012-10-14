package nssc.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SolarPowerSystemException extends Exception implements Serializable {
	
	public SolarPowerSystemException() {
		super();
	}
	
	public SolarPowerSystemException(String message) {
		super("Solar Power System Excption: " + message);		
	}
}