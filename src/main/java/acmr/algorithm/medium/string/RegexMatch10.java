package acmr.algorithm.medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/5
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RegexMatch10 {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Deprecated
    public static boolean isMatchErr(String s, String p) {
        if(Objects.equals(p, ".*")) {
            return true;
        }
        char star = '*', point = '.';
        if(p.indexOf(star) == -1 && p.indexOf(point) == -1) {
            return Objects.equals(s, p);
        }
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == point) {
                if(i < p.length() - 1) {
                    char cNext = p.charAt(i + 1);
                    if(cNext != star) {
                        return s.substring(0, i).equals(p.substring(0, i)) &&
                                i < s.length() - 1 && isMatch(s.substring(i + 1), p.substring(i + 1));
                    }
                    if(i < p.length() - 2) {
                        /**
                         * .*的出现后面无法再递归了，因为不确定要取多长
                         */
                    }
                }
                return s.length() == 1;
            }
            if(c == star) {
                char cPre = p.charAt(i - 1);
                if(i > 1) {
                    return s.substring(0, i - 1).equals(p.substring(0, i - 1)) &&
                            isMatch(s.substring(i - 1), p.substring(i - 1));
                }
                for(int j = 0; j < s.length(); j++) {
                    char cj = s.charAt(j);
                    if(cj != cPre) {
                        return i < p.length() - 1 && isMatch(s.substring(j), p.substring(i + 1));
                    }
                }
                if(i < p.length() - 1) {
                    String pNext = p.substring(i + 1);
                    int countStar = 1;
                    for(int k = 0; k < pNext.length(); k ++) {
                        char ck = pNext.charAt(k);
                        if(ck != cPre && ck != star && ck != point) {
                            if(k < pNext.length() - 1) {
                                char ckN = pNext.charAt(k + 1);
                                if(ckN != star) {
                                    return false;
                                }
                                countStar++;
                                k++;
                                continue;
                            } else {
                                return false;
                            }
                        }
                        if(ck == star) {
                            countStar ++;
                        }
                    }
                    return s.length() >= p.length() - 2 * countStar;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*c*a"));
        System.out.println(isMatch("ab", ".*.."));
        System.out.println(isMatch("bbbba",".*a*a"));
        System.out.println(isMatch("aaa", "a*aaaa*"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "a*b"));
        System.out.println(isMatch("aaa", "a"));
        System.out.println(isMatch("aaa", ".*"));
        System.out.println(isMatch("mississippi","mis*is*p*."));
        System.out.println(isMatch("mississippi","mis*is*p*."));
    }
}
