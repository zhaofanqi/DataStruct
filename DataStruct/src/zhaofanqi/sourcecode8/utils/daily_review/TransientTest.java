package zhaofanqi.sourcecode8.utils.daily_review;

import java.io.*;

/**
 * Transient 关键字修饰的属性,在对象序列化/反序列化之后,该属性的值为 null
 */
public class TransientTest implements Serializable {

    private String filed_1;
    private transient String filed_2;

    public TransientTest(String filed_1, String filed_2) {
        this.filed_1 = filed_1;
        this.filed_2 = filed_2;
    }

    public String getFiled_1() {
        return filed_1;
    }

    public void setFiled_1(String filed_1) {
        this.filed_1 = filed_1;
    }

    public String getFiled_2() {
        return filed_2;
    }

    public void setFiled_2(String filed_2) {
        this.filed_2 = filed_2;
    }

    @Override
    public String toString() {
        return String.format("filed=%s ,filed_2=%s",filed_1,filed_2);
    }

    //  写出到文件在读取文件中内容，注意写入文件之前需要给对象赋值，再查看反序列化的时候，对应的对象内容是否发生变动
    public static void main(String[] args) {
        TransientTest transientTest = new TransientTest("属性一", "transient修饰属性");
        //写出到文件：
        try {
            System.out.println("序列化之前 ： "+transientTest.toString());
            String path = "E:\\workspace\\personexercise\\DataStruct\\object.txt";
            ObjectOutputStream oous = new ObjectOutputStream(new FileOutputStream(path));
            oous.writeObject(transientTest);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            TransientTest test = (TransientTest)ois.readObject();
            System.out.println("序列化之后 ： "+test.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
