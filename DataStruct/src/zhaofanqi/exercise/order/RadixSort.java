package zhaofanqi.exercise.order;

import java.util.Arrays;
import java.util.Random;

/**
 * @Des 基数排序： 使用桶！ 将数组中的值按照个位对10 取余数 存入不同的桶中，再存入原数组，清空这十个桶
 * 第二次 从原数组中按顺序取出各个元素 并除以10再对10 取余 存入十个桶中，以此类推，直到按照最高位取余数存入桶中
 * 注意：该方法中没有考虑到数据为 负数的 情况
 *
 *  性能测试结果  8万  14ms  80 万   48ms 800万用 406ms 8000万出现堆内存溢出错误了
 */
public class RadixSort {
    public static void main(String[] args) {

        //int[] arr = {53, 3, 542, 748, 14, 214};
        int[] arr = new int[8000*10000];
        Random random = new Random();
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=random.nextInt(arr.length);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        radixSort(arr);
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(l2-l1);
    }

    private static void radixSort(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //一共需要迭代的次数
        int maxValueLength = (max + "").length();

        //先写进行一次迭代吧
        /**
         *  十个桶，每个桶存入哪些元素，需要二维数组记录
         *  还需要一个一维数组记录，每个桶子有多少元素
         */
        int[][] buckets = new int[10][arr.length];//避免溢出，每个桶的长度设置为一维数组的长度
        int[] bucketElement = new int[10];// 用于记录每个桶中有多少元素，同时此处：数组的下标对应桶的下标，该下标处的值对应该桶中元素个数
        int n = 1;//用于控制取余数用
        int element = -1;
        for (int k = 0; k < maxValueLength; k++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                element = arr[i] / n % 10;
                //[element] 很好理解是对应哪个桶；
                // [bucketElement[element]++] 则表示每个桶中有多少个元素; 很巧妙,是自然增长的整数
                //buckets[element][bucketElement[element]++]=arr[i];
                // 待测试
                buckets[element][bucketElement[element]] = arr[i];
                bucketElement[element]++;
            }

            //开始取出数据
            int index = 0;
            for (int i = 0; i < bucketElement.length; i++) {// 开始遍历每一个桶
                for (int j = 0; j < bucketElement[i]; j++) {
                    arr[index] = buckets[i][j];// 记住实际的数字是保存在二维数组中的
                    index++;
                }
                bucketElement[i] = 0;//将记录每个桶中数据的清空
            }
        }
    }
}
