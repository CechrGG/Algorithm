/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description CommonPrefix
 * 
 * 	编写一个函数来查找字符串数组中的最长公共前缀。

	如果不存在公共前缀，返回空字符串 ""。
	
	示例 1:
	
	输入: ["flower","flow","flight"]
	输出: "fl"
	示例 2:
	
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-common-prefix
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if(strs.length > 0)  {
			int length = strs[0].length();
			String min = strs[0];
			for(int i = 1; i < strs.length; i++) {
				if(length > strs[i].length()) {
					length = strs[i].length();
					min = strs[i];
				}
			}
			for(int i = 0; i < length; i++) {
				char chari = min.charAt(i);
				for(int j = 0; j < strs.length; j++) {
					char charj = strs[j].charAt(i);
					if(chari != charj) {
						return prefix;
					}
				}
				prefix += chari;
			}
		}
		return prefix;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CommonPrefix.longestCommonPrefix(new String[] {"abcd", "abc", "ab"}));
	}

}
