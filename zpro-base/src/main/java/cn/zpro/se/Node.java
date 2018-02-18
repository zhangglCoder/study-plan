package cn.zpro.se;

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

    public void print(Node head){
        while (head!=null){
            System.out.print(head.getValue()+"\t");
            head = head.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2==str1);
    }
}
