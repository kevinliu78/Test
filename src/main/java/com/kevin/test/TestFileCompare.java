package com.kevin.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-02-28 16:07:40
 **/
public class TestFileCompare {

    public static void main(String[] args) {
        compareTwoFile();
    }

    public static void compareTwoFile(){
        List<String> list1 =  new ArrayList<>();
        List<String> list2 =  new ArrayList<>();
        list1.add("qwert");
        list2.add("qwert");
        list1.add("asdfg");
        list2.add("asdfg");
        list1.add("zxcvb");
        list2.add("zxcvb");
        System.out.println(String.format("比较%s和%s两个文件，以 %s 为主", "oldFile", "newFile", "newFile"));
        List<String> finalList = list2.stream().filter(line ->
                list1.stream().filter(line2 -> line2.equals(line)).count() == 0
        ).collect(Collectors.toList());
        if (finalList.size() == 0) {
            System.out.println("两个文件无差异");
        }else{
            System.out.println("以下为差异的地方：");
            finalList.forEach(one -> System.out.println(one));
        }
    }




//    public static void compareTwoFile(String oldFile, String newFile) throws IOException {
//        List<String> list1 =  Files.readAllLines(Paths.get(oldFile));
//        List<String> list2 =  Files.readAllLines(Paths.get(newFile));
//
//        log.info("比较{}和{}两个文件，以 {} 为主", oldFile, newFile, newFile);
//        List<String> finalList = list2.stream().filter(line ->
//                list1.stream().filter(line2 -> line2.equals(line)).count() == 0
//        ).collect(Collectors.toList());
//        if (finalList.size() == 0) {
//            log.info("两个文件无差异");
//        }else{
//            log.info("以下为差异的地方：");
//            finalList.forEach(one -> System.out.println(one));
//        }
//    }
}
