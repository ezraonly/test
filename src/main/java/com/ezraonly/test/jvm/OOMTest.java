package com.ezraonly.test.jvm;

import com.ezraonly.test.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * 〈oom测试〉
 *  jvisualvm 装入dump文件查看内存溢出
 *
 * @Author:lwy
 * @Date: 2021/9/10 21:58
 */
public class OOMTest {

    public static List<Object> list = new ArrayList<>();
    // JVM设置  -Xms5M -Xmx5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User("aaaaaaaaaaaaabbbbbddddddddddddddddddddddddddddddddddddddddddaaaaaaaaaaaaaaaaabbbbbddddddddddddddddddddddddddddddddddddddddddaaabbbbbbbddddddddddddddddddddddddddddddddddddddddddbbbdddddddddddddddddddddddddddddddddddddddddd",111111));
            new User("bbbbbddddddddddddddddbbbbbdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddbbbbbddddddddddddddddddddddddddddddddddddddddddddddbbbbbdddddddddddddddddddddddddddddddddddddddddddddddbbbbbdddddddddddddddddddddddddddddddddddddddddd", 2222222);
        }
    }
}
