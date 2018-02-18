package cn.zpro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree解析工具类
 *
 * @author zhanggl
 * @version 1.0
 */
public class TreeUtil {

    private List<TreeNode> treeNodeList = new ArrayList<>();

    public TreeUtil(List<TreeNode> list) {
        treeNodeList = list;
    }

    /**
     * 根据节点ID查询节点信息
     * @param nodeId
     * @return
     */
    public TreeNode getNodeById(int nodeId) {
        TreeNode treeNode = new TreeNode();
        for (TreeNode item : treeNodeList) {
            if (item.getId() == nodeId) {
                treeNode = item;
                break;
            }
        }
        return treeNode;
    }

    /**
     * 根据当前节点ID查询子节点对象
     * @param nodeId 当前节点ID
     * @return
     */
    public List<TreeNode> getChildrenNodeById(int nodeId) {
        List<TreeNode> childrenTreeNode = new ArrayList<>();
        for (TreeNode item : treeNodeList) {
            if (item.getPid() == nodeId) {
                childrenTreeNode.add(item);
            }
        }
        return childrenTreeNode;
    }

    /**
     * 递归生成Tree结构数据
     *
     * @param rootId 根节点的ID
     * @return
     */
    public TreeNode generateTreeNode(int rootId) {
        TreeNode root = this.getNodeById(rootId);
        List<TreeNode> childrenTreeNode = this.getChildrenNodeById(rootId);
        for (TreeNode item : childrenTreeNode) {
            TreeNode node = this.generateTreeNode(item.getId());
            root.getNodes().add(node);
        }
        return root;
    }
}