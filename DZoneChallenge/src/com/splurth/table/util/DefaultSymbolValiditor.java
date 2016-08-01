/**
 * 
 */
package com.splurth.table.util;

import com.splurth.table.ChemicalElement;

/**
 * @author RavishB
 * 
 *         A Default implementation for validity of {@link ChemicalElement}
 *         Symbol validity.
 *
 */
public class DefaultSymbolValiditor implements SymbolValiditor {

	public boolean doesElementHaveAValidSymbol(ChemicalElement element) {

		String elementName = element.getElementName();
		String symbol = element.getSymbol();

		// 1. All chemical symbols must be exactly two letters
		// Element name should not be null or of length 0
		if (symbol == null || (symbol != null && symbol.length() != 2)
				|| (elementName != null && elementName.length() < 1)) {
			return false;
		}

		char smblFrstChar = symbol.charAt(0);
		char smblScndChar = symbol.charAt(1);

		int idxSmblFrstChar = elementName
				.indexOf((Character.isUpperCase(smblFrstChar) && elementName.charAt(0) != smblFrstChar)
						? Character.toLowerCase(smblFrstChar) : smblFrstChar);
		int idxSmblScndChar = 0;
		idxSmblScndChar = elementName.lastIndexOf(smblScndChar);

		// 2. Both letters in the symbol must appear in the element name
		if ((idxSmblFrstChar == -1) || (idxSmblScndChar == -1)) {
			return false;
		}
		// 3. The two letters must appear in order in the element name.
		if (!(idxSmblFrstChar < idxSmblScndChar)) {
			return false;
		}
		// 4. If the two letters in the symbol are the same, it must appear
		// twice in the element name.
		if ((symbol.charAt(0) == symbol.charAt(1)) && (idxSmblFrstChar == idxSmblScndChar)) {
			return false;
		}
		return true;
	}
}
