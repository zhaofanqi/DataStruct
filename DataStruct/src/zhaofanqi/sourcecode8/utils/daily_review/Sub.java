package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.Observable;
import java.util.Observer;

public class Sub implements Observer {

    //�˷����е�Observable ������Դ����������Դ�����仯ʱ����Ҫ��ȡ�Ķ���
    @Override
    public void update(Observable o, Object arg) {
        Pub p1 = (Pub) o;
        System.out.println("data  has been changed to : " + p1.getData());
        //��ʱ�� hasChanged()�Ѿ��� false ��
        //System.out.println(pub.hasChanged());
    }

    public static void main(String[] args) {
        Pub pub = new Pub();
        pub.addObserver(new Sub());
        pub.setData(10);
    }
}
