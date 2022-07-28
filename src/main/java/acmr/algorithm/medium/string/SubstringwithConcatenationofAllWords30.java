package acmr.algorithm.medium.string;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/27
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubstringwithConcatenationofAllWords30 {

    public static List<Integer> findSubstring(String s, String[] words) {        
        List<Integer> starts = new ArrayList<>();
        if(s == null || s.length() == 0 || words.length == 0 || words[0].length() == 0) {
            return starts;
        }
        int wordLen = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return findSubstring(s, wordCount, 0, wordLen);
    }

    public static List<Integer> findSubstring(String s, Map<String, Integer> wordCount, int base, int wordLen) {
        List<Integer> starts = new ArrayList<>();
        int start = s.length();
        Map<String, Integer> matchMap = new HashMap<>();
        for(String word : wordCount.keySet()) {
            start = Math.min(s.indexOf(word), start);
            matchMap.put(word, 0);
        }
        if(start >= 0 && start < s.length()) {
            boolean match = true;
            int next = start + wordLen;
            String tmp = s.substring(start, next);
            while(matchMap.containsKey(tmp)) {
                int count = matchMap.get(tmp);
                if(count == wordCount.get(tmp)) {
                    break;
                }
                matchMap.put(tmp, count + 1);
                if(next + wordLen <= s.length()) {
                    tmp = s.substring(next, next + wordLen);
                    next = next + wordLen;
                } else {
                    break;
                }
            }
            for (Map.Entry<String, Integer> entry : matchMap.entrySet()) {
                if (entry.getValue().intValue() != wordCount.get(entry.getKey()).intValue()) {
                    match = false;
                    break;
                }
            }
            if(match) {
                starts.add(base + start);
            }

            if(start + 1 < s.length()) {
                starts.addAll(findSubstring(s.substring(start + 1), wordCount, base + start + 1, wordLen));
            }
        }
        return starts;
    }


    public static void main(String[] args) {
//        String[] words = {"foo","bar"};
//        String[] words2 = {"word","good","best","word"};
//        String[] words3 = {"bar","foo","the"};
//        String[] words4 = {"word","good","best","good"};
        String[] words5 = {"aa","aa"};
//        System.out.println(findSubstring("barfoothefoobarman", words));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", words2));
//        System.out.println(findSubstring("barfoofoobarthefoobarman", words3));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", words4));
        System.out.println(findSubstring("aaaaaaaaaaaaaa", words5));
//        System.out.println(findSubstring("aaaa", words5));
    }
}
