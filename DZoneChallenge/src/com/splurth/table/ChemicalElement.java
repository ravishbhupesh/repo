/**
 * 
 */
package com.splurth.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.splurth.table.util.DefaultSymbolValiditor;
import com.splurth.table.util.SymbolValiditor;

/**
 * @author RavishB
 * 
 *         This class represents an element from the Periodic Table.
 *
 */
public class ChemicalElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -335041580744259112L;
	/**
	 * Name of the Chemical Element
	 */
	private String elementName;
	/**
	 * Symbolic representation of the element.
	 */
	private String symbol;
	private List<String> symbols = new ArrayList<String>();
	SymbolValiditor defaultSymbolValiditor = new DefaultSymbolValiditor();

	public ChemicalElement(String elementName, String symbol) {
		this.elementName = elementName;
		this.symbol = symbol;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		sb.append("Name   : " + this.elementName);
		sb.append(", ");
		sb.append("Symbol : " + this.symbol);
		sb.append(" ]");
		return sb.toString();
	}

	public List<String> getSymbols() {
		return symbols;
	}

	public void addSymbolToList(String symbol) {
		ChemicalElement ce = new ChemicalElement(this.elementName, symbol);
		if (defaultSymbolValiditor.doesElementHaveAValidSymbol(ce)) {
			this.symbols.add(symbol);
		} else {
			System.out.println("Invalid symbol " + symbol + " for element " + ce.toString());
		}
	}
}
