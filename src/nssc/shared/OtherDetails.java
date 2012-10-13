package nssc.shared;

import java.io.Serializable;

import nssc.shared.SolarPowerSystemException;

public class OtherDetails implements Serializable {
	
	private Double averageDailyHoursOfSunlight; // average daily hours of sun light in hours
	
	//private Double dailyAverageUsage;  // daily average usage in kWh
	private Double dayTimeHourlyUsage; // day time hourly usage in kWh
	
	//private Double tariff11Fee;		   // in AUD
	private Double electricityRate;    // electricity rate in AUD
	private Double feedInFee;		   // feed in fee in AUD
	
	private Double systemCost;		   // system cost in AUD
	
	private Double annualTariffIncrease;
	private Double investmentReturnRate;
	
	private Integer panelLifespan;		//
	
	public OtherDetails() {
		
	}
	
	public void setAverageDailyHoursOfSunlight(Double input) throws SolarPowerSystemException {
		if (input < 0.0 || input > 24.0) {
			throw new SolarPowerSystemException("Dverage daily hours of sun light " +
												"should be between 0 and 24 hours."); 
		} else {
			this.averageDailyHoursOfSunlight = input;
		}
	}
	
	/*
	public void setDailyAverageUsage(Double input) throws SolarPowerSystemException {
		if (input < 0.0) {
			throw new SolarPowerSystemException("Daily average usage" +
												"should be equal to or greater than 0");
		} else {
			this.dailyAverageUsage = input;
		}
		
	}
	*/
	
	public void setDayTimeHourlyUsage(Double input) throws SolarPowerSystemException {
		if (input < 0.0) {
			throw new SolarPowerSystemException("Day time hourly usage " +
												"should be equal to or greater than 0");
		} else {
			this.dayTimeHourlyUsage = input;
		}
		
	}
		
	public void setElectricityRate(Double input) throws SolarPowerSystemException {
		if (input <= 0.0) {
			throw new SolarPowerSystemException("Electricity rate " +
												"should be greater than 0");
		} else {
			this.electricityRate = input;
		}
		
	}
	
	public void setFeedInFee(Double input) throws SolarPowerSystemException {
		if (input <= 0.0) {
			throw new SolarPowerSystemException("Feed in fee " +
												"should be greater than 0");
		} else {
			this.feedInFee = input;
		}
		
	}
	
	public void setSystemCost(Double input) throws SolarPowerSystemException {
		if (input <= 0.0) {
			throw new SolarPowerSystemException("System cost " +
												"should be greater than 0");
		} else {
			this.systemCost = input;
		}
		
	}
	
	//not really need to be under 100%
	public void setAnnualTariffIncrease(Double input) throws SolarPowerSystemException {
		if (input < 0.0) {
			throw new SolarPowerSystemException("Annual tariff increase " +
												"should not be less than 0");
		} else {
			this.annualTariffIncrease = input;
		}
	}
	
	public void setInvestmentReturnRate(Double input) throws SolarPowerSystemException {
		if (input < 0.0) {
			throw new SolarPowerSystemException("Investment Return Rate " +
												"should not be less than 0");
		} else {
			this.investmentReturnRate = input;
		}
	}
	
	public void setPanelLifespan(Integer input) throws SolarPowerSystemException {
		if (input < 1) {
			throw new SolarPowerSystemException("Panel lifespan " +
												"should be euqal or greater than 1.");
		} else {
			this.panelLifespan = input;
		}
	}
	
	public Integer getPanelLifespan() {
		return this.panelLifespan;
	}
	
	public Double getAverageDailyHoursOfSunlight() {
		return this.averageDailyHoursOfSunlight;
	}
	
	public Double getDayTimeHourlyUsage() {
		return this.dayTimeHourlyUsage;
	}
	
	public Double getElectricityRate() {
		return this.electricityRate;
	}
	
	public Double getElectricityRate(Integer year) {
		return this.electricityRate * 
				(Math.pow(1 + this.getAnnualTariffIncrease(), year-1));
	}
	
	public Double getFeedInFee() {
		return this.feedInFee;
	}
	
	public Double getSystemCost() {
		return this.systemCost;
	}
	
	public Double getAnnualTariffIncrease() {
		return this.annualTariffIncrease;
	}
	
	public Double getInvestmentReturnRate() {
		return this.investmentReturnRate;
	}
	
	public Double getCompoundInvestmentReturn(Integer year) {
		return this.getSystemCost() * Math.pow(1 + this.getInvestmentReturnRate(), year);
	}
	
	
	public Double getInvestmentIncome() {
		return this.getSystemCost() * this.getInvestmentReturnRate();
	}
	
	public Double getCumulativeIncome(Integer year) {		
		return this.getInvestmentIncome() * year;		
	}
	
	
	@Override
	public String toString() {		
		return "\n< Other Details >" +
			   "\nAverage Daily Hours Of Sunlight:" +  this.getAverageDailyHoursOfSunlight() +
			   "\nDay Time Hourly Usage:\t\t" + this.getDayTimeHourlyUsage() +
			   "\nElectricity Rate:\t\t" + this.getElectricityRate() +
			   "\nFeed In Fee:\t\t\t" + this.getFeedInFee() +
			   "\nSystem Cost:\t\t\t" + this.getSystemCost() +
			   "\nAnnual tariff increase:\t\t" + this.getAnnualTariffIncrease() +
			   "\nInvestment Return Rate:\t\t" + this.getInvestmentReturnRate() +
			   "\n";		
	}
}
