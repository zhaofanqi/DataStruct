package zhaofanqi.exercise.order;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序：
 *         思想： 待排序数组看成 有序+无序，每次从无序中取出一个与有序进行比较
 *              待比较元素 与前面元素比较必然涉及数组中部分元素后移！
 * */

public class InsertOrder {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[8 * 10000];

        for (int i = 0; i < 8*10000; i++) {
            arr[i]=(int)random.nextInt(8*10000);
        }//性能测试 时间 545ms
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        InsertOrderMethod(arr);
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(l2-l1);
    }

    private static void InsertOrderMethod(int[] arr) {
        int temp=Integer.MIN_VALUE;
        int inserIndex=1;//需要增加一个插入下标，否则比较完以后，i不能恢复到插入的结尾，而且循环i刚好控制了比较的结尾，所以不用干涉它
        for (int i = 1; i <arr.length ; i++) {// 待插入元素是从第一个开始判断
            inserIndex=i;
            temp=arr[inserIndex];
            while (inserIndex-1>=0&&temp<arr[inserIndex-1]){//待插入元素与前一个元素比较，若小于，则需要继续比较并且，有序表中的当前元素需要在数组中后移一位
                arr[inserIndex]=arr[inserIndex-1];
                inserIndex--;
            }
            if(inserIndex!=i){//当待插入的元素就是他原来的位置的时候，此时就不需要
                arr[inserIndex]=temp;
            }

        }
       // System.out.println(Arrays.toString(arr));
    }
}
