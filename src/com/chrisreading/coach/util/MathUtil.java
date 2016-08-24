package com.chrisreading.coach.util;

/**
 * Utility class for handling all
 * math in app
 */
public class MathUtil {

	/**
	 * Calculates the kd ratio (K+A) / Max(1,D)
	 * @param k kills
	 * @param d deaths
	 * @param a assists
	 * @return Solved kd
	 */
	public static double calculateKD(int k, int d, int a) {
		return (k + a) / Math.max(1, d);
	}
	
}
