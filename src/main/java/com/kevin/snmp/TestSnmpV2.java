package com.kevin.snmp;

import com.kevin.util.DateFormatUtil;
import uk.co.westhawk.snmp.stack.AsnInteger;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.SnmpContextv2c;
import uk.co.westhawk.snmp.stack.TrapPduv2;

import java.net.InetAddress;
import java.util.Date;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-09-28 15:56:13
 **/
public class TestSnmpV2 {

    public static void main(String[] args) {
        try {
//            String target = InetAddress.getLocalHost().getHostAddress();
            String hostName = InetAddress.getLocalHost().getHostName();
            //      logger.info("address===========" + target + "=====hostName========" + hostName);
            String target = "192.168.135.97";
            String community = "public";
            String enterpriseOID = "1.3.6.1.2.1.1.2";
            int genneric = 6;
            int specific = 1;
            String bindAddr = null;
            long timeticks = System.currentTimeMillis();
            byte[] address = InetAddress.getByName(target).getAddress();
            //读取trap监听端口
            int listenerPort = 1162;
            SnmpContextv2c context = new SnmpContextv2c(target, listenerPort, bindAddr, "Standard");
            context.setMaxRecvSize(2000);
            String currentTime = DateFormatUtil.formatDateTime24(new Date(timeticks));

            TrapPduv2 pdu = new TrapPduv2(context);
//            pdu.addOid("1.3.6.1.2.1.1.3.0", new AsnInteger(31031));
//            pdu.addOid("1.3.6.1.6.3.1.1.4.1.0", new AsnOctets("1.3.6.1.4.1.2011.2.251.20.2.1.1".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.1", new AsnOctets(currentTime.getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.2", new AsnOctets(("testSnmpTrap").getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.3", new AsnOctets("test snmp trap listener status".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.4", new AsnOctets("test snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status".getBytes()));
            pdu.send();
            try {
                //线程销毁
                Thread.sleep(5000);
                context.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
