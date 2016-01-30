package jacoTools.java;

/**
 * Created by Jaco on 15-10-26.
 */
public class InsertionSort extends Sort {
    public static void sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j >= 1 && less(a[j],a[j-1]); j--)
                 exch(a,j-1,j);
        }
    }
}
