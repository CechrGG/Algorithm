package acmr.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	//直接
	public static int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
        	for(int j= i + 1; j < nums.length; j++) {
        		if(nums[i] + nums[j] == target) {
        			ret[0] = i;
        			ret[1] = j;
        			break;
        		}
        	}
        }
        return ret;
    }
	
	//空间换时间
	public static int[] twoSum2(int[] nums, int target) {
		int[] ret = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]) && map.get(nums[i]) != i) {
				ret[0] = i;
				ret[1] = map.get(nums[i]);
				break;
			}
		}
		return ret;
	}
	
	public static String toString(int[] ret) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ret.length - 1; i++) {
			sb.append(ret[i] + ",");
		}
		sb.append(ret[ret.length - 1]);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4,3,2,5};
		System.out.println(TwoSum.toString(TwoSum.twoSum(nums, 8)));
		System.out.println(TwoSum.toString(TwoSum.twoSum2(nums, 8)));
	}

}
