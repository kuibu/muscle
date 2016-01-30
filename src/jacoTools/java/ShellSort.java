package jacoTools.java;

/**
 * Created by Jaco on 15-10-26.
 */
public class ShellSort extends Sort{
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3 * h + 1;    // h's value will be : 1 or 4 or 13 or ...
        // first team: a[0] a[h]   a[2h]   ...
        //second team: a[1] a[h+1] a[2h+1] ...
        //...
        while(h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h)     //条件中出现a[j-h],所以 j要保证 j>=h
                    exch(a, j, j - h);
            h = h/3;
        }

    }
}
