package nssc.shared;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

public class InverterTest {
	private Inverter inverter;
	
	private final Double INVERTER_EFFICIENCY = 0.9;
	
	
	private BankOfPanels bank;
	
	private final Double SYSTEM_SIZE = 5.0;
	private final Double PERCENTAGE_ON_NORTH_ROOF = 0.4;
	private final Double PERCENTAGE_ON_WEST_ROOF = 0.6;
	private final Double EFFICIENCY_LOSS_NORTH_ROOF = 0.05;
	private final Double EFFICIENCY_LOSS_WEST_ROOF = 0.15;
	private final Double PANEL_EFFICIENCY = 0.95;
	private final Double PANEL_AGE_EFFICIENCY_LOSS = 0.03;
	
	private final String EXPECTED_INVERTER_OUTPUT = "3.8";
	private final String DecFormat = "#.##";	
	
	@Before
	public void setUp() throws SolarPowerSystemException {
		this.inverter = new Inverter();
		this.inverter.setInverterEfficiency(INVERTER_EFFICIENCY);
		
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
  	* test setEfficiencyLossNorthRoof(Double input)
  	*  
  	* 1. valid input
  	* 2. 0
	* 3. negative input
	* 4. greater than 1 
	*/	
	@Test
	public void testSetInverterEfficiency() throws SolarPowerSystemException {
		this.inverter.setInverterEfficiency(0.8);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetInverterEfficiencyWithZero() 
			throws SolarPowerSystemException {
		this.inverter.setInverterEfficiency(0.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetInverterEfficiencyWithNegativeInput() 
			throws SolarPowerSystemException {
		this.inverter.setInverterEfficiency(-1.0);
	}
	
	@Test (expected = SolarPowerSystemException.class)
	public void testSetInverterEfficiencyWithGreaterThanOneInput() 
			throws SolarPowerSystemException {
		this.inverter.setInverterEfficiency(1.1);
	}
	
	/**
	* test getInverterEfficiency()
	*/
	@Test
	public void testGetSystemSize() {
		assertEquals(this.INVERTER_EFFICIENCY, this.inverter.getInverterEfficiency());
	}
	
	/**
	* test getOutput(BankOfPanels b)
	*/
	@Test
	public void testGetOutput() {
		assertEquals(this.EXPECTED_INVERTER_OUTPUT, 
				new DecimalFormat(this.DecFormat).format(this.inverter.getOutput(bank)));
	}

}
