package com.kevin.util;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-11-08 17:52:40
 **/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {
    public static <T> List<T> findCommonElements(List<T> list1, List<T> list2) {
        List<T> commonElements = new ArrayList<>();
        Set<T> set1 = new HashSet<>(list1);
        for (T item1 : list2) {
            if (set1.contains(item1)) {
                commonElements.add(item1);
            }
        }
        return commonElements;
    }
}

