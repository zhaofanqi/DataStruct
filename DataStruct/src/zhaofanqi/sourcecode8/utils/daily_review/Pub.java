package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.Observable;

/**
 * 观察者模式：(可以理解为发布订阅)发布滴也就是source
 *          观察者：Observer
 *          需要观察的资源:Observable
 */
public class Pub extends Observable {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        setChanged();
        notifyObservers();
    }
}
