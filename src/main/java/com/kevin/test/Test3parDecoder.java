package com.kevin.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-22 15:10:16
 **/
public class Test3parDecoder {

    public static void main(String[] args) {
        String msgDetail = "Magazine 0:19:0, Physical Disk 12 Failed (Vacated {0x45}, Missing A Port {0x86}, Missing B Port {0x8a}, Prolonged Not Ready {0x9f}, Servicing {0x12})";
        String details = "pd wwn 5000C5005EE869E45000C5005EE869E4 changed state from valid to missing because disk gone event was received for this disk.";
        String msgKey = getMsgKey(msgDetail);
        System.out.println(msgKey);
        String time = "2022-06-22 14:37:59 CST";
        System.out.println(time.replace("CST","").trim());
        String causeLocation = StringUtils.substringBetween(details, "wwn", "changed");
        System.out.println(causeLocation.trim());
    }

    private static String getMsgKey(String msgDetail) {
        String msgKeyword = "";
        String splitKey = "Magazine~,;PD~Failed;Disk~Failed";
        String[] splits = splitKey.split(";");
        for (int i = 0; i < splits.length; i++) {
            //再按照~分割
            String[] keys = splits[i].split("~");
            if (keys.length == 2) {
                if (keys[0].equals("start")) {
                    //情况3:start表示从index为0开始截取
                    int indexOf = msgDetail.indexOf(keys[1]);
                    if (indexOf != -1) {
                        msgKeyword = msgDetail.substring(0, indexOf);
                    }
                } else {
                    if (keys[1].equals("end")) {
                        //情况3:end表示截取至最后
                        int indexOf = msgDetail.indexOf(keys[0]);
                        if (indexOf != -1) {
                            msgKeyword = msgDetail.substring(indexOf + keys[0].length());
                        }
                    } else {
                        msgKeyword = StringUtils.substringBetween(msgDetail, keys[0], keys[1]);
                    }
                }
                if (msgKeyword != null && !msgKeyword.isEmpty()) {
                    //截取字段不为空时
                    msgKeyword = msgKeyword.trim();
                    break;
                }
            }
        }
        return msgKeyword;
    }
}
