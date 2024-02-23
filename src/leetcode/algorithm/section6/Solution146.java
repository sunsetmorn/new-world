package leetcode.algorithm.section6;

import java.util.*;

/**
 * @author zhaoxq
 * @ClassName Solution146
 * @description: LRU缓存
 * @date 2024年02月19日
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

/**
 * 存储结构，按照使用时间排序，最近使用的排在最前面，存储满了之后从最后面开始删除
 * 按照使用时间排序列表
 * 按照存储信息有个map
 *
 */
public class Solution146 {
    static class LRUCache {
        class LRUNode{
            int key;
            int value;
            LRUNode pre;
            LRUNode next;
            public LRUNode(){}
            public LRUNode(int key,int value){
                this.key = key;
                this.value =value;
            }
        }

        List<Integer> cache;
        private Map<Integer, LRUNode> map = new HashMap<>();
        private int size;
        private int capacity;
        private LRUNode head,tail;

        public LRUCache(int capacity) {
            size = 0;
            this.capacity = capacity;
            head = new LRUNode();
            tail = new LRUNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            LRUNode node = map.get(key);
            if(node == null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LRUNode node = map.get(key);
            if(node == null){
                LRUNode node1 = new LRUNode(key, value);
                addToHead(node1);
                map.put(key,node1);
                size++;
                if(size > capacity){
                    LRUNode res = removeTail();
                    map.remove(res.key);
                    size--;
                }
            } else{
                node.value = value;
                moveToHead(node);
            }
        }

        public void addToHead(LRUNode node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void remove(LRUNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public LRUNode removeTail(){
            LRUNode pre = tail.pre;
            remove(pre);
            return pre;
        }

        public void moveToHead(LRUNode node){
            remove(node);
            addToHead(node);
        }
    }
}
