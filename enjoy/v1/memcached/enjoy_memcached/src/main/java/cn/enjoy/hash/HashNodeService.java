package cn.enjoy.hash;

/**
 * Created by VULCAN on 2019/1/8.
 */
public interface HashNodeService {

    /**
     * 集群增加一个数据存储节点
     * @param node
     */
    public void addNode(Node node);

    /**
     * 数据存储时查找具体使用哪个节点来存储
     * @param key
     * @return
     */
    public Node lookupNode(String key);

    /**
     * hash的算法
     * @param key
     * @return
     */
    public Long hash(String key);

    /**
     * 模拟意外情况断掉一个节点，用于测试缓存命中率
     * @param node
     */
    public void removeNodeUnexpected(Node node);
}

