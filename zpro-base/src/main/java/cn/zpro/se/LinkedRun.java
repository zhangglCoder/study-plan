package cn.zpro.se;

import java.util.Arrays;
import java.util.List;

public class LinkedRun {

    /**
     * 创建链表
     * @param data 数据列表
     * @return
     */
    private static Node createLink(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        Node firstNode = new Node(data.get(0));
        Node nextNode = createLink(data.subList(1, data.size()));
        firstNode.setNext(nextNode);
        return firstNode;
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    private static Node reverseLink(Node head){
        //1 2 3 4 5
        if(head == null || head.getNext()==null){
            return head;
        }
        //5 4 3 2
        Node newLink = reverseLink(head.getNext());
        //2 -> 1 -> null
        head.getNext().setNext(head);
        head.setNext(null);
        return newLink;
    }



    public static void main(String[] args) {
        Node link = createLink(Arrays.asList(1,2,3,4,5));
        link.print(link);
        Node reverseLink = reverseLink(link);
        reverseLink.print(reverseLink);
    }
}
