/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guohz
 * @date 2020年8月17日
 * @description FindFirstString
 * 
 * 	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	示例 1:
	
	输入: haystack = "hello", needle = "ll"
	输出: 2
	示例 2:
	
	输入: haystack = "aaaaa", needle = "bba"
	输出: -1
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/implement-strstr
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstString28 {
	
	//超时, 如果是较长字符串的话有大量重复，可参考KMP优化，
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null) {
			return -1;
		}
		if(needle.equals("")) {
			return 0;
		}
		for(int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				int j = 1;
				for(; j < needle.length(); j++) {
					if(i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
				}
				if(j == needle.length()) {
					return i;
				}
			}
		}
		return -1;
    }
	
	public static int strString(String haystack, String needle) {
		if(haystack == null || needle == null) {
			return -1;
		}
		if(needle.equals("")) {
			return 0;
		}
		for(int i = 0; i < haystack.length(); i++) {
			if(i + needle.length() > haystack.length()) {
				return -1;
			}
			if(haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
    }
	
	//查看源码
	public static int strStringDefault(String haystack, String needle) {
		return haystack.indexOf(needle);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindFirstString28.strStringDefault("afdaefa", "f"));
	}

}
