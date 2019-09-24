package zhaofanqi.exercise;

/**
 * 顶堆分为： 大顶堆/小顶堆
 *      是用完全二叉树维护的一维数组，若该二叉树中 顶点元素全都大于等于左右子节点，则成为大顶堆，反之为小顶堆
 *      大小顶堆中的数据体现在一维 数组中并不是有序的；
 *      它存在的意义不是为了搜索，只是为了将最小或者最大的值放到前面，方便增改
 */

/**
 * @Des 让数据升序排序，那么需要使用  重构大顶堆+交换值
 *          每次将大顶堆的堆顶与最后一个值交换
 */
public class MaxHeap {
    public static void main(String[] args) {

        //每插入一条数据都需要重构一次大数堆
        int[] arr = {7, 3, 8, 5, 1, 2};
        for (int i = 0; i < arr.length; i++) {
            buildHeap(arr, arr[i]);
        }
       // orderArr(arr,)
    }


    private static void buildHeap(int[] arr, int i) {
    }
    /**
     * 实现升序
     */


}







