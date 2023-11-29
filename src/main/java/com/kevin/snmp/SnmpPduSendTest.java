package com.kevin.snmp;

import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.TrapPduv1;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-09-22 16:04:58
 **/
public class SnmpPduSendTest {

    private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try {
            String target = "192.168.135.211";
//            String target = InetAddress.getLocalHost().getHostAddress();
//      String hostName = InetAddress.getLocalHost().getHostName();
            String community = "public";
            String enterpriseOID = "1.3.6.1.4.1.116.3.11.4.1.1";
            int genneric = 6;
            int specific = 3;
            String bindAddr = null;
            long timeticks = System.currentTimeMillis();
            byte[] address = InetAddress.getByName(target).getAddress();
            //读取trap监听端口
            int listenerPort = 162;
            SnmpContext context = new SnmpContext(target, listenerPort, bindAddr, "Standard");
            String currentTime = sdfDateTime24.format(new Date(timeticks));
            TrapPduv1 pdu = new TrapPduv1(context);
            pdu.setIpAddress(address);
            pdu.setEnterprise(enterpriseOID);
            pdu.setGenericTrap(genneric);
            pdu.setSpecificTrap(specific);
            pdu.setTimeTicks(timeticks);
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.1", new AsnOctets("10701".getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.2", new AsnOctets("RAID800".getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.3", new AsnOctets("7410FF".getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.4", new AsnOctets("1.3.6.1.4.1.116.5.11.4.1.1.6.1.9".getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.5", new AsnOctets(currentTime.getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.6", new AsnOctets(currentTime.getBytes()));
            pdu.addOid("1.3.6.1.4.1.116.5.11.4.2.7", new AsnOctets("SSVP error".getBytes()));
            System.out.println("发送");
            boolean send = pdu.send();
            System.out.println("结束"+send);
            Thread.sleep(10);
            context.destroy();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
