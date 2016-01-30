package jacoTools.java;

/**
 * Created by Jaco on 15-10-25.
 */
public class SelectionSort extends Sort{
    public static void sort(Comparable[] a){
        //Sort a[] into increasing order
        int N  = a.length;
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i + 1; j < N; j++){
                if(less(a[j],a[min])) min = j;
            }
            exch(a,i,min);
        }
    }
}
