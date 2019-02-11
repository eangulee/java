package cn.enjoy.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

/**
 * Created by VULCAN on 2019/1/8.
 */
public class NormalHashNodeServiceImpl implements HashNodeService{

    /**
     * 存储节点列表
     */
    private List<Node> nodes = new ArrayList<>();

    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
    }
    @Override
    public Node lookupNode(String key) {
        long k = hash(key);
        int index = (int) (k % nodes.size());
        return nodes.get(index);
    }
    @Override
    public Long hash(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        return crc32.getValue();
    }
    @Override
    public void removeNodeUnexpected(Node node) {
        nodes.remove(node);
    }
}

