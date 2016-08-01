/**
 * 
 */
package com.splurth.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.splurth.table.util.PeriodicTableUtil;

/**
 * @author RavishB
 * 
 *         Simple POJO to represent a PeriodicTable.
 *
 */
public class PeriodicTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5009802797632750622L;
	private String tableName;
	private List<ChemicalElement> elements = new ArrayList<>();
	private List<ChemicalElement> invalidElements = new ArrayList<>();
	private final PeriodicTableUtil util = new PeriodicTableUtil();

	public PeriodicTable(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<ChemicalElement> getElements() {
		return elements;
	}

	/**
	 * Checks for validity of an {@link ChemicalElement} before adding it to the
	 * {@link PeriodicTable}.
	 * 
	 * Also keep a list of invalid elements which were supposedly added to the
	 * table.
	 * 
	 * @param element
	 */
	public void addNewElement(ChemicalElement element) {
		if (util.doesElementHaveAValidSymbol(element)) {
			this.elements.add(element);
		} else {
			this.invalidElements.add(element);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ Periodic Table - " + this.tableName + " ]");
		sb.append("\n");
		sb.append("[ Number of (Valid) Elements - " + this.elements.size() + " ]");
		sb.append("\n");
		for (ChemicalElement ce : elements) {
			sb.append(ce.toString());
			sb.append("\n");
		}
		sb.append("[ Number of (Invalid) Elements - " + this.invalidElements.size() + " ]");
		sb.append("\n");
		for (ChemicalElement ce : invalidElements) {
			sb.append(ce.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
