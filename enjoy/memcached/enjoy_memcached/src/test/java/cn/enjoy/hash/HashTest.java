package cn.enjoy.hash;

import cn.enjoy.hash.HashNodeService;
import cn.enjoy.hash.Node;
import cn.enjoy.hash.NormalHashNodeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VULCAN on 2019/1/8.
 */
public class HashTest {

    private HashNodeService nodeService;

    @Before
    public void init() {
        nodeService= new NormalHashNodeServiceImpl();
        Node addNode1 = new Node("node1", "192.168.0.11");
        Node addNode2 = new Node("node2", "192.168.0.12");
        Node addNode3 = new Node("node3", "192.168.0.13");
        Node addNode4 = new Node("node4", "192.168.0.14");
        Node addNode5 = new Node("node5", "192.168.0.15");
        Node addNode6 = new Node("node6", "192.168.0.16");
        Node addNode7 = new Node("node7", "192.168.0.17");
        Node addNode8 = new Node("node8", "192.168.0.18");
        nodeService.addNode(addNode1);
        nodeService.addNode(addNode2);
        nodeService.addNode(addNode3);
        nodeService.addNode(addNode4);
        nodeService.addNode(addNode5);
        nodeService.addNode(addNode6);
        nodeService.addNode(addNode7);
        nodeService.addNode(addNode8);
    }

    /**
     * 普通的hash算法
     */
    @Test
    public void test1() {

        //用于检查数据分布情况
        Map<String, Integer> countmap = new HashMap<>();
        Node node = null;
        for (int i = 1; i <= 100000; i++) {
            String key = String.valueOf(i);
            node = nodeService.lookupNode(key);
            node.cacheString(key, "TEST_VALUE");
            String k = node.getIp();
            Integer count = countmap.get(k);
            if (count == null) {
                count = 1;
                countmap.put(k, count);
            } else {
                count++;
                countmap.put(k, count);
            }

        }
        System.out.println("初始化数据分布情况：" + countmap);

    }

    @Test
    public void test2() {
//用于检查数据分布情况
        Map<String, Integer> countmap = new HashMap<>();
        Node node = null;
        for (int i = 1; i <= 100000; i++) {
            String key = String.valueOf(i);
            node = nodeService.lookupNode(key);
            node.cacheString(key, "TEST_VALUE");
            String k = node.getIp();
            Integer count = countmap.get(k);
            if (count == null) {
                count = 1;
                countmap.put(k, count);
            } else {
                count++;
                countmap.put(k, count);
            }

        }
        System.out.println("初始化数据分布情况：" + countmap);
// 正常情况下的去获取数据，命中率
        int hitcount = 0;
        for (int i = 1; i <= 100000; i++) {
            String key = String.valueOf(i);
            node = nodeService.lookupNode(key);
            if (node != null) {
                String value = node.getCacheValue(key);
                if (value != null) {
                    hitcount++;
                }
            }
        }
        double h = Double.parseDouble(String.valueOf(hitcount))/ Double.parseDouble(String.valueOf(100000));
        System.out.println("初始化缓存命中率:"+ h);

        Node addNode9 = new Node("node9", "192.168.0.19");
        nodeService.addNode(addNode9);
        hitcount = 0;
        for (int i = 1; i <= 100000; i++) {
            String key = String.valueOf(i);
            node = nodeService.lookupNode(key);
            if (node != null) {
                String value = node.getCacheValue(key);
                if (value != null) {
                    hitcount++;
                }
            }
        }
        h = Double.parseDouble(String.valueOf(hitcount))/ Double.parseDouble(String.valueOf(100000));
        System.out.println("增加一个节点后缓存命中率:"+ h);

    }



}
