/**
 * Created by Jaco on 15-10-21.
 */
import jacoTools.java.Stack;

public class testStack {
        public  static void  main(String[] args) {
                Stack<Integer> s1 = new Stack<Integer>();
                s1.push(1);
                s1.push(2);
                s1.push(3);
                int x,y,z;
                for(Integer i : s1){
                        System.out.println(i);
                }
                System.out.println(s1.pop());
                int i = 0;
                while(++i < 10){
                        int j = i;
                        System.out.println(j);
                }

        }
}

