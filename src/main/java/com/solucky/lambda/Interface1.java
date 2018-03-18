package com.solucky.lambda;

import static java.lang.Math.sqrt;

/**
 * Created by xiechunlu on 2018-03-18 上午11:27
 */

public class Interface1 {

    interface Formula {
        double calculate(int a);

        /**
         * 默认接口实现
         *
         * @param a
         * @return
         */
        default double sqrt(int a) {
            return java.lang.Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula1.sqrt(-23);
        Formula.positive(-4);
        formula1.sqrt(1);

//        lambda方式实现接口
        Formula formula2 = (a) -> sqrt(a * 100);
    }


}
