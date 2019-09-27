package zhaofanqi.exercise.base;

import java.util.Arrays;
import java.util.List;

public class Case1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        List  ints = Arrays.asList(arr);
        System.out.println(ints.size());
        ints.add(9);
        ints.add(8);
    }
}
