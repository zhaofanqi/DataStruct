package zhaofanqi.sourcecode8.utils.daily_review;

import java.util.Observable;

/**
 * �۲���ģʽ��(�������Ϊ��������)������Ҳ����source
 *          �۲��ߣ�Observer
 *          ��Ҫ�۲����Դ:Observable
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
