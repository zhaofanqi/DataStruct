package zhaofanqi.sourcecode8.utils.daily_review;

import java.io.*;

/**
 * Transient �ؼ������ε�����,�ڶ������л�/�����л�֮��,�����Ե�ֵΪ null
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

    //  д�����ļ��ڶ�ȡ�ļ������ݣ�ע��д���ļ�֮ǰ��Ҫ������ֵ���ٲ鿴�����л���ʱ�򣬶�Ӧ�Ķ��������Ƿ����䶯
    public static void main(String[] args) {
        TransientTest transientTest = new TransientTest("����һ", "transient��������");
        //д�����ļ���
        try {
            System.out.println("���л�֮ǰ �� "+transientTest.toString());
            String path = "E:\\workspace\\personexercise\\DataStruct\\object.txt";
            ObjectOutputStream oous = new ObjectOutputStream(new FileOutputStream(path));
            oous.writeObject(transientTest);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            TransientTest test = (TransientTest)ois.readObject();
            System.out.println("���л�֮�� �� "+test.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
