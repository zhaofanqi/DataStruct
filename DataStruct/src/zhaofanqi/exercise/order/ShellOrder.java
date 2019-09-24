package zhaofanqi.exercise.order;

import java.util.Arrays;
import java.util.Random;

/**
 *  希尔排序思想： 先局部插入排序再整体插入排序 以解决插入排序存在的弊端（后插入的元素刚好与有序表中的元素逆序，会导致每次的插入排序都涉及大量数组元素移动）
 *  希尔排序分为: 交换法，移位法
 */
public class ShellOrder {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        Random random = new Random();
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)random.nextInt(8*10000);
        }

//        int[] arr = {2, 6, 8, 9, 3, 7, 5, 1, 4};
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        //ShellOrderMethod(arr);//执行时间 13 ms
        ShellOrderMethod_2(arr);//教材实现方式，相较于自己写的，少层for 循环，让程序自己实现交替比较,不过时间差不多
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(l2-l1);
    }

    private static void ShellOrderMethod_2(int[] arr) {
        int j=0;
        int temp=0;
        for (int gap = arr.length/2; gap >0; gap=gap/2 ) {
            for (int i = gap; i <arr.length ; i++) {//一个很大的好处不用一组一组的比较，而是可以让程序自己去交替比较不同的组
                j=i;
                temp=arr[j];
                if (temp<arr[j-gap]){
                    while (j-gap>=0&&arr[j-gap]>temp){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                }
                arr[j]=temp;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    private static void ShellOrderMethod(int[] arr) {
        /**
         * 步骤1：让数据分组最终趋于分为1组，在每个分组中都进行插入排序
         *
         * */
        int inserIndex=Integer.MIN_VALUE;
        int temp=Integer.MIN_VALUE;
        int count=0;
//        System.out.println("排序前为： "+Arrays.toString(arr));
        for (int gap = arr.length/2; gap >0; gap=gap/2 ) {// gap是分组数，让分组趋于1,控制分组
            //编写每组的插入程序
            for(int j=0;j<gap;j++){
                for (int i = j; i < arr.length ; i+=gap) {//每个分组有 arr.length/gap 个元素
                    inserIndex=i;
                    temp=arr[inserIndex];//得到待比较元素值
                    while (inserIndex-gap>=0&&temp<arr[inserIndex-gap]){
                        arr[inserIndex]=arr[inserIndex-gap];
                        inserIndex-=gap;
                    }
                    arr[inserIndex]=temp;
                    count++;
                }
            }
//            System.out.println("经过排序变为： "+Arrays.toString(arr));
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println("进入内部比较次数"+count);
    }
}
