package com.splurth.table;

import static org.junit.Assert.assertEquals;

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

}
