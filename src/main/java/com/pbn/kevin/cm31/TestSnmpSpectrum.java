package com.pbn.kevin.cm31;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;
import com.pbn.kevin.util.JsonUtil;
import com.pbn.snmp.SNMPConfig;
import com.pbn.snmp.SNMPHelperImpl;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kevin
 * @version 创建时间: Mar 14, 2019 10:00:35 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSnmpSpectrum {
	private static String fileUrl = "conf/spectrum.json";
	private static ObjectNode result;
	private static final OID[] oidArr = new OID[] { new OID("1.3.6.1.4.1.4491.2.1.28.1.11.1.2.48"),
			new OID("1.3.6.1.4.1.4491.2.1.28.1.11.1.3.48") };

	public static void main(String[] args) {
		try {
			SNMPConfig cmConfig = new SNMPConfig();
			cmConfig.setAgentIp("10.10.10.11");
			cmConfig.setReadCommunity("public");
			cmConfig.setWriteCommunity("public");
			SNMPHelperImpl helper = new SNMPHelperImpl(cmConfig);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					try {
						snmpSpectrum(helper);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}, 1000,60*1000);
			
		} catch (Exception e) {
		}

	}
	
	private static void snmpSpectrum(SNMPHelperImpl helper) throws IllegalArgumentException, Exception {
		List<List<VariableBinding>> tableValues = helper.getTableValues(oidArr);
		String[][] inputData = new String[32][2];
		for (int i = 0; i < tableValues.size(); i++) {
			for (VariableBinding vb : tableValues.get(i)) {
				// System.out.println(vb.getOid()+"===="+vb.getVariable());
				String oid = vb.getOid().toString();
				String str = oid.substring("1.3.6.1.4.1.4491.2.1.28.1.11.1.2.48".length() + 1);
				int ll = Integer.parseInt(str);
				if (ll > 0 && ll < 33) {
					if (oid.startsWith("1.3.6.1.4.1.4491.2.1.28.1.11.1.2.48")) {
						double freq = vb.getVariable().toLong() / 1000000d;
						inputData[i - 1][0] = freq + "";
					} else if (oid.startsWith("1.3.6.1.4.1.4491.2.1.28.1.11.1.3.48")) {
						int value = vb.getVariable().toInt();
						inputData[i - 1][1] = value + 60 + "";
					}
				}
			}
		}
		result = (ObjectNode) Convert.parse(new FileInputStream(fileUrl));
		if (result == null) {
			result = Convert.newObject();
			result.putArray("data");
		}
		ArrayNode data = (ArrayNode) result.get("data");
		long time = new Date().getTime();
		ObjectNode node = Convert.newObject();
		node.put("dts", time);
		node.putPOJO("list", inputData);
		data.add(node);
		File outdatafile = new File(fileUrl);
		if (!outdatafile.exists()) {
			outdatafile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(outdatafile);
		JsonUtil.write(fos, result);
		fos.close();
	}

}
