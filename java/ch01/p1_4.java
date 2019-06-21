/*
    Page 26, problem 1.4.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p1_4 {
    private static int bisect_left(List<Integer> seen, int val) {
        int len = seen.size();
        int pos = 0;

        while (pos < len) {
            if (seen.get(pos) >= val)
                break;
            pos++;
        }

        return pos;
    }

    private static int[] smaller_counts(int[] list) {
        int[] counts = new int[list.length];
        List<Integer> seen = new ArrayList<>();
        int last = list.length - 1;

        for (int i = last; i >= 0; i--) {
            int pos = bisect_left(seen, list[i]);
            counts[i] = pos;
            seen.add(pos, list[i]);
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] list;

        if (args.length > 0) {
            list = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                list[i] = Integer.parseInt(args[i]);
            }
        } else {
            list = new int[] {3, 4, 9, 6, 1};
        }

        System.out.println(Arrays.toString(smaller_counts(list)));
    }
}
