package challenge.periodictable;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.splurth.table.ChemicalElement;
import com.splurth.table.util.DefaultSymbolValiditor;
import com.splurth.table.util.SymbolValiditor;

public class SymbolValidityTestCase {

	private SymbolValiditor defaultSymbolValidator;

	@Before
	public void setUp() throws Exception {
		defaultSymbolValidator = new DefaultSymbolValiditor();
	}

	@After
	public void tearDown() throws Exception {
		defaultSymbolValidator = null;
	}

	@Test
	public void testPeriodicTableForElementsWithValidSymbols() {
		assertTrue(defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Spenglerium", "Ee")));
	}

	@Test
	public void testZeddemoriumForZr() {
		assertTrue(defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Zeddemorium", "Zr")));
	}

	@Test
	public void testVenkmineForKn() {
		assertTrue(defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Venkmine", "Kn")));
	}

	@Test
	public void testStantzonForZt() {
		assertTrue(!defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Stantzon", "Zt")));
	}

	@Test
	public void testMelintzumForNn() {
		assertTrue(!defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Melintzum", "Nn")));
	}

	@Test
	public void testTulliumForTy() {
		assertTrue(!defaultSymbolValidator.doesElementHaveAValidSymbol(new ChemicalElement("Tullium", "Ty")));
	}
}
