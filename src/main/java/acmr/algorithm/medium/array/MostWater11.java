package acmr.algorithm.medium.array;

import java.util.Random;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/20
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostWater11 {


    /**
     * 简单暴力
     * 数组过大时超时
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int maxVal = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                maxVal = Math.max(maxVal, (j - i) * min);
            }
        }
        return maxVal;
    }

    /**
     * 双指针优雅
     * 移动长板一定减小，因此移动短板刷新数据
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1, maxVal = 0;
        while (i < j) {
            maxVal = height[i] < height[j] ?
                    Math.max(maxVal, (j - i) * height[i++]) :
                    Math.max(maxVal, (j - i) * height[j--]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
//        int[] height = new int[]{1,1};
        int[] height = new int[80000];
        for(int i = 0; i < height.length; i++) {
            height[i] = new Random().nextInt(10000);
        }
        long l = System.currentTimeMillis();
        System.out.println(maxArea(height));
        System.out.println(System.currentTimeMillis() - l);
        long l2 = System.currentTimeMillis();
        System.out.println(maxArea2(height));
        System.out.println(System.currentTimeMillis() - l2);
    }
}
