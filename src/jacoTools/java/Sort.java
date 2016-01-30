package jacoTools.java;

/**
 * Created by Jaco on 14-8-25.
 * To reduce code lines,I create class Sort.Method less and exch(should be public) will not rewrite in MergeSort/QuickSort.
 * As class Sort olny have static methods,I define abstract class only for reuse codes.In Scala,trait can be used.
 *
 */
public  class Sort {
    public static  boolean less(Comparable v,Comparable w){
       return v.compareTo(w) < 0;   // because is "less",so add " < 0"
    }
    public static  void exch(Comparable[] a, int i,int j){
        Comparable aux = a[i]; a[i] = a[j]; a[j] = aux;
    }

    public static  <T> void show(Comparable<T>[] a){
        for(int i = 0 ; i < a.length; i++)
            System.out.println(a[i]);
    }
    public static <T> boolean isSorted(Comparable<T>[] a){
        for(int i = 1;i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

}
