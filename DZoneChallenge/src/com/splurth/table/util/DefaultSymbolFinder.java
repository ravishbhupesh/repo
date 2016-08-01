/**
 * 
 */
package com.splurth.table.util;

import java.util.Set;
import java.util.TreeSet;

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
		Set<String> symbols = new TreeSet<>();
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

}
