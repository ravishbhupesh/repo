/**
 * 
 */
package com.splurth.table;

import java.io.Serializable;

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
	private String elementName;
	private String symbol;

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
}
