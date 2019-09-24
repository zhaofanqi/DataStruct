package zhaofanqi.exercise.search;

import java.util.ArrayList;

import java.util.List;

/**
 * @Des 二叉树递归查找数据，递归的结束条件是 left>right 则结束查找
 *      前提条件：该数组是有序的
 */
public class BinaryTreeSerarch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,255,255,255,255,345,1000};
        int findVal=255;
       /* int i = binarySearch(arr, 0, arr.length - 1, findVal);
        System.out.println(i);*/
        List<Integer> resList = binarySearch2(arr, 0, arr.length - 1, findVal);
        System.out.println(resList);

    }

    /**
     *
     * @param arr  待查找的有序数组
     * @param left 二分查找的左边起始位置
     * @param right 二分查找的右边结束位置
     * @param findVal 需要找到的值
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        //二分查找需要一个中间值
        int midIndex=(left+right)/2;
        int midValue=arr[midIndex];
        if (findVal==midValue){
            return midIndex;
        }
        if(left>=right){
            return -1;
        }
        if (findVal>midValue){
            binarySearch(arr,midIndex+1,right,findVal);
        }else if(findVal<midValue){
            binarySearch(arr,left,midIndex,findVal);
        }
        return  -1;
    }
    static List<Integer> list =new ArrayList<Integer>();
    // 新增一个功能，用于返回显示数组中有几个相同的值
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //二分查找需要一个中间值
        int midIndex=(left+right)/2;
        int midValue=arr[midIndex];

        if(left>=right){
            return new ArrayList<Integer>();
        }
        if (findVal>midValue){
            binarySearch(arr,midIndex+1,right,findVal);
        }else if(findVal<midValue){
            binarySearch(arr,left,midIndex,findVal);
        }else{
            int temp=midIndex;//此时不是直接返回，而是像该索引值的左右去找
            while(true){
                if(temp<0||findVal!=arr[temp]) break;
                list.add(arr[temp]);
                temp-=1;//向左找
            }
            temp=midIndex+1;
            while(true){
                if(temp>arr.length-1||findVal!=arr[temp]) break;
                list.add(arr[temp]);
                temp+=1;
            }

        }
        return  list;
    }
}
