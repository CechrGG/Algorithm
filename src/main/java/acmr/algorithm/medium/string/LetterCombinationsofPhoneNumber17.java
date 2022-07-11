package acmr.algorithm.medium.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/11
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsofPhoneNumber17 {

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        backTrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    /**
     * 深度优先  回溯
     * @param combinations
     * @param phoneMap
     * @param digits
     * @param index
     * @param comb
     */
    public static void backTrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder comb) {
        if(index == digits.length()) {
            combinations.add(comb.toString());
        } else {
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            for(int i = 0; i < s.length(); i++) {
                comb.append(s.charAt(i));
                backTrack(combinations, phoneMap, digits, index + 1, comb);
                comb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
