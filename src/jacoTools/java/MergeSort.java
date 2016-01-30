package jacoTools.java;


/**
 * Created by Jaco on 14-11-26.
 */
public class MergeSort extends Sort {
    private static <T> void merge(Comparable<T>[] aux, Comparable<T>[] a, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

    }

    public static <T> void sort(Comparable<T>[] a){
        Comparable[] aux = new Comparable[a.length];   //？？错过： （Comparable[]) new Object[a,length]失败
        sortWithInsertionSort(aux,a,0,a.length - 1);  //  这里使用private方法sort1 sort2 sortWithInsertion（大小小于15的小数组使用插入排序） 都可以。
    }

    private static <T> void sort1(Comparable<T>[] aux, Comparable<T>[] a, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        //
        if(hi == lo) return;                        //  错过： 不能没有这一条，否则只有3个元素的数组来排序时候，要算sort（0，1） sort（2，2）。没有这条的话，sort（2，2）无法被return掉，继续进入无穷递归中，无法终止了。
        else if(hi == lo + 1) merge(aux,a,lo,hi);
        //
        else{
            sort1(aux,a,lo,mid);
            sort1(aux,a,mid+1,hi);
            merge(aux,a,lo,hi);
        }
    }

    private static <T> void sort2(Comparable<T>[] aux, Comparable<T>[] a, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        //
        if(hi <= lo) return;
        //
        else{
            sort2(aux,a,lo,mid);
            sort2(aux,a,mid+1,hi);
            merge(aux,a,lo,hi);
        }
    }

    private static <T> void sortWithInsertionSort(Comparable<T>[] aux, Comparable<T>[] a, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        //
        if(hi - lo < 15) {
            for(int i = lo + 1 ; i <= hi; i++){
                for(int j = i; j >= lo+1 && less(a[j],a[j-1]); j--){   //  错过：这里  j >= lo+1    不能写成1
                    exch(a,j,j-1);
                }
            }
        }
            //
        else{
            sortWithInsertionSort(aux,a,lo,mid);
            sortWithInsertionSort(aux,a,mid+1,hi);
            if(less(a[mid+1],a[mid]))    //加上这一句可以使得对有序数组排序变为线性。
                merge(aux,a,lo,hi);
        }
    }
//非递归版本
    public static void sortFromBottomToFront(Comparable[] a){

    }

}
