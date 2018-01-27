package cn.zpro.linked;

import java.util.Arrays;
import java.util.List;

/**
 * 创建链表类
 */
public class CreateLinkedNode {

    public static Node create(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        Node head = new Node(data.get(0));
        Node nextNode = create(data.subList(1, data.size()));
        head.setNext(nextNode);
        return head;
    }
    public static void main(String[] args) {
        Node.printLinked(create(Arrays.asList(1,2,2,3,4)));
    }
}
