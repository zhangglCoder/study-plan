package cn.zpro.zookeeper.curator;


import cn.zpro.zookeeper.Constants;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * 创建节点和事件机制
 */
public class CrudNodesDemo {

    private CuratorFramework curatorFramework;

    public CuratorFramework getCuratorFramework() {
        return curatorFramework;
    }

    public void setCuratorFramework(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    public static void main(String[] args) throws Exception {
        CrudNodesDemo crudNodesDemo = new CrudNodesDemo();
        //crudNodesDemo.create();
        //crudNodesDemo.update();
        nodeCache(crudNodesDemo.getCuratorFramework());
    }

    public CrudNodesDemo() {
        try {
            this.curatorFramework = Constants.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建临时节点
     */
    public void create(){
        try {
            String path = curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/zhanggl-temp","123".getBytes());
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建持久化节点
     */
    public void create2(){
        try {
            String path = curatorFramework.create().forPath("/zhanggl");
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改节点数据
     */
    public void update(){
        try {
            curatorFramework.setData().forPath("/zhanggl","456".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 节点数据变更事件
     * @param curatorFramework
     * @throws Exception
     */
    static void nodeCache(CuratorFramework curatorFramework) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework, "/zhanggl", false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点数据变更=" + new String(nodeCache.getCurrentData().getData()));
            }
        });
        curatorFramework.setData().forPath("/zhanggl","我改的".getBytes());
        System.in.read();
    }

    /**
     * 节点变更事件
     * @param curatorFramework
     * @throws Exception
     */
    static void pathCache(CuratorFramework curatorFramework)throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework,"/event",true);
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                switch (pathChildrenCacheEvent.getType()){
                    case CHILD_ADDED:
                        System.out.println("增加子节点");
                        break;
                    case CHILD_REMOVED:
                        System.out.println("删除子节点");
                        break;
                    case CHILD_UPDATED:
                        System.out.println("更新子节点");
                        break;
                    default:break;
                }
            }
        });
        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/event","event".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/event/event1","1".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");

        curatorFramework.setData().forPath("/event/event1","222".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3");

        curatorFramework.delete().forPath("/event/event1");
        System.out.println("4");

        System.in.read();
    }
}
