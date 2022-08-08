package com.kevin.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/11/17 13:48
 */
public class TestList2 {

    public static void main(String[] args) {
        TestListBean testListBean = new TestListBean();
        testListBean.setCount(5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        testListBean.setList(list);
        System.out.println(testListBean.toString());
        List<Integer> list1 = testListBean.getList();
        list1 = new ArrayList<>();
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        testListBean.setList(list1);
        System.out.println(testListBean.toString());

    }

    static class TestListBean {
        private int count = 0;
        private List<Integer> list;

        public TestListBean() {
        }

        public TestListBean(int count, List<Integer> list) {
            this.count = count;
            this.list = list;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "TestListBean{" +
                    "count=" + count +
                    ", list=" + list +
                    '}';
        }
    }
}
