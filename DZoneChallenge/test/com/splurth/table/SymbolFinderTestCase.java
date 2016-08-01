package com.splurth.table;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.splurth.table.util.DefaultSymbolFinder;
import com.splurth.table.util.SymbolFinder;

public class SymbolFinderTestCase {

	SymbolFinder symbolFinder;

	@Before
	public void setUp() throws Exception {
		symbolFinder = new DefaultSymbolFinder();
	}

	@After
	public void tearDown() throws Exception {
		symbolFinder = null;
	}

	@Test
	public void testFindValidSymbolsForElement() {
		assertEquals(symbolFinder.findValidSymbolsForElement(new ChemicalElement("Zuulon", null)).size(), 11);
	}

	@Test
	public void testFirstAlphabeticSymbolGozerium() {
		Set<String> symbols = symbolFinder.findValidSymbolsForElement(new ChemicalElement("Gozerium", null));
		assertEquals(symbols.iterator().next(), "Ei");
	}

	@Test
	public void testFirstAlphabeticSymbolSlimyrine() {
		Set<String> symbols = symbolFinder.findValidSymbolsForElement(new ChemicalElement("Slimyrine", null));
		assertEquals(symbols.iterator().next(), "Ie");
	}

}
