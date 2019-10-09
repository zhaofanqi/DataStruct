package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.Observable;
import java.util.Observer;

public class Sub implements Observer {

    //此方法中的Observable 就是资源，即当该资源发生变化时，需要采取的动作
    @Override
    public void update(Observable o, Object arg) {
        Pub p1 = (Pub) o;
        System.out.println("data  has been changed to : " + p1.getData());
        //此时的 hasChanged()已经是 false 了
        //System.out.println(pub.hasChanged());
    }

    public static void main(String[] args) {
        Pub pub = new Pub();
        pub.addObserver(new Sub());
        pub.setData(10);
    }
}
