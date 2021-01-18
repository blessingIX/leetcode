package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 705. 设计哈希集合
 * @author: blessing
 * @create: 2021-01-18 15:29
 */
public class Question705 {
//    https://leetcode-cn.com/problems/design-hashset/
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // 返回 true
        System.out.println(hashSet.contains(3));    // 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // 返回  false (已经被删除)

        MyHashSetByte hashSetByte = new MyHashSetByte();
        hashSetByte.add(1);
        hashSetByte.add(2);
        System.out.println(hashSetByte.contains(1));    // 返回 true
        System.out.println(hashSetByte.contains(3));    // 返回 false (未找到)
        hashSetByte.add(2);
        System.out.println(hashSetByte.contains(2));    // 返回 true
        hashSetByte.remove(2);
        System.out.println(hashSetByte.contains(2));    // 返回  false (已经被删除)
    }
}

class MyHashSet {
    boolean[] hashSet = null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// 参考提交记录中执行消耗内存为 44448kb 的范例
// 使用 1000 * 1000 的byte数组来标记存储的元素（1为存在，0为不存在）
// 使用 arr[key / 1000][key % 1000] 来定位元素（达到题目O(1)时间复杂度的要求）
class MyHashSetByte {
    byte[][] arr;

    /**
     * Initialize your data structure here.
     */
    public MyHashSetByte() {
        arr = new byte[1000][0];
    }

    public void add(int key) {
        int row = key / 1000;
        int col = key % 1000;
        if (arr[row].length == 0) {
            arr[row] = new byte[1000];
        }
        arr[row][col] = 1;
    }

    public void remove(int key) {
        int row = key / 1000;
        int col = key % 1000;
        if (arr[row].length != 0) {
            arr[row][col] = 0;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int row = key / 1000;
        int col = key % 1000;
        if (arr[row].length == 0) {
            return false;
        }
        return arr[row][col] == 1;
    }
}
