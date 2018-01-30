package cn.zpro.linked;

import java.util.Arrays;

/**
 * 链表的反转类
 */
public class ReserseLinkNode {

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
    public static void main(String[] args) {
        Node node = CreateLinkedNode.create(Arrays.asList(1, 2, 3, 4, 5));
        Node reserseLink = reserseLink(node);
        Node.printLinked(reserseLink);
    }
}
