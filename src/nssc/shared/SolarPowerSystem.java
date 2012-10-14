package nssc.shared;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.google.gwt.i18n.client.NumberFormat;

import nssc.shared.BankOfPanels;
import nssc.shared.Inverter;
import nssc.shared.OtherDetails;
import nssc.shared.SolarPowerSystemException;

public class SolarPowerSystem implements Serializable {
	
	private BankOfPanels[] banksOfPanles;
	//private BankOfPanels bank0;
	private Inverter inverter;
	private OtherDetails otherDetials;
	private final Integer DEFAULT_NUMBER_OF_BANKS = 1;
	private final Integer DEFAULT_BANK_INDEX = 0;
	
	private final Integer FIRST_YEAR = 1;
	/** 
	 * Format for output
	 */
	private final String DecFormat ="#.##";	
	
	public SolarPowerSystem() {
		this.banksOfPanles = new BankOfPanels[DEFAULT_NUMBER_OF_BANKS];
		for (int i = 0; i < banksOfPanles.length; i++) {
			banksOfPanles[i] = new BankOfPanels();
		}
		//this.banksOfPanles[0] = new BankOfPanels();
		this.inverter = new Inverter();
		this.otherDetials = new OtherDetails();
	}
	
	public void setSystemSize(Double input) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setSystemSize(input);
	}
	
	public void setPercentagesOnOrientations(Double north, 
			Double west) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setPercentagesOnOrientations(north, west);
	}
	
	public void setEfficiencyLossNorthRoof(Double input) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setEfficiencyLossNorthRoof(input);
	}
	
	public void setEfficiencyLossWestRoof(Double input) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setEfficiencyLossWestRoof(input);
	}
	
	public void setPanelEfficiency(Double input) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setPanelEfficiency(input);
	}
	
	public void setInverterEfficiency (Double input) throws SolarPowerSystemException {
		this.inverter.setInverterEfficiency(input);
	}
	
	public void setAverageDailyHoursOfSunlight(Double input) throws SolarPowerSystemException {
		this.otherDetials.setAverageDailyHoursOfSunlight(input);
	}
	
	public void setDayTimeHourlyUsage(Double input) throws SolarPowerSystemException {
		this.otherDetials.setDayTimeHourlyUsage(input);
	}
	
	public void setElectricityRate(Double input) throws SolarPowerSystemException {
		this.otherDetials.setElectricityRate(input);
	}
	
	public void setFeedInFee(Double input) throws SolarPowerSystemException {
		this.otherDetials.setFeedInFee(input);
	}				
				
	public void setSystemCost(Double input) throws SolarPowerSystemException {
		this.otherDetials.setSystemCost(input);			
	}
	
	public void setPanelAgeEfficiencyLoss(Double input) throws SolarPowerSystemException {
		this.banksOfPanles[DEFAULT_BANK_INDEX].setPanelAgeEfficiencyLoss(input);
	}
	
	public void setPanelLifespan(Integer input) throws SolarPowerSystemException {
		this.otherDetials.setPanelLifespan(input);
	}
	
	public String toString() {		
		return "\n< Solar Power System >" +
			   this.banksOfPanles[DEFAULT_BANK_INDEX].toString() +
			   this.inverter.toString() +  this.otherDetials.toString() +
			   " \n< Calculation Results >" + 
			   " \nAverage Daily Solar Generation:\t" +
			   convertIntoFormat(this.getAverageDailySolarGeneration()) + " kWh" +
			   " \nReplacement Generation:\t\t" +
			   convertIntoFormat(this.getReplacementGeneration()) + " kWh" +
			   " \nExported Generation:\t\t" +
			   convertIntoFormat(this.getExportedGeneration()) + " kWh" +
			   " \nDaily Savings:\t\t\t" +
			   convertIntoFormat(this.getDailySavings()) + " AUD" +
			   " \nAnnual Solar Generation:\t" +
			   convertIntoFormat(this.getAnnualSolarGeneration()) + " kWh" +
			   " \nAnnual Savings:\t\t\t" +
			   convertIntoFormat(this.getAnnualSavings()) + " AUD" ;
			   //+
			   //"\n\n< Future Annual Solar Generation >" + this.getFutureOutput() +
			   //"\n";		
	}
	
	public static String convertIntoFormat(Double input) {
		return NumberFormat.getFormat("#.00").format(input);
		//return new DecimalFormat(this.DecFormat).format(input);
	}
	
	public Double getAverageDailySolarGeneration() {
		return this.getAverageDailySolarGeneration(FIRST_YEAR);
		//return this.inverter.getOutput(banksOfPanles[DEFAULT_BANK_INDEX]) * 
		//		this.otherDetials.getAverageDailyHoursOfSunlight();
	}
	
	public Double getAverageDailySolarGeneration(Integer year) {
		return this.inverter.getOutput(banksOfPanles[DEFAULT_BANK_INDEX]) * 
				this.otherDetials.getAverageDailyHoursOfSunlight() * 
				this.banksOfPanles[DEFAULT_BANK_INDEX].getPanelEfficiency(year) /
				this.banksOfPanles[DEFAULT_BANK_INDEX].getPanelEfficiency();
	}
	
	public Double getReplacementGeneration() {
		return this.otherDetials.getDayTimeHourlyUsage() * 
				this.otherDetials.getAverageDailyHoursOfSunlight();
	}
	
	public Double getExportedGeneration(Integer year) {
		return this.getAverageDailySolarGeneration(year) -
				this.getReplacementGeneration();
	}
	
	public Double getExportedGeneration() {
		return this.getAverageDailySolarGeneration() -
				this.getReplacementGeneration();
	}
	
	public Double getDailySavings() {
		return this.getReplacementGeneration() * 
				this.otherDetials.getElectricityRate() +
				this.getExportedGeneration() *
				this.otherDetials.getFeedInFee();
	}
	
	public Double getDailySavings(Integer year) {
		return this.getReplacementGeneration() * 
				this.otherDetials.getElectricityRate(year) +
				this.getExportedGeneration(year) *
				this.otherDetials.getFeedInFee();
	}
	
	public Double getAnnualSolarGeneration() {
		return this.getAverageDailySolarGeneration(FIRST_YEAR) * 365;
	}
	
	public Double getAnnualSolarGeneration(Integer year) {
		return this.getAverageDailySolarGeneration(year) * 365;				
	}
	
	public Double getAnnualSavings() {
		return this.getDailySavings() * 365;
	}
	
	public Double getAnnualSavings(Integer year) {
		return this.getDailySavings(year) * 365;
	}
	
	public Double getCumulativeAnnualSavings(Integer year) {
		Double sum = 0.0;
		
		for (int i = 1; i <= year ; i++){
			sum += this.getAnnualSavings(year);
		}
		
		return sum;
	}
	
	//outdated
	public String getFutureOutput() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("year ");
			sb.append(year);
			sb.append(" - ");
			sb.append(this.getAnnualSolarGeneration(year).toString().substring(0, 7));			
			sb.append(" kW\n");
		}
					
		return sb.toString();
	}
	
	public String getFutureAnnualSolarGenerationForChartInput() {
		StringBuffer sb = new StringBuffer();
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("['");
			sb.append(year);
			sb.append("',");
			sb.append(this.convertIntoFormat(this.getAnnualSolarGeneration(year)));
			sb.append("]");
			
			if (year < this.otherDetials.getPanelLifespan())
				sb.append(",");
		}
		
		return sb.toString();
	}
	
	public String[] getFutureAnnualSolarGenerationForGWTChartInput() {
		String[] stringArray = new String[this.otherDetials.getPanelLifespan()];
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			stringArray[year - 1] = this.convertIntoFormat(this.getAnnualSolarGeneration(year));
		}
		return stringArray;		
	}
	
	public String getFutureAnnualSavingsForChartInput() {
		StringBuffer sb = new StringBuffer();
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("['");
			sb.append(year);
			sb.append("',");
			sb.append(this.convertIntoFormat(this.getAnnualSavings(year)));
			sb.append("]");
			
			if (year < this.otherDetials.getPanelLifespan())
				sb.append(",");
		}
		
		return sb.toString();
	}
	
	public String[] getFutureAnnualSavingsForGWTChartInput() {
		String[] stringArray = new String[this.otherDetials.getPanelLifespan()];
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			stringArray[year - 1] = this.convertIntoFormat(this.getAnnualSavings(year));
		}
		return stringArray;		
	}
	
	
	public String getCumulativeIncomeForChartInput() {
		StringBuffer sb = new StringBuffer();
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("['");
			sb.append(year);
			sb.append("',");
			sb.append(this.convertIntoFormat(this.otherDetials.getCumulativeIncome(year)));
			sb.append("]");
			
			if (year < this.otherDetials.getPanelLifespan())
				sb.append(",");
		}
		
		return sb.toString();
	}
	
	public String getCompoundInvestmentReturnForChartInput() {
		StringBuffer sb = new StringBuffer();
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("['");
			sb.append(year);
			sb.append("',");
			sb.append(this.convertIntoFormat(this.otherDetials.getCompoundInvestmentReturn(year)));
			sb.append("]");
			
			if (year < this.otherDetials.getPanelLifespan())
				sb.append(",");
		}
		
		return sb.toString();
	}
	
	public String getReturnOnInvestmentForChartInput() {
		StringBuffer sb = new StringBuffer();
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			sb.append("['");
			sb.append(year);
			sb.append("',");
			sb.append(this.convertIntoFormat(this.getCumulativeAnnualSavings(year)));
			sb.append(",");
			sb.append(this.convertIntoFormat(this.otherDetials.getCompoundInvestmentReturn(year)));
			sb.append(",");
			sb.append(this.convertIntoFormat(this.otherDetials.getCumulativeIncome(year)));
			sb.append("]");
			
			if (year < this.otherDetials.getPanelLifespan())
				sb.append(",");
		}
		
		return sb.toString();
	}
	
	public String[] getCumulativeAnnualSavingsForGWTChartInput() {
		String[] stringArray = new String[this.otherDetials.getPanelLifespan()];
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			stringArray[year - 1] = this.convertIntoFormat(this.getCumulativeAnnualSavings(year));
		}
		return stringArray;		
	}
	
	public String[] getCompoundInvestmentReturnForGWTChartInput() {
		String[] stringArray = new String[this.otherDetials.getPanelLifespan()];
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			stringArray[year - 1] = this.convertIntoFormat(this.otherDetials.getCompoundInvestmentReturn(year));
		}
		return stringArray;		
	}
	
	public String[] getCumulativeIncomeForGWTChartInput() {
		String[] stringArray = new String[this.otherDetials.getPanelLifespan()];
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++) {
			stringArray[year - 1] = this.convertIntoFormat(this.otherDetials.getCumulativeIncome(year));
		}
		return stringArray;		
	}
	
	public Double getAnnualTariffIncrease() {
		return this.otherDetials.getAnnualTariffIncrease();
	}
	
	public Double getInvestmentReturnRate() {
		return this.otherDetials.getInvestmentReturnRate();
	}
	
	public void setAnnualTariffIncrease(Double input) throws SolarPowerSystemException {
		this.otherDetials.setAnnualTariffIncrease(input);
	}
	
	public void setInvestmentReturnRate(Double input) throws SolarPowerSystemException {
		this.otherDetials.setInvestmentReturnRate(input);
	}
	
	public Integer getPayBackTime() {
		
		for (int year = 1; year <= this.otherDetials.getPanelLifespan(); year++){
			if ((this.otherDetials.getCompoundInvestmentReturn(year) - 
					this.getCumulativeAnnualSavings(year)) < 0) {
				return year;
			}			
		}
		
		return 0;
	}
	
}
