package acmr.algorithm.medium.math;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/26
 */
public class DivideTwoIntegers29 {

    public static int divide(int dividend, int divisor) throws Exception {
        if(divisor == 0) {
            throw new Exception("divisor is 0");
        }
        if(dividend == 0) {
            return 0;
        }
        if(divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE){
                return 1;
            } else {
                return 0;
            }
        }
        boolean min = false;
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == 1) {
                return Integer.MIN_VALUE;
            } else if(divisor == -1) {
                return Integer.MAX_VALUE;
            }
            dividend++;
            min = true;
        }

        int count = 0;
        boolean signed = false;
        if(dividend < 0 && divisor > 0) {
            signed = true;
            dividend = -dividend;
        }else if(dividend > 0 && divisor < 0) {
            signed = true;
            divisor = -divisor;
        }else if(dividend < 0) {
            dividend = -dividend;
            divisor = -divisor;
        }
        //减法超时了。。。
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }
        if(min && dividend + 1 >= divisor) {
            count++;
        }
        return signed ?  -count : count;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(1, 1));
//        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE, 2));
    }
}
