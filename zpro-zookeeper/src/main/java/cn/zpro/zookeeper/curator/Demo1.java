package cn.zpro.zookeeper.curator;

import cn.zpro.zookeeper.Constants;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Demo1 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        try (CuratorFramework curatorFramework = Constants.getInstance()) {
            List<String> strings = curatorFramework.getChildren().forPath("/");
            for (String res : strings) {
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
