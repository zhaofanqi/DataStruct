package zhaofanqi.exercise.order;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序 ：先分后合。时间复杂度为 O(n)需要借助临时数组，用于存储
 * 合步骤： 先比较最小合并单位并决定谁先插入
 * 若一组数据比较完成，则将另外一组数据按顺序直接插入
 * 将临时数组中的数据拷贝进入原来的数组中
 * <p>
 * <p>
 * 分的时候采用递归，则在栈顶的时候直接对其使用 merge 即可
 */
public class MergeSort_good {
    public static void main(String[] args) {
//        int[] arr = {8, 3, 5, 7, 6, 1, 4, 2};
        int[] arr=new int[8*10000000];
        Random random = new Random();
        for (int i = 0; i <80000000 ; i++) {
            arr[i]=random.nextInt(80000000);
        }//数据量 8万 为  10ms   80万 为 91毫秒 800万 979ms 8000万 10898ms
        int[] temp = new int[arr.length];
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        mergeSort(arr, 0, arr.length - 1, temp);
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(l2-l1);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2; //mid 是左边数组的最后一个元素下标，如 7/2=3 为左边的四个元素，右边三个元素
        if (left < right) {
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // 经过以上2个方法递归时，则此时已经在栈顶了，直接合并操作了
            merge(arr, left, mid, right, temp);
        }


    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;//分别用于表示被分割后数组的下表位置
        int t = 0;// 定义临时数组的起始位置
        while (i <= mid && j <= right) {// 一个不能分割的数组也会进入，此时添加if判断，可减少进入内部逻辑了
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }// 这种写法，可以控制左右数组中数据是否比较完成
        }
        //开始执行步骤二
        // 跳出以上循环表示，一组数据已经比较完成
        while (i <= mid) {// 表示左边数组没有填充结束， 要有等于，避免进来的时候，左边数组只有一个元素
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {//表示右边数组没有填充结束， 要有等于，避免进来的时候，右边数组只有一个元素
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //开始执行步骤三
        int tempLeft = left;//每次合并的仅仅是传入的数据,所以开始位置为 left 结束位置为right
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft += 1;
            t += 1;
        }

    }
}
