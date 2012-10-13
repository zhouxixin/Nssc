package nssc.shared;

import java.io.Serializable;

import nssc.shared.BankOfPanels;
import nssc.shared.SolarPowerSystemException;

public class Inverter implements Serializable {
	
	private Double inverterEfficiency; // percentage in decimal form
		
	public Inverter() {
		
	}
	
	public void setInverterEfficiency(Double input) throws SolarPowerSystemException {
		if (input <= 0.0 || input > 1.0) {
			throw new SolarPowerSystemException("Inverter Efficiency " +
												"should be valid percentage.");
		} else {
			this.inverterEfficiency = input;
		}
	}
	
	public Double getInverterEfficiency() {
		return this.inverterEfficiency;
	} 
	
	public Double getOutput(BankOfPanels b) {
		return b.getOutput() * this.getInverterEfficiency();
	}
	
	/*
	public Double getOutput(Double input) {
		return input * this.getInverterEfficiency();
	}
	*/
	
	@Override
	public String toString() {		
		return "\n< Inverter >" +
			   "\nInverter Efficiency:\t\t" +  this.inverterEfficiency +			   
			   "\n";		
	}

}