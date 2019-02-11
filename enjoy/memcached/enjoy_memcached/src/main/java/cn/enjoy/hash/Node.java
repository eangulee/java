package cn.enjoy.hash;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by VULCAN on 2019/1/8.
 */
public class Node {

    private String ip;
    private String hostName;

    private Map<String,String> map = new TreeMap<>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Node(String ip, String hostName) {
        this.ip = ip;
        this.hostName = hostName;
    }

    public Node() {
    }

    public String getCacheValue(String key) {
        return map.get(key);
    }

    public  void cacheString(String key,String value) {
         map.put(key, value);
    }
}
