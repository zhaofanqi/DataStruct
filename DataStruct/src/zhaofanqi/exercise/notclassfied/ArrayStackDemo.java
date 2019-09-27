package zhaofanqi.exercise.notclassfied;


public class ArrayStackDemo {
    public static void main(String[] args) {
       /* ArrayStack arrayStack = new ArrayStack(5);
        for (int i = 0; i <5 ; i++) {
            arrayStack.push(i);
        }
        arrayStack.show();
        arrayStack.pop();
        System.out.println("已经取出一个元素 了");
        arrayStack.show();*/


        /**
         * 求表达式 expression "3+2*6-2" 的值
         * 思路： 使用2个栈存储结果： 数字栈，符号栈
         *      遍历表达式，当得到的是数字时，则将数组写入数字栈中；若得到的为运算符则存入 符号栈
         *                 操作符是否首次入栈， 是 ：直接写入符号栈
         *                                  否：判断运算的优先级 ，与现有栈顶的运算符比较
         *                                          待插入的运算符 优先级 低于栈中的运算符
         *                                                              是： 则取出数字栈中2个数字以及当前符号栈的符号进行运算，
         *                                                                      运算结束以后将结果写回数字栈中，并将带插入的符号覆盖当前符号栈栈顶符号
         *                                                              否：直接将符号插入符号栈中
         *
         *                                          最后剩余 符号栈中一个符号，数字栈中2个数字，还需要再运算一次！
         *                                          表达式是否遍历结束： 看遍历控制变量index是否已经等于表达式的长度
         *
         *
         */
        String expression = "3+20*6-2";
        int index = 0;
        int result = 0;
        ArrayStack numStack = new ArrayStack(expression.length());
        ArrayStack operaStack = new ArrayStack(expression.length());
        while (index < expression.length()) {
            char c = expression.substring(index, index + 1).charAt(0);
            if (isOper(c)) {
                if (operaStack.isEmpty()) {// 首个字符插入
                    operaStack.push(c);
                } else {//后续操作字符插入,需要与现有 符号栈顶 的符号优先级进行比较
                    if (operaStack.priority(c) < operaStack.priority(operaStack.peek())) {
                        //此时需要计算：
                        result = cal(numStack, operaStack);
                        numStack.push(result);
                        operaStack.push(c);
                    } else {
                        operaStack.push(c);
                    }
                }
            } else {
//                numStack.push(c - '0');
                //递归 判断是否是多位数字的
                if(index==expression.length()-1){
                    numStack.push(c-'0');

                }else{
                    if(!isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.valueOf(expression.substring(index,index+2)));
                        index++;
                    }else  numStack.push(c-'0');
                }
            }
            index++;
        }
        while (true) {

            result = cal(numStack, operaStack);
            numStack.push(result);
            if (operaStack.isEmpty()) {
                break;
            }
        }
        System.out.println(" final result :" + result);

    }

    private static boolean isOper(char c) {
       return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int cal(ArrayStack numStack, ArrayStack operaStack) {
        int num1;
        int num2;
        int res;
        num1 = numStack.pop();
        num2 = numStack.pop();
        switch (operaStack.pop()) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 + num1;
                break;
            default:
                res = -999;
                System.out.println('+' + "\t" + '-' + "\t" + '*' + "\t" + '/');
                break;
        }
        return res;

    }
}


/**
 * 数组模拟栈 : 栈顶，栈,栈的大小
 */
class ArrayStack {
    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int i) {
        if (isFull()) {
            System.out.println("stack is full");
        }
        top++;
        stack[top] = i;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(" show stack " + stack[i]);
        }
    }

    public int peek() {//查看栈顶元素
        return stack[top];
    }

    /**
     * @param num1 数字栈 栈顶的第一个元素
     * @param num2 数字栈 栈顶的第二个元素
     * @param s    数字计算的操作符
     * @return
     */
    public int cal(int num1, int num2, String s) {
        return 0;
    }

    /**
     * 定义符号位的优先级
     */
    public int priority(int c) {
        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        }
        System.out.println(" Error operation ");
        return -1;
    }


}
