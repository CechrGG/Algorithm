package acmr.algorithm.medium.string;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/29
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigZagConversion6 {

    public static String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder cvs = new StringBuilder();
        int step = 2 * numRows - 2;//步长
        int len = (s.length() - 1) / step;//列循环次数
        for(int row = 0;row < numRows; row++) {
            for (int i = 0; i <= len; i++) {
                int start = i * step + row;//起始字符
                if(start < s.length()) {
                    cvs.append(s.charAt(start));
                    if(row != 0 && row != numRows - 1) {
                        int next = start + step - row * 2;//部分中间字符
                        if(next < s.length()) {
                            cvs.append(s.charAt(next));
                        }
                    }
                }
            }
        }
        return cvs.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("ABCD", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
