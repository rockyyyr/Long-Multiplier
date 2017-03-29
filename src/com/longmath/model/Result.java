package com.longmath.model;

import java.text.NumberFormat;

public class Result {

	private long[] table;
	private long a;
	private long b;
	private long total;

	/**
	 * @param table
	 * @param a
	 * @param b
	 */
	public Result(long[] table, long a, long b) {
		this.table = table;
		this.a = a;
		this.b = b;
		this.total = a * b;
	}

	public long[] getTable() {
		return table;
	}

	public String getA() {
		return NumberFormat.getInstance().format(a);
	}

	public String getB() {
		return NumberFormat.getInstance().format(b);
	}

	public String getTotal() {
		return NumberFormat.getInstance().format(total);
	}

	public int size() {
		return table.length;
	}

	private long getTotalFromTable(long[] table) {
		long total = 0;
		for (int i = table.length - 1; i >= 0; i--)
			total += table[i];

		return total;
	}

}
