package com.kevin;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-15 16:27:24
 **/
public class TestChartset {

    private static String ZN_CHARSET = "GBK";
    private static String LOCAL_CHARSET = "UTF-8";
    private static String serverCharset = "ISO-8859-1";

    public static void main(String[] args) {
        try {
            String fileName = "alarm小帅Notify.txt";
            String newFileName = new String(fileName.getBytes(LOCAL_CHARSET), serverCharset);
            System.out.println(newFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(getStandbyIpAddress("192.168.135.215,192", "192.168.135.215"));


    }

    protected static String getStandbyIpAddress(String gossipRelevanceUrl, String myIpAddress) {
        try {
            if (gossipRelevanceUrl != null && !gossipRelevanceUrl.isEmpty()) {
                String[] urlArr = gossipRelevanceUrl.trim().split(",");
                for (String url : urlArr) {
                    if (!myIpAddress.equals(url)) {
                        return url;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
