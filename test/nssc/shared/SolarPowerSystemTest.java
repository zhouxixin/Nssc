package nssc.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolarPowerSystemTest {
	
	private SolarPowerSystem sps;	
	
	private final Double SYSTEM_SIZE = 5.0;
	private final Double PERCENTAGE_ON_NORTH_ROOF = 0.4;
	private final Double PERCENTAGE_ON_WEST_ROOF = 0.6;
	private final Double EFFICIENCY_LOSS_NORTH_ROOF = 0.05;
	private final Double EFFICIENCY_LOSS_WEST_ROOF = 0.15;
	private final Double PANEL_EFFICIENCY = 0.95;
	private final Double PANEL_AGE_EFFICIENCY_LOSS = 0.03;
	
	private final Double INVERTER_EFFICIENCY = 0.9;
	
	private final Integer PANEL_LIFESPAN = 20;
	private final Double AVERAGE_DAILY_HOURS_OF_SUNLIGHT = 5.3;
	private final Double DAY_TIME_HOURLY_USAGE = 2.0;
	private final Double ELECTRICITY_RATE = 0.67;
	//private final Double ELECTRICITY_RATE_YEAR_6 = 0.8551;
	private final Double ANNUAL_TARIFF_INCREASE = 0.05;
	private final Double INVESTMENT_RETURN_RATE = 0.05;
	private final Double FEED_IN_FEE = 0.5;
	private final Double SYSTEM_COST = 25000.0;
	
	private final Integer EXPECTED_PAY_BACK_TIME = 9;
	private final Double EXPECTED_DAILY_SOLAR_GENERATION = 20.165;
	private final Double EXPECTED_DAILY_SOLAR_GENERATION_YEAR_10 = 14.434;
	private final Double EXPECTED_REPLACEMENT_GENERATION = 10.60;
	
	private final Double EXPECTED_EXPORTED_GENERATION_YEAR_8 = 5.107;
	private final Double EXPECTED_EXPORTED_GENERATION = 9.565;
	
	private final Double EXPECTED_DAILY_SAVINGS_YEAR_8 = 12.547;
	private final Double EXPECTED_DAILY_SAVINGS = 11.885;
	
	private final Double EXPECTED_ANNUAL_SOLAR_GENERATION = 7360.289;
	private final Double EXPECTED_ANNUAL_SOLAR_GENERATION_YEAR_8 = 5733.278;
	
	private final Double EXPECTED_ANNUAL_SAVINGS = 4337.874;
	private final Double EXPECTED_ANNUAL_SAVINGS_YEAR_8 = 4579.667;
	
	private final Double EXPECTED_CUMULATIVE_ANNUAL_SAVINGS_YEAR_3 = 13113.444;
	
	private final Double EPSILON = 0.001;
	
	private final String EXPECTED_FUTURE_ANNUAL_SOLAR_GENERATION_FOR_CHART_INPUT = 
			"['1',7360.29],['2',7127.86],['3',6895.43]";
	
	private final String EXPECTED_FUTURE_ANNUAL_SAVINGS_FOR_CHART_INPUT = 
			"['1',4337.87],['2',4351.27],['3',4371.15]";
	
	private final String EXPECTED_CUMULATIVE_INCOME_FOR_CHART_INPUT = "";
	private final String EXPECTED_COMPOUND_INVESTMENT_RETURN_FOR_CHART_INPUT = "";
	
	private final String EXPECTED_RETURN_ON_INVESTMENT_FOR_CHART_INPUT = 
			"['1',4337.87,26250,1250],['2',8702.54,27562.5,2500],['3',13113.44,28940.63,3750]";
	
	
	//FutureAnnulSolarGenerationForChartInput

	/**
	 * @throws java.lang.Exception
	 */
	@Before@Test
	public void setUp() throws Exception {
		sps = new SolarPowerSystem();
		sps.setSystemSize(SYSTEM_SIZE);
        sps.setPercentagesOnOrientations(PERCENTAGE_ON_NORTH_ROOF, PERCENTAGE_ON_WEST_ROOF);
        sps.setEfficiencyLossNorthRoof(EFFICIENCY_LOSS_NORTH_ROOF);
        sps.setEfficiencyLossWestRoof(EFFICIENCY_LOSS_WEST_ROOF);
        sps.setPanelEfficiency(PANEL_EFFICIENCY);			
        sps.setInverterEfficiency(INVERTER_EFFICIENCY);		
        sps.setAverageDailyHoursOfSunlight(AVERAGE_DAILY_HOURS_OF_SUNLIGHT);
        sps.setDayTimeHourlyUsage(DAY_TIME_HOURLY_USAGE);
        sps.setElectricityRate(ELECTRICITY_RATE);
        sps.setFeedInFee(FEED_IN_FEE);
        sps.setSystemCost(SYSTEM_COST);
        sps.setPanelAgeEfficiencyLoss(PANEL_AGE_EFFICIENCY_LOSS);
        sps.setPanelLifespan(PANEL_LIFESPAN);
        sps.setAnnualTariffIncrease(ANNUAL_TARIFF_INCREASE);
        sps.setInvestmentReturnRate(INVESTMENT_RETURN_RATE);
	}

	

	/**
	 * Test method for Integer getPayBackTime()
	 */
	@Test
	public void testGetPayBackTime() {
		assertEquals(this.EXPECTED_PAY_BACK_TIME, this.sps.getPayBackTime());
	}
	
	/**
	 * Test method for Double getAverageDailySolarGeneration()
	 */
	@Test
	public void testGetAverageDailySolarGeneration() {
		assertEquals(this.EXPECTED_DAILY_SOLAR_GENERATION, 
				this.sps.getAverageDailySolarGeneration(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getAverageDailySolarGeneration(Integer year)
	 */
	@Test
	public void testGetAverageDailySolarGenerationWithYearParameter() {
		final Integer YEAR = 10;
		assertEquals(this.EXPECTED_DAILY_SOLAR_GENERATION_YEAR_10, 
				this.sps.getAverageDailySolarGeneration(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getReplacementGeneration()
	 */
	@Test
	public void testGetReplacementGeneration() {
		assertEquals(this.EXPECTED_REPLACEMENT_GENERATION, 
				this.sps.getReplacementGeneration(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getExportedGeneration()
	 */
	@Test
	public void testGetExportedGeneration() {
		assertEquals(this.EXPECTED_EXPORTED_GENERATION, 
				this.sps.getExportedGeneration(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getExportedGeneration(Integer year)
	 */
	@Test
	public void testGetExportedGenerationWithYearParameter() {
		final Integer YEAR = 8;
		assertEquals(this.EXPECTED_EXPORTED_GENERATION_YEAR_8, 
				this.sps.getExportedGeneration(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getDailySavings()
	 */
	@Test
	public void testGetDailySavings() {
		assertEquals(this.EXPECTED_DAILY_SAVINGS, 
				this.sps.getDailySavings(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getDailySavings(Integer year)
	 */
	@Test
	public void testGetDailySavingsWithYearParameter() {
		final Integer YEAR = 8;
		assertEquals(this.EXPECTED_DAILY_SAVINGS_YEAR_8, 
				this.sps.getDailySavings(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getAnnualSolarGeneration()
	 */
	@Test
	public void testGetAnnualSolarGeneration() {
		assertEquals(this.EXPECTED_ANNUAL_SOLAR_GENERATION, 
				this.sps.getAnnualSolarGeneration(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getAnnualSolarGeneration(Integer year)
	 */
	@Test
	public void testGetAnnualSolarGenerationWithYearParameter() {
		final Integer YEAR = 8;
		assertEquals(this.EXPECTED_ANNUAL_SOLAR_GENERATION_YEAR_8, 
				this.sps.getAnnualSolarGeneration(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getAnnualSavings()
	 */
	@Test
	public void testGetAnnualSavings() {
		assertEquals(this.EXPECTED_ANNUAL_SAVINGS, 
				this.sps.getAnnualSavings(),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getAnnualSavings(Integer year)
	 */
	@Test
	public void testGetAnnualSavingsWithYearParameter() {
		final Integer YEAR = 8;
		assertEquals(this.EXPECTED_ANNUAL_SAVINGS_YEAR_8, 
				this.sps.getAnnualSavings(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for Double getCumulativeAnnualSavings(Integer year)
	 */
	@Test
	public void testGetCumulativeAnnualSavings() {
		final Integer YEAR = 3;
		assertEquals(this.EXPECTED_CUMULATIVE_ANNUAL_SAVINGS_YEAR_3, 
				this.sps.getCumulativeAnnualSavings(YEAR),
				this.EPSILON);
	}
	
	/**
	 * Test method for String getFutureAnnulSolarGenerationForChartInput()
	 * @throws SolarPowerSystemException 
	 */
	@Test
	public void testGetFutureAnnulSolarGenerationForChartInput() throws SolarPowerSystemException {
		final Integer YEAR = 3;
		this.sps.setPanelLifespan(YEAR);
		assertEquals(this.EXPECTED_FUTURE_ANNUAL_SOLAR_GENERATION_FOR_CHART_INPUT, 
				this.sps.getFutureAnnualSolarGenerationForChartInput());
	}
	
	/**
	 * Test method for String getFutureAnnualSavingsForChartInput()
	 * @throws SolarPowerSystemException 
	 */
	@Test
	public void testGetFutureAnnualSavingsForChartInput() throws SolarPowerSystemException {
		final Integer YEAR = 3;
		this.sps.setPanelLifespan(YEAR);
		assertEquals(this.EXPECTED_FUTURE_ANNUAL_SAVINGS_FOR_CHART_INPUT, 
				this.sps.getFutureAnnualSavingsForChartInput());
	}
	
	/**
	 * Test method for String getReturnOnInvestmentForChartInput()
	 * @throws SolarPowerSystemException 
	 */
	@Test
	public void testGetReturnOnInvestmentForChartInput() throws SolarPowerSystemException {
		final Integer YEAR = 3;
		this.sps.setPanelLifespan(YEAR);
		assertEquals(this.EXPECTED_RETURN_ON_INVESTMENT_FOR_CHART_INPUT, 
				this.sps.getReturnOnInvestmentForChartInput());
	}

}
