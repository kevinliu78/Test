package com.kevin.test;

import com.kevin.util.BrocadeParseUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: Dec 24, 20181:29:06 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringIndexof {
    public static void main(String[] args) {
        String s = "(106.120.84.194)-1545629473050_c445ec0c9cb6_11.235.242.39";
        String[] arr = s.split("_");
        // userId like "admin(192.168.11.131)-1823829839"
        String userId = arr[0];
        if (userId.contains("-")) {
            userId = userId.substring(0, userId.indexOf("-"));
        }
        String cmMac = arr[1];
        System.out.println(userId + "=====" + cmMac);

        String ss = "小明,小李,小赵,,,,";
        String s1 = testLastIndexOf(ss);
        System.out.println(s1);
        String string = "219.1.168.11:/share_045e42d2_4f73_4095_b05d_f5f7391ca431";
        System.out.println(string.substring(0, string.indexOf(":/")));
        System.out.println(string.substring(string.indexOf("/") + 1));
        System.out.println("======================================================");
        String mapsDesc = "MAPS-1005 slot3 port44, F-Port 3/44,Conditon=ALL_PORTS(PORT_BANDWIDTH==OVERSUBCRIPTION_CLEAR)," +
                "Current Value:[PORT_BANDWIDTH,OVERSUBCRIPTION_CLEAR], Rule SAN_X68_ALL_PORTS_OVERSUBCRIPTION_CLEAR triggered 2 times in 1 hour and last trigger time Wed Fe";
        String mapsDesc1 = "MAPS-1004 slot3 port44, F-Port 3/44,Conditon=ALL_PORTS(PORT_BANDWIDTH==OVERSUBCRIPTION_CLEAR)," +
                "Current Value:[PORT_BANDWIDTH,OVERSUBCRIPTION_CLEAR], RuleName SAN_X68_ALL_PORTS_OVERSUBCRIPTION_CLEAR, Dashboard Category=Fabric Performance Impact";
        String mapsDesc2 = "MAPS-1005 Flow (SID=0x3e8400,DID=0x3c0b00,Host Port=3/20),Conditon=sys_flow_monitor(RD_STATUS_TIME/10SEC>100000)," +
                "Current Value:[RD_STATUS_TIME, 407533 Microseconds], Rule SAN_X68_RD_STATUS_TIME_4000 triggered 20 times in 10 min and last trigger time Mon";
        String desc = "Flow (SID=0x3e8400,DID=0x3c0b00,Host Port=3/20)";
        String mapsDesc3 = "MAPS-1004 SFP 3/30,Conditon=ALL_SFP(TXP<500)," +
                "Current Value:[TXP,499 uW], RuleName=SANsev2_X68_ALL_SFPTXP_LOW_500, Dashboard Category=Port Health.";
        String mapsDesc4 = "MAPS-1005 SFP 3/28,Conditon=ALL_SFP(RXP<300)," +
                "Current Value:[RXP,266 uW], RuleName=SANsev2_X68_ALL_SFPRXP_LOW_300, Dashboard Category=Port Health,";
        String mapsDesc5 = "MAPS-1020 Switch wide status has changed from MARGINAL to HEALTHY.";
        String mapsDesc6 = "C3-1013 Multi RDY/Frame Loss detected on internal port of Slot 8,Port-1(41)m_rdy(0x0)/m_frame(0xff).";
        String mapsDesc7 = "MAPS-1005 SF1P 3/28,Conditon=ALL_SF1P(RXP<300)," +
                "Current Value:[RXP,266 uW], RuleName=SANsev2_X68_ALL_SF1PRXP_LOW_300, Dashboard Category=Port Health.";


        String netappDesc = "Spare Disk 0d.27.7 Shelf 27 Bay 7 [NETAPP X343_TA15E1T8A10 NA011] S/N [Z030A008F4VR]";
        testNetappDiskIndexOf(netappDesc);
        List<String> causeLocationList = new ArrayList<>();
        causeLocationList.add("0c.10.0");
        causeLocationList.add("/zbnaspoo13_2b_sas_aggr1/plex0/rg4/0d.05.10");
        causeLocationList.add("0a.02.17");
        causeLocationList.add("0a.00.6");
        causeLocationList.add("0c.10.13");
        causeLocationList.add("/zbnaspoo11_1b_sas_aggr2/plex0/rg5/0c.10.21");
        causeLocationList.add("0a.00.14");
        causeLocationList.add("0d.20.23");
        for (String causeLocation : causeLocationList) {
            testNetappDiskIndexOf2(causeLocation);
        }

        String netappDesc1 = "Disk on adapter 0a, shelf 10, bay 5, failed. Disk on adapter 0a, shelf 12, bay 11, failed.";
        String netappDesc2 = "Disk on adapter 5c, shelf 14, bay 0, not responding. Disk on adapter 5a, shelf 32, bay 5, failed.";
        String netappDesc3 = "Disk on adapter 3b, shelf 42, bay 7, failed. Disk on adapter 0a, shelf 41, bay 0, failed.";
        testNetappDiskIndexOf3(netappDesc1);
        testNetappDiskIndexOf3(netappDesc2);
        testNetappDiskIndexOf3(netappDesc3);
        String netappDesc4 = "Volume otcsfile_back@vserver:aaa57fc2-c4fe is offline.";
        System.out.println(StringUtils.substringBetween(netappDesc4, "Volume", "is").trim());
        System.out.println(StringUtils.substringBetween(netappDesc4, "Volume", "@vserver").trim());
        String netappDesc5 = "netif.linkDown:Ethernet e0c: Link down, check cable.";
        String[] split = netappDesc5.split(":");
        int pos1 = netappDesc5.indexOf("Ethernet");
        if (pos1 > 0) {
            int pos2 = netappDesc5.indexOf(":", pos1);
            if (pos2 > 0) {
                System.out.println(netappDesc5.substring(pos1, pos2));
            }
        }
        System.out.println(split[1].trim());
        String netappDesc6 = "Disk [NETAP :X343 TA15E1T8A10:NA01] S/N [9060A065F4UR] on channels 0a shelf ID 5 IOM A bay 10 disabled due to excessive phy changes.";
        if (netappDesc6.contains("Disk")) {
            String adapter = "";
            String shelf = "";
            String bay = "";
            int pos61 = netappDesc6.indexOf("channels");
            int pos62 = netappDesc6.indexOf("shelf ID");
            int pos63 = netappDesc6.indexOf("IOM A bay");
            int pos64 = netappDesc6.indexOf(" ", pos63 + 10);
            if (pos61 > 0 && pos62 > 0 && pos63 > 0) {
                adapter = netappDesc6.substring(pos61 + 8, pos62).trim();
                shelf = netappDesc6.substring(pos62 + 8, pos63).trim();
                if (shelf != null && shelf.length() == 1) {
                    shelf = "0" + shelf;
                }
                bay = netappDesc6.substring(pos63 + 10, pos64).trim();
                System.out.println(adapter + "." + shelf + "." + bay);
            }
        }

        String brocadeDesc = "HIL-1109 PS 4 SEEPROM corruption (fruhdr checksum mismatch) detected";
        System.out.println(StringUtils.substringBetween(brocadeDesc, "PS", "SEEPROM").trim());
        if (brocadeDesc.contains("PS") && brocadeDesc.contains("SEEPROM")) {
            int ps1 = brocadeDesc.indexOf("PS");
            int ps2 = brocadeDesc.indexOf("SEEPROM");
            String substring = brocadeDesc.substring(ps1, ps2);
            String causeLocation = substring.replace("PS", "Power Supply");
            System.out.println(substring);
            System.out.println(causeLocation);
        }
        String eventDesc = "Node SN=1CQX3Z2: DISK SN=WSD126LF on rack=red, node=ecsnode15.spdbdev.com, slot=3 is missing. Disk Details: Type=HDD, Model=ATA ST8000NM012A-2KE, Size=8001 GB, Firmware=CALD, reason: System does not detect the disk partition. Contact your service provider.";
        if (eventDesc.contains("DISK SN=") && eventDesc.contains("rack=")) {
            int pos11 = eventDesc.indexOf("DISK SN=");
            int pos22 = eventDesc.indexOf("rack=");
            String causeLocation = eventDesc.substring(pos11 + 8, pos22 - 3);
            System.out.println(causeLocation);
        }
        String eventDesc1 = "SoftQuotaLimitExceeded: bucket hfdev_ns1.api";
        if (eventDesc1.contains("bucket")) {
            int pos11 = eventDesc1.indexOf("bucket");
            String bucketName = "";
            try {
                bucketName = eventDesc1.substring(pos11 + 6);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(bucketName.trim());
        }
        String eventDesc2 = "Node ecsnode07.spdbdev.com has failed";
        if (eventDesc2.contains("Node") && eventDesc2.contains("has")) {
            int pos11 = eventDesc2.indexOf("Node");
            int pos2 = eventDesc2.indexOf("has");
            String nodeName = "";
            try {
                nodeName = eventDesc2.substring(pos11 + 4, pos2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println((nodeName.trim()));
        }
//        String eventDesc3 ="Disk 1EGAGMRB on node provo-mustard.ecs.lab.emc.com has failed";
        String eventDesc3 = "Disk 1EV1H2WB on node provo-copper.ecs.lab.emc.com was revived";
        if (eventDesc3.contains("Disk") && eventDesc3.contains("on")) {
            int pos11 = eventDesc3.indexOf("Disk");
            int pos2 = eventDesc3.indexOf("on");
            String diskName = "";
            try {
                diskName = eventDesc3.substring(pos11 + 4, pos2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(diskName.trim());
        }

        String brocadeRuleName = "SANsev1_X68_ALL_PORTSSFP_STATE_FAULTY";
        if (brocadeRuleName.contains("ALL_PORTSSFP_STATE_FAULTY")) {
            System.out.println("=====1111========");
        }
        if (brocadeRuleName.endsWith("ALL_PORTSSFP_STATE_FAULTY")) {
            System.out.println("=====222222========");
        }

        long l1 = 1781551890560L;
        System.out.println(l1 / 1024 / 1024 / 1024);

        String unitName = "000496800367";
        String emcDesc = "Disk state is now Offline (was: Online).-Object is: 000496800367:02C:C387";
        String keyword = "Object is: " + unitName + ":";
        System.out.println(("keyword===" + keyword));
        if (emcDesc.contains(keyword)) {
            int pos11 = emcDesc.indexOf(keyword);
            int pos12 = emcDesc.indexOf(":", pos11);
            System.out.println((emcDesc.substring(pos11, pos12)));
        }

        testSwMapIndexOf(mapsDesc7);
    }

    private static String testLastIndexOf(String s) {
        String substring = s.substring(0, s.lastIndexOf(","));
        return substring;
    }

    private static void testNetappDiskIndexOf(String desc) {
        int pos1 = desc.indexOf("Shelf ");
        int pos2 = desc.indexOf("Bay ");
        int pos3 = desc.indexOf("[", pos2);
        String shelfIndex = desc.substring(pos1 + 5, pos2).trim();
        String bayIndex = desc.substring(pos2 + 3, pos3).trim();
        System.out.println("shelfIndex===" + shelfIndex);
        System.out.println("bayIndex===" + bayIndex);
    }

    private static void testNetappDiskIndexOf2(String desc) {
        int pos1 = desc.lastIndexOf("/");
        if (pos1 > 0) {
            desc = desc.substring(pos1 + 1);
        }
        System.out.println("causelocation=11==" + desc);
        String[] arr = desc.split("\\.");
        if (arr.length == 3) {
            Integer shelfIndex = Integer.parseInt(arr[1].trim());
            Integer bayIndex = Integer.parseInt(arr[2].trim());
//            System.out.println("shelfIndex===" + shelfIndex);
//            System.out.println("bayIndex===" + bayIndex);
            desc = "." + shelfIndex + "." + bayIndex;
        }
        System.out.println("causelocation=22==" + desc);
    }

    private static void testNetappDiskIndexOf3(String desc) {
        if (desc.contains("Disk on adapter") && desc.contains("shelf") && desc.contains("bay")) {
            String[] descSplits = desc.split("\\.");
            String causeLocation = "";
            for (int a = 0; a < descSplits.length; a++) {
                String desc1 = descSplits[a].trim();
                String[] arr = desc1.split(",");
                String adapter = "";
                String shelf = "";
                String bay = "";
                for (int i = 0; i < arr.length; i++) {
                    String temp = arr[i];
                    if (temp.contains("adapter")) {
                        adapter = temp.replace("Disk on adapter", "").trim();
                    } else if (temp.contains("shelf")) {
                        shelf = temp.replace("shelf", "").trim();
                        if (shelf.length() == 1) {
                            shelf = "0" + shelf;
                        }
                    } else if (temp.contains("bay")) {
                        bay = temp.replace("bay", "").trim();
                    }
                }
                causeLocation += adapter + "." + shelf + "." + bay;
                causeLocation += ",";
            }
            //多个故障位置特殊处理
            if (!causeLocation.isEmpty()) {
                System.out.println("causelocation=33=======" + causeLocation.substring(0, causeLocation.length() - 1));
            }
        }
    }

    private static void testSwMapIndexOf(String desc) {
        int pos1 = desc.indexOf("Port ");
        int pos2 = desc.indexOf("RuleName");
        if (desc.startsWith("MAPS-")) {
            String ruleName = "";
            String portName = null;
            if (pos2 > 0) {
                int pos4 = desc.indexOf(",", pos2);
                ruleName = desc.substring(pos2 + 9, pos4);
                System.out.println("ruleName1===" + ruleName);
            } else {
                pos2 = desc.indexOf(", Rule ");
                if (pos2 > 0) {
                    int pos4 = desc.indexOf(" ", pos2 + 8);
                    ruleName = desc.substring(pos2 + 6, pos4).trim();
                } else {
                    String errorCode = StringUtils.substringBefore(desc, " ");
                    ruleName = "BROCADE_" + errorCode;
                }
                System.out.println("ruleName2===" + ruleName);
            }
            if (pos1 > 0) {
                int pos3 = desc.indexOf(",", pos1);
                int sfp = desc.indexOf("SFP");
//                if (pos3 < 0) {
//                    int sfp = desc.indexOf("SFP");
//                    int pos4 = desc.indexOf(",", sfp);
//                    String portIndex = desc.substring(sfp + 3, pos4).trim();
//                    portName = getPortInfoByFcPortIndex(portIndex);
//                    System.out.println("portIndex===" + portIndex);
//                    System.out.println("portName===" + portName);
//                } else {
//                    String portIndex = desc.substring(pos1 + 4, pos3).trim();
//                    portName = getPortInfoByFcPortIndex(portIndex);
//                    System.out.println("portIndex===" + portIndex);
//                    System.out.println("portName===" + portName);
//                }
                if (sfp > 0) {
                    //MAPS SFP 端口格式
                    //MAPS-1005 SFP 3/28,Conditon=ALL_SFP(RXP<300),Current Value:[RXP,266 uW], RuleName=SANsev2_X68_ALL_SFPRXP_LOW_300, Dashboard Category=Port Health.
                    //MAPS-1004 SFP 3/47, Condition=ALL_16GSWL_SFP(RXP/NONE<=32), Current Value:[RXP, 3 uW], RuleName=SANsev2_X68_ALL_16GSWL_SFPRXP_32, Dashboard Category=Port Health, Quiet Time=1 hour.
                    int pos4 = desc.indexOf(",", sfp);
                    String portIndex = desc.substring(sfp + 3, pos4).trim();
                    portName = getPortInfoByFcPortIndex(portIndex);
                    System.out.println("portIndex===" + portIndex);
                    System.out.println("portName===" + portName);
                } else {
                    if (pos3 > 0) {
                        String portIndex = desc.substring(pos1 + 4, pos3).trim();
                        portName = getPortInfoByFcPortIndex(portIndex);
                        System.out.println("portIndex===" + portIndex);
                        System.out.println("portName===" + portName);
                    }
                }
            } else {
                if (desc.contains("Flow") && desc.contains("Port=")) {
                    int pos3 = desc.indexOf("Port=");
                    int pos4 = desc.indexOf(")");
                    if (pos3 > 0) {
                        portName = desc.substring(pos3 + 5, pos4);
                    } else {
                        portName = desc.substring(pos3 + 5);
                    }
                    System.out.println("portName==333===" + portName);
                }
            }
            if (portName == null) {
                portName = extractPortName(desc);
                portName = getPortInfoByFcPortIndex(portName);
            }
        } else {
            String strTemp = desc.toLowerCase();
            if (strTemp.contains("slot") && strTemp.contains("port-")) {
                int slot = strTemp.indexOf("slot");
                int port = strTemp.indexOf("port-");
                int i = strTemp.indexOf(",", slot);
                int j = strTemp.indexOf("(", port);
                String slotName = strTemp.substring(slot + 4, i).trim();
                String portName = strTemp.substring(port + 5, j).trim();
                portName = getPortInfoByFcPortIndex(slotName + "/" + portName);
                System.out.println(new Date() + "port name ====" + portName);
            }
        }
    }

    private static String getPortInfoByFcPortIndex(String portIndex) {
        String portName = "";
        try {
            if (portIndex == null) {
                return portName;
            }
            if (portIndex.contains("/")) {
                int i = portIndex.indexOf("/");
                //截取板卡号和端口号
                String slot = portIndex.substring(0, i);
                String port = portIndex.substring(i + 1);
                portName = BrocadeParseUtils.getPortName("s#p#", slot, port);
            } else {
                portName = portIndex;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return portName;
    }

    private static void test2(String strPortName) {
        if (strPortName.startsWith("Flow") && strPortName.contains("Port=")) {
            int pos1 = strPortName.indexOf("Port=");
            int pos2 = strPortName.indexOf(")");
            if (pos2 > 0) {
                strPortName = strPortName.substring(pos1 + 5, pos2);
            } else {
                strPortName = strPortName.substring(pos1 + 5);
            }
            System.out.println("portName==333===" + strPortName);
        }
    }

    private static String extractPortName(String desc) {
        String portName = null;
        String strTemp = desc.toLowerCase();
        int ppos1 = strTemp.indexOf("slot");
        int ppos2 = strTemp.indexOf("port");
        String ssPort = strTemp.substring(ppos2 + 4).trim();
        if (ppos1 > 0 && ppos2 > 0) {
            String slot = strTemp.substring(ppos1 + 4, ppos2).trim();
            int sLen = 3;
            if (ssPort.length() < 3)
                sLen = ssPort.length();
            String digit = "";
            for (int ii = 0; ii < sLen; ii++) {
                if (ssPort.charAt(ii) >= 48 && ssPort.charAt(ii) <= 57)
                    digit += ssPort.charAt(ii);
            }
            if (!digit.isEmpty()) {
                portName = BrocadeParseUtils.getPortName("s#p#", slot, digit);
            }
        } else if (ppos1 < 0 && ppos2 > 0) {
            char c = ssPort.charAt(ssPort.length() - 1);
            if (c < 48 || c > 57)
                ssPort = ssPort.substring(0, ssPort.length() - 1);
            if (ssPort.contains("/")) {
                int aa = ssPort.indexOf("/");
                //截取板卡号和端口号
                String slot = ssPort.substring(0, aa);
                String port = ssPort.substring(aa + 1);
                portName = BrocadeParseUtils.getPortName("s#p#", slot, port);
            }
        }
        System.out.println("portName==2222==" + portName);
        return portName;
    }
}
