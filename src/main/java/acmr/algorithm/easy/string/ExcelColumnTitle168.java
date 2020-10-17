/**
 * 
 */
package acmr.algorithm.easy.string;

/**
 * @author guoguo
 * @date 2020年10月17日
 * @Description ExcelColumnTitle168
 * 
 * 168 给定一个正整数，返回它在 Excel 表中相对应的列名称。

	例如，
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	    ...
	示例 1:
	
	输入: 1
	输出: "A"
	示例 2:
	
	输入: 28
	输出: "AB"
	示例 3:
	
	输入: 701
	输出: "ZY"
	
	171.给定一个Excel表格中的列名称，返回其相应的列序号。

	例如，
	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
	    ...
	示例 1:
	
	输入: "A"
	输出: 1
	示例 2:
	
	输入: "AB"
	输出: 28
	示例 3:
	
	输入: "ZY"
	输出: 701
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/excel-sheet-column-title
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExcelColumnTitle168 {
	
    public static String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n > 0) {
    		sb.insert(0, (char)((n - 1) % 26 + 'A'));
    		n = (n - 1)/26;
    	}
    	return sb.toString();
    }
    
    public static int titleToNumber(String s) {
    	int ret = 0;
    	int carry = 1;
    	for(int i = s.length() - 1; i >= 0; i--) {
    		ret += carry * (s.charAt(i) - 'A' + 1);
    		carry *= 26;
    	}
    	return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ExcelColumnTitle168.convertToTitle(1));
		System.out.println(ExcelColumnTitle168.convertToTitle(8));
		System.out.println(ExcelColumnTitle168.convertToTitle(26));
		System.out.println(ExcelColumnTitle168.convertToTitle(27));
		System.out.println(ExcelColumnTitle168.convertToTitle(701));
		System.out.println(ExcelColumnTitle168.titleToNumber("A"));
		System.out.println(ExcelColumnTitle168.titleToNumber("Z"));
		System.out.println(ExcelColumnTitle168.titleToNumber("AB"));
		System.out.println(ExcelColumnTitle168.titleToNumber("ZY"));
	}

}
