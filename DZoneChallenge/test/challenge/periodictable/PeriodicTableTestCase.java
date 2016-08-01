package challenge.periodictable;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.splurth.table.ChemicalElement;
import com.splurth.table.util.PeriodicTableUtil;

public class PeriodicTableTestCase {

	private PeriodicTableUtil pTable;

	@Before
	public void setUp() throws Exception {
		pTable = new PeriodicTableUtil();
	}

	@After
	public void tearDown() throws Exception {
		pTable = null;
	}

	@Test
	public void testPeriodicTableForElementsWithValidSymbols() {
		assertTrue(pTable.doesElementHaveAValidSymbol(new ChemicalElement("Spenglerium", "Ee")));
	}

	@Test
	public void testZeddemoriumForZr() {
		assertTrue(pTable.doesElementHaveAValidSymbol(new ChemicalElement("Zeddemorium", "Zr")));
	}

	@Test
	public void testVenkmineForKn() {
		assertTrue(pTable.doesElementHaveAValidSymbol(new ChemicalElement("Venkmine", "Kn")));
	}

	@Test
	public void testStantzonForZt() {
		assertTrue(!pTable.doesElementHaveAValidSymbol(new ChemicalElement("Stantzon", "Zt")));
	}

	@Test
	public void testMelintzumForNn() {
		assertTrue(!pTable.doesElementHaveAValidSymbol(new ChemicalElement("Melintzum", "Nn")));
	}

	@Test
	public void testTulliumForTy() {
		assertTrue(!pTable.doesElementHaveAValidSymbol(new ChemicalElement("Tullium", "Ty")));
	}
}
