/**
 * 
 */
package acmr.algorithm.easy.string;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description RomanToInt
 * 	罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
	
	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
	
	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/roman-to-integer
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RomanToInt {
	
    public static int romanToInt(String s) {
//    	Map<Character, Integer> map = new HashMap<Character, Integer>();
//    	map.put('I', 1);
//    	map.put('V', 5);
//    	map.put('X', 10);
//    	map.put('L', 50);
//    	map.put('C', 100);
//    	map.put('D', 500);
//    	map.put('M', 1000);
    	int ret = 0;
    	for(int i = 0; i < s.length(); i++) {
    		char chari = s.charAt(i);
    		if((chari == 'I' || chari == 'X' || chari == 'C') && i < s.length() - 1) {
    			char charNext = s.charAt(i + 1);
    			if(RomanToInt.getChar(charNext) > RomanToInt.getChar(chari)) {
    				ret += RomanToInt.getChar(charNext) - RomanToInt.getChar(chari);
    				i++;
    				continue;
    			}
    		}
    		ret += RomanToInt.getChar(chari);
    	}
    	return ret;
    }
    
    public static int getChar(char c) {
    	switch(c) {
    		case 'I': return 1;
    		case 'V': return 5;
    		case 'X': return 10;
    		case 'L': return 50;
    		case 'C': return 100;
    		case 'D': return 500;
    		case 'M': return 1000;
    		default : return 0;
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RomanToInt.romanToInt("III"));
		System.out.println(RomanToInt.romanToInt("IV"));
		System.out.println(RomanToInt.romanToInt("IX"));
		System.out.println(RomanToInt.romanToInt("LVIII"));
		System.out.println(RomanToInt.romanToInt("MCMXCIV"));
	}

}
