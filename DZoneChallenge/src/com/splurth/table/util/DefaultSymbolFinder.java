/**
 * 
 */
package com.splurth.table.util;

import java.util.LinkedHashSet;
import java.util.Set;

import com.splurth.table.ChemicalElement;

/**
 * @author RavishB
 *
 */
public class DefaultSymbolFinder implements SymbolFinder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.splurth.table.util.SymbolFinder#findValidSymbolsForElement(com.
	 * splurth.table.ChemicalElement)
	 */
	public Set<String> findValidSymbolsForElement(ChemicalElement element) {
		Set<String> symbols = new LinkedHashSet<>();
		String elementName = element.getElementName();
		for (int i = 0; i < elementName.length(); i++) {
			for (int j = i + 1; j < elementName.length(); j++) {
				StringBuilder sb = new StringBuilder();
				if (!Character.isUpperCase(elementName.charAt(i))) {
					sb.append(new String("" + elementName.charAt(i)).toUpperCase());
				} else {
					sb.append(elementName.charAt(i));
				}
				sb.append(elementName.charAt(j));
				if (i == 0 && j == i)
					continue;
				if (!symbols.contains(sb.toString()))
					symbols.add(sb.toString());
			}
		}
		return symbols;
	}

	public static void main(String[] args) {
		SymbolFinder sf = new DefaultSymbolFinder();
		Set<String> symbols = sf.findValidSymbolsForElement(new ChemicalElement("Zuulon", null));
		System.out.println(symbols);
		System.out.println(symbols.size());
	}

}
