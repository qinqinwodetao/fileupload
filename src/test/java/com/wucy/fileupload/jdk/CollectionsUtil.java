package com.wucy.fileupload.jdk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsUtil {

    private final static int LIST_SIZE = 10000;

    public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < LIST_SIZE; i++)
        {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++)
        {
            arrayList.get(i);
        }
        System.out.println("ArrayList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++)
        {
            linkedList.get(i);
        }
        System.out.println("普通LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (Integer i : linkedList)
        {
            i.toString();
        }

        System.out.println("增强性for 循环及 Iterator LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");





    }



}
