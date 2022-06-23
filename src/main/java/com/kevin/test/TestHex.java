package com.kevin.test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * @Author: LWS
 * @Date: 2021/1/7 17:47
 */
public class TestHex {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入十六进制数 ：");
//        String hexStr = sc.next();
//        String hexStr = "5A5";
        String hexStr = "0A5";

//        Integer num = Integer.parseInt(hexStr, 16);
//        System.out.println("num===" + num);
//        String binaryString = Integer.toBinaryString(num);
        String binaryString = hexToBinary(hexStr);
        int mid = binaryString.length() / 2;
        String s1 = binaryString.substring(0, mid);
        String s2 = binaryString.substring(mid);
        System.out.println(binaryString);
        System.out.println(s1);
        System.out.println(s2);
        int dec1 = Integer.parseInt(s1, 2);
        int dec2 = Integer.parseInt(s2, 2);
        System.out.println(dec1 + "-" + dec2);

        String diskName = getDiskName("00A");
        System.out.println("测试16进制转10进制：" + diskName);
        System.out.println(Integer.parseInt("040", 16));
//        sc.close();

        String diskIndex = StringUtils.substringAfterLast("21AA", "21AA");
        System.out.println(diskIndex);
        System.out.println(diskIndex.isEmpty());
    }

    // declaring the method to convert
    // Hexadecimal to Binary
    private static String hexToBinary(String hex) {

        // variable to store the converted
        // Binary Sequence
        String binary = "";

        // converting the accepted Hexadecimal
        // string to upper case
        hex = hex.toUpperCase();

        // initializing the HashMap class
        HashMap<Character, String> hashMap
                = new HashMap<Character, String>();

        // storing the key value pairs
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");

        int i;
        char ch;

        // loop to iterate through the length
        // of the Hexadecimal String
        for (i = 0; i < hex.length(); i++) {
            // extracting each character
            ch = hex.charAt(i);

            // checking if the character is
            // present in the keys
            if (hashMap.containsKey(ch)) {

                // adding to the Binary Sequence
                // the corresponding value of
                // the key
                binary += hashMap.get(ch);

                // returning Invalid Hexadecimal
                // String if the character is
                // not present in the keys
            }
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }

        // returning the converted Binary
        return binary;
    }

    /**
     * 根据错误码获取磁盘名称
     *
     * @param errorCode
     * @return
     */
    private static String getDiskName(String errorCode) {
        int dec = Integer.parseInt(errorCode, 16);
        String a = dec / 60 + "";
        String b = dec % 60 + "";
        if (a.length() == 1) {
            a = "0" + a;
        }
        if (b.length() == 1) {
            b = "0" + b;
        }
        return "HDD" + a + "-" + b;
    }
}
