package nssc.shared;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldVerifierTest {

	
	private final String TEST_EMPTY_STRING = "";
	private final String TEST_NULL_STRING = null;
	private final String TEST_INVALID_STRING = "abc";
	private final String TEST_VALID_STRING = "10";
		
	@Test
	public void testIsValidDecimalWithEmptyInput() {
		assertEquals(false, FieldVerifier.isValidDecimal(TEST_EMPTY_STRING));
	}
	
	@Test
	public void testIsValidDecimalWithNullInput() {
		assertEquals(false, FieldVerifier.isValidDecimal(TEST_NULL_STRING));
	}
	
	@Test
	public void testIsValidDecimalWithInvalidInput() {
		assertEquals(false, FieldVerifier.isValidDecimal(TEST_INVALID_STRING));
	}
	
	@Test
	public void testIsValidDecimalWithValidInput() {
		assertEquals(true, FieldVerifier.isValidDecimal(TEST_VALID_STRING));
	}

}
