package LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;

// 参考：https://mp.weixin.qq.com/s/oXv03m1J8TwtHwMJEZ1ApQ
class LFUCache {
    // 记录key对应的value
    HashMap<Integer, Integer> keyToVal;
    // 记录key对应的使用频率
    HashMap<Integer, Integer> keyToFreq;
    // 使用频率对应的key列表
    // LinkedHashSet是链表和哈希集合的结合体。
    // 链表不能快速访问链表节点，但是插入元素具有时序；
    // 哈希集合中的元素无序，但是可以对元素进行快速的访问和删除。
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int size;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
        size = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;
        // 增加key对应的freq
        increaseFreq(key);
        return  keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (size <= 0)
            return;
        if (keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        // 容量满，删除最小频率最先put的key
        if(keyToVal.size() >= size){
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);

        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }
    public void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq+1);
        // 删掉原来频率下的key
        freqToKeys.get(freq).remove(key);
        // 增加新频率的keyLists
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>());
        // 把key放到新频率下
        freqToKeys.get(freq+1).add(key);
        if (freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if (minFreq == freq)
                minFreq++;
        }
    }
    public void removeMinFreqKey(){
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        // 得到要删除的key
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        if (keyList.isEmpty())
            freqToKeys.remove(minFreq);
            // 移走完不需要更新minFreq的原因是因为removeMinFreqKey是在put操作里面执行的
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */