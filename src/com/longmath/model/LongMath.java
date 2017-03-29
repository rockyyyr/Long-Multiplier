
package com.longmath.model;

public class LongMath {

	public static Result longMultiply(long a, long num2) {
		long[] b = longToArrayOfDigits(num2);
		long[] steps = new long[b.length];

		for (int i = b.length - 1; i >= 0; i--) {
			int index = (b.length - 1) - i;
			long multiple = (long) (b[i] * Math.pow(10, index));

			steps[index] = multiple * a;
		}
		return new Result(steps, a, num2);
	}

	private static long[] longToArrayOfDigits(long num) {
		char[] number = String.valueOf(num).toCharArray();
		long[] result = new long[number.length];

		for (int i = 0; i < number.length; i++)
			result[i] = Long.parseLong(String.valueOf(number[i]));

		return result;
	}

}
