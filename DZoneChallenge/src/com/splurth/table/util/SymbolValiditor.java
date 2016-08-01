/**
 * 
 */
package com.splurth.table.util;

import com.splurth.table.ChemicalElement;

/**
 * @author RavishB
 * 
 *         Interface to implement algorithms for checking the validity of the
 *         symbols for the {@link ChemicalElement}.
 *
 */
public interface SymbolValiditor {

	boolean doesElementHaveAValidSymbol(ChemicalElement element);
}
