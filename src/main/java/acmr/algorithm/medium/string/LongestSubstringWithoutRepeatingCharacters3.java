package acmr.algorithm.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/21
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }

        int length = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            Set<Character> charSet = new HashSet<>();
            charSet.add(c);
            for(int j = i + 1; j < s.length(); j++) {
                char c1 = s.charAt(j);
                if (!charSet.contains(c1)) {
                    charSet.add(c1);
                } else {
                    break;
                }
            }
            length = Math.max(length, charSet.size());
        }
        return length;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }

        int length = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charMap.containsKey(c)) {
                left = Math.max(left, charMap.get(c) + 1);
            }
            charMap.put(c, i);
            length = Math.max(length, i - left + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabca"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("abcabca"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("abba"));
    }
}
