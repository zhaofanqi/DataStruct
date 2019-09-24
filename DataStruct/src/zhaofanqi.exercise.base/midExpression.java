package zhaofanqi.exercise.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式：人看方便，机器看起来不方便，先需要将中缀表达式转为后缀表达式
 * <p>
 * 转换逻辑 ：中缀表达式==》 数组  ==》 后缀表达式
 */
public class midExpression {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> list = expressToArray(expression);
        System.out.println(list);
        List<String> afterSuffixExpressionList = arrayToSuffExpression(list);
        System.out.println(afterSuffixExpressionList);
        SuffixNewPolan utilSuff = new SuffixNewPolan();
        System.out.println("后缀表达式计算结果为 ： "+utilSuff.cal(afterSuffixExpressionList));
    }

    /**
     * 先将中缀表达式转为一个数组
     */
    public static List<String> expressToArray(String s) {

        List<String> list = new ArrayList<String>();
        // 判断是否为数字  数字的ascii码值为48到57
        int index = 0;
        String str;
        char c;
        while (index <= s.length() - 1) {
            if ((c = s.charAt(index)) >= 57 || (c = s.charAt(index)) <= 48) {//判断是否为数字
                list.add("" + c);
                index++;
            } else {
                str = "";
                while (index <= s.length() - 1 && ((c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57)) {
                    str += "" + c;
                    index++;
                }
                list.add(str);
            }
        }
        return list;

    }

    public static List<String> arrayToSuffExpression(List<String> list) {
        //定义2个栈
        Stack<String> stack_1 = new Stack<String>();
        // 说明因为stack_2从来没有出战操作，后面还需要逆序输出，此时直接用数组代替stack_2
        //Stack<String> stack_2 = new Stack<String>();
        ArrayList<String> s2 = new ArrayList<String>();
        for (String item : list) {
            //如果是数字直接入 stack_2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                stack_1.push(item);
            } else if (item.equals(")")) {//如果是右括号，需要将 stack1的栈顶运算符
                //弹出，并压入s2，直到遇到左括号为止，此时将这一对括号去除
                while (!stack_1.peek().equals("(")) {
                    s2.add(stack_1.pop());
                }
                stack_1.pop();
            } else {
                //当 s1栈顶的运算符优先级 <=栈顶运算符时：
                //将 s1栈顶运算符 弹出并压入 s2中，再与新的是s1栈顶运算符进行比较
                // 缺少一个比较优先级高低的方法
                while (stack_1.size() != 0 && (Opreation.getValue(stack_1.peek()) >= Opreation.getValue(item))) {
                    s2.add(stack_1.pop());
                }
                //需要记得将 item 压入栈
                stack_1.push(item);
            }
        }

        //将stack_1中的剩余的运算符压入 s2中
        while (stack_1.size()!=0){
            s2.add(stack_1.pop());
        }
        return s2;
    }
}

/**
 * 编写一个类Operation 可以返回一个运算符 对应的优先级
 */
class Opreation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法判断 对应优先级的数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation.charAt(0)) {
            case '+':
                result = ADD;
                break;
            case '-':
                result = SUB;
                break;
            case '*':
                result = MUL;
                break;
            case '/':
                result = DIV;
                break;
            default:
                System.out.println("operation is not exist");
        }
        return result;
    }
}