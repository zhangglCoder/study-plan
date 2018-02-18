package cn.zpro.tree;


import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {

    static List<TreeNode> data = new ArrayList<>();

    public static void main(String[] args) {
        setData();
        TreeUtil treeUtil = new TreeUtil(data);
        TreeNode treeNode = treeUtil.generateTreeNode(1);
        System.out.println(treeNode);
//        TreeNode treeNodes = test2();
//        System.out.println(treeNodes);

    }

    /**
     * 循环的方式实现
     * @return
     */
    private static TreeNode test2() {
        TreeNode tree = new TreeNode();
        for (TreeNode node1 : data) {
            boolean mark = false;
            for (TreeNode node2 : data) {
                if (node1.getPid() != null && node1.getPid().equals(node2.getId())) {
                    mark = true;
                    node2.getNodes().add(node1);
                    break;
                }
            }
            if (!mark) {
                tree = node1;
            }
        }
        return tree;
    }

    private static void setData() {
        TreeNode o1 = new TreeNode();
        o1.setId(1);
        o1.setCname("一级组织");
        o1.setPid(0);

        TreeNode o2 = new TreeNode();
        o2.setId(2);
        o2.setCname("二级组织");
        o2.setPid(1);

        TreeNode o3 = new TreeNode();
        o3.setId(3);
        o3.setCname("三级组织");
        o3.setPid(1);

        TreeNode o4 = new TreeNode();
        o4.setId(4);
        o4.setCname("331");
        o4.setPid(3);

        TreeNode o5 = new TreeNode();
        o5.setId(5);
        o5.setCname("332");
        o5.setPid(3);

        TreeNode o6 = new TreeNode();
        o6.setId(6);
        o6.setCname("3320001");
        o6.setPid(5);

        data.add(o1);
        data.add(o2);
        data.add(o3);
        data.add(o4);
        data.add(o5);
        data.add(o6);
    }
}