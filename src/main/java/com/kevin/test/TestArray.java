package com.kevin.test;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2021-08-12 16:00:41
 **/
public class TestArray {
    // An highlighted block
    public static void main(String[] args) {
        int[] s1 = new int[4];
        int[] s2 = new int[4];
        s1[0] = 1;
        s1[1] = 13;
        s1[2] = 16;
        s1[3] = 20;

        s2[0] = 2;
        s2[1] = 8;
        s2[2] = 12;
        s2[3] = 27;
        for (int i = 1; i < 9; i++) {
            System.out.println(i + "结果：" + newFind(i, s1, s2));
        }
    }

    private static int newFind(int k, int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;
        int kval = 0;
        int val = 0;//每一个数组的值(第一次循环)
        int ab = 0;//每一个数组的值(第二次循环)

        for (int i = 0; i < (al + bl); i++) {
            if (i < al) {
                val = a[i];
            } else {
                val = b[i - al];
            }
            int bigger = 0;//有几个数比K的值大
            int smaller = 0;//有几个数比K的值小
            int equal = 0;//相等的数有几个
            for (int j = 0; j < (al + bl); j++) {
                if (j < al) {
                    ab = a[j];
                } else {
                    ab = b[j - al];
                }
                if (val > ab) {
                    smaller++;
                } else if (val < ab) {
                    bigger++;
                } else {
                    equal++;
                }
            }
            //System.out.println("k="+k+","+val+"的比较结果：smaller="+smaller+",bigger="+bigger+",equal="+equal);
            if (0 < k - smaller && k - smaller <= equal) {
                kval = val;
            }
        }

        return kval;
    }
}
