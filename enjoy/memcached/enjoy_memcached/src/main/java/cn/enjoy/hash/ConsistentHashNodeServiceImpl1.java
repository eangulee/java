package cn.enjoy.hash;

import java.util.*;
import java.util.zip.CRC32;

/**
 * Created by VULCAN on 2019/1/8.
 */
public class ConsistentHashNodeServiceImpl1 implements HashNodeService {
    /**
     * 存储节点列表
     */
    private List<Node> nodeList = new ArrayList<>();

    /**
     * 节点环
     */
    private Map<Long,Node> nodeMap = new TreeMap();

    @Override
    public void addNode(Node node) {
        nodeList.add(node);
        long crcKey = hash(node.getIp());
        nodeMap.put(crcKey, node);
    }

    @Override
    public Node lookupNode(String key) {
        long crcKey = hash(key);
        Node node = findValidNode(crcKey);
        if(node == null){
            return findValidNode(0);
        }
        return node;
    }

    /**
     * @param crcKey
     */
    private Node findValidNode(long crcKey) {
        Set<Map.Entry<Long, Node>> entrySet = nodeMap.entrySet();
//顺时针找到最近的一个节点
        for(Map.Entry<Long, Node> entry : entrySet){
            long k = entry.getKey();
            if(crcKey <= k){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Long hash(String key) {
        CRC32 crc = new CRC32();
        crc.update(key.getBytes());
        return crc.getValue();
    }

    @Override
    public void removeNodeUnexpected(Node node) {
        nodeList.remove(node);
        Long hash = hash(node.getIp());
        nodeMap.remove(hash,node);
    }


}
