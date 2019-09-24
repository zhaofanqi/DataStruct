package zhaofanqi.exercise.order;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序 ： 每一次轮询给指定位置插入对应顺序的数字 如 第一轮询后，第一个位置就是最小值，第二次轮询后，第二个位置就是最大值
 *      思路： 每第 n 次轮询都可以将第 n 位的值确定下来 所以内存循环与外层控制次数循环相关
 */
public class ChooseOrder {
    public static void main(String[] args) {
        int[] arr=new int[80000]; //80000 条执行时间为9065毫秒
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i]=(int)random.nextInt(80000);
        }// 执行时间为 1708 ms

        int max=Integer.MIN_VALUE;;
        int  temp;
        int minIndex=0;
        int min=0;
        Long l1=System.currentTimeMillis();
        System.out.println("执行前时间"+l1);

        for (int i = 0; i <arr.length ; i++) {// 控制循环次数
            min=arr[i];
            for (int j = i+1; j <arr.length ; j++) {// 每次循环需要比较的次数
                if(min>arr[j]){//升序 arr[i]现在就是i最小的
                    min=arr[j];
                    minIndex=j;
                    /*temp= arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;*/ // 由于在内部涉及数组的交换会导致效率低下
                }

            }
            arr[minIndex]=arr[i];
            arr[i]=min;
        }
        long l2 = System.currentTimeMillis();
        System.out.println("执行时间"+(l2-l1));

        //System.out.println(Arrays.toString(arr));
    }
}
