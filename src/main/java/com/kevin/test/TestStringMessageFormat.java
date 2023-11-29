package com.kevin.test;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-06 17:32:15
 **/
public class TestStringMessageFormat {

    @Test
    public void test() {
        String msg =
                "source:=10.122.166.166<&&>uptime:=null<&&>version:=v2<&&>enterprise:=1.3.6.1.4.1.2011.2.91.10.2.1.0.1<&&>generic:=null<&&>specific:=null<&&>vb[0]:=1.3.6.1.2.1.1.3.0-->863667<&&>vb[1]:=1.3.6.1.6.3.1.1.4.1.0-->1.3.6.1.4.1.2011.2.91.10.2.1.0.1<&&>vb[2]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.1.0-->Array<&&>vb[3]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.2.0-->domain-name=DiskDomain001,domain-id=0,FrameType=disk enclosure,FrameID=CTE0,SlotID=11,real-disk-type=SAS,sn=W8G8N0RX<&&>vb[4]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.3.0-->Step1 Reinsert the removed disk. If the alarm persists=>[Step2].<&&>vb[5]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.4.0-->A Disk Is Removed From A Disk Domain<&&>vb[6]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.5.0-->2<&&>vb[7]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.6.0-->2<&&>vb[8]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.7.0-->17432584<&&>vb[9]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.8.0-->0x07:E6:06:10:10:2C:11:00<&&>vb[10]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.9.0-->1702<&&>vb[11]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.10.0-->Disk (disk enclosure CTE0, slot ID {0}, type SAS, serial number W8G8N0RX) is removed from disk domain (ID 0, name DiskDomain001).<&&>vb[12]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.11.0-->1<&&>vb[13]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.12.0-->17432584<&&>vb[14]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.13.0-->70<&&>vb[15]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.14.0-->2102350DHW10H7000016<&&>vb[16]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.15.0-->Huawei.Storage<&&>";
        String msg1 =
                "vb[11]:=1.3.6.1.4.1.2011.2.91.10.3.1.1.10.0-->Disk (disk enclosure CTE0, slot ID {0}, type SAS, serial number W8G8N0RX) is removed from disk domain (ID 0, name DiskDomain001).";
        for (int i = 0; i < 10; i++) {
            String format = MessageFormat.format(msg, i);
//            System.out.println(format);
        }

        String message = "短信发送失败，发送总数:{0},失败数量:{1}。";
        String format1 = MessageFormat.format(message, 100,50);
        System.out.println(format1);
    }
}
