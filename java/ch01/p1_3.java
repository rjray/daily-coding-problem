/*
    Page 24, problem 1.3.
 */

import java.util.Arrays;

public class p1_3 {
    public p1_3() {}

    private static int max_subarray_sum(int[] arr) {
        int max_ending_here = 0, max_so_far = 0;

        for (int x : arr) {
            max_ending_here = Integer.max(x, max_ending_here + x);
            max_so_far = Integer.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    private static int min_subarray_sum(int[] arr) {
        int min_ending_here = 0, min_so_far = 0;

        for (int x : arr) {
            min_ending_here = Integer.min(x, min_ending_here + x);
            min_so_far = Integer.min(min_so_far, min_ending_here);
        }

        return min_so_far;
    }

    private static int maximum_circular_subarray(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        int wraparound = sum - min_subarray_sum(arr);

        return Integer.max(max_subarray_sum(arr), wraparound);
    }

    public static void main(String[] args) {
        int[] list = null;

        if (args.length > 0) {
            list = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                list[i] = Integer.parseInt(args[i]);
            }
        } else {
            System.out.println("Need numbers");
            System.exit(-1);
        }

        System.out.println("Max subarray sum = " + max_subarray_sum(list));
        System.out.println(
                "Max wraparound sum = " + maximum_circular_subarray(list)
        );
    }
}
