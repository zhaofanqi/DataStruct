package zhaofanqi.exercise.recursion;

public class RecursionDemo {


    public static void main(String[] args) {
        test(5);
        System.out.println("阶乘结果为"+mul(5));
    }

    private static int mul(int i) {
        if (i==1){
            return 1;
        }else{
            int res = mul(i - 1);
            return i*res;
        }

    }

    private static void test(int i) {
        if(i>0){
            test(i-1);
        }
        System.out.println("this is i :"+i);
    }
}
