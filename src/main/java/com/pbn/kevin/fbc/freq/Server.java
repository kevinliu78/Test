package com.pbn.kevin.fbc.freq;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author kevin
 * @version 创建时间: 2018年3月22日下午1:27:22
 * @ClassName Socket服务端
 * @Description 默认监听端口1080，默认服务器IP192.168.100.11
 */
public class Server {
	
	private final float startSpectrumHistory = 5;
	private final float endSpectrumHistory = 205; 
	private final float startSpectrumLive = 5;
	private final float endSpectrumLive = 65; 
	private final float spanHistory = Float.parseFloat(new DecimalFormat("#.000").format(((endSpectrumHistory-startSpectrumHistory)/(680-1))));
	private final float spanLive = Float.parseFloat(new DecimalFormat("#.000").format(((endSpectrumLive-startSpectrumLive)/(500-1))));
	/**
	 * Socket服务端
	 */
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
	
	public static String byte2HexStr2(byte[] b)    
	{    
	    String stmp="";    
	    StringBuilder sb = new StringBuilder("");    
	    for (int n=0;n<b.length;n++)    
	    {    
	        stmp = Integer.toHexString(b[n] & 0xFF);    
	        sb.append((stmp.length()==1)? "0"+stmp : stmp);    
	        if(n != b.length-1 ) {
	        		sb.append(":");
	        }
	    } 
	    return sb.toString().toUpperCase().trim();    
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
	   
	public void init() {
		try {
			ServerSocket serverSocket=new ServerSocket(1080, 2,InetAddress.getByName("0.0.0.0"));
			while (true) {
				// 从请求队列中取出一个连接
				Socket client = serverSocket.accept();
				// 处理这次连接
				new HandlerThread(client);
			}
		} catch (Exception e) {
			System.out.println("服务器异常: " + e.getMessage());
		}
	}
	   
   private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();
		}

		public void run() {
			try {
				BufferedInputStream bis = new BufferedInputStream(
                        socket.getInputStream());
                DataInputStream dis = new DataInputStream(bis);
                byte[] lenbyte = new byte[5];
                while (true) {
                		dis.read(lenbyte);
                    int slot = lenbyte[0];
                    int type = lenbyte[1];
                    int port = lenbyte[2];
                    byte [] lengthb = new byte[2];
                    lengthb[0] = lenbyte[3];
                    lengthb[1] = lenbyte[4];
                    String hexstr = byte2HexStr(lengthb);
                    int len = Integer.valueOf(hexstr, 16);
//                    System.out.println("slot="+slot+"type"+type+"port"+port+"len = "+ len);
                    byte[] dataByte = new byte[len];
                    dis.readFully(dataByte);
                    String data = byte2HexStr2(dataByte);
                    ObjectNode jsonNode = new ObjectMapper().createObjectNode();
                    jsonNode.put("ip", socket.getInetAddress().getHostAddress());
                    jsonNode.put("slot", slot);
                    jsonNode.put("type", type);
                    jsonNode.put("port", port);
                    ArrayNode arr = calculate(type,data);
                    jsonNode.putPOJO("freqData", arr);
                    System.out.println(jsonNode);
                }
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("服务器 run 异常: " + e.getMessage());
				try {
                    socket.close();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
			} 
		}

		private ArrayNode calculate(int type, String data) {
			ArrayNode arr = new ObjectMapper().createArrayNode();
			String[] split = data.split(":");
			//历史 1:历史  2：实时
			if(type == 1) {
				for (int i=0;i<split.length;i=i+2) {
					ObjectNode node = new ObjectMapper().createObjectNode();
					float y = Integer.valueOf(split[i]+split[i+1], 16);
					float x = startSpectrumHistory+(i/2)*spanHistory;
					if(i == split.length-2) {
						x = endSpectrumHistory;
					}
					node.put("x", x);
					node.put("y", y/1000);
					arr.add(node);
				}
			}
			//实时
			else {
				for (int j=0;j<split.length;j=j+24) {
					ObjectNode node = new ObjectMapper().createObjectNode();
					float y = Integer.valueOf(split[j+1]+split[j], 16);
					float x = startSpectrumLive+((j/24)*spanLive);
					if(j == split.length-24) {
						x = endSpectrumLive;
					}
					node.put("x", x);
					node.put("y", y/1000);
					arr.add(node);
				}
			}
			return arr;
		}
	}
   
}
