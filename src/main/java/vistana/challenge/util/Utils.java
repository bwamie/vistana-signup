package vistana.challenge.util;

import java.util.Random;

public class Utils {
	
	public static int getRndomNumberInRange(int start, int end) {
		Random rn = new Random();
		int num = rn.nextInt(end) + start;
		return num;
	}

}
