package com.kevin.test;

import java.io.*;

/**
 * @Author: LWS
 * @Date: 2020/11/9 16:12
 */
public class TestReadFile {

    public static void main(String[] args) throws IOException {

        String fileName = "E:/ev_condition2code.txt";
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File(fileName)));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis,
                "utf-8"), 50 * 1024 * 1024);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            String featureCode = split[0];
            Integer conditionId = Integer.parseInt(split[1]);
            System.out.println("featureCode = "+featureCode+"--------conditionId = "+conditionId);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        bis.close();

    }
}
