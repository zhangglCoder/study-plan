package cn.zpro.linked;

/**
 * 链表节点Node
 */
public class Node {

    private final int value;

    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLinked(Node head){
        while (head!=null){
            System.out.print(head.getValue()+"\t");
            head = head.getNext();
        }
    }
}
