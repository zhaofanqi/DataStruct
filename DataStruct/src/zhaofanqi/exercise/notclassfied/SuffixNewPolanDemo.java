package zhaofanqi.exercise.notclassfied;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式 也就是后缀表达式
 */
public class SuffixNewPolanDemo {
    public static void main(String[] args) {
        /**
         *   假设提供表达式为 ： 3 4 + 5 * 6 -，并且是以空格分隔
         */
        String expression = "3 4 + 5 * 6 -";
        String[] arr = expression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : arr) {
            list.add(ele);
        }
        System.out.println(list);
        SuffixNewPolan utilSuff = new SuffixNewPolan();
        System.out.println(utilSuff.cal(list));


    }
}

class SuffixNewPolan {
    /**
     * 将数组中的元素放入 stack中实现
     *
     * @param list
     */
    public int cal(List<String> list) {
        Stack<String> stack = new Stack<String>();
        String res = "", num_1 = "", num_2 = "";


        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.add(s);
            } else { //待插入的元素 已经确定为 运算符了
                num_1 = stack.pop();
                num_2 = stack.pop();
                if (s.equals("+")) {
                    res = String.valueOf(Integer.valueOf(num_1) + Integer.valueOf(num_2));
                } else if (s.equals("-")) {
                    res = String.valueOf(Integer.valueOf(num_2) - Integer.valueOf(num_1));
                } else if (s.equals("*")) {
                    res = String.valueOf(Integer.valueOf(num_2) * Integer.valueOf(num_1));
                } else if (s.equals("/")) {
                    res = String.valueOf(Integer.valueOf(num_2) / Integer.valueOf(num_1));
                } else {
                    System.err.println("Error");
                }
                stack.push(res);
            }

        }
        return Integer.valueOf(stack.pop());

    }


}



