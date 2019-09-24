package zhaofanqi.exercise.order;

import java.util.Random;

/**
 * 冒泡排序： 时间复杂度为 n 的二次方
 * 比较思路： 两两之间相互比较
 */
public class Maopao {
    public static void main(String[] args) {
        // int[] arr = {2, 6, 8, 9, 3, 7, 5, 1, 4};
        // 正常测试的数据
        //int[] arr = {3, -1, 9, 10, -2};
        //int[] arr = {-2,-1,3,9,10};
        int[] arr= new int[8*10000];
        Random random = new Random();
        //性能测试数据
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)random.nextInt(8*10000);
        } // 执行时间 9688

        pubble(arr);


    }

    private static void pubble(int[] arr) {
        long l1 = System.currentTimeMillis();
        System.out.println("冒泡排序开始执行的时间"+l1);
        int temp = -1;
        boolean flag; //添加标示位；当某次循环中没有发生交换，即已经顺序了。此时不用后面的循环了。所以表示位 在底层for循环里面。
        for (int i = 0; i < arr.length - 1; i++) {//控制循环次数
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {//每一次循环需要比较的个数
                if (arr[j] > arr[j + 1]) {// 按照升序
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;// 此处修改flag表示存在逆序
                }
            }
            if (!flag) {
                break;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println("冒泡排序结束执行的时间"+(l2-l1)/1000);

    }
}
