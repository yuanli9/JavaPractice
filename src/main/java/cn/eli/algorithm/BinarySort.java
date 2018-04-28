package cn.eli.algorithm;

import java.util.Arrays;

/**
 *  ComparableTimSortStu.binarySort源码研究
 * */
public class BinarySort {

    public static void binarySort(Object[] a, int lo, int hi, int start) {
        if (start == lo)
            start++;
        for ( ; start < hi; start++) {
            Comparable pivot = (Comparable) a[start];

            // Set left (and right) to the index where a[start] (pivot) belongs
            int left = lo;
            int right = start;
            assert left <= right;
            /*
             * Invariants:
             *   pivot >= all in [lo, left).
             *   pivot <  all in [right, start).
             */
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot.compareTo(a[mid]) < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            assert left == right;

            /*
             * The invariants still hold: pivot >= all in [lo, left) and
             * pivot < all in [left, start), so pivot belongs at left.  Note
             * that if there are elements equal to pivot, left points to the
             * first slot after them -- that's why this sort is stable.
             * Slide elements over to make room for pivot.
             */
            int n = start - left;  // The number of elements to move
            // Switch is just an optimization for arraycopy in default case
            switch (n) {
                case 2:  a[left + 2] = a[left + 1];
                case 1:  a[left + 1] = a[left];
                    break;
                default: System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = pivot;
        }
    }

    public static void main(String[] args) {
        Integer a[] = {1,3,6,98,55,100,66,22,89,105};
        long start = System.currentTimeMillis();
        binarySort(a,0,9,0);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.asList(a));
    }
}


