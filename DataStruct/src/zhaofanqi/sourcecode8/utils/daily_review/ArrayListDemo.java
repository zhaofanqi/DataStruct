package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ѧϰ ArrayList ��ʹ��
 *  Array  ����  ��С���ɱ䣬����һ��
 *  List   ���� ��С�ɱ� �����÷��ͣ�һ��ʹ���������ͣ�8�ֻ�����������ģ�Byte,short,char,int,long,float,double,Boolean��
 *  ArrayList ����(���ȿɱ�����飬�ײ��õĻ������顣Ĭ�ϴ�С0 ���״δ�������ʱ�Ĵ�СΪ10���Ժ���������չ��ÿ������Ϊԭ����1.5��)
 *         newCapacity = oldCapacity + (oldCapacity >> 1)������ oldCapacity >> 1 ��ʾ��oldCapacity ȥ�����ұߵ�һλ������߲� 0 ������Ϊ 0.5��
 *
 *
 */
public class ArrayListDemo {

    public static void main(String[] args) {

        /**
         *  ���֣� ArrayList ��Ϊ�������ͺ��ڵ����Ĺ�����ɾ��ArrayList Ԫ��
         *      �������������.�鿴Դ�룺����Ϊ ArrayList  תΪ���������ͺ�ִ����ɾ����һ�� checkForComodification()
         *      checkForComodification() ���� У�飺modCount != expectedModCount
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
