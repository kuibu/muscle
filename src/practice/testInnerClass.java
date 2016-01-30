package practice;

/**
 * Created by Jaco on 15-11-9.
 */
public class testInnerClass {
    inner x = new inner();
    private class inner{
        private int return1(){
            return 1;
        }
    }
    public int return1x(){
        return x.return1();
    }
}
