/**
 * 
 */
package acmr.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年9月21日
 * @description PascalTriangle118
 * 
 * 	给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
	在杨辉三角中，每个数是它左上方和右上方的数的和。
	
	示例:
	
	输入: 5
	输出:
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/pascals-triangle
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PascalTriangle118 {

    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	if(numRows <= 0) {
    		return triangle;
    	}
    	for(int i = 0; i < numRows; i++) {
    		List<Integer> row = new ArrayList<Integer>();
    		if(i == 0) {
    			row.add(1);
    			triangle.add(row);
    		} else {
    			row.add(1);
    			List<Integer> rowPre = triangle.get(i - 1);
    			for(int j = 0; j < rowPre.size() - 1; j++) {
    				row.add(rowPre.get(j) + rowPre.get(j+1));
    			}
    			row.add(1);
    			triangle.add(row);
    		}
    	}
    	return triangle;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.printArray2(PascalTriangle118.generate(10));
	}

}
