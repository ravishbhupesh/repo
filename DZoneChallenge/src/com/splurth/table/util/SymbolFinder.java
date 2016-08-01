/**
 * 
 */
package com.splurth.table.util;

import java.util.Set;

import com.splurth.table.ChemicalElement;

/**
 * @author RavishB
 *
 */
public interface SymbolFinder {

	Set<String> findValidSymbolsForElement(ChemicalElement element);
}
