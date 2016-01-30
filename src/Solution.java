import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


    public class Solution {
        public static int bs(int lo , int hi, int[] nums, int aim){

            int mid = lo + (hi - lo) /2;
            if(mid < lo || mid > hi) return -1;
            else if(aim == nums[mid]) return mid;
            else if(aim > nums[mid]) return bs(mid+1,hi,nums,aim);
            else return bs(lo,mid-1,nums,aim);
        }
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            int sum3,sum2,left;
            List<List<Integer>> re = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            int N = nums.length;
            //int 33sum = 0;
            //int 2sum = 0;
            //int left = 0;
            for(int i = 0; i < N - 3; i++ ){
                sum3 = target - nums[i];
                for(int j = i+1; j < N; j++){
                    sum2 = sum3 - nums[j];
                    for(int k = j + 1; k < N; k++){
                        left = sum2 - nums[k];
                        int l = bs(k+1,N-1,nums,left);
                        if ( l > 0 ) {
                            ArrayList<Integer> aux = new ArrayList<Integer>();
                            Collections.addAll(aux,nums[i],nums[j],nums[k],nums[l]);
                            re.add(aux);
                        }

                    }
                }
            }

            return re;
        }

    public static void main (String[] args){
        int[] nums = {1 ,0 ,-1 ,0 ,-2 ,2};
        System.out.println(fourSum(nums,0));
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(1);
        x.add(2);
        y.add(2);
        y.add(1);
        System.out.println(x.equals(y));
    }
}