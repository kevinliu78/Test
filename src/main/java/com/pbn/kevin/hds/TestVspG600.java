package com.pbn.kevin.hds;

import java.io.*;

/**
 * @Author: LWS
 * @Date: 2021/1/11 11:27
 */
public class TestVspG600 {

    public static void main(String[] args) {
        try {
            String filePath = "doc/HDS_VSP_G600_DISK_NAME.txt";
            String outputPath = "doc/HDS_VSP_G600_OUTPUT.txt";
            File outdatafile = new File(outputPath);
            if (outdatafile.exists()){
                outdatafile.delete();
            }
            if (!outdatafile.exists()) {
                outdatafile.createNewFile();
            }
            FileOutputStream cmout = new FileOutputStream(outdatafile);
            BufferedWriter cmwriter = new BufferedWriter(new OutputStreamWriter(cmout));
            File f = new File(filePath);
            FileInputStream inputStream = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis, "utf-8"), 50 * 1024 * 1024);
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                String diskName = getDiskName(line);
                String text = diskName + "|" + line;
                cmwriter.write(text);
                cmwriter.newLine();
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            bis.close();
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
