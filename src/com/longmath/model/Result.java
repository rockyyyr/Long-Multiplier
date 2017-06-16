package com.longmath.model;

import java.math.BigInteger;
import java.text.NumberFormat;

public class Result {

	private BigInteger[] table;
	private BigInteger a;
	private BigInteger b;
	private BigInteger total;

	public Result(BigInteger[] table, String a, String b) {
		this.table = table;
		this.a = new BigInteger(a);
		this.b = new BigInteger(b);
		this.total = this.a.multiply(this.b);
	}

	public BigInteger[] getTable() {
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
