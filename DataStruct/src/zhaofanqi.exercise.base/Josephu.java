package zhaofanqi.exercise.base;

/**
 * 模拟实现约瑟夫问题：
 *              假设有5个人丢手绢，从第一个人开始丢，每次数2次，求出圈顺序： 2->4->1->5->3
 *              单向环形链表（使用带头节点的方式）：存在一个属性指向下一个节点，
 */
public class Josephu {
    public static void main(String[] args) {
        SingleCircleLinked singleCircleLinked = new SingleCircleLinked();
        Boy adds = singleCircleLinked.add(5);
        singleCircleLinked.update(3,adds,"xiugai");
        singleCircleLinked.show();
 //       singleCircleLinked.pop(1,2,5);

    }
}

class Boy{
    private int no ; //存储编号
    private String name;//对象名称
    private Boy next; //用于指向下一个对象用

    public Boy(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{ no=" + no + ", name='" + name + '\'' +'}';
    }
}
class SingleCircleLinked{
    private Boy first=null;
    private Boy last=null;

    public Boy add(int nums){ //用于生成指定个数的单向环形链表
        if(nums <1){
            System.out.println("输入数据个数小于1，无法穿件单向环形链表");
        }
        if(first==null){
            first = new Boy(1, "kaishi");
            last=first;
            first.setNext(last);
        }
        //开始从第二个插入了
        for (int i = 2; i <=nums ; i++) {
            Boy boy = new Boy(i, String.valueOf(i));
            last.setNext(boy);
            last=last.getNext();// 将最后标示位 后移
        }
        last.setNext(first);
        return first;
    }

    public  void show(){
        //由于已经形成环形，此时需要临时变量
        Boy tmp=first;
        while (true){
            System.out.println(tmp);
            if (tmp.getNext()==first){
                break;
            }
            tmp=tmp.getNext();
        }
    }

    public void update(int num,Boy first,String s){
        Boy cur=first;
        while(true){
            if(cur.getNo()==num){
                cur.setName(s);
                break;
            }
            cur=cur.getNext();
            System.out.println("aaa"+cur.getNo());
        }
    }
    /**
     *
     * @param startNum 开始计数的位置
     * @param counts 每几次取出一个 即移动 counts-1 取出
     * @param nums   总共的个数
     */
    public void pop(int startNum,int counts,int nums){ //将数据弹出
        add(nums);
        //先找到位置,并将 first 位置指向此处
        while (first.getNo()!=startNum){
            first=first.getNext();
            last=last.getNext();
        }
        //
        while (true){
            if (last==first){
                System.out.println(first);
                break;
            }
            for (int i = 0; i <counts-1 ; i++) {
                first=first.getNext();
                last=last.getNext();
            }
            System.out.println(first);// 需要输出项
            first=first.getNext();
            last.setNext(first);
        }
    }


}
