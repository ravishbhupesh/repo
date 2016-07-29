package challenge.periodictable;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PeriodicTableTestCase {

	private PeriodicTable pTable;

	@Before
	public void setUp() throws Exception {
		pTable = new PeriodicTable();
	}

	@After
	public void tearDown() throws Exception {
		pTable = null;
	}

	@Test
	public void testSpengleriumForEe() {
		assertTrue(pTable.isValidSymbolForElement("Spenglerium", "Ee"));
	}

	@Test
	public void testZeddemoriumForZr() {
		assertTrue(pTable.isValidSymbolForElement("Zeddemorium", "Zr"));
	}

	@Test
	public void testVenkmineForKn() {
		assertTrue(pTable.isValidSymbolForElement("Venkmine", "Kn"));
	}

	@Test
	public void testStantzonForZt() {
		assertTrue(!pTable.isValidSymbolForElement("Stantzon", "Zt"));
	}

	@Test
	public void testMelintzumForNn() {
		assertTrue(!pTable.isValidSymbolForElement("Melintzum", "Nn"));
	}

	@Test
	public void testTulliumForTy() {
		assertTrue(!pTable.isValidSymbolForElement("Tullium", "Ty"));
	}

}
