/*
    Page 20, problem 1.1.
 */

import java.util.Arrays;

public class p1_1 {
    /*
        Simple solution, using division
     */
    private static long[] arrayProdsSimple(long[] list) {
        long[] prods = new long[list.length];
        long allProd = 1;

        for (long x : list) {
            allProd *= x;
        }

        for (int i = 0; i < list.length; i++) {
            prods[i] = allProd / list[i];
        }

        return prods;
    }

    /*
        Non-division solution.
     */
    private static long[] arrayProds(long[] list) {
        long[] prods = new long[list.length];
        long[] forward = new long[list.length];
        long[] backward = new long[list.length];
        int size = list.length;

        // Compute the partials
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                forward[i] = list[i];
                backward[size - 1] = list[size - 1];
            } else {
                forward[i] = list[i] * forward[i - 1];
                backward[size - i - 1] = list[size - i - 1] * backward[size - i];
            }
        }

        // Compute the products
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                prods[i] = backward[1];
            } else if (i == (size - 1)) {
                prods[i] = forward[i - 1];
            } else {
                prods[i] = forward[i - 1] * backward[i + 1];
            }
        }

        return prods;
    }

    public static void main(String[] args) {
        long[] list;

        if (args.length > 0) {
            list = new long[args.length];
            for (int i = 0; i < args.length; i++) {
                list[i] = Long.parseLong(args[i]);
            }
        } else {
            list = new long[]{1L, 2L, 3L, 4L, 5L};
        }

        System.out.println(Arrays.toString(arrayProdsSimple(list)));
        System.out.println(Arrays.toString(arrayProds(list)));
    }
}