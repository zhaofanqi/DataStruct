package zhaofanqi.exercise.search;


/**
 * 缓存或者说是不使用数据库的情况下 提高检索速度， 可以使用缓存产品或者是自己手写  数组+二叉树   数组+链表
 * 数组中的每个元素都是一个链表，每个链表有会有一个个节点元素
 */
public class HashSearch {
    public static void main(String[] args) {
        TempNode node = new TempNode(1, "zzz");
        TempNode node2 = new TempNode(2, "fff");
        HashTab hashTab = new HashTab(10);
        hashTab.add(node);
        hashTab.add(node2);
        hashTab.list();
    }
}


class HashTab {
    //HashTab就是 多个 LinkedList组成的数组，实际存储是在LinkedList 中，但是会由 HashTab实际决定去哪个数组中
    private LinkedList[] arrLinkedList;
    // 数组的大小
    private int maxSize;

    public HashTab(int maxSize) {
        this.maxSize = maxSize;
        this.arrLinkedList = new LinkedList[maxSize];
        // arrLinkedList = new LinkedList[maxSize];
    }

    // 用于确定每个节点元素加入到哪个链表中
    public int hashFun(TempNode node) {
        return node.getId() % this.maxSize;
    }

    public void add(TempNode node) {
        int linkIndex = hashFun(node);
        System.out.println("start execute add");
        if (null == arrLinkedList[linkIndex]) {
            arrLinkedList[linkIndex] = new LinkedList();
            arrLinkedList[linkIndex].add(node);
        } else {
            arrLinkedList[linkIndex].add(node);
        }

    }


    public void list() {
        for (int i = 0; i < maxSize; i++) {
            if (!(null == arrLinkedList[i])) {
                System.out.println("开始遍历第 " + i + "\t条链表");
                arrLinkedList[i].list();
            }
        }
    }

}


/**
 * 这是数组中的一个元素，也就是一个链表；
 * 既然是链表就会有增 删 是否满，是否空 这些基础判断
 */
class LinkedList {
    private TempNode head;

    public void add(TempNode node) {
        if (head == null) {
            head = node;
            return;
        }
        //得到最后一个节点，并添加
        TempNode curNode = head;
        while (true) {
            if (null == curNode.getNext()) {
                break;
            }
            curNode = curNode.getNext();
        }
        curNode.setNext(node);
        //  head = curNode;
    }

    //查看链表中数据
    public void list() {
        if (null == head) {
            System.out.println(" head is null !!");
            return;
        }
        TempNode curNode = head;
        while (true) {
            System.out.printf("=>id =%d \t name=%s \t\n", curNode.getId(), curNode.getName());
            if (null == curNode.getNext()) {
                break;
            }
            curNode = curNode.getNext();
        }
    }


}


/**
 * 节点的资源类
 */
class TempNode {
    private int id;
    private String name;
    private TempNode next;

    public TempNode(int id, String name) {
        this.next = null;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TempNode getNext() {
        return next;
    }

    public void setNext(TempNode next) {
        this.next = next;
    }
}


