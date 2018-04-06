package com.kevin.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * Created by sam on 17-5-18.
 */
public class VendorConfService{

    private static final Logger logger = LoggerFactory.getLogger(VendorConfService.class);

    private static final String CONF_DIR = System.getProperty("user.dir") + File.separator + "conf";
    private static final String FILE_NAME = "vendor.json";
    private static final String FILE_PATH = CONF_DIR + File.separator + FILE_NAME;
    private static File f;

    private static ObjectNode json;
    private static final String FIELD_VENDORDATA = "vendorData";
    private static final String FIELD_VENDORDATA_NAME = "name";
    private static final String FIELD_VENDORDATA_OID = "oid";
    private static final String FIELD_VENDORDATA_AMPMAX = "ampMax";
    private static final String FIELD_VENDORDATA_NIBBLETYPE = "nibbleType";


    public static void main(String[] args) throws FileNotFoundException {
    		load();
	}

    public static void load() throws FileNotFoundException
    {
    		File f = new File("src/main/json/test2.json");
    		ObjectNode json = (ObjectNode) Convert.parse(new FileInputStream(f));
    		String mac1 = "001fa493784d";
    		String mac2 = "001fa493785e";
		ArrayNode vendorDatas = (ArrayNode) json.get("PNMDATA");
		for (JsonNode jsonNode : vendorDatas) {
			String mac = jsonNode.get("mac").asText();
			if(mac1.equals(mac)) {
				ArrayNode preData = (ArrayNode)jsonNode.get("preData");
				System.out.println("mac ===="+mac);
				for (JsonNode j : preData) {
					String preEqData = j.get("preEqData").asText();
					float upstreamFrequency =j.get("upstreamFrequency").floatValue();
					float upstreamWidth = j.get("upstreamWidth").floatValue();
					System.out.println("preEqData=="+preEqData);
					System.out.println("upstreamFrequency=="+upstreamFrequency);
					System.out.println("upstreamWidth=="+upstreamWidth);
				}
			}else if(mac2.equals(mac)) {
				ArrayNode preData = (ArrayNode)jsonNode.get("preData");
				System.out.println("mac ===="+mac);
				for (JsonNode j : preData) {
					String preEqData = j.get("preEqData").asText();
					float upstreamFrequency =j.get("upstreamFrequency").floatValue();
					float upstreamWidth = j.get("upstreamWidth").floatValue();
					System.out.println("preEqData=="+preEqData);
					System.out.println("upstreamFrequency=="+upstreamFrequency);
					System.out.println("upstreamWidth=="+upstreamWidth);
				}
			}
		}
//		System.out.println(vendorDatas);
    }

//    public static List<VendorData> getVendors()
//    {
//        if (json == null)
//            return null;
//
//        ArrayNode vendorDatas = (ArrayNode) json.get(FIELD_VENDORDATA);
//
//        List<VendorData> vendors = new ArrayList<VendorData>(vendorDatas.size());
//        vendorDatas.forEach(o ->{
//            VendorData vd = new VendorData();
//
//            vd.Name = o.get(FIELD_VENDORDATA_NAME).asText();
//            vd.OID = o.get(FIELD_VENDORDATA_OID).asText();
//            vd.AmpMax = o.get(FIELD_VENDORDATA_AMPMAX).asInt();
//            vd.NibbleType = o.get(FIELD_VENDORDATA_NIBBLETYPE).asInt();
//
//            vendors.add(vd);
//        });
////        logger.info("vendors size=" + vendors.size());
//        return vendors;
//    }

}
