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

    /**
     * 循环的方式
     * @param data
     * @return
     */
    public static Node create2(List<Integer> data){
        Node head = new Node(data.get(0));

        for (Integer i :data){

        }
        return head;
    }
    public static void main(String[] args) {
        Node.printLinked(create2(Arrays.asList(1,2,3,4,5)));
    }
}
