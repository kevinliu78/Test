package com.kevin.snmp;

import com.alibaba.fastjson2.JSONObject;
import com.kevin.expiringmap.EvEventDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.TrapPduv1;
import uk.co.westhawk.snmp.stack.TrapPduv2;
import uk.co.westhawk.snmp.stack.varbind;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-10-25 10:57:05
 **/
public class TestSnmpByteMessageV1 {

//    private final static Logger logger = LoggerFactory.getLogger(TestSnmpByteMessageV1.class);

    public static void main(String[] args) {
        try {
            String host = "127.0.0.1";
            byte[] message = {48, 43, 2, 1, 0, 4, 9, 83, 78, 77, 80, 95, 116, 114, 97, 112, -92, 27, 6, 8, 43, 6, 1, 4, 1, -120, 115, 3, 64, 4, 10, 119, -82, -56, 2, 1, 0, 2, 1, 0, 67, 1, 0, 48, 0};
//            byte[] message = {48, 47, 2, 1, 0, 4, 6, 112, 117, 98, 108, 105, 99, -92, 34, 6, 12, 43, 6, 1, 4, 1, -116, 52, 2, 1, 1, -127, 38, 64, 4, 10, -122, 41, 65, 2, 1, 1, 2, 1, 0, 67, 4, 64, -84, -109, 52, 48, 0};
            String messageStr = Arrays.toString(message);
            SnmpContext context;
            context = new SnmpContext(host, 1162);
            TrapPduv1 pdu = (TrapPduv1) context.processIncomingPdu(message);
            if (pdu == null) {
                snmpReceivedTrap(host, "v1", messageStr);
            } else {
                snmpReceivedTrap(pdu, host, messageStr);
            }
            context.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void snmpReceivedTrap(TrapPduv1 pdu, String host, String message) {
        try {
            String strTemp = pdu.getTimeTicks() + "";
            System.out.println("****************  Receive trap from " + host + "  ****************");
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDebug = "\r\n";
            strDebug += "V1 Trap from agent " + host + " on port 1162" + "\r\n" + "    Ip Address................. " + host + "\r\n"
                    + "    Enterprise Id.............. " + pdu.getEnterprise() + "\r\n" + "    Generic ................... " + pdu.getGenericTrap() + "\r\n"
                    + "    Specific .................. " + pdu.getSpecificTrap() + "\r\n" + "    TimeStamp ................. " + pdu.getTimeTicks() + "\r\n"
                    + "    Length..................... " + pdu.getResponseVarbinds().length + "\r\n";
            int k = pdu.getResponseVarbinds().length;
            int trapInfoType = 0;
            if (k > 0) {
                strDebug += "Trap VB Information:\r\n";
                for (int i = 0; i < k; i++) {
                    varbind vb = pdu.getResponseVarbinds()[i];
                    strDebug += "     Varbind[" + i + "] := " + vb.getOid().toString() + " --> " + vb.getValue().toString() + "\r\n";
                }
            } else {
                //pdu=0
                strDebug += "    Trap PDU message: " + message + "\r\n";
                trapInfoType = 2;
            }
            System.out.println(" " + strDebug);
        } catch (Exception e) {
            System.out.println(" snmp v1 trap process error:" + e);
        }
    }

    public static void snmpReceivedTrap(String host, String version, String message) {
        System.out.println("****************  Receive trap from " + host + "  ****************");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDebug = "\r\n";
        strDebug += "    Raw PDU message: " + message + "\r\n";
        System.out.println(" " + strDebug);
    }

}
