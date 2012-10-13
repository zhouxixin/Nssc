package nssc.shared;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OtherDetailsTest {
	private OtherDetails otherDetails;
	
	private final Integer PANEL_LIFESPAN = 10;
	private final Double AVERAGE_DAILY_HOURS_OF_SUNLIGHT = 3.3;
	private final Double DAY_TIME_HOURLY_USAGE = 3.3;
	private final Double ELECTRICITY_RATE = 0.67;
	private final Double ELECTRICITY_RATE_YEAR_6 = 0.8551;
	private final Double ANNUAL_TARIFF_INCREASE = 0.05;
	private final Double INVESTMENT_RETURN_RATE = 0.05;
	private final Double FEED_IN_FEE = 0.5;
	private final Double SYSTEM_COST = 25000.0;
	
	private final Double EXPECTED_INVESTMENT_INCOME = 1250.0;
	private final Double EXPECTED_CUMULATIVE_INCOME_YEAR_5 = 6250.0;
	private final Double EXPECTED_COMPOUND_INVESTMENT_RETURN_YEAR_3 = 28940.625;
	
	private final Double EPSILON = 0.001;
	

	@Before@Test
	public void setUp() throws SolarPowerSystemException {
		this.otherDetails = new OtherDetails();
		this.otherDetails.setPanelLifespan(PANEL_LIFESPAN);
		this.otherDetails.setAverageDailyHoursOfSunlight(
				AVERAGE_DAILY_HOURS_OF_SUNLIGHT);
		this.otherDetails.setDayTimeHourlyUsage(DAY_TIME_HOURLY_USAGE);
		this.otherDetails.setElectricityRate(ELECTRICITY_RATE);
		this.otherDetails.setAnnualTariffIncrease(ANNUAL_TARIFF_INCREASE);
		this.otherDetails.setInvestmentReturnRate(INVESTMENT_RETURN_RATE);
		this.otherDetails.setFeedInFee(FEED_IN_FEE);
		this.otherDetails.setSystemCost(SYSTEM_COST);
	}
	
   /**
	* test setPanelLifespan(Integer input)
	* 
    * 1. valid input
	* 2. 1
	* 3. less than 1
	*/
	@Test
	public void testSetPanelLifespan() 
			throws SolarPowerSystemException {
		this.otherDetails.setPanelLifespan(3);
	}
	
	@Test 
	public void testSetPanelLifespanWithOne() 
			throws SolarPowerSystemException {
		this.otherDetails.setPanelLifespan(1);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetPanelLifespanWithLessThanOneInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setPanelLifespan(-3);
	}   
	
	/**
  	* test setAverageDailyHoursOfSunlight(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input
	* 4. greater than 24
	* 5. 24 
	*/	
	@Test
	public void testSetAverageDailyHoursOfSunlight() 
			throws SolarPowerSystemException {
		this.otherDetails.setAverageDailyHoursOfSunlight(5.5);
	}
	
	@Test
	public void testSetAverageDailyHoursOfSunlightWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setAverageDailyHoursOfSunlight(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetAverageDailyHoursOfSunlightWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setAverageDailyHoursOfSunlight(-5.5);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetAverageDailyHoursOfSunlightWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setAverageDailyHoursOfSunlight(50.0);
	}
	
	@Test 
	public void testSetAverageDailyHoursOfSunlightWithTwentyFour() 
			throws SolarPowerSystemException {
		this.otherDetails.setAverageDailyHoursOfSunlight(24.0);
	}
	
   /**
  	* test setDayTimeHourlyUsage(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	 
	*/	
	@Test
	public void testSetDayTimeHourlyUsage() 
			throws SolarPowerSystemException {
		this.otherDetails.setDayTimeHourlyUsage(4.5);
	}
	
	@Test
	public void testSetDayTimeHourlyUsageWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setDayTimeHourlyUsage(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetDayTimeHourlyUsageWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setDayTimeHourlyUsage(-6.5);
	}
	
   /**
  	* test setElectricityRate(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	  
	*/	
	@Test
	public void testSetElectricityRate() 
			throws SolarPowerSystemException {
		this.otherDetails.setElectricityRate(10.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetElectricityRateWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setElectricityRate(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetElectricityRateWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setElectricityRate(-1.0);
	}
	

   /**
  	* test setAnnualTariffIncrease(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	  
	*/	
	@Test
	public void testSetAnnualTariffIncrease() 
			throws SolarPowerSystemException {
		this.otherDetails.setAnnualTariffIncrease(5.5);
	}
	
	@Test 
	public void testSetAnnualTariffIncreaseWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setAnnualTariffIncrease(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetAnnualTariffIncreaseWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setAnnualTariffIncrease(-5.0);
	}
	
   /**
  	* test setInvestmentReturnRate(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	  
	*/	
	@Test
	public void testSetInvestmentReturnRate() 
			throws SolarPowerSystemException {
		this.otherDetails.setInvestmentReturnRate(5.5);
	}
	
	@Test 
	public void testSetInvestmentReturnRateWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setInvestmentReturnRate(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetInvestmentReturnRateWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setInvestmentReturnRate(-5.0);
	}
	
   /**
  	* test setFeedInFee(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	  
	*/	
	@Test
	public void testSetFeedInFee() 
			throws SolarPowerSystemException {
		this.otherDetails.setFeedInFee(5.5);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetFeedInFeeWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setFeedInFee(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetFeedInFeeWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setFeedInFee(-5.0);
	}
	

   /**
  	* test setSystemCost(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input	  
	*/	
	@Test
	public void testSetSystemCost() 
			throws SolarPowerSystemException {
		this.otherDetails.setSystemCost(50000.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetSystemCostWithZero() 
			throws SolarPowerSystemException {
		this.otherDetails.setSystemCost(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetSystemCostWithNegativeInput() 
			throws SolarPowerSystemException {
		this.otherDetails.setSystemCost(-50000.0);
	}
	
	
	
	
	
   /**
	* test getSystemCost()
	*/
	@Test
	public void testGetSystemCost() {
		assertEquals(this.SYSTEM_COST, this.otherDetails.getSystemCost());
	}	
		
	
   /**
	* test getFeedInFee()
	*/
	@Test
	public void testGetFeedInFee() {
		assertEquals(this.FEED_IN_FEE, this.otherDetails.getFeedInFee());
	}	
	
   /**
	* test getInvestmentReturnRate()
	*/
	@Test
	public void testGetInvestmentReturnRate() {
		assertEquals(this.INVESTMENT_RETURN_RATE, this.otherDetails.getInvestmentReturnRate());
	}	
	
   /**
	* test getPanelLifespan()
	*/
	@Test
	public void testGetPanelLifespan() {
		assertEquals(this.PANEL_LIFESPAN, this.otherDetails.getPanelLifespan());
	}
	
   /**
	* test getAverageDailyHoursOfSunlight()
	*/
	@Test
	public void testGetAverageDailyHoursOfSunlight() {
		assertEquals(this.AVERAGE_DAILY_HOURS_OF_SUNLIGHT, 
				this.otherDetails.getAverageDailyHoursOfSunlight());
	}
	
   /**
	* test getDayTimeHourlyUsage()
	*/
	@Test
	public void testGetDayTimeHourlyUsage() {
		assertEquals(this.DAY_TIME_HOURLY_USAGE, 
				this.otherDetails.getDayTimeHourlyUsage());
	}
	
  /**
	* test getElectricityRate()
	*/
	@Test
	public void testGetElectricityRate() {
		assertEquals(this.ELECTRICITY_RATE, 
				this.otherDetails.getElectricityRate());
	}
		
   /**
	* test getElectricityRate(Integer year)
	*/
	@Test
	public void testGetElectricityRateWithYearParameter() {
		final Integer YEAR = 6;		
		assertEquals(this.ELECTRICITY_RATE_YEAR_6, 
				this.otherDetails.getElectricityRate(YEAR),
				EPSILON);
	}
	
   /**
	* test getAnnualTariffIncrease()
	*/
	@Test
	public void testGetAnnualTariffIncrease() {
		assertEquals(this.ANNUAL_TARIFF_INCREASE, 
				this.otherDetails.getAnnualTariffIncrease());
	}
	
   /**
	* test getInvestmentIncome()
	*/
	@Test
	public void testGetInvestmentIncome() {
		assertEquals(this.EXPECTED_INVESTMENT_INCOME, 
				this.otherDetails.getInvestmentIncome(),
				EPSILON);
	}
	
   /**
	* test getCumulativeIncome(Integer year)
	*/
	@Test
	public void testCumulativeIncome() {
		final Integer YEAR = 5;			
		assertEquals(this.EXPECTED_CUMULATIVE_INCOME_YEAR_5, 
				this.otherDetails.getCumulativeIncome(YEAR),
				EPSILON);
	}
	
   /**
	* test getCompoundInvestmentReturn(Integer year)
	*/
	@Test
	public void testCompoundInvestmentReturn() {
		final Integer YEAR = 3;			
		assertEquals(this.EXPECTED_COMPOUND_INVESTMENT_RETURN_YEAR_3, 
				this.otherDetails.getCompoundInvestmentReturn(YEAR),
				EPSILON);
	}
	
}
