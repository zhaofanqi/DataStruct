package zhaofanqi.exercise.notclassfied;

/**
 * 顶堆分为： 大顶堆/小顶堆
 * 是用完全二叉树维护的一维数组，若该二叉树中 顶点元素全都大于等于左右子节点，则成为大顶堆，反之为小顶堆
 * 大小顶堆中的数据体现在一维 数组中并不是有序的；
 * 它存在的意义不是为了搜索，只是为了将最小或者最大的值放到前面，方便增改
 * <p>
 * 0
 * 1                        2
 * 3                 4            5           6
 * 7        8      9        10   11   12   13    14
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */

/**
 * @Des 让数据升序排序，那么需要使用  重构大顶堆+交换值
 * 每次将大顶堆的堆顶与最后一个值交换
 */
public class MaxHeap {
    public static void main(String[] args) {

        //每插入一条数据都需要重构一次大数堆
        int[] arr = {7, 3, 8, 5, 1, 2};
        int len = 6;
        int i;
        for (i = len; i > 0; i--) {
            buildHeap(arr, i);
            Swap(arr, i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
            }
            System.out.println("执行的次数"+i+"\t&&");
        }

        for (i = 0; i < len; i++) {
            System.out.printf("%d\t", arr[i]);
        }
    }


    /**
     * 构建大顶堆
     */
    private static void buildHeap(int[] arr, int len) {
        int i;
        int temp;

        for (i = len / 2 - 1; i >= 0; i--) {
            if (2 * i + 1 < len && arr[i] < arr[2 * i + 1]) {//顶点小于左子节点
                temp = arr[i];
                arr[i] = arr[2 * i + 1];
                arr[2 * i + 1] = temp;
                //调整完以后还需继续判断，左子节点的子节点是否已经是正确的顶堆
                if (2 * (2 * i + 1) + 1 < len && arr[2 * i + 1] < arr[2 * (2 * i + 1) + 1] || 2 * (2 * i + 2) + 2 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 2]) {
                    buildHeap(arr, len);
                }
            }
            if (2 * i + 2 < len && arr[i] < arr[2 * i + 2]) {// 顶点小于右节点
                temp = arr[i];
                arr[i] = arr[2 * i + 2];
                arr[2 * i + 2] = temp;
                // 2*i +2 ==>2*(2*i +2)+1 为左  ;2*(2*i +2) +2 为右
                if (2 * (2 * i + 2) + 1 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 1] || 2 * (2 * i + 2) + 2 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 2]) {
                    buildHeap(arr, len);
                }
            }

        }


    }

    /**
     * 交换数组最后一位与顶堆值
     */
    public static void Swap(int[] arr, int len) {
        int temp;
        temp = arr[len - 1];
        arr[len - 1] = arr[0];
        arr[0] = temp;
    }

}







