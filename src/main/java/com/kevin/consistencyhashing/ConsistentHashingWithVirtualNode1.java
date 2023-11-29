package com.kevin.consistencyhashing;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-13 14:48:51
 **/

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 带虚拟节点的一致性Hash算法
 */
public class ConsistentHashingWithVirtualNode1 {
    //待添加入Hash环的服务器列表
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    //真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
    private static List<String> realNodes = new LinkedList<String>();

    //虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
    private static SortedMap<Long, String> virtualNodes = new TreeMap<Long, String>();

    //虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
    private static final int VIRTUAL_NODES = 5;

    static {
        //先把原始的服务器添加到真实结点列表中
        for (int i = 0; i < servers.length; i++)
            realNodes.add(servers[i]);

        //再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                Long hash = getHash1(virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
        System.out.println();
    }

    //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    /**
     * get hash code on 2^32 ring (md5散列的方式计算hash值)
     *
     * @param key
     * @return
     */
    private static long getHash1(String key) {
        // md5 byte
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes = null;
        try {
            keyBytes = key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unknown string :" + key, e);
        }
        md5.update(keyBytes);
        byte[] digest = md5.digest();
        // hash code, Truncate to 32-bits
        long hashCode = ((long) (digest[3] & 0xFF) << 24) | ((long) (digest[2] & 0xFF) << 16) | ((long) (digest[1] & 0xFF) << 8) | (digest[0] & 0xFF);
        return hashCode & 0xffffffffL;
    }

    //得到应当路由到的结点
    private static String getServer(String key) {
        //得到该key的hash值
        int hash = getHash(key);
        // 得到大于该Hash值的所有Map
        SortedMap<Long, String> subMap = virtualNodes.tailMap(Long.parseLong(hash+""));
        String virtualNode;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            //返回对应的服务器
            virtualNode = virtualNodes.get(virtualNodes.firstKey());
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            //返回对应的服务器
            virtualNode = subMap.get(subMap.firstKey());
        }
        //virtualNode虚拟节点名称要截取一下
        if (StringUtils.isNotBlank(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    //得到应当路由到的结点
    private static String getServer1(String key) {
        //得到该key的hash值
        long hash = getHash1(key);
        // 得到大于该Hash值的所有Map
        SortedMap<Long, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            //返回对应的服务器
            virtualNode = virtualNodes.get(virtualNodes.firstKey());
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            //返回对应的服务器
            virtualNode = subMap.get(subMap.firstKey());
        }
        //virtualNode虚拟节点名称要截取一下
        if (StringUtils.isNotBlank(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    public static void main(String[] args) {
        String[] keys = {"太阳", "月亮", "星星"};
        for (int i = 0; i < keys.length; i++) {
            System.out.println("[" + keys[i] + "]的hash值为" +
                    getHash(keys[i]) + ", 被路由到结点[" + getServer(keys[i]) + "]");
            System.out.println("-------------------------------------------------");
            System.out.println("[" + keys[i] + "]的hash值为" +
                    getHash1(keys[i]) + ", 被路由到结点[" + getServer1(keys[i]) + "]");
            System.out.println("=====================================");
        }
    }

}
