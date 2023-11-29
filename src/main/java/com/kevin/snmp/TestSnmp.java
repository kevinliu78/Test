package com.kevin.snmp;

import com.kevin.util.ConfigUtil;
import com.kevin.util.DateFormatUtil;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.TrapPduv1;

import java.net.InetAddress;
import java.util.Date;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-09-28 15:56:13
 **/
public class TestSnmp {

    public static void main(String[] args) {
        try {
//            String target = InetAddress.getLocalHost().getHostAddress();
            String hostName = InetAddress.getLocalHost().getHostName();
            //      logger.info("address===========" + target + "=====hostName========" + hostName);
            String target = "192.168.135.97";
            String community = "public";
            String enterpriseOID = "1.3.6.1.2.1.1.10";
            int genneric = 6;
            int specific = 1;
            String bindAddr = null;
            long timeticks = System.currentTimeMillis();
            byte[] address = InetAddress.getByName(target).getAddress();
            //读取trap监听端口
            int listenerPort = 1162;
            SnmpContext context = new SnmpContext(target, listenerPort, bindAddr, "Standard");
            context.setMaxRecvSize(1500);
            String currentTime = DateFormatUtil.formatDateTime24(new Date(timeticks));

            TrapPduv1 pdu = new TrapPduv1(context);
            pdu.setIpAddress(address);
            pdu.setEnterprise(enterpriseOID);
            pdu.setGenericTrap(genneric);
            pdu.setSpecificTrap(specific);
            pdu.setTimeTicks(timeticks);

//            pdu.addOid("1.3.6.1.2.1.1.1", new AsnOctets("test snmp trap listener statustest ".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.2", new AsnOctets(hostName.getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.3", new AsnOctets(currentTime.getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.4", new AsnOctets(("testSnmpTrap").getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.5", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.6", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.7", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.8", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.9", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.10", new AsnOctets("test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890 test snmp trap listener status 1234567890".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.7", new AsnOctets("test snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status".getBytes()));
//            pdu.addOid("1.3.6.1.2.1.1.8", new AsnOctets("test snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener statustest snmp trap listener status".getBytes()));
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
