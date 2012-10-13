package nssc.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankOfPanelsTest {
	private BankOfPanels bank;
	
	private final Double SYSTEM_SIZE = 5.0;
	private final Double PERCENTAGE_ON_NORTH_ROOF = 0.4;
	private final Double PERCENTAGE_ON_WEST_ROOF = 0.6;
	private final Double EFFICIENCY_LOSS_NORTH_ROOF = 0.05;
	private final Double EFFICIENCY_LOSS_WEST_ROOF = 0.15;
	private final Double PANEL_EFFICIENCY = 0.95;
	private final Double PANEL_AGE_EFFICIENCY_LOSS = 0.03;
	
	private final Double EXPECTED_OUTPUT_YEAR_1 = 4.228;
	private final Double EXPECTED_OUTPUT_YEAR_4 = 3.827;
	
	private final Double EPSILON = 0.001;
	
	
	@Before@Test
	public void setUp() throws SolarPowerSystemException {
		this.bank = new BankOfPanels();
		this.bank.setSystemSize(SYSTEM_SIZE);
		this.bank.setPercentagesOnOrientations(PERCENTAGE_ON_NORTH_ROOF, 
				PERCENTAGE_ON_WEST_ROOF);
		this.bank.setEfficiencyLossNorthRoof(EFFICIENCY_LOSS_NORTH_ROOF);
		this.bank.setEfficiencyLossWestRoof(EFFICIENCY_LOSS_WEST_ROOF);
		this.bank.setPanelEfficiency(PANEL_EFFICIENCY);		
		this.bank.setPanelAgeEfficiencyLoss(PANEL_AGE_EFFICIENCY_LOSS);
	}
	
   /**
	* test setSystemSize(Double input)
	*  
	* 1. valid input
	* 2. 0
	* 3. negative input
	*/
	@Test
	public void testSetSystemSize() throws SolarPowerSystemException {
		this.bank.setSystemSize(4.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetSystemSizeWithZero() throws SolarPowerSystemException {
		this.bank.setSystemSize(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetSystemSizeWithNegativeInput() throws SolarPowerSystemException {
		this.bank.setSystemSize(-4.0);
	}
	
   /**
	* test setPercentagesOnOrientations(Double north, Double west)
	*  
	* 1. both valid input and sum is 1
	* 2. negative + valid
	* 3. valid + negative
	* 4. greater than 1 + valid
	* 5. valid + greater than 1
	* 6. 0 + 1
	* 7. 1 + 0
	* 8. both valid but sum is not 1
	* 9. sum is 1 but not valid 
	*/
	@Test
	public void testPercentagesOnOrientations() throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(0.7, 0.3);
	}
	
	@Test
	public void testPercentagesOnOrientationsWithZeroAndOne() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(0.0, 1.0);
	}

	@Test
	public void testPercentagesOnOrientationsWithOneAndZero() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(1.0, 0.0);
	}

	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsWithNegativeAndValid() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(-0.7, 0.3);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsWithValidAndNegative() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(0.7, -0.3);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsWithGreaterThanOneAndValid() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(1.7, 0.3);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsValidAndGreaterThanOne() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(0.7, 1.3);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsWithBothValidButSumIsNotOne() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(0.3, 0.3);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testPercentagesOnOrientationsWithSumIsOneButNotValid() 
			throws SolarPowerSystemException {
		this.bank.setPercentagesOnOrientations(-11.0, 12.0);
	}
	
   /**
	* test setEfficiencyLossNorthRoof(Double input)
	*  
	* 1. valid input
	* 2. 0
	* 3. negative input
	* 4. greater than 1 
	*/
	@Test
	public void testSetEfficiencyLossNorthRoof() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossNorthRoof(0.1);
	}
	
	@Test
	public void testSetEfficiencyLossNorthRoofWithZero() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossNorthRoof(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetEfficiencyLossNorthRoofWithNegativeInput() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossNorthRoof(-0.1);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetEfficiencyLossNorthRoofWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossNorthRoof(1.1);
	}
	
   /**
	* test setEfficiencyLossWestRoof(Double input)
	*  
	* 1. valid input
	* 2. 0
	* 3. negative input
	* 4. greater than 1 
	*/
	@Test
	public void testSetEfficiencyLossWestRoof() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossWestRoof(0.1);
	}
	
	@Test
	public void testSetEfficiencyLossWestRoofWithZero() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossWestRoof(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetEfficiencyLossWestRoofWithNegativeInput() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossWestRoof(-0.1);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetEfficiencyLossWestRoofWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.bank.setEfficiencyLossWestRoof(1.1);
	}
	
   /**
	* test setPanelEfficiency(Double input)
	*  
	* 1. valid input
	* 2. 0
	* 3. negative input
	* 4. greater than 1 
	*/
	@Test
	public void testSetPanelEfficiency() 
			throws SolarPowerSystemException {
		this.bank.setPanelEfficiency(0.1);
	}
	
	@Test
	public void testSetPanelEfficiencyWithZero() 
			throws SolarPowerSystemException {
		this.bank.setPanelEfficiency(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetPanelEfficiencyWithNegativeInput() 
			throws SolarPowerSystemException {
		this.bank.setPanelEfficiency(-0.1);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetPanelEfficiencyWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.bank.setPanelEfficiency(1.1);
	}
	
   /**
	* test setPanelAgeEfficiencyLoss(Double input)
	*  
	* 1. valid input
	* 2. 0
	* 3. negative input
	* 4. greater than 1 
	*/
	@Test
	public void testSetPanelAgeEfficiencyLoss() 
			throws SolarPowerSystemException {
		this.bank.setPanelAgeEfficiencyLoss(0.1);
	}
	
	@Test
	public void testSetPanelAgeEfficiencyLossWithZero() 
			throws SolarPowerSystemException {
		this.bank.setPanelAgeEfficiencyLoss(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetPanelAgeEfficiencyLossWithNegativeInput() 
			throws SolarPowerSystemException {
		this.bank.setPanelAgeEfficiencyLoss(-0.1);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetPanelAgeEfficiencyLossWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.bank.setPanelAgeEfficiencyLoss(1.1);
	}   
	
   /**
	* test isValidPercentage (Double input)
	*  
	* 1. between 0 and 1
	* 2. greater than 1
	* 3. less than 0
	* 4. 1
	* 5. 0
	*/
	@Test
	public void testIsvalidPercentage() {
		assertEquals(true, BankOfPanels.isValidPercentage(0.5));
	}
	
	@Test
	public void testIsvalidPercentageWithGeaterThanOneInput() {
		assertEquals(false, BankOfPanels.isValidPercentage(5.5));
	}
	
	@Test
	public void testIsvalidPercentageWithlessThanZeroInput() {
		assertEquals(false, BankOfPanels.isValidPercentage(-90.0));
	}
	
	@Test
	public void testIsvalidPercentageWithOne() {
		assertEquals(true, BankOfPanels.isValidPercentage(1.0));
	}
	
	@Test
	public void testIsvalidPercentageWithZero() {
		assertEquals(true, BankOfPanels.isValidPercentage(0.0));
	}
	
   /**
	* test getSystemSize()
	*/
	@Test
	public void testGetSystemSize() {
		assertEquals(SYSTEM_SIZE, this.bank.getSystemSize());
	}
	
   /**
	* test getPanelEfficiency()
	*/
	@Test
	public void testGetPanelEfficiency() {
		assertEquals(PANEL_EFFICIENCY, this.bank.getPanelEfficiency());
	}
	
   /**
    * test getPanelEfficiency(Integer year)
    */
	@Test
	public void testGetPanelEfficiencyWithYearParameter() {
		final Integer YEAR = 4;
		assertEquals((Double)(PANEL_EFFICIENCY - PANEL_AGE_EFFICIENCY_LOSS * (YEAR - 1)), 
				this.bank.getPanelEfficiency(YEAR));
	}

   /**
	* test getPanelAgeEfficiencyLoss()
	*/
	@Test
	public void testGetPanelAgeEfficiencyLoss() {
		assertEquals(PANEL_AGE_EFFICIENCY_LOSS, this.bank.getPanelAgeEfficiencyLoss());
	}
	
   /**
	* test getEfficiencyLossNorthRoof()
	*/
	@Test
	public void testGetEfficiencyLossNorthRoof() {
		assertEquals(EFFICIENCY_LOSS_NORTH_ROOF, this.bank.getEfficiencyLossNorthRoof());
	}
	
   /**
	* test getEfficiencyLossWestRoof()
	*/
	@Test
	public void testGetEfficiencyLossWestRoof() {
		assertEquals(EFFICIENCY_LOSS_WEST_ROOF, this.bank.getEfficiencyLossWestRoof());
	}
	
   /**
	* test getPercentageOnNorthRoof()
	*/
	@Test
	public void testGetPercentageOnNorthRoof() {
		assertEquals(PERCENTAGE_ON_NORTH_ROOF, this.bank.getPercentageOnNorthRoof());
	}
	
   /**
	* test getPercentageOnNorthRoof()
	*/
	@Test
	public void testGetPercentageOnWestRoof() {
		assertEquals(PERCENTAGE_ON_WEST_ROOF, this.bank.getPercentageOnWestRoof());
	}
	
   /**
	* test getOutput()
	*/
	@Test
	public void testGetOutput() {		 
		assertEquals(EXPECTED_OUTPUT_YEAR_1, this.bank.getOutput(), EPSILON);		
	}
	
	/**
	* test getOutput(Integer year)
	*/
	@Test
	public void testGetOutputWithYearParameter() {
		final Integer YEAR = 4;		
		assertEquals(EXPECTED_OUTPUT_YEAR_4, this.bank.getOutput(YEAR), EPSILON);
	}
	
}
