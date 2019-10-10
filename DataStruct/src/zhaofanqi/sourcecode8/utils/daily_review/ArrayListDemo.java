package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 学习 ArrayList 的使用
 *  Array  数组  大小不可变，类型一致
 *  List   集合 大小可变 ，采用泛型，一般使用引用类型（8种基本类型以外的：Byte,short,char,int,long,float,double,Boolean）
 *  ArrayList 集合(长度可变的数组，底层用的还是数组。默认大小0 ，首次存入数据时的大小为10，以后不足会进行扩展，每次扩大为原来的1.5倍)
 *         newCapacity = oldCapacity + (oldCapacity >> 1)；其中 oldCapacity >> 1 表示：oldCapacity 去除最右边的一位，最左边补 0 ，近似为 0.5倍
 *
 *
 */
public class ArrayListDemo {

    public static void main(String[] args) {

        /**
         *  重现： ArrayList 变为迭代类型后，在迭代的过程中删除ArrayList 元素
         *      期望结果：报错.查看源码：是因为 ArrayList  转为迭代器类型后，执行增删都有一个 checkForComodification()
         *      checkForComodification() 就是 校验：modCount != expectedModCount
         *
         */

        List<String> list = new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list);


        /*
        Iterator<String> iterator = list.iterator();
        String next;
        while (iterator.hasNext()) {
            next = iterator.next();
            list.remove(next);
        }
        System.out.println(list);
        */


    }
}
