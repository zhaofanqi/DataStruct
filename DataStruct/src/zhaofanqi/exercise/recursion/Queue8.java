package zhaofanqi.exercise.recursion;

public class Queue8 {
     int max=8;
     int[] array=new int[max];//new int[max];



    //定义数组array ,保存皇后放置位置的结果，比如 {0，4，7,5，2,6,1,3}
    // 此处需要注意！！！： 一维数组的下标表示行数，下标对应的值为列数
    public static void main(String[] args) {

//         array={0,4,7,5,2,6,1,3};
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        queue8.print();
    }

    // 8皇后 判断是否是 同行同列 同斜线的依据 ：
        // 行差值= 列差值 因为是正方形啊，一旦在同一斜线，那么行差值必然等于列差值
        // 同列： 一维数组，不同下标值是否相等

    private   void print(){
       /* for (int ele : array) {
            System.out.print(ele+"\t");
        }*/
        for (int i = 0; i <array.length ; i++) {
            System.out.print("\t"+array[i]);
        }
        System.out.println();
    }
    private void  check(int n ){
        if(n==max){//n=8 ，其实就已经有8个皇后放入了
            print();
            return;
        }
        // 由于每次放入是从第一列开始，所以遍历列，此处的列为 i 表示
        for (int i=0;i<max;i++){
            // 先把当前这个皇后n，放到改行第一列，
            array[n]=i; // 表示第 n 个皇后放在 第 i 列 也在第n-1 行
            if (judge(n)){
                check(n+1);
            }
            //  如果 冲突，就继续 执行 array[n]=i;即将第n 个皇后，放置在本行后移一列的位置
        }

    }

    /**
     *  查看我们放置的第n个皇后是否满足要求
     * @param n
     * @return
     */
    public  boolean judge(int n ){
        for (int i = 0; i <n ; i++) {//每放置一个都需要与之前的判断是否是同行同列同斜线
            //array[i]==array[n] 则表示同一列了
            //Math.abs(n-i) 表示列差值
            //Math.abs(array[n]-array[i]) 表示行差值
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return  false;
            }

        }
        return  true;
    }
}
