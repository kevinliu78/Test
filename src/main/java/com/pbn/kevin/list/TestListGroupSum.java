package com.pbn.kevin.list;

import com.alibaba.fastjson.JSONObject;
import com.nms.util.Convert;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-12-07 14:19:06
 **/
public class TestListGroupSum {

    public static void main(String[] args) {
        try {
            String filePath = "doc/pmdataTest.txt";
            List<PmDataDTO> result = new ArrayList<>();
            File f = new File(filePath);
            FileInputStream inputStream = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis, "utf-8"), 50 * 1024 * 1024);
            int count = 0;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line != null && line.contains(",")) {
                    String[] split = line.split(",");
                    PmDataDTO pmData = new PmDataDTO();
                    pmData.setDataValue(Double.parseDouble(split[0]));
                    pmData.setDataTime(split[1]);
//                    if (count == 5) {
//                        pmData.setDataValue(0d);
//                        pmData.setDataTime("");
//                    } else {
//                        pmData.setDataValue(Double.parseDouble(split[0]));
//                        pmData.setDataTime(split[1]);
//                    }
                    result.add(pmData);
                }
                count++;
            }
            Map<String, List<PmDataDTO>> groups = result.stream().collect(Collectors.groupingBy(PmDataDTO::getDataTime, Collectors.toList()));
            List<PmDataDTO> result2 = new ArrayList<>();
            for (Map.Entry<String, List<PmDataDTO>> entry : groups.entrySet()) {
                List<PmDataDTO> value = entry.getValue();
                String key = entry.getKey();
                Double reduce = value.stream().map(PmDataDTO::getDataValue).reduce(0d, Double::sum);
                PmDataDTO pmData = new PmDataDTO();
                pmData.setDataTime(key);
                pmData.setDataValue(reduce);
                result2.add(pmData);
            }
            System.out.println(JSONObject.toJSONString(result));
            System.out.println(JSONObject.toJSONString(groups));
            System.out.println("-----------------------------------------");
            System.out.println(JSONObject.toJSONString(result2));
            System.out.println(count);
            bufferedReader.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        List<User> users = generateUserList();
//        int reduce = users.stream().mapToInt(x -> x.getSalary().intValue()).reduce(0, Integer::sum);
//        log.info("Int sum - {}", reduce);
//        BigDecimal reduce1 = users.stream().map(User::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
//        log.info("BigDecimal sum - {}", reduce);
//    }
//
//    private static List<User> generateUserList() {
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            users.add(new User((long) (i + 1), StrFormatter.format("用户-{}", i), RandomUtil.randomBigDecimal(new BigDecimal(1000), new BigDecimal(100000))));
//        }
//        return users;
//    }

//    Map<String, List<User>> groups = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.toList()));


}
