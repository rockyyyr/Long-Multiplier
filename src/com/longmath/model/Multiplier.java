
package com.longmath.model;

import java.math.BigInteger;

public class Multiplier {

	public static Result longMultiply(String a, String num2) {
		String[] b = stringToStringArray(num2);
		BigInteger[] steps = new BigInteger[b.length];

		for (int i = b.length - 1; i >= 0; i--) {
			int index = (b.length - 1) - i;

			BigInteger multiple = new BigInteger(String.valueOf((long) (Integer.valueOf(b[i]) * Math.pow(10, index))));
			BigInteger multiple2 = new BigInteger(a);

			steps[index] = multiple.multiply(multiple2);
		}
		return new Result(steps, a, num2);
	}

	private static String[] stringToStringArray(String string) {
		return string.split("");
	}

}
