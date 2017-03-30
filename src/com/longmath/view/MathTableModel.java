
package com.longmath.view;

import java.math.BigInteger;
import java.text.NumberFormat;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MathTableModel implements TableModel {

	private static final String COLUMN_NAME = "Steps";

	private String[] table;

	public MathTableModel(BigInteger[] table) {
		this.table = formatTableArray(table);
	}

	private String[] formatTableArray(BigInteger[] table) {
		String[] temp = new String[table.length];
		for (int i = 0; i < table.length; i++) {
			temp[i] = NumberFormat.getInstance().format(table[i]);
		}
		return temp;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int arg0) {
		return COLUMN_NAME;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return table.length;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return table[arg0];
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener arg0) {
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
	}

}
