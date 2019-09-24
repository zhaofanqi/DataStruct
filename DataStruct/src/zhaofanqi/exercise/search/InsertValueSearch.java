package zhaofanqi.exercise.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   插值查找算法： 有序数组中的元素变化比较均匀时，可以按照一定的百分去找 这样的mid是种自适应。
 *                  类似的如果数组中的元素是按照2次方，对应的自适应也可以调整逻辑
 *      mid=(left+right)/2  ----> mid=arr[left]+ (right-left) *  (findVal-arr[left])/(arr[right]-arr[left])
 *      对于 数据量 较大，数据分布均匀使用这种方法，搜索数值的效果较好，如果数据分布不均匀，使用这种方法不一定比二叉树查找好
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[20];
        /*for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }*/
        for (int i = 0; i <arr.length ; i++) {
            if (i%10==0){
                arr[i]=i;
                arr[i++]=i;
            }
            arr[i]=i;
        }
        System.out.println(Arrays.toString(arr));
        int findVal=11;
        //int i = insertSearch(arr, 0, arr.length - 1, findVal);
//        System.out.println(i);
        List<Integer> list = insertSearch2(arr, 0, arr.length - 1, findVal);
        System.out.println(list);
    }

    private static List<Integer> insertSearch2(int[] arr, int left, int right, int findVal) {
        if (left>right||findVal>arr[right]||findVal<arr[left]){
            return  new ArrayList<Integer>();
        }
        int midIndex=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        if (findVal>arr[midIndex]){
            insertSearch2(arr,midIndex+1,right,findVal);
        }else  if (findVal<arr[midIndex]){
            insertSearch2(arr,left,midIndex-1,findVal);
        }else {
            //可能存在多个相同值
            int temp=midIndex;
            List<Integer> list = new ArrayList<Integer>();
            while (true){
                if (findVal!=arr[temp]||temp<left) break;
                list.add(arr[temp]);
                temp--;
            }
            temp=midIndex+1;
            while (true){
                if (findVal!=arr[temp]||temp>right) break;
                list.add(arr[temp]);
                temp++;
            }
            return list;
        }

        return new ArrayList<Integer>();
    }

    /**
     *  插值查找的最好地方就是在二叉树的基础上针对数据特点，调整mid值的位置
     *  所以前提条件：插值查找的数据也是有序的
     */
    private static int insertSearch(int[] arr, int left, int right, int findVal) {
        // left>right 表明递归结束，在写递归时候，递归结束条件尽量往前些；
        //findVal<arr[left]||findVal>arr[right]  保证查找的数据是在该数组范围内
        if (left>right||findVal<arr[left]||findVal>arr[right]){
            return -1;
        }
        int  midIndex=left+ (right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[midIndex];

        if (midValue<findVal){
            insertSearch(arr,midIndex+1,right,findVal);
        }else if(midValue>findVal){
            insertSearch(arr,left,midIndex-1,findVal);//刚才的mid已经比较过了，所以这次可以右边界为
        }else {
            return  midValue;
        }

        return  -1;
    }
}
