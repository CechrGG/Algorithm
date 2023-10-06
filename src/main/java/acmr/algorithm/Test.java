package acmr.algorithm;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author guoguo
 * @version 1.0.0
 * @date 2023/9/20
 * @description
 */
public class Test {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int total = in.nextInt();
        if(total <= 0 || total > 1000) {
            System.out.println("error");
        }
        BigDecimal origin = new BigDecimal("0");
        BigDecimal discount = new BigDecimal("0");

        for(int i = 0; i < total; i++) {
            BigDecimal next = in.nextBigDecimal();
            BigDecimal nextDiscount = in.nextBigDecimal();
            if(nextDiscount.compareTo(next) > 0 ) {
                System.out.println("error");
            }
            origin = origin.add(next);
            System.out.println(origin);
            discount = discount.add(nextDiscount);
            System.out.println(discount);
        }

    }
}
