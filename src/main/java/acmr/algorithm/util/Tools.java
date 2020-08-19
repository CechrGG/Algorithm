/**
 * 
 */
package acmr.algorithm.util;

/**
 * @author guohz
 * @date 2020年8月19日
 * @description Tools
 */
public class Tools {
	
	public static String arrayToString(int[] ret) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ret.length - 1; i++) {
			sb.append(ret[i] + ",");
		}
		sb.append(ret[ret.length - 1]);
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
