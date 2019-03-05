package com.pbn.kevin.timer;

import java.util.Date;
import java.util.TimerTask;

import com.pbn.kevin.util.ConfigUtil;

/**
 * @author kevin
 * @version 创建时间: 2018年10月15日下午3:04:36
 * @ClassName 类名称
 * @Description 类描述
 */
public class Task extends TimerTask {
    public void run() {
        System.out.println("我有一头小毛驴!"+ConfigUtil.formatDate24(new Date())); 
    }
}
