/*
    Page 22, problem 1.2.
 */

import java.util.Arrays;

public class p1_2 {
    public p1_2() {}

    private static int[] find_bounds(int[] arr) {
        int left = arr.length, right = 0;
        int max_seen = Integer.MIN_VALUE, min_seen = Integer.MAX_VALUE;

        // Get the right bound:
        for (int i = 0; i < arr.length; i++) {
            max_seen = Integer.max(max_seen, arr[i]);
            if (arr[i] < max_seen) {
                right = i;
            }
        }
        // Get the left bound:
        for (int i = arr.length - 1; i >= 0; i--) {
            min_seen = Integer.min(min_seen, arr[i]);
            if (arr[i] > min_seen) {
                left = i;
            }
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] list;

        if (args.length > 0) {
            list = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                list[i] = Integer.parseInt(args[i]);
            }
        } else {
            list = new int[]{3, 7, 5, 6, 9};
        }

        System.out.println(Arrays.toString(find_bounds(list)));
    }
}
