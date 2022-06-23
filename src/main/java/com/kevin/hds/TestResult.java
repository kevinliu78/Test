package com.kevin.hds;

import java.io.*;

/**
 * @Author: LWS
 * @Date: 2021/1/11 11:27
 */
public class TestResult {

    public static void main(String[] args) {
        try {
            String oldPath = "doc/HDS_VSP_G600_DISK_NAME_ERROR_CODE.txt";
            String newPath = "doc/HDS_VSP_G600_OUTPUT.txt";

            File oldFile = new File(oldPath);
            FileInputStream oldInputStream = new FileInputStream(oldFile);
            BufferedInputStream oldBis = new BufferedInputStream(oldInputStream);
            BufferedReader oldBufferedReader = new BufferedReader(new InputStreamReader(oldBis, "utf-8"), 50 * 1024 * 1024);
            String oldLine = oldBufferedReader.readLine();

            File newFile = new File(newPath);
            FileInputStream newInputStream = new FileInputStream(newFile);
            BufferedInputStream newBis = new BufferedInputStream(newInputStream);
            BufferedReader newBufferedReader = new BufferedReader(new InputStreamReader(newBis, "utf-8"), 50 * 1024 * 1024);
            String newLine = newBufferedReader.readLine();
            while (oldLine != null) {
                String[] oldStrArr = oldLine.split(",");
                String[] newStrArr = newLine.split("\\|");
                String oldDiskName = oldStrArr[0];
                String newDiskName = newStrArr[0];
                String oldErrorCode = oldStrArr[1];
                String newErrorCode = newStrArr[1];
                if (oldDiskName.equals(newDiskName) && oldErrorCode.equals(newErrorCode)){

                }else {
                    System.out.println("有錯誤信息=====");
                    System.out.println(oldDiskName+"==="+newDiskName+"==="+oldErrorCode+"==="+newErrorCode);
                }
                newLine = newBufferedReader.readLine();
                oldLine = oldBufferedReader.readLine();
            }
            oldBufferedReader.close();
            oldBis.close();
            newBufferedReader.close();
            newBis.close();
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
        int dec = Integer.parseInt(errorCode, 16);

        String a = dec / 64 + "";
        String b = dec % 64 + "";

        if (a.length() == 1) {
            a = "0" + a;
        }
        if (b.length() == 1) {
            b = "0" + b;
        }
        return "HDD" + a + "-" + b;
    }
}
