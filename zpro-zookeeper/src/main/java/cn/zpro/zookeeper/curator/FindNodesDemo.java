package cn.zpro.zookeeper.curator;


import cn.zpro.zookeeper.Constants;
import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/**
 * 查询节点和遍历节点
 */
public class FindNodesDemo {

    public static void main(String[] args) {
        //findNodesByPath("/");
        findNodesData("/zhanggl");
    }

    /**
     * 查询子节点
     */
    public static void findNodesByPath(String path){
        try (CuratorFramework curatorFramework = Constants.getInstance()) {
            List<String> strings = curatorFramework.getChildren().forPath(path);
            for (String res : strings) {
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询节点数据
     */
    public static void findNodesData(String path){
        try (CuratorFramework curatorFramework = Constants.getInstance()) {
            System.out.println(new String(curatorFramework.getData().forPath(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
