package com.kevin.test.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author kevin
 * @version 创建时间: 2018年3月22日下午1:27:34
 * @ClassName 类名称
 * @Description 类描述
 */
public class Client {
	/**
	 * Socket客户端
	 */
	public static void main(String[] args) {
		try {
			// 创建Socket对象
			Socket socket = new Socket("localhost", 1080);
			// 根据输入输出流和服务端连接
			OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
			PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
//			File file = new File("doc/a.txt");
//			Long filelength = file.length();  
//	        byte[] filecontent = new byte[filelength.intValue()];  
//	        try {  
//	            FileInputStream in = new FileInputStream(file);  
//	            BufferedInputStream bis = new BufferedInputStream(in);
//				DataInputStream dis = new DataInputStream(bis);
//	            dis.read(filecontent);
//	        } catch (FileNotFoundException e) {  
//	            e.printStackTrace();  
//	        } catch (IOException e) {  
//	            e.printStackTrace();  
//	        }  
	        
//	        String s = new String(filecontent);
//	        String result = strTo16(s);
//	        System.out.println(result.getBytes().length);
	        printWriter.write("01");
	        printWriter.close();
	        socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String strTo16(String s) {
	    String str = "";
	    for (int i = 0; i < s.length(); i++) {
	        int ch = (int) s.charAt(i);
	        String s4 = Integer.toHexString(ch);
	        str = str + s4;
	    }
	    return str;
	}
}
