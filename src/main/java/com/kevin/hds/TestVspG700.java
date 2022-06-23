package com.kevin.hds;

import java.io.*;
import java.util.HashMap;

/**
 * @Author: LWS
 * @Date: 2021/1/11 11:27
 */
public class TestVspG700 {

    public static void main(String[] args) {
        try {
            String outputPath = "doc/HDS_VSP_G700_OUTPUT.txt";
            File outdatafile = new File(outputPath);
//            if (outdatafile.exists()){
//                outdatafile.delete();
//            }
            if (!outdatafile.exists()) {
                outdatafile.createNewFile();
            }
            FileOutputStream cmout = new FileOutputStream(outdatafile);
            BufferedWriter cmwriter = new BufferedWriter(new OutputStreamWriter(cmout));
            //0A5 ---- 2-37
            String diskName = getDiskName("0A5");
            String text = diskName + "|" + "0A5";
            cmwriter.write(text);
            cmwriter.newLine();
            cmwriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据错误码获取磁盘名称
     *
     * @param errorCode
     * @return
     */
    private static String getDiskName(String errorCode) {
        String binaryString = hexToBinary(errorCode);
        int mid = binaryString.length() / 2;
        String s1 = binaryString.substring(0, mid);
        String s2 = binaryString.substring(mid);
        String a = Integer.parseInt(s1, 2)+"";
        String b = Integer.parseInt(s2, 2)+"";


        if (a.length() == 1) {
            a = "0" + a;
        }
        if (b.length() == 1) {
            b = "0" + b;
        }
        return "HDD" + a + "-" + b;
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
}
