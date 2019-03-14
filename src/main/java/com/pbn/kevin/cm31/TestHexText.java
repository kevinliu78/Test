package com.pbn.kevin.cm31;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;
import com.pbn.kevin.util.ConfigUtil;
import com.pbn.kevin.util.JsonUtil;

/**
 * @author kevin
 * @version 创建时间: Mar 5, 2019 9:48:33 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestHexText {
	private static int QuarterDb = Integer.valueOf("5F", 16);
	private static String fileUrl = "conf/rxmer.json";
	private static ObjectNode result;
	public static void main(String[] args) throws IOException {
		String fileName = "PNMDsMer_105611fdab37_1551679302";
		//读取文件，转换文件输入流
		FileInputStream fis = new FileInputStream("conf/"+fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		//定义长度为26的字节数组
		byte[] lenbyte = new byte[26];
		//读取
		dis.read(lenbyte);
		String str = byte2HexStr(lenbyte);
//		System.out.println(str);
		//fileType 4bytes
		byte [] fileTypeb = new byte[4];
		fileTypeb[0] = lenbyte[0];
		fileTypeb[1] = lenbyte[1];
		fileTypeb[2] = lenbyte[2];
		fileTypeb[3] = lenbyte[3];
        String ftstr = byte2HexStr(fileTypeb);
        int fileType = Integer.valueOf(ftstr, 16);
        
        //capture time 4bytes
        byte [] ctb = new byte[4];
		ctb[0] = lenbyte[4];
		ctb[1] = lenbyte[5];
		ctb[2] = lenbyte[6];
		ctb[3] = lenbyte[7];
        String ctstr = byte2HexStr(ctb);
        long captureTime = Long.valueOf(ctstr, 16);
        
        //DS ChannelID 1bytes
        int dsChannelId = lenbyte[8] & 0XFF;
        
        //cm mac 6bytes
        byte [] cmMacb = new byte[6];
		cmMacb[0] = lenbyte[9];
		cmMacb[1] = lenbyte[10];
		cmMacb[2] = lenbyte[11];
		cmMacb[3] = lenbyte[12];
		cmMacb[4] = lenbyte[13];
		cmMacb[5] = lenbyte[14];
        String cmMac = byte2HexStr(cmMacb);
        
        //Subcarrier zero frequency in Hz 4bytes
        byte [] startFreqb = new byte[4];
		startFreqb[0] = lenbyte[15];
		startFreqb[1] = lenbyte[16];
		startFreqb[2] = lenbyte[17];
		startFreqb[3] = lenbyte[18];
        String hexstr = byte2HexStr(startFreqb);
        int startFreqInt = Integer.valueOf(hexstr, 16);
        double startFreq = (double)startFreqInt/(1000*1000);
        
        //FirstActiveSubcarrierIndex 2bytes
        byte [] firstActiveb = new byte[2];
		firstActiveb[0] = lenbyte[19];
		firstActiveb[1] = lenbyte[20];
        String firstActivestr = byte2HexStr(firstActiveb);
        int firstActive = Integer.valueOf(firstActivestr, 16);
        
      //Subcarrier spacing in KHz 1bytes
		int spaceInt = lenbyte[21] & 0xff;
		double space = (double)spaceInt/1000;
        
      //length in bytes of RxMer data 4bytes
        byte [] dataLength = new byte[4];
		dataLength[0] = lenbyte[22];
		dataLength[1] = lenbyte[23];
		dataLength[2] = lenbyte[24];
		dataLength[3] = lenbyte[25];
        int dataLeng = Integer.valueOf(byte2HexStr(dataLength), 16);
        System.out.println("fileType:"+fileType+", CaptureTime:"+ConfigUtil.formatDate24(new Date(captureTime))+", dsChannelId:"+dsChannelId+", cmMac:"+cmMac+", startFreq:"+startFreq+"MHz, firstActive:"+firstActive+", space:"+space+"MHz, dataLength:"+dataLeng);
	
        byte[] dataByte = new byte[dataLeng];
//        double[] resultArr = new double[dataLeng];
        dis.readFully(dataByte);
        startFreq = Math.floor(startFreq + firstActive*space);
        List<String[]> list = new ArrayList<String[]>(dataLeng);
        DecimalFormat df = new DecimalFormat("#.000");
        for (int i = 0; i < dataLeng; i++) {
        		String[] s = new String[2];
        		s[0] = df.format(startFreq+i*space);
        		s[1] = String.valueOf(((double)((int)(dataByte[i] & 0xFF)-QuarterDb)/4+23.75));
        		list.add(s);
//			resultArr[i] = ((double)((int)(dataByte[i] & 0xFF)-QuarterDb)/4+23.75);
		}
        result = (ObjectNode)Convert.parse(new FileInputStream(fileUrl));
        if(result == null) {
        		result = Convert.newObject();
        		result.putArray("data");
        }
        ArrayNode data = (ArrayNode)result.get("data");
        long time = new Date().getTime();
        for (int i = 0; i < 1; i++) {
			ObjectNode node = Convert.newObject();
			node.put("dts", time+i*20000);
			node.putPOJO("list", list);
			data.add(node);
		}
        File outdatafile = new File(fileUrl);
		if(!outdatafile.exists()){
			outdatafile.createNewFile();
		}
        FileOutputStream fos = new FileOutputStream(outdatafile);
		JsonUtil.write(fos, result);
		fos.close();
	}
	
	public static String byte2HexStr(byte[] b)    
	{    
	    String stmp="";    
	    StringBuilder sb = new StringBuilder("");    
	    for (int n=0;n<b.length;n++)    
	    {    
	        stmp = Integer.toHexString(b[n] & 0xFF);    
	        sb.append((stmp.length()==1)? "0"+stmp : stmp);    
    
	    }    
	    return sb.toString().toUpperCase().trim();    
	}
}
