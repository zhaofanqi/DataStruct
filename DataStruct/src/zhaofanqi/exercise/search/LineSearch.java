package zhaofanqi.exercise.search;

import java.util.Arrays;

/**
 * @Des 线性查找数据
 */
public class LineSearch {
    public static void main(String[] args) {
        int[] arr ={53,3,542,748,14,214};
        int val=3;// 表示要查找的值
        int i = lineSearch(arr, val);
        if(-1==i){
            System.out.println("didn't find value :"+ val);
        }else {
            System.out.println("find it ,at arr index of "+i);
        }

    }

    private static int lineSearch(int[] arr, int val) {
        for (int i = 0; i <arr.length ; i++) {
            if (val==arr[i]){
                return i;
            }

        }
        return -1;
    }
}
