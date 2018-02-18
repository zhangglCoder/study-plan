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
        Node head = null;
        Node child = null;
        for (int i=0;i<data.size();i++){
            Node node = new Node(data.get(i));
            if(child!=null){
                child.setNext(node);
            }else {
                head = node;
            }
            child = node;
        }
        return head;
    }
    public static void main(String[] args) {
        Node.printLinked(create2(Arrays.asList(1,2,3,4,5,100)));

    }
}
