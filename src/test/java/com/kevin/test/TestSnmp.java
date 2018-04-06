package com.kevin.test;


import java.util.List;

import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;
import com.pbn.snmp.SNMPConfig;
import com.pbn.snmp.SNMPHelperImpl;

public class TestSnmp {

	public static void main(String[] args) {
		try {
            SNMPConfig cmConfig = new SNMPConfig();
            cmConfig.setAgentIp("192.168.10.1");
            cmConfig.setReadCommunity("public");
            cmConfig.setWriteCommunity("public");   
            SNMPHelperImpl helper = new SNMPHelperImpl(cmConfig);
           
            List<List<VariableBinding>> tableValues = helper.getTableValues(cmOidArr);
            //preEqData,upstreamFrequency, upstreamWidth
            ArrayNode arr = Convert.newObject().arrayNode();
            int i = 0;
            for (List<VariableBinding> list : tableValues) {
            		ObjectNode node = Convert.newObject();
            		i++;
				for (VariableBinding vb : list) {
//					System.out.println(vb.getOid()+"===="+vb.getVariable());
					String oid = vb.getOid().toString();
					//upstreamFrequency
					if(oid.startsWith("1.3.6.1.2.1.10.127.1.1.2.1.2")) {
						node.put("upstreamFrequency", vb.getVariable().toLong() / 1000000f);
					}
					//upstreamWidth
					else if(oid.startsWith("1.3.6.1.2.1.10.127.1.1.2.1.3")) {
						node.put("upstreamWidth", vb.getVariable().toLong() / 1000000f);
					}
					//preEqData
					else if(oid.startsWith("1.3.6.1.4.1.4491.2.1.20.1.2.1.6")) {
						node.put("preEqData", vb.getVariable().toString());
					}
				}
				arr.add(node);
			}
            System.out.println(arr);
//            System.out.println("循环了s"+i+"次");
            
//            List<VariableBinding> groupValues = helper.getGroupValues(cmOidArr, PDU.GETNEXT);
//            for (VariableBinding v : groupValues) {
//				System.out.println(v.getVariable());
//			}
//            List<VariableBinding> sysValues = helper.getGroupValues(sysOidArr, PDU.GET);
//            for (VariableBinding v : sysValues) {
//            	System.out.println("name:"+v.getOid()+",value:"+v.getVariable());
//			}
            
         // Get Modulation table from CMTS synchronous
//			List<List<VariableBinding>> modList = helper.getTableValues(modulationOidArr);
//			for (List<VariableBinding> list : modList) {
//				for (VariableBinding v : list) {
//					System.out.println("name1:"+v.getOid()+",value:"+v.getVariable());
//				}
//			}
//			// Get US channel info synchronous
//			List<List<VariableBinding>> usValues = helper.getTableValues(upOidArr);
//			for (List<VariableBinding> list : usValues) {
//				for (VariableBinding v : list) {
//					System.out.println("name2:"+v.getOid()+",value:"+v.getVariable());
//				}
//			}
	
//			List<List<VariableBinding>> dsValues = helper.getTableValues(downOidArr);
//			for (List<VariableBinding> list : dsValues) {
//				for (VariableBinding v : list) {
//					System.out.println("name3:"+v.getOid()+",value:"+v.getVariable());
//				}
//			}
	
			// Get US/DS channel common info
//			List<List<VariableBinding>> ifValues = helper.getTableValues(ifInterfacesOidArr);
//			for (List<VariableBinding> list : ifValues) {
//				for (VariableBinding v : list) {
//					System.out.println("name4:"+v.getOid()+",value:"+v.getVariable());
//				}
//			}
        } catch (Exception e) {
        }

	}
	
	 private static final OID[] cmOidArr = new OID[]{
 			new OID("1.3.6.1.4.1.4491.2.1.20.1.2.1.6"),
// 			new OID("1.3.6.1.2.1.10.127.1.1.2.1.2"),
// 			new OID("1.3.6.1.2.1.10.127.1.1.2.1.3"),
// 			new OID("1.3.6.1.2.1.10.127.1.2.2.1.17"),
// 			new OID("1.3.6.1.2.1.1.2"),
 		};
	 
	 private static final OID[] sysOidArr = new OID[]{
			new OID(SystemMIBConstant.sysDescr),
			new OID(SystemMIBConstant.sysObjectID),
			new OID(SystemMIBConstant.sysUpTime),
			new OID(SystemMIBConstant.sysName),
	};
	 private static final OID[] modulationOidArr = new OID[]{new OID(DocsisSNMPConstant.docsIfCmtsModType)};
		
	private static final OID[] ifInterfacesOidArr = new OID[]{
		new OID(SystemMIBConstant.ifIndex),
//		new OID(SystemMIBConstant.ifDescr),
//		new OID(SystemMIBConstant.ifType),
//		new OID(SystemMIBConstant.ifSpeed),
//		new OID(SystemMIBConstant.ifOperStatus),
	};
	
	private static final OID[] upOidArr = new OID[]{
		new OID(DocsisSNMPConstant.docsIfUpChannelId),
		new OID(DocsisSNMPConstant.docsIfUpChannelFrequency),
		new OID(DocsisSNMPConstant.docsIfUpChannelWidth),
		new OID(DocsisSNMPConstant.docsIfUpChannelModulationProfile),
	};
	
	private static final OID[] downOidArr = new OID[]{
		new OID(DocsisSNMPConstant.docsIfDownChannelId),
		new OID(DocsisSNMPConstant.docsIfDownChannelFrequency),
		new OID(DocsisSNMPConstant.docsIfDownChannelWidth),
		new OID(DocsisSNMPConstant.docsIfDownChannelModulation),
		new OID(DocsisSNMPConstant.docsIfDownChannelPower),
	};
}
