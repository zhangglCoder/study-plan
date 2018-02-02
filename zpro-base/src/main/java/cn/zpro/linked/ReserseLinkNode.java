package cn.zpro.linked;

import java.util.Arrays;

/**
 * 链表的反转类
 */
public class ReserseLinkNode {

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static Node reserseLink(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }
        //从第二个节点开始反转
        Node reserseLink = reserseLink(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reserseLink;

    }

    /**
     * 循环实现
     *
     *  1 2 3 4 5 null
     *
     *  5 4 3 2 1 null
     *
     * @param head
     * @return
     */
    public static Node reserseLink2(Node head){
        Node newHead = null;
        Node currentHead = head;

        while (currentHead!=null){
            Node next = currentHead.getNext();
            currentHead.setNext(newHead);
            newHead = currentHead;
            currentHead = next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        Node node = CreateLinkedNode.create(Arrays.asList(1, 2, 3, 4, 5));
        Node reserseLink = reserseLink2(node);
        Node.printLinked(reserseLink);
    }
}
