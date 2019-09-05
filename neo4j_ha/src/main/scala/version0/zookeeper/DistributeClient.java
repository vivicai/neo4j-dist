package version0.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import scala.collection.LinearSeq;
import scala.collection.mutable.ArrayBuffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {
    private static String connectString = "192.168.49.10:2181,192.168.49.11:2181,192.168.49.12:2181";
    private static int sessionTimeout = 3000;
    private ZooKeeper zk = null;
    private String parentNode = "/servers";

    public void getConnect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, event -> {

        });
    }

    public ArrayList<String> getChildren() throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren(parentNode, true);
        ArrayList<String> hosts = new ArrayList<>();
        for (String child: children) {
            byte[] data = zk.getData(parentNode + "/" + child, false, null);
            hosts.add(new String(data));
        }
        zk.close();
        return hosts;
    }

}