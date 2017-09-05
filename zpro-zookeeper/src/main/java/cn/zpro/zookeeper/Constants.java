package cn.zpro.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Constants {
    public static final String CONNECTION = "116.196.94.14:2181";
    public static CuratorFramework curatorFramework;

    public static CuratorFramework getInstance() throws Exception {
        curatorFramework = CuratorFrameworkFactory.newClient(CONNECTION, 5000, 5000, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        return curatorFramework;
    }
}
